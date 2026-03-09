package base;

import org.example.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ConfigReader con;
    protected Actions actions;
    protected JavascriptExecutor js;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.con = new ConfigReader();
        this.actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    public BasePage click(By element){
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        webElement.click();
        return this;
    }

    public BasePage sendKeys(By element, String value){
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        webElement.sendKeys(value);
        return this;
    }

    public String getText(By element){
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return webElement.getText();
    }

    public void selectDropdown(By locator, String value, String type) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        Select select = new Select(element);

        switch (type.toLowerCase()) {
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                throw new IllegalArgumentException("Type không hợp lệ: " + type + ". Dùng: text | value | index");
        }
    }

    public void sendText(By element, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
    }

    public void clickJS(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

    public String buildAriaLabel(LocalDate date){
        String dayName = date.format(DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH));
        String monthName = date.format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH));
        int day = date.getDayOfMonth();
        int year = date.getYear();

        return "Choose " + dayName + ", " + monthName + " " + day + getDaySuffix(day) + ", " + year;
    }

    public String getDaySuffix(int day){
        if(day >= 11 && day <= 13){
            return "th";
        }
        switch(day % 10){
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }


}
