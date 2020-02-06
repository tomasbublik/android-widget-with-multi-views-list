package cz.bublik.testwidgetapp.widget.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class HdoPeriodSet {

    @SerializedName("periodTo")
    private Date periodTo;

    @SerializedName("periodFrom")
    private Date periodFrom;

    @SerializedName("hdorateSet")
    private List<HdoRateSet> hdorateSet;

    public void setPeriodTo(Date periodTo) {
        this.periodTo = periodTo;
    }

    public Date getPeriodTo() {
        return periodTo;
    }

    public void setPeriodFrom(Date periodFrom) {
        this.periodFrom = periodFrom;
    }

    public Date getPeriodFrom() {
        return periodFrom;
    }

    public void setHdorateSet(List<HdoRateSet> hdorateSet) {
        this.hdorateSet = hdorateSet;
    }

    public List<HdoRateSet> getHdorateSet() {
        return hdorateSet;
    }

    @Override
    public String toString() {
        return
                "HdoPeriodSet{" +
                        "periodTo = '" + periodTo + '\'' +
                        ",periodFrom = '" + periodFrom + '\'' +
                        ",hdorateSet = '" + hdorateSet + '\'' +
                        "}";
    }
}