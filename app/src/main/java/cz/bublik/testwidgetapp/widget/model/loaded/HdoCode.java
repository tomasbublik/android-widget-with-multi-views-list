package cz.bublik.testwidgetapp.widget.model.loaded;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HdoCode {

    @SerializedName("hdoperiodSet")
    private List<HdoPeriod> hdoperiodSet;

    public void setHdoperiodSet(List<HdoPeriod> hdoperiodSet) {
        this.hdoperiodSet = hdoperiodSet;
    }

    public List<HdoPeriod> getHdoperiodSet() {
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