package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _09_iFrames extends Base {

    @Test(priority = 1)
    public void testIFrames () {

        driver.get("https://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Frames");

        heroAppPage.iFrameLink.click();

        // Switch driver to inner HTML (iFrame)
//        driver.switchTo().frame(0);
//        driver.switchTo().frame("mce_0_ifr");
        driver.switchTo().frame(heroAppPage.innerIFrame);
        Waiter.pause(1);

        heroAppPage.contentBox.clear();
        heroAppPage.contentBox.sendKeys("Hello World!");
        Assert.assertEquals(heroAppPage.contentBox.getText(), "Hello World!");
        Waiter.pause(1);

        // Switch driver back to outer HTML
        driver.switchTo().parentFrame(); // or .defaultContent();
        Assert.assertEquals(heroAppPage.iFrameHeading3.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
        Waiter.pause(3);
    }

    /*
    Go to https://www.rediff.com/
    Validate money iFrame displayed with cell one and cell two
    */
    @Test(priority = 2)
    public void testIFrame2(){
        driver.get("https://www.rediff.com/");

        driver.switchTo().frame(rediffHomePage.moneyIFrame);
//        driver.switchTo().frame(0);
//        driver.switchTo().frame("moneyiframe");

        for(WebElement element : rediffHomePage.moneyCells){
            Assert.assertTrue(element.isDisplayed());
        }
    }
}
