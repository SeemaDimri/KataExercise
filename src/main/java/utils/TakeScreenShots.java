package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class TakeScreenShots {
    public static void takeSelfie(String nameOfScreenShot){
        try {
            File f = ((TakesScreenshot)GlobalResource.driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(f, new File("C:/Selenium_Screenshots/"+GlobalResource.testCase_ID+"/"+nameOfScreenShot+".png"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
