import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.homeScreen;
import util.util;
import config.baseSetup;

public class HomeTest extends baseSetup{


    @Test()
    @Description("Add item on Cart")
    public void testAddtoCart(){
        util util = new util(driver);
        util.login();
        homeScreen homeScreen = new homeScreen(driver);
        String getItemName = homeScreen.checkItem().get(2);
        homeScreen.addToChart(getItemName);
        homeScreen.verifyCart(getItemName);
    }

    @Test()
    @Description("Hamburger Button - About Page")
    public void testHamburgerButton(){
        util util = new util(driver);
        util.login();
        homeScreen homeScreen = new homeScreen(driver);
        homeScreen.hamburgerMenu();
    }
}
