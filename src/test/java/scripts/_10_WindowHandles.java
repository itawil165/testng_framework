package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _10_WindowHandles extends Base {

    /*
    TEST CASE 1: Validate FaceBook social media icon for TechGlobal School
    1. Go to https://www.techglobalschool.com/
    2. Click on FaceBook icon in the footer
    3. Validate user is routed to https://www.facebook.com/techglobalschool
    */

    @Test(priority = 1, description = "TEST CASE 1: Validate FaceBook social media icon for TechGlobal School")
    public void testTechGlobalSchoolFaceBookIcon(){

        driver.get("https://www.techglobalschool.com/");

        String tgHomeWindowHandle = driver.getWindowHandle();
        tgHomePage.faceBookIcon.click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(tgHomeWindowHandle)) driver.switchTo().window(windowHandle);
        }

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/techglobalschool");
    }

    /*
    TEST CASE 2: Multiple Windows
    Go to http://the-internet.herokuapp.com/
    Click on "Multiple Windows" link
    Click on "Click Here" link
    Validate the heading3 as "New Window"
    Navigate back to previous window
    Validate the heading3 as "Opening a new window"
    */

    @Test(priority = 2, description = "TEST CASE 2: Multiple Windows")
    public void testWindowHandle2(){

        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("Multiple Windows");

        String openNewWindowPageHandle = driver.getWindowHandle();
        heroAppPage.openNewWindowLink.click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(openNewWindowPageHandle)) driver.switchTo().window(windowHandle);
        }

        Assert.assertEquals(heroAppPage.newWindowHeading.getText(), "New Window");

        driver.switchTo().window(openNewWindowPageHandle);

        Assert.assertEquals(heroAppPage.openNewWindowHeading.getText(), "Opening a new window");
    }
}
