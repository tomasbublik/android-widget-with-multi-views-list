package cz.bublik.testwidgetapp;

public class Const {

    private Const() {
    }
    static String PERIOD_FROM = "2020-01-31T23:00:00+00:00";
    static String PERIOD_TO = "2020-03-29T22:59:59+00:00";

    public static final String JSON_SAMPLE = "{\n" +
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

    public static final String MULTI_CONSUMPTIONS_SAMPLE = "{\n" +
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
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Home2\",\n" +
            "      \"icon\": \"socket\",\n" +
            "      \"hdoCode\": {\n" +
            "        \"hdoperiodSet\": [\n" +
            "          {\n" +
            "            \"periodFrom\": \"2020-03-30T00:00:00+00:00\",\n" +
            "            \"periodTo\": \"2020-06-29T23:59:59+00:00\",\n" +
            "            \"hdorateSet\": [\n" +
            "              {\n" +
            "                \"rate\": \"PV2\",\n" +
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
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";
}
