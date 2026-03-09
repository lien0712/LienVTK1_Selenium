package exercise4_2.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramePage extends BasePage {
    By parentFrame = By.id("frame1");
    By childFrame = By.tagName("iframe");
    By childText = By.tagName("p");
    By parentText = By.tagName("body");

    public NestedFramePage(WebDriver driver) {
        super(driver);
    }

    public String switchToChild(){
        driver.switchTo().frame(driver.findElement(parentFrame));
        driver.switchTo().frame(driver.findElement(childFrame));
        return driver.findElement(childText).getText();
    }

    public String switchToParent(){
        driver.switchTo().parentFrame();
        return driver.findElement(parentText).getText();
    }
}
