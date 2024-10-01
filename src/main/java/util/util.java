package util;

import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.login.LoginScreen;
import pages.homeScreen;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
public class util {
    WebDriver driver;

    public util(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    };

    public void takeScreenshot(WebDriver driver, String filePath) {
        // Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            // Save the screenshot to the specified file path
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    @Step("Login User")
    public void login(){
        LoginScreen loginScreen = new LoginScreen(driver);
        homeScreen homeScreen = new homeScreen(driver);
        loginScreen.validLogin();
        homeScreen.appLogo.isDisplayed();
        homeScreen.title.isDisplayed();
    }

}
