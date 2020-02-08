package cz.bublik.testwidgetapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cz.bublik.testwidgetapp.R;
import cz.bublik.testwidgetapp.widget.model.WidgetDataModel;
import cz.bublik.testwidgetapp.widget.model.loaded.ConsumptionPlace;
import cz.bublik.testwidgetapp.widget.model.loaded.HdoCode;
import cz.bublik.testwidgetapp.widget.model.loaded.HdoDayOfWeek;
import cz.bublik.testwidgetapp.widget.model.loaded.HdoDefinition;
import cz.bublik.testwidgetapp.widget.model.loaded.HdoPeriod;
import cz.bublik.testwidgetapp.widget.model.loaded.HdoRate;
import cz.bublik.testwidgetapp.widget.model.loaded.HdoTimeSlot;

import static cz.bublik.testwidgetapp.widget.Const.LEFT_BUTTON_CLICKED;
import static cz.bublik.testwidgetapp.widget.Const.REALISTIC_TEST_JSON;
import static cz.bublik.testwidgetapp.widget.Const.RIGHT_BUTTON_CLICKED;

public class ModelUtils {

    private static final String WILL_BE_ACTIVE_AT = "Bude aktivní v ";
    private static final String NOW_ACTIVE_TILL = "Nyní aktivní do ";
    private static final String APPLICATION_EXECUTION_NEEDED = "Nutné spuštění aplikace";

    private ModelUtils() {
    }

