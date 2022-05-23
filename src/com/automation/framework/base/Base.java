package com.automation.framework.base;

import org.openqa.selenium.support.PageFactory;

public class Base {

    public static BasePage CURRENT_PAGE;

    public <TPage extends BasePage> TPage GetInstance(Class<TPage> page){
        Object obj = PageFactory.initElements(DriverContext.DRIVER, page);
        return page.cast(obj);
    }
}
