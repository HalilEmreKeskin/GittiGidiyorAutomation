import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends BaseTest {
    WebDriver driver;

    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public WebElement find(By locator){
        return   driver.findElement(locator);
    }

    protected JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) driver;
    }

    protected void scrollTo(int x, int y) {
        String jsStmt = String.format("window.scrollTo(%d, %d);", x, y);
        getJSExecutor().executeScript(jsStmt, true);
    }

    public void hoverElement(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }
    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public void click(By locator){
        find(locator).click();
    }
    public void type(By locator, String text){
        find(locator).sendKeys(text);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
}
