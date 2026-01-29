package exercise1_4.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingBar));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBar));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        if (driver.findElement(successMessage).getText().equals("Hello World!")) {
            System.out.println("Successful");
        } else {
            System.out.println("Failed");
        }
    }
}
