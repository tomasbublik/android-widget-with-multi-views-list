package cz.bublik.testwidgetapp.widget.model.loaded;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HdoDefinition {

    @SerializedName("consumptionPlaces")
    private List<ConsumptionPlace> consumptionPlaces;

    public void setConsumptionPlaces(List<ConsumptionPlace> consumptionPlaces) {
        this.consumptionPlaces = consumptionPlaces;
    }

    public List<ConsumptionPlace> getConsumptionPlaces() {
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