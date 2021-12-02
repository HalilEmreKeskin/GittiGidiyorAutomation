import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;


public class TestPage extends BaseTest{

    LoginPage loginPage;
    SearchProductPage searchProductPage;
    FavoritePage favoritePage;
    NewTapAndLogout newTapAndLogout;

    final static Logger logger = Logger.getLogger(String.valueOf(TestPage.class));

    @Test
    public void loginTest(){
        logger.info(" Login Test başlatıldı.");
        loginPage=new LoginPage(driver);
        loginPage.setClickLogin();
        Assert.assertTrue("Login Başarısız",loginPage.checkIfLoginSuccess());
        logger.info(" Login Test başarılı.");
    }
    @Test
    public void loginAndRandomSearch() throws InterruptedException {
        logger.info(" Login Ve Arama Test başlatıldı.");
        loginPage=new LoginPage(driver);
        loginPage.setClickLogin();
        searchProductPage = new SearchProductPage(driver);
        searchProductPage.search();
        logger.info("Login Ve Arama işlemi başarılı.");

    }

    @Test
    public void bagSearchAndAdd() throws InterruptedException {
        logger.info(" Arama Test başlatıldı.");
        driver.navigate().to("https://www.gittigidiyor.com/uye-girisi?s=1");
        searchProductPage = new SearchProductPage(driver);
        searchProductPage.searchBagAndAddToCart();
        Assert.assertTrue("No product add",searchProductPage.checkIfProductAdd());
        logger.info(" Arama işlemi başarılı.");

    }
    @Test
    public void deleteFavorite() throws InterruptedException {
        logger.info(" Silme Testi başlatıldı.");
        favoritePage = new FavoritePage(driver);
        favoritePage.delete3rdProduct();
        Assert.assertTrue("Product not deleted",favoritePage.checkIfProductDeleted());
        logger.info(" silme işlemi başarılı.");
    }
    @Test
    public void newTapAndLogoutTest() throws InterruptedException {
        logger.info(" NewTap Testi başlatıldı.");
        newTapAndLogout = new NewTapAndLogout(driver);
        newTapAndLogout.newTap();
        logger.info(" NewTap işlemi başarılı.");
    }

}
