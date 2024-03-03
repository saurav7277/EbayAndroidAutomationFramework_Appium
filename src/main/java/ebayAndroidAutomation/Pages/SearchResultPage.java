package ebayAndroidAutomation.pages;

import ebayAndroidAutomation.utility.AppiumUtil;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {
    AndroidDriver driver;
    Logger logger = Logger.getLogger(SearchResultPage.class);

    public SearchResultPage(AndroidDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id = "com.ebay.mobile:id/button_sort")
    public WebElement sortButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.ebay.mobile:id/search_textview_filter_title\" and @text=\"Lowest Price + Shipping\"]")
    public WebElement lowToHighPriceSort;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.ebay.mobile:id/search_textview_filter_title\" and @text=\"Highest Price + Shipping\"]")
    public WebElement highToLowPriceSort;

    @FindBy(id = "com.ebay.mobile:id/textview_header_0")
    public List<WebElement> itemName;

    @FindBy(id = "com.ebay.mobile:id/textview_primary_0")
    public List<WebElement> itemPrice;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.ebay.mobile:id/cell_collection_item\"])[1]")
    public WebElement firstItemFromSearchResult;

    @FindBy(id = "com.ebay.mobile:id/text_slot_1")
    public WebElement saveThisSearchTextPopup;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.ebay.mobile:id/cell_collection_item\"]")
    public List<WebElement> allItems;


    public void sortItemsByPrice(String sortType){
        AppiumUtil.waitForElement(saveThisSearchTextPopup);
        saveThisSearchTextPopup.click();
        AppiumUtil.waitForElement(sortButton);
        sortButton.click();
        switch (sortType){
            case "LOW_TO_HIGH":
                lowToHighPriceSort.click();
                break;

            case "HIGH_TO_LOW":
                highToLowPriceSort.click();
                break;
        }
    }

    public List<String> getFirstNItemsNameAndPrice(int n){
        String xpathItemName = "//android.widget.TextView[@resource-id=\"com.ebay.mobile:id/textview_header_0\"]";
        String xpathItemPrice = "//android.widget.TextView[@resource-id=\"com.ebay.mobile:id/textview_primary_0\"]";
        List<String> itemsDetails = new ArrayList<>();
        List<String> itemsName = new ArrayList<>();

        for(int i=0; i<allItems.size()-1; i++){
            itemsDetails.add(allItems.get(i).findElement(By.xpath(xpathItemName)).getText()+" ---> "+allItems.get(i).findElement(By.xpath(xpathItemPrice)).getText());
            itemsName.add(allItems.get(i).findElement(By.xpath(xpathItemName)).getText());
        }

        while (itemsDetails.size()!=n){
            AppiumUtil.scrollPageDownWithNoOfScroll(driver, 1);
            for(int j=0; j<allItems.size()-1; j++){
                if(!itemsName.contains(allItems.get(j).findElement(By.xpath(xpathItemName)).getText()))
                {
                    itemsDetails.add(allItems.get(j).findElement(By.xpath(xpathItemName)).getText()+" ---> "+allItems.get(j).findElement(By.xpath(xpathItemPrice)).getText());
                    itemsName.add(allItems.get(j).findElement(By.xpath(xpathItemName)).getText());

                }
                if(itemsDetails.size()==n){
                    break;
                }
            }
        }
        logger.info(itemsDetails);
        AppiumUtil.scrollPageUpWithNoOfScroll(driver, 1);
        return itemsDetails;
    }

    public void clickFirstProductFromSearchResult(){
        AppiumUtil.waitForElement(firstItemFromSearchResult);
        firstItemFromSearchResult.click();

    }


}
