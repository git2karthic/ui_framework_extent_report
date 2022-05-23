package com.automation.framework.base;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Browser {

    public WebDriver _driver;

    public Browser(WebDriver _driver) {
        this._driver = _driver;
    }

    public void GoTo(String url){
        this._driver.navigate().to(url);
    }

    public void Close (){
        this._driver.close();
    }

    public void Maximize(){
        this._driver.manage().window().maximize();
    }

    public void SetTimeOut(){
        this._driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
