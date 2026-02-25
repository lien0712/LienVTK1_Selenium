package exercise4_2.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IFramePage extends BasePage {
    By iframe = By.tagName("iframe");
    By iframe1 = By.id("frame1");
    By iframe2 = By.id("frame2");
    By messageText = By.id("sampleHeading");
    By frameWrapper = By.id("framesWrapper");

    public IFramePage(WebDriver driver) {
        super(driver);
    }

    public int getSizeFrame(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(frameWrapper));
        return driver.findElements(iframe).size();
    }

    public void switchByIndex(int index){
        driver.switchTo().frame(index);
    }

    public void switchByIDFrame1(){
        driver.switchTo().frame(driver.findElement(iframe1));
    }

    public void switchByIDFrame2(){
        driver.switchTo().frame(driver.findElement(iframe2));
    }

    public String getMessage(){
        return driver.findElement(messageText).getText();
    }

    public void switchMain(){
        driver.switchTo().defaultContent();
    }

    public boolean checkMain(){
        return driver.findElement(frameWrapper).isDisplayed();
    }
}
