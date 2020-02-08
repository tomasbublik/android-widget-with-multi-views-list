package cz.bublik.testwidgetapp.widget.model.loaded;

import com.google.gson.annotations.SerializedName;

public class HdoTimeSlot {

    @SerializedName("timeslotFrom")
    private String timeslotFrom;

    @SerializedName("timeslotTo")
    private String timeslotTo;

    public void setTimeslotFrom(String timeslotFrom) {
        this.timeslotFrom = timeslotFrom;
    }

    public String getTimeslotFrom() {
        return timeslotFrom;
    }

    public void setTimeslotTo(String timeslotTo) {
        this.timeslotTo = timeslotTo;
    }

    public String getTimeslotTo() {
        return timeslotTo;
    }

    @Override
    public String toString() {
        return
                "HdoTimeSlot{" +
                        "timeslotFrom = '" + timeslotFrom + '\'' +
                        ",timeslotTo = '" + timeslotTo + '\'' +
                        "}";
    }
}