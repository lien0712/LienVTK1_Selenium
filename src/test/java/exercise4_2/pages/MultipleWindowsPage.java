package exercise4_2.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class MultipleWindowsPage extends BasePage {
    By newWindow = By.id("tabButton");
    By newTab = By.id("windowButton");
    By newWindowMess = By.id("messageWindowButton");
    By message = By.id("sampleHeading");

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    public String getWindowHandle(){
        return driver.getWindowHandle();
    }

    public String openNewWindow(){
        Set<String> oldWindows = driver.getWindowHandles();
        wait.until(ExpectedConditions.elementToBeClickable(newWindow)).click();
        wait.until(d -> d.getWindowHandles().size() > oldWindows.size());
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!oldWindows.contains(handle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return driver.getWindowHandle();
    }

    public String openNewTab(){
        Set<String> oldWindows = driver.getWindowHandles();
        wait.until(ExpectedConditions.elementToBeClickable(newTab)).click();
        wait.until(d -> d.getWindowHandles().size() > oldWindows.size());
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!oldWindows.contains(handle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return driver.getWindowHandle();
    }

    public String openNewWindowMess(){
        Set<String> oldWindows = driver.getWindowHandles();
        wait.until(ExpectedConditions.elementToBeClickable(newWindowMess)).click();
        wait.until(d -> d.getWindowHandles().size() > oldWindows.size());
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!oldWindows.contains(handle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return driver.getWindowHandle();
    }

    public void switchToWindow(String windowHandle){
        driver.switchTo().window(windowHandle);
    }

    public void closeWindow(String windowHandle){
        driver.switchTo().window(windowHandle);
        driver.close();
    }

    public void closeAllNewWindow(String windowHandle){
        Set<String> windows = driver.getWindowHandles();
        for (String w : windows){
            if(!w.equals(windowHandle)){
                driver.switchTo().window(w);
                driver.close();
            }
        }
    }

    public int getTotalWindows(){
        return driver.getWindowHandles().size();
    }

    public String getMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
    }

    public String getBodyText(){
        WebElement body = driver.findElement(By.tagName("body"));
        return body.getText();
    }
}
