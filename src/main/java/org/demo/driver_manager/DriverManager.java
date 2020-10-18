package org.demo.driver_manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public class DriverManager {

    private static WebDriver driver;
    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal();
    private static DriverManager driverManager;

    public static synchronized DriverManager getInstance() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public void createWebDriver(String browserName) throws IOException {
        switch (browserName.toLowerCase()) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Error creating web driver");
                throw new IOException();
        }

        driverThreadLocal.set(driver);
    }

    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getCurrentDriver() {
        return driverThreadLocal.get();
    }


}
