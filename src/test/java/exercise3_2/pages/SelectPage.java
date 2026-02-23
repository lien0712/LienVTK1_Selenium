package exercise3_2.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SelectPage extends BasePage {
    By multiSelect = By.id("cars");
    By oneSelect = By.id("oldSelectMenu");

    public SelectPage(WebDriver driver) {
        super(driver);
    }

    public String selectOneValue(String value){
        WebElement oneSelectElement = driver.findElement(oneSelect);
        Select select = new Select(oneSelectElement);
        select.selectByVisibleText(value);
        return select.getFirstSelectedOption().getText();
    }

    public void standardMultiSelect(String value1, String value2){
        WebElement multiSelectElement = driver.findElement(multiSelect);
        Select select = new Select(multiSelectElement);
        select.selectByValue(value1);
        select.selectByValue(value2);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        Assert.assertEquals(selectedOptions.size(), 2, "Should have 2 options selected");
        select.deselectByValue("volvo");
        select.deselectAll();
    }
}
