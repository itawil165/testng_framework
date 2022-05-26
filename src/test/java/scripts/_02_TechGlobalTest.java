package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;

public class _02_TechGlobalTest {
    /*
    1. Go to "https://www.techglobalschool.com/apply-now"
    2. Validate the heading1 is displayed and the text for it is ="Application Form"
    */

    // 1. Set up
    // Declare your driver
    WebDriver driver;

    // 1. Initial setup
    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
    }

    // 2. Validate test
    @Test(description = "TC123: Validate Application Form heading")
    public void testApplicationFormHeading() {
        driver.get("https://www.techglobalschool.com/apply-now");

        WebElement heading1 = driver.findElement(By.xpath("//div[@id='comp-kh9s3kyz3']//span/span"));

        Assert.assertTrue(heading1.isDisplayed());
        Assert.assertEquals(heading1.getText(), "Application Form");
    }

    // 3. Teardown
    @AfterMethod
    public void teardown() {
        Driver.quitDriver();
    }
}
