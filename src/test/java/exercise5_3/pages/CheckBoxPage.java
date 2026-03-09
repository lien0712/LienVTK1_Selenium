package exercise5_3.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckBoxPage extends BasePage {

    By elementInput = By.xpath("//div[@class='rc-tree']/div/input");
    By role = By.xpath("//div[@role='treeitem']");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public String checkAriaLabels(){
        String ariaLabel = driver.findElement(elementInput).getAttribute("aria-label");
        return ariaLabel;
    }

    public String getRole(){
        WebElement roleEle = wait.until(ExpectedConditions.visibilityOfElementLocated(role));
        String role = roleEle.getAttribute("role");
        return role;
    }
}
