package cz.bublik.testwidgetapp.widget.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HdoDayOfWeekSet {

    @SerializedName("weekDay")
    private int weekDay;

    @SerializedName("hdotimeslotSet")
    private List<HdoTimeSlotSet> hdotimeslotSet;

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setHdotimeslotSet(List<HdoTimeSlotSet> hdotimeslotSet) {
        this.hdotimeslotSet = hdotimeslotSet;
    }

    public List<HdoTimeSlotSet> getHdotimeslotSet() {
        return hdotimeslotSet;
    }

    @Override
    public String toString() {
        return
                "HdoDayOfWeekSet{" +
                        "weekDay = '" + weekDay + '\'' +
                        ",hdotimeslotSet = '" + hdotimeslotSet + '\'' +
                        "}";
    }
}