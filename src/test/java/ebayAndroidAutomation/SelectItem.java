package ebayAndroidAutomation;

import org.testng.annotations.Test;
import ebayAndroidAutomation.Pages.WelcomePage;
import org.openqa.selenium.support.PageFactory;

public class SelectItem extends BaseClass{


    @Test
    public void SelectItems()
    {
        System.out.println("\n In test");
        WelcomePage welcomepage=PageFactory.initElements(driver,WelcomePage.class);
        welcomepage.WaitForLoadLogo();
        welcomepage.ClickOnSignIn();
        //welcomepage.selectItem();
    }

}
