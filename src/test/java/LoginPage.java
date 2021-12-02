import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
   public void setClickLogin(){

       By clickUserNameLocator = By.id("L-UserNameField");
       By clickUserPasswordLocator =By.id("L-PasswordField");
       By clickLogin =By.id("gg-login-enter");

       click(clickUserNameLocator);
       type(clickUserNameLocator,"testmailautomation123@gmail.com");
       click(clickUserPasswordLocator);
       type(clickUserPasswordLocator,"justwork123");
       click(clickLogin);
   }
    public boolean checkIfLoginSuccess() {

        return getName().contains("Hesabım");
    }

    private String getName(){
        return driver.findElement(By.cssSelector("div[title='Hesabım']")).getText();
    }

}
