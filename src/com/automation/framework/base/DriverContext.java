package com.automation.framework.base;

import org.openqa.selenium.WebDriver;

public class DriverContext {
    public static WebDriver DRIVER;
    public static Browser BROWSER;

    public static void setDRIVER(WebDriver DRIVER) {

        DriverContext.DRIVER = DRIVER;
    }
}
