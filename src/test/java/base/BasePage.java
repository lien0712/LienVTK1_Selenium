package base;

import org.example.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    JavascriptExecutor js;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.con = new ConfigReader();
        this.actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
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
