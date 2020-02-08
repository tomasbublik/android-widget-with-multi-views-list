package cz.bublik.testwidgetapp.widget.model.loaded;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class HdoPeriod {

    @SerializedName("periodTo")
    private Date periodTo;

    @SerializedName("periodFrom")
    private Date periodFrom;

    @SerializedName("hdorateSet")
    private List<HdoRate> hdorateSet;

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

    public void setHdorateSet(List<HdoRate> hdorateSet) {
        this.hdorateSet = hdorateSet;
    }

    public List<HdoRate> getHdorateSet() {
        return hdorateSet;
    }

    @Override
    public String toString() {
        return
                "HdoPeriod{" +
                        "periodTo = '" + periodTo + '\'' +
                        ",periodFrom = '" + periodFrom + '\'' +
                        ",hdorateSet = '" + hdorateSet + '\'' +
                        "}";
    }
}