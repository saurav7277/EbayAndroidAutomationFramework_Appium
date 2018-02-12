package ebayAndroidAutomation.Pages;

import ebayAndroidAutomation.config.ExcelDataProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static ebayAndroidAutomation.config.DriverManager.prop;

public class LoginPage {

    AndroidDriver driver;
    Logger logger = Logger.getLogger(WelcomePage.class);
   // ExcelDataProvider excelDataProvider;

    public  LoginPage(AndroidDriver driver)
    {
        this.driver=driver;
    }

    @AndroidFindBy(id="com.ebay.mobile:id/edit_text_username")
    private WebElement username;

    @AndroidFindBy(id="com.ebay.mobile:id/edit_text_password")
    private WebElement password;

    @AndroidFindBy(id="com.ebay.mobile:id/button_sign_in")
    private WebElement SignInButton;

    public AddProductToCart LoginInApp()
    {
        // String popup=driver.getContext();
        //String pagedata=driver.getPageSource();
        //System.out.println("Contex ID is"+popup+"PageData:"+pagedata);
        logger.info("In Sign in Frame");
        driver.hideKeyboard();
        logger.info("Entering Username");
        //username.sendKeys(excelDataProvider.getCellData(1,1,0));
        username.sendKeys(prop.getProperty("Username"));
        logger.info("Entering password");
        //password.sendKeys(excelDataProvider.getCellData(1,1,2));
        password.sendKeys(prop.getProperty("Password"));
        SignInButton.click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_DOWN);
        logger.info("Keypad down pressed");
        driver.pressKeyCode(AndroidKeyCode.ENTER);
        logger.info("Clicked Enter");
        logger.info("Signed succesfully in app");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AddProductToCart(driver);
    }
}
