package org.demo.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumWebDrivers {
    CHROME("CHROME"),
    IE("INTERNETEXPLORER"),
    FIREFOX("FIREFOX");

    private static Map<String, EnumWebDrivers> lookup = new HashMap<>();

    static {
        for (EnumWebDrivers type : EnumWebDrivers.values()) {
            lookup.put(type.name(), type);
        }
    }

    private String webDrivers;

    public String obtainDriverName() {
        return this.webDrivers;
    }

    EnumWebDrivers(String webDrivers) {
        this.webDrivers = webDrivers;
    }

    public static EnumWebDrivers getEnumWebDriver(String webDriver) {
        return lookup.get(webDriver);
    }

}
