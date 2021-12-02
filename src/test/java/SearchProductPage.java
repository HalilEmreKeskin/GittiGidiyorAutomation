import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class SearchProductPage extends LoginPage{
    BasePage basePage;
    LoginPage loginPage;

    public SearchProductPage(WebDriver driver) {
        super(driver);
    }
    public void search() throws InterruptedException {
        driver.findElement(By.name("k")).click();
        driver.findElement(By.name("k")).sendKeys("Kitap"+ Keys.ENTER);
        Random random = new Random();
        for (int a=0; a<=3;a++) {
            int x = random.nextInt(30);
            driver.findElements(By.name("like")).get(x).click();
            TimeUnit.SECONDS.sleep(3);
        }
        basePage = new BasePage(driver);
        basePage.scrollTo(0, 100000);
    }
    public void searchBagAndAddToCart() throws InterruptedException {

        loginPage = new LoginPage(driver);
        loginPage.setClickLogin();

        // Çanta yaz ve sepete git
        driver.findElement(By.name("k")).click();
        driver.findElement(By.name("k")).sendKeys("Çanta"+ Keys.ENTER);
        driver.findElements(By.cssSelector("div[class='sc-533kbx-0 sc-1v2q8t1-0 iCRwxx ixSZpI sc-1n49x8z-12 bhlHZl']")).get(6).click();
        driver.findElement(By.id("add-to-basket")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.navigate().to("https://www.gittigidiyor.com/sepetim");


        // ürün artır
        Select select = new Select(driver.findElement(By.cssSelector("select[class='amount']")));
        select.selectByVisibleText("2");
        TimeUnit.SECONDS.sleep(4);

        //alışveriş tamamla tıkla
        driver.findElement(By.cssSelector("input[class='gg-d-24 gg-ui-btn-primary gg-ui-btn-lg btn-pay']")).click();
        TimeUnit.SECONDS.sleep(3);

        //Kaydet button bas
        driver.findElement(By.cssSelector("button[class='gg-ui-btn-primary gg-btn post-address gg-ui-btn-fluid post-address-button gg-ui-btn-lg']")).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.cssSelector("a[title='Sepeti Düzenle']")).click();
        TimeUnit.SECONDS.sleep(2);

        //favoriden seç
        driver.findElement(By.cssSelector("a[class='gg-ui-btn-default btn-add-to-basket']")).click();
    }
    public boolean checkIfProductAdd() {
        return getProducts().size() >0;
    }

    private List<WebElement> getProducts(){
        return findAll((By) driver.findElement(By.cssSelector("div[class='gg-w-24 gg-d-24 gg-t-24 gg-m-24 padding-none product-item-box-container']")));
    }

    public void randomNumber() throws InterruptedException {
        Random random = new Random();
        for (int a=0; a<=3;a++) {
            int x = random.nextInt(30);
            driver.findElements(By.name("like")).get(x).click();
            TimeUnit.SECONDS.sleep(3);
        }

    }
}
