package org.demo.glue;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.demo.driver_manager.DriverManager;

import java.io.IOException;

public class Hooks {

    @Before
    public void setUp() throws IOException {
        DriverManager.getInstance().createWebDriver("chrome");
        DriverManager.getCurrentDriver().get("https://www.zalando.es/");
        DriverManager.getCurrentDriver().manage().window().maximize();
    }

    @After
    public void tearDown(){
        DriverManager.quitWebDriver();
    }

}
