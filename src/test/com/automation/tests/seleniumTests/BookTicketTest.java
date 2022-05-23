package com.automation.tests.seleniumTests;

import com.automation.framework.base.BrowserTypes;
import com.automation.framework.base.DriverContext;
import com.automation.framework.base.FrameworkInitialize;
import com.automation.framework.utils.ConfigUtilities;
import com.automation.tests.pages.HomePage;
import com.automation.tests.pages.PaymentPage;
import com.automation.tests.pages.PurchaseSummaryPage;
import com.automation.tests.pages.SearchResultsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BookTicketTest extends FrameworkInitialize {

    ExtentReports extent;
    ExtentTest logger;

    @BeforeMethod
    public void Initialize() throws IOException {
        InitializeBrowser(BrowserTypes.Chrome);
        DriverContext.BROWSER.GoTo(ConfigUtilities.GetGlobalConfig("URL"));
        DriverContext.BROWSER.Maximize();
        DriverContext.BROWSER.SetTimeOut();
    }

    @BeforeTest
    public void StartReporting(){
        extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
        extent.addSystemInfo("Host Name", "Blaze Demo")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Karthic E Selvan");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
    }

    @Test
    public void Test_BookFlights(){
        logger = extent.startTest("Book Flights");
        CURRENT_PAGE = GetInstance(HomePage.class);
        CURRENT_PAGE = CURRENT_PAGE.As(HomePage.class).SearchFlights("Boston", "Cairo");
        CURRENT_PAGE = CURRENT_PAGE.As(SearchResultsPage.class).SelectFlight("Airline", "Aer Lingus");
        CURRENT_PAGE = CURRENT_PAGE.As(PaymentPage.class).PurchaseFlight();
        CURRENT_PAGE = CURRENT_PAGE.As(PurchaseSummaryPage.class).NavigateToHomePage();
        logger.log(LogStatus.PASS, "Test Book Flights is passed");
    }

    @Test
    public void Test_BookFlights_2(){
        logger = extent.startTest("Book Flights 2");
        CURRENT_PAGE = GetInstance(HomePage.class);
        CURRENT_PAGE = CURRENT_PAGE.As(HomePage.class).SearchFlights("Boston", "Cairo");
        CURRENT_PAGE = CURRENT_PAGE.As(SearchResultsPage.class).SelectFlight("Airline", "Aer Lingus");
        CURRENT_PAGE = CURRENT_PAGE.As(PaymentPage.class).PurchaseFlight();
        CURRENT_PAGE = CURRENT_PAGE.As(PurchaseSummaryPage.class).NavigateToHomePage();
        logger.log(LogStatus.PASS, "Test Book Flights 2 is passed");
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
        }
    }


    @AfterTest
    public void endReport(){
        extent.flush();

    }

    @AfterSuite
    public void TearDown() throws IOException {
        DriverContext.BROWSER.Close();
    }


}
