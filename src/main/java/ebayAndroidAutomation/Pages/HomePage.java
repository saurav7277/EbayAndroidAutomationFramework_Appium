package ebayAndroidAutomation.pages;

import com.google.common.collect.ImmutableMap;
import ebayAndroidAutomation.utility.AppiumUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    AndroidDriver driver;
    Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(AndroidDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id = "com.ebay.mobile:id/search_box")
    public WebElement searchBox;

    @FindBy(id = "com.ebay.mobile:id/search_src_text")
    public WebElement searchInText;

    public void searchItem(String itemToSearch) {
        logger.info("In search bar searching the Item for purchase");
        AppiumUtil.waitForElement(searchBox);
        searchBox.click();
        AppiumUtil.waitForElement(searchInText);
        searchInText.sendKeys(itemToSearch);
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
    }

}
