package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _08_Alerts extends Base {

    /*
    TASK-5 - Amazon Address Modal
    Go to https://www.amazon.com/
    Click on "Select your address" link in the top navigation bar
    Validate "Choose your location" modal is displayed
    Enter your zip code to input box
    Click on "Apply" button
    Validate the zip code entered displayed in the delivery message
    */

    @Test(priority = 5, description = "TASK-5 - Amazon Address Modal")
    public void testAmazonAddressModal() {

        driver.get("https://www.amazon.com/");

        amazonHomePage.selectAddressLink.click();
        Assert.assertTrue(amazonHomePage.addressModal.isDisplayed());

        Waiter.pause(1);
        String zipCode = "60018";

        amazonHomePage.zipCodeInputBox.sendKeys(zipCode);
        amazonHomePage.applyButton.click();
        Waiter.pause(1);

        Assert.assertTrue(amazonHomePage.deliveryMessage.getText().contains(zipCode));
    }
}
