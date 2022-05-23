package com.automation.framework.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

public class FrameworkInitialize extends Base{

    public void InitializeBrowser(BrowserTypes browserTypes){
        WebDriver driver = null;

        switch (browserTypes){
            case IE:
            case Edge:
            case Firefox:
                System.setProperty("webdriver.gecko.driver" ,System.getProperty("user.dir") + "/src/com/automation/framework/utils/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case Chrome:
                System.setProperty("webdriver.chrome.driver" ,System.getProperty("user.dir") + "/src/com/automation/framework/utils/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }

        DriverContext.setDRIVER(driver);
        DriverContext.BROWSER = new Browser(driver);
    }

}
