package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _05_CheckBoxTest extends Base {

    /*
    Go to http://the-internet.herokuapp.com/
    Click on "Checkboxes" link
    Validate "checkbox 1" is displayed, enabled and not selected
    Validate "checkbox 2" is displayed, enabled and selected
    Select "checkbox 1" and validate it is selected
    Deselect both "checkbox 1" and "checkbox 2" and validate they are deselected
    */

    @Test (priority = 1, description = "TC001: Validate checkbox in hero app")
    public void testCheckBoxInHeroApp(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Checkboxes");

        // Validate that both checkboxes are displayed and enabled
        for (WebElement element : heroAppPage.checkboxes) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.isEnabled());
        }

        // Validate that checkbox 1 is not selected and checkbox 2 is selected
        Assert.assertFalse(heroAppPage.checkboxes.get(0).isSelected());
        Assert.assertTrue(heroAppPage.checkboxes.get(1).isSelected());

        // Select checkbox 1 and validate that it is selected
        heroAppPage.checkboxes.get(0).click();
        Assert.assertTrue(heroAppPage.checkboxes.get(0).isSelected());

        // Deselect both checkbox 1 and 2 and validate that they are deselected
        for (WebElement element: heroAppPage.checkboxes) {
            element.click();
            Assert.assertFalse(element.isSelected());
        }


    }
}