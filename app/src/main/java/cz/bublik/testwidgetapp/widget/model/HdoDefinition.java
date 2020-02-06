package cz.bublik.testwidgetapp.widget.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HdoDefinition {

    @SerializedName("consumptionPlaces")
    private List<ConsumptionPlacesItem> consumptionPlaces;

    public void setConsumptionPlaces(List<ConsumptionPlacesItem> consumptionPlaces) {
        this.consumptionPlaces = consumptionPlaces;
    }

    public List<ConsumptionPlacesItem> getConsumptionPlaces() {
        return consumptionPlaces;
    }

    @Override
    public String toString() {
        return
                "HdoDefinition{" +
                        "consumptionPlaces = '" + consumptionPlaces + '\'' +
                        "}";
    }
}