    /**
     * Loads the data JSON definition file from SharedPreferences and transforms it into the widget
     * presentation view model represented by the WidgetDataModel. If no data are available,
     * it jumps to the default static JSON REALISTIC_TEST_JSON.
     *
     * @param context Context of the widget app.
     * @return WidgetDataModel A View representation of what is presented to a user by the widget.
     * @see WidgetDataModel
     */
    public static WidgetDataModel loadDataModelFromSharedPreferences(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.widgetDataStorage), Context.MODE_PRIVATE);
        String widgetData = sharedPref.getString(String.valueOf(R.string.widgetData), REALISTIC_TEST_JSON);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        HdoDefinition loadedHdoDefinition = gson.fromJson(widgetData, HdoDefinition.class);

        return getWidgetModelFromHdoDefinition(loadedHdoDefinition, getCurrentCalendarTime());
    }

    /**
     * Loads the last remembered page of the view model. The page index is being stored inside
     * SharedPreferences and interchanged between the main widget and widget service.
     *
     * @param widgetDataModel A View representation of what is presented to a user by the widget.
     * @param context         Context of the widget app.
     * @return WidgetDataModel.Page Current widget page representation. In fact,
     * this is the representation of a consumption place.
     * @see WidgetDataModel.Page
     * @see cz.bublik.testwidgetapp.widget.ItemsWidgetService
     */
    public static WidgetDataModel.Page loadLastPage(WidgetDataModel widgetDataModel, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.page_id_index_key), Context.MODE_PRIVATE);
        int pageIndex = sharedPref.getInt(String.valueOf(R.string.page_index), 0);
        if (widgetDataModel.getPages().size() > pageIndex) {
            return widgetDataModel.getPages().get(pageIndex);
        } else {
            return widgetDataModel.getPages().get(0);
        }
    }

    /**
     * Based on the incoming intentAction, which is actually a user click, calculates the next page
     * to be presented to a user.
     *
     * @param context         Context of the widget app.
     * @param intentAction    Carrier of the information, which button was clicked by a user
     * @param widgetDataModel A View representation of what is presented to a user by the widget.
     * @return A model representation of the newly presented page
     * @see WidgetDataModel.Page
     */
    public static WidgetDataModel.Page getNewPage(Context context, String intentAction, WidgetDataModel widgetDataModel) {
        WidgetDataModel.Page lastPage = loadLastPage(widgetDataModel, context);
        return storeShownPage(context, intentAction, widgetDataModel, lastPage);
    }

    private static WidgetDataModel.Page storeShownPage(Context context, String action, WidgetDataModel widgetDataModel, WidgetDataModel.Page currentPage) {
        WidgetDataModel.Page newPage = calculateShownPageBaseOnClick(action, widgetDataModel, currentPage);

        SharedPreferences sharedPref = context.getSharedPreferences(String.valueOf(R.string.page_id_index_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(String.valueOf(R.string.page_index), widgetDataModel.getPages().indexOf(newPage));
        editor.commit();

        return newPage;
    }

    private static WidgetDataModel.Page calculateShownPageBaseOnClick(String buttonClickedDirection, WidgetDataModel widgetDataModel, WidgetDataModel.Page currentPage) {
        if (dataModelIsNotEmpty(widgetDataModel) && currentPage != null) {
            if (buttonClickedDirection.equals(LEFT_BUTTON_CLICKED)) {
                if (widgetDataModel.getPages().indexOf(currentPage) == 0) {
                    return widgetDataModel.getPages().get(widgetDataModel.getPages().size() - 1);
                } else {
                    return widgetDataModel.getPages().get(widgetDataModel.getPages().indexOf(currentPage) - 1);
                }
            }
            if (buttonClickedDirection.equals(RIGHT_BUTTON_CLICKED)) {
                if (widgetDataModel.getPages().indexOf(currentPage) == (widgetDataModel.getPages().size() - 1)) {
                    return widgetDataModel.getPages().get(0);
                } else {
                    return widgetDataModel.getPages().get(widgetDataModel.getPages().indexOf(currentPage) + 1);
                }
            }
        }
        return currentPage;
    }

    /**
     * Calculated a widget view model based on the hdo definition data model and current time.
     * The current time used here can be relative to the device or to the caller of this method
     * and thus it is not created here. For example, this allows tests to be executed in any time
     * of the future or past.
     *
     * @param hdoDefinition Data model of HDO definitions
     * @param currentTime   Calendar instance carrying current time.
     * @return View model for the widget
     * @see HdoDefinition
     */
    static WidgetDataModel getWidgetModelFromHdoDefinition(HdoDefinition hdoDefinition, Calendar currentTime) {
        return generateDataModelFromActualConsumptionPlaces(getConsumptionPlacesWithActualPeriod(hdoDefinition, currentTime), currentTime);
    }

    /**
     * Picks up those consumption places having the period corresponding to the actual time.
     *
     * @param hdoDefinition Data model of HDO definitions
     * @param currentTime   Calendar instance carrying current time.
     * @return Array list of the consumption places
     */
    private static List<ConsumptionPlace> getConsumptionPlacesWithActualPeriod(HdoDefinition hdoDefinition, Calendar currentTime) {
        List<ConsumptionPlace> consumptionPlaces = new ArrayList<>();

        if (hdoDefinitionHasNonEmptyConsumptionPlaces(hdoDefinition)) {
            for (ConsumptionPlace consumptionPlace : hdoDefinition.getConsumptionPlaces()) {
                HdoCode hdoCode = consumptionPlace.getHdoCode();
                addConsumptionPlaceWithActualPeriod(consumptionPlaces, consumptionPlace, hdoCode, currentTime);
            }
        }

        return consumptionPlaces;
    }

    /**
     * Based on the given consumption places list, this method calculates proper widget view model.
     *
     * @param consumptionPlaces List of valid consumption places
     * @param currentCalendar   Current calendar instance to detect proper day and time for choosing
     *                          the corresponding program week prescription.
     * @return View model for the widget
     */
    private static WidgetDataModel generateDataModelFromActualConsumptionPlaces(List<ConsumptionPlace> consumptionPlaces, Calendar currentCalendar) {
        WidgetDataModel widgetDataModel = new WidgetDataModel();
        List<WidgetDataModel.Page> pages = new ArrayList<>();
        // No consumption places variant
        if (noConsumptionPlaces(consumptionPlaces)) {
            return setupModelWithoutData(widgetDataModel, pages);
        }

        for (ConsumptionPlace consumptionPlace : consumptionPlaces) {
            // Common part of the widget
            WidgetDataModel.Page page = new WidgetDataModel.Page();
            page.setPlaceName(consumptionPlace.getName());
            page.setIcon(consumptionPlace.getIcon());

            List<WidgetDataModel.Page.Item> items = new ArrayList<>();
            HdoCode hdoCode = consumptionPlace.getHdoCode();
            if (hdoCodeHasNonEmptyPeriodSet(hdoCode)) {
                setupEarliestPeriodChangeDate(widgetDataModel, hdoCode);
                for (HdoPeriod hdoPeriod : hdoCode.getHdoperiodSet()) {
                    createItemsForPage(currentCalendar, widgetDataModel, items, hdoPeriod);
                }
            }
            page.setItems(items);
            pages.add(page);
        }
        widgetDataModel.setPages(pages);

        return widgetDataModel;
    }

    private static void createItemsForPage(Calendar currentCalendar, WidgetDataModel widgetDataModel, List<WidgetDataModel.Page.Item> items, HdoPeriod hdoPeriod) {
        if (hdoPeriodHasDefinedDates(hdoPeriod)) {
            for (HdoRate hdoRate : hdoPeriod.getHdorateSet()) {
                WidgetDataModel.Page.Item item = new WidgetDataModel.Page.Item();
                item.setItemTitle(hdoRate.getRate());
                // TODO map icons by rateName

                Calendar calendarToAlarm = calculateAlarmTime(currentCalendar, hdoRate, item);
                if (alarmNotSetOrIfBeforeActualOne(widgetDataModel, calendarToAlarm)) {
                    widgetDataModel.setNearestAlarmDate(calendarToAlarm);
                }

                items.add(item);
            }
        }
    }

    private static WidgetDataModel setupModelWithoutData(WidgetDataModel widgetDataModel, List<WidgetDataModel.Page> pages) {
        WidgetDataModel.Page page = new WidgetDataModel.Page();
        page.setPlaceName(APPLICATION_EXECUTION_NEEDED);
        pages.add(page);
        widgetDataModel.setPages(pages);
        return widgetDataModel;
    }

    private static boolean alarmNotSetOrIfBeforeActualOne(WidgetDataModel widgetDataModel, Calendar calendarToAlarm) {
        return widgetDataModel.getNearestAlarmDate() == null || widgetDataModel.getNearestAlarmDate().after(calendarToAlarm);
    }

    /**
     * It calculates alarms to be executed at the time when week prescriptions shall be changed.
     * Based on the current calendar, it chooses the nearest time of change alarm and saves
     * it into the view model. Whenever an update of the widget is called, the earliest alarm time
     * from this model is set. This means when an active period is actual, it set the nearest "to"
     * time as the end of the period, while whnen a period is inactive, the closest "from" time
     * is picked.
     * @param currentCalendar Calendar instance carrying current time.
     * @param hdoRate HDO rate week prescription model.
     * @param item Ite of the view model page for which the alarm shall be calculated
     * @return Calendar instance of the alarm
     * @see HdoRate
     * @see cz.bublik.testwidgetapp.widget.model.WidgetDataModel.Page.Item
     */
    private static Calendar calculateAlarmTime(Calendar currentCalendar, HdoRate hdoRate, WidgetDataModel.Page.Item item) {
        HdoDayOfWeek currentDayOfWeek = pickUpProperDayOfWeek(hdoRate, currentCalendar);
        HdoTimeSlot currentHdoTimeSlot = getActualTimeSlot(currentDayOfWeek, currentCalendar);

        Calendar calendarToAlarm = Calendar.getInstance();
        if (currentHdoTimeSlot == null) {
            HdoTimeSlot futureHdoTimeSlot = getFutureTimeSlot(currentDayOfWeek, currentCalendar);
            item.setActive(false);
            if (futureHdoTimeSlot == null) {
                HdoDayOfWeek nextDayOfWeek = pickUpFollowingDayOfWeek(hdoRate, currentDayOfWeek);
                HdoTimeSlot firstTimeSlotOfANextDay = getFirstTimeSlot(nextDayOfWeek);
                if (firstTimeSlotOfANextDay != null) {
                    item.setItemSubTitle(WILL_BE_ACTIVE_AT + firstTimeSlotOfANextDay.getTimeslotFrom().substring(0, 5));
                    calendarToAlarm = getAlarmFromTimeSlot(firstTimeSlotOfANextDay, currentCalendar, true);
                    calendarToAlarm.add(Calendar.DAY_OF_WEEK, 1);
                }
            } else {
                item.setItemSubTitle(WILL_BE_ACTIVE_AT + futureHdoTimeSlot.getTimeslotFrom().substring(0, 5));
                calendarToAlarm = getAlarmFromTimeSlot(futureHdoTimeSlot, currentCalendar, true);
            }
        } else {
            item.setActive(true);
            item.setItemSubTitle(NOW_ACTIVE_TILL + currentHdoTimeSlot.getTimeslotTo().substring(0, 5));
            calendarToAlarm = getAlarmFromTimeSlot(currentHdoTimeSlot, currentCalendar, false);
        }
        return calendarToAlarm;
    }

    static Calendar getAlarmFromTimeSlot(HdoTimeSlot currentHdoTimeSlot, Calendar slotToCalendar, boolean future) {
        String timeSlotTime = future ? currentHdoTimeSlot.getTimeslotFrom() : currentHdoTimeSlot.getTimeslotTo();

        Calendar calendarToAlarm = Calendar.getInstance();
        calendarToAlarm.setTime(slotToCalendar.getTime());
        calendarToAlarm.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeSlotTime.substring(0, 2)));
        calendarToAlarm.set(Calendar.MINUTE, Integer.parseInt(timeSlotTime.substring(3, 5)));
        calendarToAlarm.set(Calendar.SECOND, 0);

        return calendarToAlarm;
    }

    static HdoTimeSlot getActualTimeSlot(HdoDayOfWeek requestedDayOfWeek, Calendar currentCalendar) {
        if (hdoDayOfWeekHasNonEmptyHdoTimeSlots(requestedDayOfWeek)) {
            int currentTimeAmount = (currentCalendar.get(Calendar.HOUR_OF_DAY) * 100) + currentCalendar.get(Calendar.MINUTE);

            for (HdoTimeSlot hdoTimeSlot : requestedDayOfWeek.getHdotimeslotSet()) {
                if (timeSlotHasBoundaries(hdoTimeSlot) && timeAmountFitsIntoBoundaries(currentTimeAmount, hdoTimeSlot)) {
                    return hdoTimeSlot;
                }
            }
        }

        return null;
    }

    static HdoTimeSlot getFirstTimeSlot(HdoDayOfWeek requestedDayOfWeek) {
        if (hdoDayOfWeekHasNonEmptyHdoTimeSlots(requestedDayOfWeek)) {
            return requestedDayOfWeek.getHdotimeslotSet().get(0);
        }

        return null;
    }

    static HdoTimeSlot getFutureTimeSlot(HdoDayOfWeek currentDayOfWeek, Calendar currentCalendar) {
        if (hdoDayOfWeekHasNonEmptyHdoTimeSlots(currentDayOfWeek)) {
            int currentTimeAmount = (currentCalendar.get(Calendar.HOUR_OF_DAY) * 100) + currentCalendar.get(Calendar.MINUTE);

            for (HdoTimeSlot hdoTimeSlot : currentDayOfWeek.getHdotimeslotSet()) {
                if (timeSlotHasBoundaries(hdoTimeSlot) && timeAmountIsBeforeLowerBoundary(currentTimeAmount, hdoTimeSlot)) {
                    return hdoTimeSlot;
                }
            }
        }

        // This usually happens when time is after the ned of last period
        // Must be checked, and the first period of the following day has to be chosen
        return null;
    }

    private static boolean timeAmountFitsIntoBoundaries(int currentTimeAmount, HdoTimeSlot hdoTimeSlot) {
        return currentTimeAmount >= calculateTimeAmountFromString(hdoTimeSlot.getTimeslotFrom()) && currentTimeAmount <= calculateTimeAmountFromString(hdoTimeSlot.getTimeslotTo());
    }

    private static boolean timeAmountIsBeforeLowerBoundary(int currentTimeAmount, HdoTimeSlot hdoTimeSlot) {
        return currentTimeAmount <= calculateTimeAmountFromString(hdoTimeSlot.getTimeslotFrom());
    }

    static int calculateTimeAmountFromString(String timeSlotDefinition) {
        int intValueOfTime = 0;
        try {
            intValueOfTime = Integer.parseInt(timeSlotDefinition.substring(0, 5).replace(":", ""));
        } catch (NumberFormatException | StringIndexOutOfBoundsException ouex) {
            return intValueOfTime;
        }

        return intValueOfTime;
    }

    static Calendar getCurrentCalendarTime() {
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(new Date());

        return currentCalendar;
    }

    private static HdoDayOfWeek pickUpProperDayOfWeek(HdoRate hdoRate, Calendar currentCalendar) {
        if (hdoRateHasNonEmptyWeekDaysSet(hdoRate)) {

            int todaysWeekDay = currentCalendar.get(Calendar.DAY_OF_WEEK);

            if (todaysWeekDay == 1) {
                todaysWeekDay = 7;
            } else {
                todaysWeekDay = todaysWeekDay - 1;
            }

            if (todaysWeekDay <= hdoRate.getHdodayofweekSet().size()) {
                return hdoRate.getHdodayofweekSet().get(todaysWeekDay - 1);
            }
        }

        return null;
    }

    private static HdoDayOfWeek pickUpFollowingDayOfWeek(HdoRate hdoRate, HdoDayOfWeek currentDayOfWeek) {
        if (hdoRateHasNonEmptyWeekDaysSet(hdoRate)) {
            int currentIndex = hdoRate.getHdodayofweekSet().indexOf(currentDayOfWeek);

            if (currentIndex == 6) {
                return hdoRate.getHdodayofweekSet().get(0);
            } else {
                return hdoRate.getHdodayofweekSet().get(currentIndex + 1);
            }
        }

        return null;
    }

    private static void setupEarliestPeriodChangeDate(WidgetDataModel widgetDataModel, HdoCode hdoCode) {
        for (HdoPeriod hdoPeriod : hdoCode.getHdoperiodSet()) {
            Calendar calendarInstance = Calendar.getInstance();
            calendarInstance.setTime(hdoPeriod.getPeriodTo());

            if (widgetDataModel.getAlarmPeriodChange() == null || widgetDataModel.getAlarmPeriodChange().after(calendarInstance)) {
                widgetDataModel.setAlarmPeriodChange(calendarInstance);
            }
        }
    }

    private static void addConsumptionPlaceWithActualPeriod(List<ConsumptionPlace> consumptionPlaces, ConsumptionPlace consumptionPlace, HdoCode hdoCode, Calendar currentTime) {
        if (hdoCodeHasNonEmptyPeriodSet(hdoCode)) {
            for (HdoPeriod hdoPeriod : hdoCode.getHdoperiodSet()) {
                addPlaceCorrespondingTheActualPeriod(consumptionPlaces, consumptionPlace, hdoPeriod, currentTime);
            }
        }
    }

    private static void addPlaceCorrespondingTheActualPeriod(List<ConsumptionPlace> consumptionPlaces, ConsumptionPlace consumptionPlace, HdoPeriod hdoPeriod, Calendar currentTime) {
        Calendar calendarPeriodFrom = Calendar.getInstance();
        calendarPeriodFrom.setTime(hdoPeriod.getPeriodFrom());
        Calendar calendarPeriodTo = Calendar.getInstance();
        calendarPeriodTo.setTime(hdoPeriod.getPeriodTo());

        if (hdoPeriodHasDefinedDates(hdoPeriod) && currentTime.after(calendarPeriodFrom) && currentTime.before(calendarPeriodTo)) {
            consumptionPlaces.add(consumptionPlace);
        }
    }

    public static String shortenIfNecessary(String placeName) {
        if (placeName != null && placeName.length() > 15) {
            return placeName.substring(0, 13).concat("...");
        }
        return placeName;
    }

    private static boolean hdoPeriodHasDefinedDates(HdoPeriod hdoPeriod) {
        return hdoPeriod.getPeriodFrom() != null && hdoPeriod.getPeriodTo() != null;
    }

    private static boolean hdoDefinitionHasNonEmptyConsumptionPlaces(HdoDefinition hdoDefinition) {
        return hdoDefinition != null && hdoDefinition.getConsumptionPlaces() != null && !hdoDefinition.getConsumptionPlaces().isEmpty();
    }

    private static boolean hdoCodeHasNonEmptyPeriodSet(HdoCode hdoCode) {
        return hdoCode != null && hdoCode.getHdoperiodSet() != null && !hdoCode.getHdoperiodSet().isEmpty();
    }

    private static boolean hdoRateHasNonEmptyWeekDaysSet(HdoRate hdoRate) {
        return hdoRate != null && hdoRate.getHdodayofweekSet() != null && !hdoRate.getHdodayofweekSet().isEmpty();
    }

    private static boolean hdoDayOfWeekHasNonEmptyHdoTimeSlots(HdoDayOfWeek hdoDayOfWeek) {
        return hdoDayOfWeek != null && hdoDayOfWeek.getHdotimeslotSet() != null && !hdoDayOfWeek.getHdotimeslotSet().isEmpty();
    }

    private static boolean timeSlotHasBoundaries(HdoTimeSlot hdoTimeSlot) {
        return hdoTimeSlot.getTimeslotFrom() != null && hdoTimeSlot.getTimeslotTo() != null;
    }

    public static boolean dataModelIsNotEmpty(WidgetDataModel widgetDataModel) {
        return widgetDataModel.getPages() != null && !widgetDataModel.getPages().isEmpty();
    }

    private static boolean noConsumptionPlaces(List<ConsumptionPlace> consumptionPlaces) {
        return consumptionPlaces == null || consumptionPlaces.isEmpty();
    }
}
