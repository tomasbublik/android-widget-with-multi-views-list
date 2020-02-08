package cz.bublik.testwidgetapp.utils;

import com.google.gson.GsonBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import cz.bublik.testwidgetapp.BaseTest;
import cz.bublik.testwidgetapp.widget.model.WidgetDataModel;
import cz.bublik.testwidgetapp.widget.model.loaded.HdoDayOfWeek;
import cz.bublik.testwidgetapp.widget.model.loaded.HdoDefinition;
import cz.bublik.testwidgetapp.widget.model.loaded.HdoTimeSlot;

import static cz.bublik.testwidgetapp.Const.JSON_SAMPLE;
import static cz.bublik.testwidgetapp.utils.ModelUtils.calculateTimeAmountFromString;
import static cz.bublik.testwidgetapp.utils.ModelUtils.getActualTimeSlot;
import static cz.bublik.testwidgetapp.utils.ModelUtils.getAlarmFromTimeSlot;
import static cz.bublik.testwidgetapp.utils.ModelUtils.getCurrentCalendarTime;
import static cz.bublik.testwidgetapp.utils.ModelUtils.getFutureTimeSlot;
import static cz.bublik.testwidgetapp.utils.ModelUtils.getWidgetModelFromHdoDefinition;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ModelUtilsTest extends BaseTest {

    @BeforeAll
    void setup() {
        gson = new GsonBuilder().setDateFormat(PERIODS_GSON_DATE_FORMAT).create();
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Nested
    @DisplayName("Tests all the variants related to the calculateTimeAmountFromString() method")
    class TimeAmountFromString {

        @Test
        void canTimeAmountBeCalculatedFromStringWhenMorningValueIsGiven() {
            int timeAmount = calculateTimeAmountFromString("05:00:01");

            assertThat(timeAmount).isEqualTo(500);
        }

        @Test
        void canTimeAmountBeCalculatedFromStringWhenEveningValueIsGiven() {
            int timeAmount = calculateTimeAmountFromString("19:20:30");

            assertThat(timeAmount).isEqualTo(1920);
        }

        @Test
        void canTimeAmountBeCalculatedFromStringWhenZeroValueIsGiven() {
            int timeAmount = calculateTimeAmountFromString("00:00:00");

            assertThat(timeAmount).isEqualTo(0);
        }

        @Test
        void isTimeAmountSetToZeroWhenWrongValueIsGiven() {
            int timeAmount = calculateTimeAmountFromString("aaaa");

            assertThat(timeAmount).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("Tests all the variants related to the getAlarmFromTimeSlot() method")
    class AlarmFromTimeSlot {

        @Test
        void isLowerBoundSelectedWhenCurrentTimeSlotProvided() {
            HdoTimeSlot hdoTimeSlot = setupHdoSlot();

            Calendar selectedTime = getAlarmFromTimeSlot(hdoTimeSlot, Calendar.getInstance(), false);

            assertThat(selectedTime.get(Calendar.HOUR_OF_DAY)).isEqualTo(7);
            assertThat(selectedTime.get(Calendar.MINUTE)).isEqualTo(30);
        }

        @Test
        void isUpperBoundSelectedWhenCurrentTimeSlotProvided() {
            HdoTimeSlot hdoTimeSlot = setupHdoSlot();

            Calendar selectedTime = getAlarmFromTimeSlot(hdoTimeSlot, Calendar.getInstance(), true);

            assertThat(selectedTime.get(Calendar.HOUR_OF_DAY)).isEqualTo(5);
            assertThat(selectedTime.get(Calendar.MINUTE)).isEqualTo(0);
        }

        private HdoTimeSlot setupHdoSlot() {
            HdoTimeSlot hdoTimeSlot = new HdoTimeSlot();
            hdoTimeSlot.setTimeslotFrom("05:00:00");
            hdoTimeSlot.setTimeslotTo("07:30:00");
            return hdoTimeSlot;
        }
    }

    @Nested
    @DisplayName("Tests all the variants related to the getActualTimeSlot() and getFutureTimeSlot() methods")
    class ActualAndFutureTimeSlot {

        @Test
        void isActualTimeSlotSelectedWhenTimeFitsToInterval() {
            HdoDayOfWeek hdoDayOfWeek = setupHdoDayOfWeek();
            Calendar instance = Calendar.getInstance();
            instance.set(Calendar.HOUR_OF_DAY, 3);

            HdoTimeSlot chosenSlot = getActualTimeSlot(hdoDayOfWeek, instance);

            assertThat(hdoDayOfWeek.getHdotimeslotSet().indexOf(chosenSlot)).isEqualTo(0);
        }

        @Test
        void isActualTimeSlotSelectedWhenTimeFitsToTheLastInterval() {
            HdoDayOfWeek hdoDayOfWeek = setupHdoDayOfWeek();
            Calendar instance = Calendar.getInstance();
            instance.set(Calendar.HOUR_OF_DAY, 23);
            instance.set(Calendar.MINUTE, 30);

            HdoTimeSlot chosenSlot = getActualTimeSlot(hdoDayOfWeek, instance);

            assertThat(hdoDayOfWeek.getHdotimeslotSet().indexOf(chosenSlot)).isEqualTo(3);
        }

        @Test
        void isNullReturnedWhenNoIntervalFits() {
            HdoDayOfWeek hdoDayOfWeek = setupHdoDayOfWeek();
            Calendar instance = Calendar.getInstance();
            instance.set(Calendar.HOUR_OF_DAY, 4);
            instance.set(Calendar.MINUTE, 30);

            HdoTimeSlot chosenSlot = getActualTimeSlot(hdoDayOfWeek, instance);

            assertThat(chosenSlot).isNull();
        }

        @Test
        void isFutureTimeSlotSelectedWhenTimeFitsToTheGap() {
            HdoDayOfWeek hdoDayOfWeek = setupHdoDayOfWeek();
            Calendar instance = Calendar.getInstance();
            instance.set(Calendar.HOUR_OF_DAY, 4);
            instance.set(Calendar.MINUTE, 30);

            HdoTimeSlot chosenSlot = getFutureTimeSlot(hdoDayOfWeek, instance);

            assertThat(hdoDayOfWeek.getHdotimeslotSet().indexOf(chosenSlot)).isEqualTo(1);
        }

        @Test
        void isFutureTimeSlotSelectedWhenTimeFitsToTheGapBeforeLastPeriod() {
            HdoDayOfWeek hdoDayOfWeek = setupHdoDayOfWeek();
            Calendar instance = Calendar.getInstance();
            instance.set(Calendar.HOUR_OF_DAY, 21);

            HdoTimeSlot chosenSlot = getFutureTimeSlot(hdoDayOfWeek, instance);

            assertThat(hdoDayOfWeek.getHdotimeslotSet().indexOf(chosenSlot)).isEqualTo(3);
        }

        @Test
        void isNullReturnedWhenTimeIsAfterLastPeriodButBeforeMidnight() {
            HdoDayOfWeek hdoDayOfWeek = setupHdoDayOfWeek();
            Calendar instance = Calendar.getInstance();
            instance.set(Calendar.HOUR_OF_DAY, 23);
            instance.set(Calendar.MINUTE, 59);
            instance.set(Calendar.SECOND, 30);

            HdoTimeSlot chosenSlot = getFutureTimeSlot(hdoDayOfWeek, instance);

            assertThat(chosenSlot).isNull();
        }

        private HdoDayOfWeek setupHdoDayOfWeek() {
            List<HdoTimeSlot> hdoTimeSlots = new ArrayList<>();

            HdoTimeSlot hdoTimeSlot = new HdoTimeSlot();
            hdoTimeSlot.setTimeslotFrom("00:00:00");
            hdoTimeSlot.setTimeslotTo("04:00:00");
            hdoTimeSlots.add(hdoTimeSlot);

            hdoTimeSlot = new HdoTimeSlot();
            hdoTimeSlot.setTimeslotFrom("05:00:00");
            hdoTimeSlot.setTimeslotTo("07:30:00");
            hdoTimeSlots.add(hdoTimeSlot);

            hdoTimeSlot = new HdoTimeSlot();
            hdoTimeSlot.setTimeslotFrom("16:00:00");
            hdoTimeSlot.setTimeslotTo("19:30:00");
            hdoTimeSlots.add(hdoTimeSlot);

            hdoTimeSlot = new HdoTimeSlot();
            hdoTimeSlot.setTimeslotFrom("22:00:00");
            hdoTimeSlot.setTimeslotTo("23:59:00");
            hdoTimeSlots.add(hdoTimeSlot);

            HdoDayOfWeek hdoDayOfWeek = new HdoDayOfWeek();
            hdoDayOfWeek.setHdotimeslotSet(hdoTimeSlots);

            return hdoDayOfWeek;
        }
    }

    @Nested
    @DisplayName("Tests all the variants related to the whole model loading methods")
    class ModelLoading {

        @Test
        void canAStandardModelBeLoadedWhenJsonIsGiven() {
            HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);
            Calendar getTime = getRelativeCalendar();

            WidgetDataModel widgetModelFromHdoDefinition = getWidgetModelFromHdoDefinition(hdoDefinition, getTime);

            assertThat(widgetModelFromHdoDefinition).isNotNull();
        }

        @Test
        void isANonMatchingSlotPresentedAsInactiveWhenTimeMoved() {
            HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);
            Calendar getTime = getRelativeCalendar();
            getTime.set(Calendar.HOUR_OF_DAY, 18);

            WidgetDataModel widgetModelFromHdoDefinition = getWidgetModelFromHdoDefinition(hdoDefinition, getTime);

            assertThat(widgetModelFromHdoDefinition.getPages().get(0).getItems().get(0).isActive()).isFalse();
        }

        @Test
        void isLastDayOfWeekMatchingMatchingSlotCalculatedProperlyWhenTimeMoved() {
            HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);
            Calendar getTime = getRelativeCalendar();
            getTime.set(Calendar.HOUR_OF_DAY, 9);
            getTime.set(Calendar.DAY_OF_MONTH, 9);
            getTime.set(Calendar.MINUTE, 5);

            WidgetDataModel widgetModelFromHdoDefinition = getWidgetModelFromHdoDefinition(hdoDefinition, getTime);

            assertThat(widgetModelFromHdoDefinition.getNearestAlarmDate().get(Calendar.HOUR_OF_DAY)).isEqualTo(10);
        }

        private Calendar getRelativeCalendar() {
            Calendar currentCalendarTime = getCurrentCalendarTime();
            currentCalendarTime.set(Calendar.MONTH, 1);
            currentCalendarTime.set(Calendar.DAY_OF_MONTH, 8);
            currentCalendarTime.set(Calendar.HOUR_OF_DAY, 16);
            currentCalendarTime.set(Calendar.MINUTE, 30);
            currentCalendarTime.set(Calendar.SECOND, 0);
            return currentCalendarTime;
        }
    }
}