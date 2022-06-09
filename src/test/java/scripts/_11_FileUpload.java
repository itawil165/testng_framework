package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _11_FileUpload extends Base {

    @Test(priority = 1, description = "File upload")
    public void testFileUpload1(){
        driver.get("http://the-internet.herokuapp.com/");

        heroAppPage.clickOnLink("File Upload");

        heroAppPage.chooseFileInputBox.sendKeys("C:\\Users\\Suma\\IdeaProjects\\testng_framework\\myFileTawil.txt");
        Waiter.pause(1);

        heroAppPage.uploadFileButton.click();
        Waiter.pause(3);

        Assert.assertEquals(heroAppPage.fileUploaded.getText(), "File Uploaded!");
        Assert.assertEquals(heroAppPage.uploadedFileText.getText(), "myFileTawil.txt");
    }
}
