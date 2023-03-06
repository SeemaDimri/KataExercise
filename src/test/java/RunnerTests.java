import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

public class RunnerTests extends BasePage {

    HomePage hp;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        NavigateToHomePage();
        hp = new HomePage();
    }

    @Test
    public void bookRoom(){
        hp.bookRoomMethod();
        hp.enterCredentials("firstName", "lastName","email", "phone");
        hp.selectDates();
    }

}
