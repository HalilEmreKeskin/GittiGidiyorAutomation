import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NewTapAndLogout extends LoginPage {

    LoginPage loginPage;

    public NewTapAndLogout(WebDriver driver) {
        super(driver);
    }
    public void newTap() throws InterruptedException {

        loginPage = new LoginPage(driver);
        loginPage.setClickLogin();
        TimeUnit.SECONDS.sleep(3);

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.gittigidiyor.com/");

        driver.findElement(By.cssSelector("div[title='Hesabım']")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.name("accountExit")).click();

        TimeUnit.SECONDS.sleep(3);
        driver.close();
        driver.navigate().refresh();
        TimeUnit.SECONDS.sleep(4);
        driver.quit();

    }
}
