package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GlobalResource;

public class HomePage {
    /*
    Using Page factory class and it's initElements method from Selenium, I am loading the web objects with the help of Driver
     */

   public HomePage(){
       PageFactory.initElements(GlobalResource.driver, this);
   }

   String firstName= "Sam";
   String lastName = "Pan";
   String email = "SamPan@gmail.com";
   String phone = "047854690822";

    @FindBy(xpath = "//button[text()='Book this room']") WebElement bookThisRoomButton;

   @FindBy(xpath = "//input[@name='firstname']") WebElement firstNameBox;

   @FindBy(xpath = "//input[@name='lastname']") WebElement lastNameBox;

   @FindBy(xpath= "//input[@name='email']") WebElement emailBox;

   @FindBy(xpath="//input[@name='phone']") WebElement phoneBox;

   @FindBy(xpath = "//button[text()='15']") WebElement startDate;

    @FindBy(xpath = "//button[text()='17']") WebElement endDate;

   public void bookRoomMethod(){
       bookThisRoomButton.click();

   }
/*
    By using this method User will enter the credentials to book the Room.
 */
   public void enterCredentials(String firstName, String lastName, String email ,String phone){
      firstNameBox.sendKeys(this.firstName);
      lastNameBox.sendKeys(this.lastName);
      emailBox.sendKeys(this.email);
      phoneBox.sendKeys(this.phone);
   }
/*
    Below method will select the dates for booking by using Actions class of Java where we need to perform the action drag and drop, click and hold, build and perform.
 */
   public void selectDates(){
       Actions  ac = new Actions(GlobalResource.driver);
       GlobalResource.driver.switchTo().frame(0);
       WebElement source = GlobalResource.driver.findElement(By.xpath("startDate"));
       WebElement destination = GlobalResource.driver.findElement(By.xpath("endDate"));
       Action builder = ac.moveToElement(source).
               clickAndHold().
               moveToElement(destination).
               release().
               build();
       builder.perform();
   }


}
