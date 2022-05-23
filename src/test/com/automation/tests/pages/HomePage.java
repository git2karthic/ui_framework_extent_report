package com.automation.tests.pages;

import com.automation.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//select[@name='fromPort']")
    private WebElement dd_From;
    @FindBy(how = How.XPATH, using = "//select[@name='toPort']")
    private WebElement dd_to;
    @FindBy(how = How.XPATH, using = "//input[@value='Find Flights']")
    private WebElement btn_FindFlights;

    public SearchResultsPage SearchFlights(String departure, String destination){
        Select select = new Select(dd_From);
        select.selectByVisibleText(departure);
        select = new Select(dd_to);
        btn_FindFlights.click();
        return GetInstance(SearchResultsPage.class);
    }

}
