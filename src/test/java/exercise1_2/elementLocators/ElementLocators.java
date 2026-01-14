package exercise1_2.elementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementLocators {

    private WebDriver driver;
    private WebElement byId = driver.findElement(By.id("userName-label"));
    private WebElement byName = driver.findElement(By.name("gender"));
    private WebElement byClassName = driver.findElement(By.className("form-label"));
    private WebElement byTagname = driver.findElement(By.tagName("input"));
    private WebElement byCssSelector = driver.findElement(By.cssSelector("#firstName"));
    private WebElement getByCssSelector2 = driver.findElement(By.cssSelector("input[type='text'][placeholder='Last Name']"));
    private WebElement getByFullXpath = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[1]/div[4]"));
    private WebElement getByXpath = driver.findElement(By.xpath("//div[@id='userName-wrapper']//div[4]"));
    private WebElement getText = driver.findElement(By.xpath("//label[text()='Name']"));
    private WebElement getContains = driver.findElement(By.xpath("//input[contains(@placeholder,'@example.com')]"));
    private WebElement getNormalize = driver.findElement(By.xpath("//label[normalize-space()='Select picture']"));
}
