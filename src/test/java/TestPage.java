
import org.junit.jupiter.api.*;
import java.util.logging.Logger;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPage extends BaseTest{

    LoginPage loginPage;
    SearchProductPage searchProductPage;
    FavoritePage favoritePage;
    NewTapAndLogout newTapAndLogout;

    final static Logger logger = Logger.getLogger(String.valueOf(TestPage.class));

    @Order(1)
    @Test
    public void loginTest(){
        logger.info(" Login Test başlatıldı.");
        loginPage=new LoginPage(driver);
        loginPage.setClickLogin();
        Assertions.assertTrue(loginPage.checkIfLoginSuccess(),"Login Başarısız");
        logger.info(" Login Test başarılı.");
    }

    @Order(2)
    @Test
    public void loginAndRandomSearch() throws InterruptedException {
        logger.info(" Login Ve Arama Test başlatıldı.");
        loginPage=new LoginPage(driver);
        loginPage.setClickLogin();
        searchProductPage = new SearchProductPage(driver);
        searchProductPage.search();
        logger.info("Login Ve Arama işlemi başarılı.");

    }

    @Order(3)
    @Test
    public void bagSearchAndAdd() throws InterruptedException {
        logger.info(" Arama Test başlatıldı.");
        driver.navigate().to("https://www.gittigidiyor.com/uye-girisi?s=1");
        searchProductPage = new SearchProductPage(driver);
        searchProductPage.searchBagAndAddToCart();
        // Assertions.assertTrue(searchProductPage.checkIfProductAdd(),"No product add");
        logger.info(" Arama işlemi başarılı.");

    }

    @Order(4)
    @Test
    public void deleteFavorite() throws InterruptedException {
        logger.info(" Silme Testi başlatıldı.");
        favoritePage = new FavoritePage(driver);
        favoritePage.delete3rdProduct();
        //Assertions.assertTrue(favoritePage.checkIfProductDeleted(),"Product not deleted");
        logger.info(" silme işlemi başarılı.");
    }


    @Order(5)
    @Test
    public void newTapAndLogoutTest() throws InterruptedException {
        logger.info(" NewTap Testi başlatıldı.");
        newTapAndLogout = new NewTapAndLogout(driver);
        newTapAndLogout.newTap();
        logger.info(" NewTap işlemi başarılı.");
    }

}
