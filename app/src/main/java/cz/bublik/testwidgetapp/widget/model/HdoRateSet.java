package cz.bublik.testwidgetapp.widget.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HdoRateSet {

    @SerializedName("hdodayofweekSet")
    private List<HdoDayOfWeekSet> hdodayofweekSet;

    @SerializedName("rate")
    private String rate;

    public void setHdodayofweekSet(List<HdoDayOfWeekSet> hdodayofweekSet) {
        this.hdodayofweekSet = hdodayofweekSet;
    }

    public List<HdoDayOfWeekSet> getHdodayofweekSet() {
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
                "HdoRateSet{" +
                        "hdodayofweekSet = '" + hdodayofweekSet + '\'' +
                        ",rate = '" + rate + '\'' +
                        "}";
    }
}