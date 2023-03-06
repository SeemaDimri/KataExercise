package utils;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class GlobalResource {
    public static WebDriver driver;
    public static Properties prop;
    public static int  implicitWaitTimeInSeconds = 5;
    public static String  testCase_ID;

}
