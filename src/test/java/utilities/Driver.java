package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // 1. Private Constructor
    private Driver(){
    }

    // 2. Private Driver
    private static WebDriver driver;

    // 3. Get Driver and quit driver Method
    public static WebDriver getDriver(){
        if(driver == null){
            // Telling your system where your chrome driver is located
            // System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suma\\IdeaProjects\\selenium_intro\\chromedriver.exe");

            WebDriverManager.chromedriver().setup();

            // Create the object of the web browser that you are automating
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            //waiting only that web element to be EXISTED
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quitDriver(){
//        // delays quit by X seconds
//        try{
//            Thread.sleep(3000);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
        if(driver != null){
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }
}