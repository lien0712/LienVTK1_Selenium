package exercise1_2.elementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementLocators {

    private WebDriver driver;
    private final By idField = By.id("userName-label");
    private final By nameField = By.name("gender");
    private final By classNameField = By.className("form-label");
    private final By getNameField = By.tagName("input");
    private final By firstNameField = By.cssSelector("#firstName");
    private final By lastNameField = By.cssSelector("input[type='text'][placeholder='Last Name']");
    private final By getFirstNameField = By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[1]/div[2]/input");
    private final By getFirstNameField1 = By.xpath("//div[@id='userName-wrapper']//div[4]");
    private final By nameLabelField = By.xpath("//label[text()='Name']");
    private final By emailField = By.xpath("//input[contains(@placeholder,'@example.com')]");
    private final By pictureField = By.xpath("//label[normalize-space()='Select picture']");

    public ElementLocators(WebDriver driver) {
        this.driver = driver;
    }

    public void getAllElements() {
        WebElement idInput = driver.findElement(idField);
        WebElement nameInput = driver.findElement(nameField);
        WebElement classNameInput = driver.findElement(classNameField);
        WebElement getNameInput = driver.findElement(getNameField);
        WebElement firstNameInput = driver.findElement(firstNameField);
        WebElement lastNameInput = driver.findElement(lastNameField);
        WebElement getFirstNameInput = driver.findElement(getFirstNameField);
        WebElement getFirstNameInput1 = driver.findElement(getFirstNameField1);
        WebElement nameLabel = driver.findElement(nameLabelField);
        WebElement emailInput = driver.findElement(emailField);
        WebElement pictureText = driver.findElement(pictureField);
        idInput.getText();
    }
}
