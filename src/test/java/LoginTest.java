import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import config.baseSetup;
import pages.login.LoginScreen;
import util.util;
import java.time.Duration;

public class LoginTest extends baseSetup{

    @Test()
    @Description("Valid Login")
    public void testLogin1() {
        System.out.println("Running test: driver is " + (driver != null ? "initialized" : "null"));
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.validLogin();
        util util = new util(driver);
        util.takeScreenshot(driver, "screenshots/testLogin1.png");
    }

    @Test()
    @Description("Invalid Login")
    public void testinvalidLogin1() {
        System.out.println("Running test: driver is " + (driver != null ? "initialized" : "null"));
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.invalidLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Assert.assertEquals(loginScreen.btnError.getText(), "Epic sadface: Username and password do not match any user in this service");
        util util = new util(driver);
        util.takeScreenshot(driver, "screenshots/testLogin1.png");
    }

}
