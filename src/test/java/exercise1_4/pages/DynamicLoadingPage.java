package exercise1_4.pages;

import base.BasePage;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicLoadingPage extends BasePage {
    private By startButton = By.xpath("//button[normalize-space()='Start']");
    private By loadingBar = By.id("loading");
    private By successMessage = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void clickButton() {
        driver.findElement(startButton).click();
    }

    public void verifySuccess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        Assert.assertEquals(driver.findElement(successMessage).getText(),con.getDataInput("loadingsuccess"));
    }

    public void waitForLoadingDisappear() {
        wait.until(driver ->
                driver.findElements(loadingBar).isEmpty()
                        || !driver.findElement(loadingBar).isDisplayed()
        );
    }
}
