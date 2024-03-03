package ebayAndroidAutomation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePage {
    AndroidDriver driver;
    Logger logger = Logger.getLogger(WelcomePage.class);
    public WelcomePage(AndroidDriver ldriver)
    {
        this.driver=ldriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "com.ebay.mobile:id/button_classic")
    public WebElement SignInWelcomePage;

    @FindBy(id="com.ebay.mobile:id/identity_app_onboarding_screen_close")
    public  WebElement crossButton;


    public void waitForAppToLoad()
    {
        logger.info("Waiting for App to load");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.ebay.mobile:id/identity_app_onboarding_logo")));
        logger.info("App to loaded successfully");

    }

    public void clickOnSignInPopupCrossButton()
    {
        logger.info("Click on Sign In Popup Cross Button");
        crossButton.click();
        logger.info("Clicked on Sign In Popup Cross Button");
    }


}
