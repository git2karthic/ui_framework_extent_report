package com.automation.tests.pages;

import com.automation.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentPage extends BasePage {

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/form/div[11]/div/input")
    private WebElement btn_PurchaseFlight;

    public PurchaseSummaryPage PurchaseFlight(){
        btn_PurchaseFlight.click();
        return GetInstance(PurchaseSummaryPage.class);
    }


}
