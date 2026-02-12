package exercise3_4.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class LoginPage extends BasePage {

    By userNameInput = By.id("userName");
    By passwordInput = By.id("password");
    By loginButton = By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password){
        actions.scrollByAmount(500,500).perform();
        driver.findElement(userNameInput).sendKeys(userName);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
