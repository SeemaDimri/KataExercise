package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GlobalClass;

public class HomePage {

   public HomePage(){
       PageFactory.initElements(GlobalClass.driver, this);
   }
    @FindBy(xpath = "//button[text()='Book this room']")
    WebElement bookThisRoomButton;


   public void bookRoomMethod(){
       bookThisRoomButton.click();
   }
}
