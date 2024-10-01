package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;


public class baseSetup {
    public WebDriver driver;

    @BeforeMethod
    public WebDriver setupClass() {
        System.out.println("Running setupClass: Setting up WebDriverManager...");
        WebDriverManager.chromedriver().setup();
        System.out.println("Running setupTest: Initializing ChromeDriver...");
        return driver;
    }

    @BeforeClass
    public WebDriver setupTest() {
        System.out.println("Running setupTest: Initializing ChromeDriver...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Driver initialized: " + (driver != null));
        return driver;
    }

    public static File takeScreenshotNew(WebDriver driver, String testName) {
        String screenshootPath = null;
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            screenshootPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
            FileUtils.copyFile(src, new File(screenshootPath));
        } catch (IOException e) {
            e.printStackTrace();}
        return src;
    }

    @AfterClass(alwaysRun = true)
    public void teardown(ITestContext result) throws IOException {
//        File path = takeScreenshotNew(driver, result.getName());
//        Allure.addAttachment("Screenshot", FileUtils.openInputStream(path));
        System.out.println("Test class name: " + result.getName());
        driver.quit();
    }
}
