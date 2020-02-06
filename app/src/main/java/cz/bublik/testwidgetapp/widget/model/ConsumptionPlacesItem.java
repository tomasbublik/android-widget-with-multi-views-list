package cz.bublik.testwidgetapp.widget.model;

import com.google.gson.annotations.SerializedName;

public class ConsumptionPlacesItem {

    @SerializedName("name")
    private String name;

    @SerializedName("icon")
    private String icon;

    @SerializedName("hdoCode")
    private HdoCode hdoCode;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setHdoCode(HdoCode hdoCode) {
        this.hdoCode = hdoCode;
    }

    public HdoCode getHdoCode() {
        return hdoCode;
    }

    @Override
    public String toString() {
        return
                "ConsumptionPlacesItem{" +
                        "name = '" + name + '\'' +
                        ",icon = '" + icon + '\'' +
                        ",hdoCode = '" + hdoCode + '\'' +
                        "}";
    }
}