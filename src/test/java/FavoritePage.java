import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FavoritePage extends LoginPage{
    LoginPage loginPage;


    public FavoritePage(WebDriver driver) {
        super(driver);
    }

    public void delete3rdProduct() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.setClickLogin();

        driver.navigate().to("https://www.gittigidiyor.com/hesabim/izlediklerim");
        TimeUnit.SECONDS.sleep(4);

        driver.findElements(By.cssSelector("span[class='checkmark']")).get(3).click();
        TimeUnit.SECONDS.sleep(3);

        //ürünü sil
        driver.findElement(By.cssSelector("button[class='delete-watch-products robot-delete-all-button']")).click();

    }

    private List<WebElement> getProducts(){
        By productNameLocator1 = (By) driver.findElement(By.cssSelector("div[class='watch-products--table']"));
        return findAll(productNameLocator1);
    }
    public boolean checkIfProductDeleted() {
        return getProducts().size() == 3;
    }
}
