package ebayAndroidAutomation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.aventstack.extentreports.ExtentTest;
import ebayAndroidAutomation.Pages.AddProductToCart;
import ebayAndroidAutomation.Pages.LoginPage;
import ebayAndroidAutomation.config.CommonAppiumTest;
import ebayAndroidAutomation.config.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ebayAndroidAutomation.Pages.WelcomePage;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class EbayFlowTillAddCart extends BaseClass{

    DriverManager driverManager;
    WelcomePage welcomepage;
    LoginPage loginPage;
    AddProductToCart addProductToCart;
    AndroidDriver driver;
    CommonAppiumTest commonAppiumTest;
    boolean status=true;

    @Test
    public void SelectItems() throws InterruptedException, IOException
    {
        test=extent.createTest("Add product Test","Login and add product you cart");
        driver=DriverManager.getDriver();
        welcomepage = new WelcomePage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),welcomepage);
        test.info("Opening app on device");
        test.info("Waiting for app to load device");
        welcomepage.waitForAppToLoadLogo();
        test.info("Clicking on Sign in Button");
        welcomepage.ClickOnSignIn();
        //Assert.assertTrue(status);
       loginPage=new LoginPage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),loginPage);
        test.info("Performing login action");
        loginPage.LoginInApp();
        test.info("Login succesfull");
        addProductToCart=new AddProductToCart(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),addProductToCart);
        test.info("Clicking on Search box for product search");
        addProductToCart.SearchBox();
        test.info("Searched Item in search box");
        addProductToCart.SearchItemFromSearchBox();
        test.info("Add product to cart");
        addProductToCart.SelectProduct();
        test.info("Product Added in Cart sucessfully");
    }

}
