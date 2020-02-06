package cz.bublik.testwidgetapp.widget.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HdoCode {

    @SerializedName("hdoperiodSet")
    private List<HdoPeriodSet> hdoperiodSet;

    public void setHdoperiodSet(List<HdoPeriodSet> hdoperiodSet) {
        this.hdoperiodSet = hdoperiodSet;
    }

    public List<HdoPeriodSet> getHdoperiodSet() {
        return hdoperiodSet;
    }

    @Override
    public String toString() {
        return
                "HdoCode{" +
                        "hdoperiodSet = '" + hdoperiodSet + '\'' +
                        "}";
    }
}