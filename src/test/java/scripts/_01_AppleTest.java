package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class _01_AppleTest {

    // Declare your driver
    WebDriver driver;

    // 1. Initial setup
    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
    }

    // 2. Validation of test
    @Test
    public void testAppleTitle() {
        driver.get("https://www.apple.com/");

        String expectedTitle = "Apple"; // requirement
        String actualTitle = driver.getTitle(); // development

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testAppleURL() {
        driver.get("https://www.apple.com/");

        String expectedURL = "https://www.apple.com/"; // requirement
        String actualURL = driver.getCurrentUrl(); // development

        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void X() {
        // Used for known issues
        Assert.fail("Failed on purpose");
    }

    // 3. Teardown actions
    @AfterMethod
    public void teardown() {
        Driver.quitDriver();
    }
}
