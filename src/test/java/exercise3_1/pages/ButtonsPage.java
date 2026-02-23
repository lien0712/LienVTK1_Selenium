package exercise3_1.pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

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
        actions.scrollByAmount(200,200).perform();
        actions.moveToElement(clickMeMesage).contextClick().perform();
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
        WebElement dragWebElement = wait.until(ExpectedConditions.elementToBeClickable(dragElement));
        System.out.println(dragWebElement.getText());
        WebElement dropWebElement = wait.until(ExpectedConditions.elementToBeClickable(dropElement));
        System.out.println(dropWebElement.getText());
        actions.scrollByAmount(150, 150).perform();
        try {
            Thread.sleep(Duration.ofSeconds(5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int xOffset = dragWebElement.getLocation().getX() - dropWebElement.getLocation().getX();
        int yOffset = dragWebElement.getLocation().getY() - dropWebElement.getLocation().getY();
//        actions.dragAndDrop(dragWebElement, dropWebElement).perform();
//        actions.clickAndHold(dragWebElement)
//                .pause(Duration.ofSeconds(5))
//                .moveByOffset(xOffset, yOffset)
//                .pause(Duration.ofSeconds(5))
//                .release()
//                .perform();
//        actions.clickAndHold(dragWebElement)
//                .moveToElement(dropWebElement)
//                .release()
//                .perform();
        actions.clickAndHold(dragWebElement)
                .pause(Duration.ofSeconds(3))
                .moveToElement(dropWebElement)
                .release()
                .perform();
        System.out.println(dropWebElement.getText());
        return dropWebElement.getText();
    }

}
