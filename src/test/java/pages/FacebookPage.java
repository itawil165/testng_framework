package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FacebookPage {

    public FacebookPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id=\"login_link\"]/div[3]/a")
    public WebElement createAccountLink;

    @FindBy (className = "_8esa")
    public List<WebElement> radioButtons;

    
}
