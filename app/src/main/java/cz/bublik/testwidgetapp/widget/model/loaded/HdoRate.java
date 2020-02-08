package cz.bublik.testwidgetapp.widget.model.loaded;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HdoRate {

    @SerializedName("hdodayofweekSet")
    private List<HdoDayOfWeek> hdodayofweekSet;

    @SerializedName("rate")
    private String rate;

    public void setHdodayofweekSet(List<HdoDayOfWeek> hdodayofweekSet) {
        this.hdodayofweekSet = hdodayofweekSet;
    }

    public List<HdoDayOfWeek> getHdodayofweekSet() {
        return hdodayofweekSet;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return
                "HdoRate{" +
                        "hdodayofweekSet = '" + hdodayofweekSet + '\'' +
                        ",rate = '" + rate + '\'' +
                        "}";
    }
}