package com.automation.tests.pages;

import com.automation.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PurchaseSummaryPage extends BasePage {

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/a[2]")
    private WebElement link_HomePage;

    public HomePage NavigateToHomePage(){
        link_HomePage.click();
        return GetInstance(HomePage.class);
    }
}
