package ebayAndroidAutomation.pages;

import ebayAndroidAutomation.utility.AppiumUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignInPage {

    AndroidDriver driver;
    Logger logger = Logger.getLogger(SignInPage.class);

    public SignInPage(AndroidDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//android.widget.TextView[@text=\"Sign in\"]")
    private WebElement signInText;

    @FindBy(id="com.ebay.mobile:id/edit_text_username")
    private WebElement username;

    @FindBy(xpath="//android.widget.ImageButton[@content-desc=\"close\"]")
    private WebElement closeSignInButton;

    public void verifyIfSignInPageDisplayed(){
        AppiumUtil.waitForElement(driver, signInText);
        Assert.assertTrue(signInText.isDisplayed(), "SignIn page not displayed");
    }

    public void closeSignInPage(){
        closeSignInButton.click();
    }




}
