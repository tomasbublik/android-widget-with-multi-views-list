package cz.bublik.testwidgetapp.widget.model.loaded;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HdoDayOfWeek {

    @SerializedName("weekDay")
    private int weekDay;

    @SerializedName("hdotimeslotSet")
    private List<HdoTimeSlot> hdotimeslotSet;

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setHdotimeslotSet(List<HdoTimeSlot> hdotimeslotSet) {
        this.hdotimeslotSet = hdotimeslotSet;
    }

    public List<HdoTimeSlot> getHdotimeslotSet() {
        return hdotimeslotSet;
    }

    @Override
    public String toString() {
        return
                "HdoDayOfWeek{" +
                        "weekDay = '" + weekDay + '\'' +
                        ",hdotimeslotSet = '" + hdotimeslotSet + '\'' +
                        "}";
    }
}