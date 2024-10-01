package pages.login;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginScreen {
    @FindBy(className = "login_logo")
    public WebElement header_name;

    @FindBy(xpath = "//input[@data-test='username']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@data-test='password']")
    public WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement btnLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement btnError;

    @FindBy(id = "com.loginmodule.learning:id/textViewLinkRegister")
    public WebElement register_text;

    @FindBy(id = "com.loginmodule.learning:id/textViewName")
    public WebElement email_info;

    @FindBy(id ="com.loginmodule.learning:id/snackbar_text")
    public WebElement snack_bar_info;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Enter Valid Email\"]")
    public WebElement red_line_error_username;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Enter Valid Email\"]")
    public WebElement red_line_error_pass;

    WebDriver driver;


    public LoginScreen(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements( driver ,this);
    }

    @Step("Go To Login Page")
    public void validLogin(){
        driver.get("https://saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(elementToBeClickable(header_name));
        try{
            userNameInput.sendKeys("standard_user");
            passwordInput.sendKeys("secret_sauce");
            btnLogin.click();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

    }

    @Step("Go To Login Page")
    public void invalidLogin(){
        driver.get("https://saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(elementToBeClickable(header_name));
        userNameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce123");
        btnLogin.click();
        System.out.println(btnError.getText());
    }

}
