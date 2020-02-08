package cz.bublik.testwidgetapp;

import com.google.gson.GsonBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.TimeZone;

import cz.bublik.testwidgetapp.widget.model.loaded.HdoDefinition;

import static cz.bublik.testwidgetapp.Const.JSON_SAMPLE;
import static cz.bublik.testwidgetapp.Const.PERIOD_FROM;
import static cz.bublik.testwidgetapp.Const.PERIOD_TO;
import static org.assertj.core.api.Assertions.assertThat;

class HdoDefinitionTest extends BaseTest {

    @BeforeAll
    void setup() {
        gson = new GsonBuilder().setDateFormat(PERIODS_GSON_DATE_FORMAT).create();
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Test
    void canTheHdoObjectBeCreatedWhenJsonIsGiven() {
        HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);

        assertThat(hdoDefinition).isNotNull();
    }

    @Test
    void isOneConsumptionPlaceParsedWhenJsonIsGiven() {
        HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);

        assertThat(hdoDefinition.getConsumptionPlaces()).hasSize(1);
    }

    @Test
    void isOneHdoPeriodSetParsedWhenJsonIsGiven() {
        HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);

        assertThat(hdoDefinition.getConsumptionPlaces().get(0).getHdoCode().getHdoperiodSet()).hasSize(1);
    }

    @Test
    void isThePeriodFromSameAsInputWhenJsonIsGiven() {
        HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);

        String periodFromString = dateFormat.format(hdoDefinition.getConsumptionPlaces().get(0).getHdoCode().getHdoperiodSet().get(0).getPeriodFrom());

        assertThat(periodFromString).isEqualTo(getUtcTime(PERIOD_FROM));
    }

    @Test
    void isThePeriodToSameAsInputWhenJsonIsGiven() {
        HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);

        String periodToString = dateFormat.format(hdoDefinition.getConsumptionPlaces().get(0).getHdoCode().getHdoperiodSet().get(0).getPeriodTo());

        assertThat(periodToString).isEqualTo(getUtcTime(PERIOD_TO));
    }

    private String getUtcTime(String periodFrom) {
        return periodFrom.substring(0, 19);
    }

}
