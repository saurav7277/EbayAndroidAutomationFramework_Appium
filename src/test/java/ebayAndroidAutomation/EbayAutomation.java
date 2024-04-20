package ebayAndroidAutomation;

import ebayAndroidAutomation.base.BaseClass;
import ebayAndroidAutomation.pages.*;
import ebayAndroidAutomation.reportManager.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ebayAndroidAutomation.config.DriverManager;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class EbayAutomation extends BaseClass {

    WelcomePage welcomepage;
    SignInPage loginPage;
    AndroidDriver driver;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductDetailsPage productDetailsPage;
    SignInPage signInPage;


    @BeforeClass
    public void beforeClass() throws IOException {
        driver=DriverManager.getDriverInstance();
        welcomepage = new WelcomePage(driver);
        loginPage = new SignInPage(driver);
        homePage= new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        signInPage = new SignInPage(driver);

    }


    @Test
    public void printFirstNItemsDetailsFromSearchResult(){
        ExtentTestManager.getTest().info("Opening app on device");
        ExtentTestManager.getTest().info("Waiting for app to load on device");
        welcomepage.waitForAppToLoad();
        ExtentTestManager.getTest().info("Clicking on Sign in frame cross Button");
        welcomepage.clickOnSignInPopupCrossButton();
        ExtentTestManager.getTest().info("Searching items");
        homePage.searchItem("iphone 15");
        ExtentTestManager.getTest().info("Sorting items by price");
        searchResultPage.sortItemsByPrice("LOW_TO_HIGH");
        ExtentTestManager.getTest().info("Fecthing first N items name and its price as list");
        searchResultPage.getFirstNItemsNameAndPrice(4);
        ExtentTestManager.getTest().info("Clicking first product from search result");
        searchResultPage.clickFirstProductFromSearchResult();
        ExtentTestManager.getTest().info("Clicking on add to watchlist");
        productDetailsPage.addToWatchList();
        ExtentTestManager.getTest().info("Verifying if sign-in page displayed");
        signInPage.verifyIfSignInPageDisplayed();
        ExtentTestManager.getTest().info("Closing sign-in page");
        signInPage.closeSignInPage();
    }
}
