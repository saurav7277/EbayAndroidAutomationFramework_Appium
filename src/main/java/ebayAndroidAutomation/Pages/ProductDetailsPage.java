package ebayAndroidAutomation.pages;

import ebayAndroidAutomation.utility.AppiumUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    AndroidDriver driver;
    Logger logger = Logger.getLogger(ProductDetailsPage.class);

    public ProductDetailsPage(AndroidDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id = "com.ebay.mobile:id/vi_pages_menu_share_header")
    public WebElement itemShareButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Add to watchlist\"]")
    public WebElement addToWatchList;


    public void addToWatchList(){
        AppiumUtil.waitForElement(itemShareButton);
        AppiumUtil.ScrollToElement(driver, addToWatchList.getText());
        addToWatchList.click();
    }
}
