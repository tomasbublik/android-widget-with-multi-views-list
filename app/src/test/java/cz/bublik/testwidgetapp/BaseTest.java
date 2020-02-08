package cz.bublik.testwidgetapp;

import com.google.gson.Gson;

import org.junit.jupiter.api.TestInstance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected static final String PERIODS_GSON_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    static final String PERIODS_JAVA_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    protected DateFormat dateFormat = new SimpleDateFormat(PERIODS_JAVA_DATE_FORMAT);
    public Gson gson;
}
