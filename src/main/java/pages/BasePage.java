package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.CommonUtils;
import utils.GlobalResource;
import utils.TakeScreenShots;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    /* Below constructor will take care of loading property file where keyvalue pair stored */

    public BasePage(){
        try{
            FileInputStream file = new FileInputStream("src/main/java/properties/Config.properties");
            GlobalResource.prop = new Properties();
            GlobalResource.prop.load(file);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    /* Below method will load value from property file, initialize browser and open url*/

    public void NavigateToHomePage() throws InterruptedException {
        String applicationURL = GlobalResource.prop.getProperty("url");
        String browsername = GlobalResource.prop.getProperty("browser");
        assignBrowser(browsername);
        GlobalResource.driver.get(applicationURL);
        GlobalResource.driver.manage().window().maximize();
        GlobalResource.driver.manage().timeouts().implicitlyWait(GlobalResource.implicitWaitTimeInSeconds,TimeUnit.SECONDS);
        CommonUtils.scrollDown(GlobalResource.driver);
        TakeScreenShots.takeSelfie("basePage_ScreenShot");

    }

    public void assignBrowser(String nameofBrowser){
        if(nameofBrowser.equals("chrome") || nameofBrowser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver","C:/Hybrid/Drivers/Chrome/chromedriver.exe");
            GlobalResource.driver = new ChromeDriver();
        }
        else if(nameofBrowser.equals("ff") || nameofBrowser.equals("FF") || nameofBrowser.equals("firefox")){
            System.setProperty("wedriver.gecko.driver","C:/Hybrid/Drivers/Firefox/geckodriver.exe");
            GlobalResource.driver = new FirefoxDriver();
        }

    }

}
