
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeAll
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

        driver.get("https://www.gittigidiyor.com/uye-girisi?s=1");

    }

    @AfterAll
    public void tearDown(){

        //driver.close();
        //driver.quit();
    }

}
