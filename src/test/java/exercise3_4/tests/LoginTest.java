package exercise3_4.tests;

import Utils.CookieUtils;
import base.BaseTest;
import exercise3_4.pages.LoginPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    String tokenFilePath = System.getProperty("user.dir") + "/token.data";
    String cookieFile = System.getProperty("user.dir") + "/cookies.data";

    @BeforeMethod
    public void initPage(){
        driver.get(con.getDataInput("LOGIN_PAGE"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginByCookie(){
        Cookie cookie = new Cookie("username", "student");
        driver.manage().addCookie(cookie);
        Cookie getCookie = driver.manage().getCookieNamed("username");
        Assert.assertNotNull(getCookie);
        Assert.assertEquals(getCookie.getValue(), "student");
        driver.manage().deleteCookieNamed("username");
        Cookie deleted = driver.manage().getCookieNamed("username");
        Assert.assertNull(deleted);
    }

    @Test
    public void testLoginSession(){
        loginPage.login(con.getDataInput("USERNAME"), con.getDataInput("PASSWORD"));
        Set<Cookie> cookies = driver.manage().getCookies();
        CookieUtils.saveCookies(cookies,cookieFile);

        Cookie tokenCookie = driver.manage().getCookieNamed("token");
        if (tokenCookie != null) {
            CookieUtils.saveToken(tokenCookie.getValue(), tokenFilePath);
            System.out.println("Token from cookie: " + tokenCookie.getValue());
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String localToken = (String) js.executeScript("return window.localStorage.getItem('token');");

        if (localToken != null) {
            CookieUtils.saveToken(localToken, tokenFilePath);
            System.out.println("Token from localStorage: " + localToken);
        }

        driver.quit();
        ChromeOptions options = new ChromeOptions();
        String isCI = System.getProperty("isCI", "false");
        if (isCI.equals("true")) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);
        driver.get(con.getDataInput("LOGIN_PAGE"));
        Set<Cookie> loadedCookies = CookieUtils.loadCookies(cookieFile);
        for (Cookie cookie : loadedCookies) {
            driver.manage().addCookie(cookie);
        }

        String savedToken = CookieUtils.loadToken(tokenFilePath);

        if (savedToken != null && !savedToken.isEmpty()) {
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("window.localStorage.setItem('token', arguments[0]);", savedToken);
        }

        driver.navigate().refresh();
        driver.get("https://demoqa.com/profile");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/profile", "Login fail");
    }

    @Test
    public void testDeleteAllCookies() {
        // Add multiple cookies
        driver.manage().addCookie(new Cookie("cookie1", "value1"));
        driver.manage().addCookie(new Cookie("cookie2", "value2"));

        // Delete all cookies
        driver.manage().deleteAllCookies();

        // Verify all deleted
        Set<Cookie> remaining = driver.manage().getCookies();
        Assert.assertTrue(remaining.isEmpty(), "All cookies should be deleted");
    }
}
