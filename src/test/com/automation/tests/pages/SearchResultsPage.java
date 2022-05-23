package com.automation.tests.pages;

import com.automation.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//table[@class='table']")
    private WebElement tbl_SearchResults;

    public PaymentPage SelectFlight(String key, String value){
        List<WebElement> rows = tbl_SearchResults.findElements(By.tagName("tr"));
        for(int i = 1; i < rows.size(); i++){
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if(key.equalsIgnoreCase("flightNumber")){
                String temp = cols.get(1).getText();
                if(temp.equalsIgnoreCase(value)){
                    cols.get(0).findElements(By.tagName("input")).get(0).click();
                    return GetInstance(PaymentPage.class);
                }
            }else if(key.equalsIgnoreCase("Airline")){
                String temp = cols.get(2).getText();
                if(temp.equalsIgnoreCase(value)){
                    cols.get(0).findElements(By.tagName("input")).get(0).click();
                    return GetInstance(PaymentPage.class);
                }
            }else if(key.equalsIgnoreCase("Departure")){
                String temp = cols.get(3).getText();
                if(temp.equalsIgnoreCase(value)){
                    cols.get(0).findElements(By.tagName("input")).get(0).click();
                    return GetInstance(PaymentPage.class);
                }
            }else if(key.equalsIgnoreCase("Arrival")){
                String temp = cols.get(4).getText();
                if(temp.equalsIgnoreCase(value)){
                    cols.get(0).findElements(By.tagName("input")).get(0).click();
                    return GetInstance(PaymentPage.class);
                }
            }else if(key.equalsIgnoreCase("Price")){
                String temp = cols.get(5).getText();
                if(temp.equalsIgnoreCase(value)){
                    cols.get(0).findElements(By.tagName("input")).get(0).click();
                    return GetInstance(PaymentPage.class);
                }
            }
        }

        return null;
    }
}
