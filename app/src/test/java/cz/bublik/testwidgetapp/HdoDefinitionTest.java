package cz.bublik.testwidgetapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import cz.bublik.testwidgetapp.widget.model.HdoDefinition;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HdoDefinitionTest {

    private static final String PERIODS_GSON_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String PERIODS_JAVA_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private DateFormat dateFormat = new SimpleDateFormat(PERIODS_JAVA_DATE_FORMAT);
    private Gson gson;

    private static String PERIOD_FROM = "2020-01-31T23:00:00+00:00";
    private static String PERIOD_TO = "2020-03-29T22:59:59+00:00";

    @BeforeAll
    public void setup() {
        gson = new GsonBuilder().setDateFormat(PERIODS_GSON_DATE_FORMAT).create();
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Test
    public void canTheHdoObjectBeCreatedWhenJsonIsGiven() {
        HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);

        assertThat(hdoDefinition).isNotNull();
    }

    @Test
    public void isOneConsumptionPlaceParsedWhenJsonIsGiven() {
        HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);

        assertThat(hdoDefinition.getConsumptionPlaces()).hasSize(1);
    }

    @Test
    public void isOneHdoPeriodSetParsedWhenJsonIsGiven() {
        HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);

        assertThat(hdoDefinition.getConsumptionPlaces().get(0).getHdoCode().getHdoperiodSet()).hasSize(1);
    }

    @Test
    public void isThePeriodFromSameAsInputWhenJsonIsGiven() {
        HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);

        String periodFromString = dateFormat.format(hdoDefinition.getConsumptionPlaces().get(0).getHdoCode().getHdoperiodSet().get(0).getPeriodFrom());

        assertThat(periodFromString).isEqualTo(getUtcTime(PERIOD_FROM));
    }

    @Test
    public void isThePeriodToSameAsInputWhenJsonIsGiven() {
        HdoDefinition hdoDefinition = gson.fromJson(JSON_SAMPLE, HdoDefinition.class);

        String periodToString = dateFormat.format(hdoDefinition.getConsumptionPlaces().get(0).getHdoCode().getHdoperiodSet().get(0).getPeriodTo());

        assertThat(periodToString).isEqualTo(getUtcTime(PERIOD_TO));
    }

    private String getUtcTime(String periodFrom) {
        return periodFrom.substring(0, 19);
    }

    private final String JSON_SAMPLE = "{\n" +
            "  \"consumptionPlaces\": [\n" +
            "    {\n" +
            "      \"name\": \"Domov\",\n" +
            "      \"icon\": \"socket\",\n" +
            "      \"hdoCode\": {\n" +
            "        \"hdoperiodSet\": [\n" +
            "          {\n" +
            "            \"periodFrom\": \"" + PERIOD_FROM + "\",\n" +
            "            \"periodTo\": \"" + PERIOD_TO + "\",\n" +
            "            \"hdorateSet\": [\n" +
            "              {\n" +
            "                \"rate\": \"PV\",\n" +
            "                \"hdodayofweekSet\": [\n" +
            "                  {\n" +
            "                    \"weekDay\": 1,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"08:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 2,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"08:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 3,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"08:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 4,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"08:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 5,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"08:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 6,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"18:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"19:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 7,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"18:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"19:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"rate\": \"TAR\",\n" +
            "                \"hdodayofweekSet\": [\n" +
            "                  {\n" +
            "                    \"weekDay\": 1,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"08:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 2,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"08:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 3,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"08:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 4,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"08:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 5,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"08:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 6,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"18:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"19:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 7,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"10:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"11:00:00\",\n" +
            "                        \"timeslotTo\": \"14:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"18:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"19:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"21:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  }\n" +
            "                ]\n" +
            "              },\n" +
            "              {\n" +
            "                \"rate\": \"TUV\",\n" +
            "                \"hdodayofweekSet\": [\n" +
            "                  {\n" +
            "                    \"weekDay\": 1,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"02:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"03:00:00\",\n" +
            "                        \"timeslotTo\": \"06:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"17:00:00\",\n" +
            "                        \"timeslotTo\": \"18:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"22:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 2,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"02:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"03:00:00\",\n" +
            "                        \"timeslotTo\": \"06:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"17:00:00\",\n" +
            "                        \"timeslotTo\": \"18:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"22:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 3,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"02:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"03:00:00\",\n" +
            "                        \"timeslotTo\": \"06:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"17:00:00\",\n" +
            "                        \"timeslotTo\": \"18:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"22:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 4,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"02:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"03:00:00\",\n" +
            "                        \"timeslotTo\": \"06:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"17:00:00\",\n" +
            "                        \"timeslotTo\": \"18:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"22:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 5,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"00:00:00\",\n" +
            "                        \"timeslotTo\": \"02:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"03:00:00\",\n" +
            "                        \"timeslotTo\": \"06:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"17:00:00\",\n" +
            "                        \"timeslotTo\": \"18:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"22:00:00\",\n" +
            "                        \"timeslotTo\": \"23:59:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 6,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"03:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"18:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"19:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  {\n" +
            "                    \"weekDay\": 7,\n" +
            "                    \"hdotimeslotSet\": [\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"03:00:00\",\n" +
            "                        \"timeslotTo\": \"07:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"15:00:00\",\n" +
            "                        \"timeslotTo\": \"18:00:00\"\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"timeslotFrom\": \"19:00:00\",\n" +
            "                        \"timeslotTo\": \"20:00:00\"\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  }\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }]\n" +
            "}";
}
