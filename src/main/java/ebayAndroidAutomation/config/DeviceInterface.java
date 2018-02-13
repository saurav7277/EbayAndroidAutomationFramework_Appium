package ebayAndroidAutomation.config;

import java.io.IOException;
import ebayAndroidAutomation.Pages.LoginPage;
import ebayAndroidAutomation.Pages.WelcomePage;

public interface DeviceInterface {

    public void waitForHomePage(WelcomePage welcomePage);
    public void login(LoginPage loginPage, String username, String password) throws IOException, InterruptedException;


}
