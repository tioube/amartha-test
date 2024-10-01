package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class homeScreen {

    WebDriver driver;
    @FindBy(className = "app_logo")
    public WebElement appLogo;

    @FindBy(xpath = "//span[@data-test='title']")
    public WebElement title;

    @FindBy(xpath = "//*[@data-test='inventory-item-name']")
    public WebElement dataItem;

    @FindBy(xpath = "//span[@data-test='shopping-cart-badge']")
    WebElement shoppingCartBadge;

    @FindBy(id = "react-burger-menu-btn")
    WebElement hamburgerMenu;

    @FindBy(id="about_sidebar_link")
    WebElement aboutMenu;


    public homeScreen(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements( driver ,this);
    }
    @Step("Check Item")
    public List<String> checkItem(){
        List<WebElement> itemElements = driver.findElements(By.cssSelector("[data-test='inventory-item-name']"));
        List<String> itemNames = new ArrayList<>();
        for (WebElement items : itemElements) {
            itemNames.add(items.getText());
        }
        System.out.println("Total items: " + itemNames.size());
        System.out.println("Item names: " + itemNames);


        return itemNames;

    }

    @Step(value = "Add to Chart : {itemNames}")
    public void addToChart(String itemNames){
        checkItem();
        WebElement item = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='" + itemNames + "']"));
        WebElement addToCartButton = item.findElement(By.xpath(".//ancestor::div[@data-test='inventory-item-description']//button[@data-test='add-to-cart-" + itemNames.toLowerCase().replace(" ", "-") + "']"));
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Assert.assertEquals(shoppingCartBadge.getText(), "1");
    }

    @Step(value = "Verify Cart}")
    public void verifyCart(String itemNames){
        shoppingCartBadge.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until((ExpectedConditions.visibilityOf(title)));
        Assert.assertEquals(dataItem.getText(),itemNames);
    }

    @Step(value = "Click Hamburger Menu")
    public void hamburgerMenu() {
        hamburgerMenu.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            // Wait for the element to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(aboutMenu));
            aboutMenu.click();
            String pageTitle = driver.getTitle();
            Assert.assertEquals(pageTitle,"Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
        } catch (Exception e) {
            System.out.println("Element not interactable: " + e.getMessage());
        }

    }
}
