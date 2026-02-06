package exercise3_1.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonsPage extends BasePage {

    By doubleClickButton = By.id("doubleClickBtn");
    By rightClickButton = By.id("rightClickBtn");
    By clickMeButton = By.id("2zROf");
    By doubleClickText = By.id("doubleClickMessage");
    By rightClickText = By.id("rightClickMessage");
    By clickMeText = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public String doubleClick(){
        WebElement doubleClickBtn = driver.findElement(doubleClickButton);
        actions.moveToElement(doubleClickBtn).doubleClick().perform();;
        String doubleClickMesage = wait.until(ExpectedConditions.visibilityOfElementLocated(doubleClickText)).getText();
        return doubleClickMesage;
    }

    public String rightClick(){
        WebElement rightClickBtn = driver.findElement(rightClickButton);
        actions.moveToElement(rightClickBtn).contextClick().perform();;
        String rightClickMesage = wait.until(ExpectedConditions.visibilityOfElementLocated(rightClickText)).getText();
        return rightClickMesage;
    }

    public String clickMe(){
        WebElement clickMeBtn = driver.findElement(clickMeButton);
        actions.moveToElement(clickMeBtn).doubleClick().perform();;
        String clickMeMesage = wait.until(ExpectedConditions.visibilityOfElementLocated(clickMeText)).getText();
        return clickMeMesage;
    }

    public String shiftClickMe() {
        WebElement clickMeBtn = driver.findElement(clickMeButton);
        actions.keyDown(Keys.SHIFT)
                .click(clickMeBtn)
                .keyUp(Keys.SHIFT)
                .perform();
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(clickMeText)).getText();
        return message;
    }

}
