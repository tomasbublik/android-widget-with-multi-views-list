package cz.bublik.testwidgetapp.widget.model.loaded;

import com.google.gson.annotations.SerializedName;

public class ConsumptionPlace {

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
                "ConsumptionPlace{" +
                        "name = '" + name + '\'' +
                        ",icon = '" + icon + '\'' +
                        ",hdoCode = '" + hdoCode + '\'' +
                        "}";
    }
}