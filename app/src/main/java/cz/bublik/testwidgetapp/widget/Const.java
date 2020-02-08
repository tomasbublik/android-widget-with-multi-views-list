package cz.bublik.testwidgetapp.widget;

public class Const {

    private Const(){}

    public static final String LEFT_BUTTON_CLICKED = "leftButtonClicked";
    public static final String RIGHT_BUTTON_CLICKED = "rightButtonClicked";
    static final String VARIANT = "cz.bublik.testwidgetapp.widget.VARIANT";

    /**
     * Variant with one column. Used when widget gets smaller.
     */
    static final String VARIANT_A = "cz.bublik.testwidgetapp.widget.VARIANT_A";

    /**
     * Variant with two columns. Used when widget gets spread.
     */
    static final String VARIANT_B = "cz.bublik.testwidgetapp.widget.VARIANT_B";

    public static final String REALISTIC_TEST_JSON = "{\n" +
            "  \"consumptionPlaces\": [\n" +
            "    {\n" +
            "      \"name\": \"Domov\",\n" +
            "      \"icon\": \"socket\",\n" +
            "      \"hdoCode\": {\n" +
            "        \"hdoperiodSet\": [\n" +
            "          {\n" +
            "            \"periodFrom\": \"2020-01-31T23:00:00+00:00\",\n" +
            "            \"periodTo\": \"2020-03-29T22:59:59+00:00\",\n" +
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
