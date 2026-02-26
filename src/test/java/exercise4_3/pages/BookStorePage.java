package exercise4_3.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BookStorePage extends BasePage {
    By gitName = By.xpath("//a[normalize-space()='Git Pocket Guide']");
    By btnClass = By.xpath("//button[starts-with(@class, 'btn')]");
    By searchInput = By.cssSelector("input[type='text']");
    By bookLabels = By.id("userName-value");
    String authorName = "//a[text()='%s']/ancestor::tr/td[3]";

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    public String getGitBookName(String name){
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        search.sendKeys(name);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(gitName)).getText();
    }

    public String getBook(String name){
        WebElement author = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(authorName, name))));
        return author.getText();
    }

    public int numberButton(){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnClass)).size();
    }

    public String bookGitDetail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(gitName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookLabels));
        List<WebElement> details = driver.findElements(bookLabels);
        return details.get(1).getText();
    }

}
