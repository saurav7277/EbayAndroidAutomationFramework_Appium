package ebayAndroidAutomation.config;

import java.io.IOException;

public interface DeviceInterface {

    public void login(LoginPage loginPage, String username, String password) throws IOException, InterruptedException;

    public void waitForHomePage(WelcomePage welcomePage);
}
