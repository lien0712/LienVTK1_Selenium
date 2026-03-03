package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseAuthenticatedPage extends BasePage {

    private By logoutButton = By.xpath("//button[@id='submit' and text()='Log out']");

    public BaseAuthenticatedPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        click(logoutButton);
    }
}
