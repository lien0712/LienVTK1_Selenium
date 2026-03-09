package exercise5_3.pages;

import Utils.ColorUtils;
import base.BasePage;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class BookStorePage extends BasePage {
    By loginButton = By.id("login");
    By searchBox = By.id("searchBox");
    By secondBook = By.xpath("//tbody/tr[2]");
    By images = By.tagName("img");
    By inputs = By.tagName("input");

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    public String keyboardNavi(){
        WebElement searchBoxEle = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        actions.moveToElement(searchBoxEle).sendKeys(Keys.TAB).perform();
        WebElement focused = driver.switchTo().activeElement();
        String tagName = focused.getTagName();
        return tagName;
    }

    public double colorConstract(){
        WebElement secondBookEle = wait.until(ExpectedConditions.visibilityOfElementLocated(secondBook));
        String bgColor = secondBookEle.getCssValue("background-color");
        double ratio = ColorUtils.convertColor(bgColor);
        return ratio;
    }

    public List<Rule> checkScreenReader() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondBook));

        // Dùng AxeBuilder mới
        Results results = new AxeBuilder().analyze(driver);
        return results.getViolations();
    }
}
