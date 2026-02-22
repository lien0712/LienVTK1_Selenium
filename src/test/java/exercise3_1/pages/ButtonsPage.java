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
    By clickMeButton = By.xpath("//button[text()='Click Me']");
    By doubleClickText = By.id("doubleClickMessage");
    By rightClickText = By.id("rightClickMessage");
    By clickMeText = By.id("dynamicClickMessage");
    By dragElement = By.id("draggable");
    By dropElement = By.id("droppable");
    By userName = By.id("userName");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public String doubleClick(){
        WebElement doubleClickBtn = driver.findElement(doubleClickButton);
        actions.scrollByAmount(200,200).perform();
        actions.moveToElement(doubleClickBtn).doubleClick().perform();
        String doubleClickMesage = wait.until(ExpectedConditions.visibilityOfElementLocated(doubleClickText)).getText();
        return doubleClickMesage;
    }

    public String rightClick(){
        WebElement rightClickBtn = driver.findElement(rightClickButton);
        actions.scrollByAmount(200,200).perform();
        actions.moveToElement(rightClickBtn).contextClick().perform();
        String rightClickMesage = wait.until(ExpectedConditions.visibilityOfElementLocated(rightClickText)).getText();
        return rightClickMesage;
    }

    public String clickMe(){
        WebElement clickMeBtn = driver.findElement(clickMeButton);
        actions.moveToElement(clickMeBtn).click().perform();
        WebElement clickMeMesage = driver.findElement(clickMeText);
        js.executeScript("arguments[0].scrollIntoView(true);", clickMeMesage);
        return clickMeMesage.getText();
    }

    public String keyboardAction() {
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        actions.click(username)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("Test")
                .perform();
        return username.getAttribute("value");
    }

    public String dragAndDrop(){
        actions.scrollByAmount(200,200).perform();
        WebElement dragWebElement = driver.findElement(dragElement);
        WebElement dropWebElement = driver.findElement(dropElement);
        actions.dragAndDrop(dragWebElement, dropWebElement).perform();
        wait.until(ExpectedConditions.visibilityOf(dropWebElement));
        return dropWebElement.getText();
    }

}
