package ebayAndroidAutomation.Pages;

import ebayAndroidAutomation.config.CommonAppiumTest;
import ebayAndroidAutomation.config.ScreenShotUtil;
import ebayAndroidAutomation.config.ScrollElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static ebayAndroidAutomation.config.DriverManager.prop;

public class AddProductToCart {
    AndroidDriver driver;
    Logger logger = Logger.getLogger(AddProductToCart.class);
    public AddProductToCart(AndroidDriver ldriver)
    {
        this.driver=ldriver;
    }

    @AndroidFindBy(id = "com.ebay.mobile:id/search_box")
    public WebElement SearchBox;

    @AndroidFindBy(id="com.ebay.mobile:id/search_src_text")
    public WebElement SearchInText;

    @AndroidFindBy(xpath = ".//*[@text='Hamlet William Shakespeare Wordsworth Classics Paperback Book New Free UK Post']")
    private WebElement Product;

    @AndroidFindBy(id="com.ebay.mobile:id/button_add_to_cart")
    public WebElement AddToCartButton;

    @AndroidFindBy(id="com.ebay.mobile:id/fragmentContainer")
    public MobileElement ProductContainer;

    @AndroidFindBy(id="com.ebay.mobile:id/top_scrollview_content")
    public MobileElement ScrollinProductPage;

    String str="ADD TO CART";
    String Item="Hamlet NEW BOOK";


    public void SearchBox()
    {
        logger.info("Click button or tap on screen");
        try {
            Thread.sleep(3000);
            SearchBox.click();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Search button clicked");
    }

    public void SearchItemFromSearchBox()
    {
        logger.info("In search bar searching the Item for purchase");
        SearchInText.sendKeys(prop.getProperty("SearchItemForPurchase"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_PAGE_DOWN);
        driver.pressKeyCode(AndroidKeyCode.ENTER);
    }

    public boolean SelectProduct()
    {
        logger.info("In select product");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MobileElement ProductFromList=ScrollElement.scrollToExactElement(ProductContainer,Item);
        //ScreenShotUtil.capscreen(driver);
        ProductFromList.click();
        logger.info("In product buy page");
        MobileElement AddToCartID=ScrollElement.ScrollToElement(ScrollinProductPage,str);
        AddToCartID.click();
        logger.info("Product Added to cart succesfully");
        return true;

    }



}
