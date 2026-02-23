package exercise3_2.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FormsPage extends BasePage {

    By firstNameInput = By.id("firstName");
    By lastNameInput = By.id("lastName");
    By emailInput = By.id("userEmail");
    By phonelInput = By.id("userNumber");
    By stateDropdown = By.id("state");
    private String genderXpath = "//label[text()='%s']";
    private String hobbieXpath = "//label[text()='%s']";
    By birthInput = By.id("dateOfBirthInput");
    String dateXpath = "//div[@aria-label='%s']";
    By monthPicker = By.xpath("//select[@class='react-datepicker__month-select']");
    By yearPicker = By.xpath("//select[@class='react-datepicker__year-select']");
    By textArea = By.xpath("//textarea[@id='currentAddress']");
    By stateInput = By.id("react-select-3-input");
    By submitButton = By.id("submit");
    By successText = By.id("example-modal-sizes-title-lg");
    By multiSelect = By.id("react-select-4-input");

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public void inputFirstName(String firstName){
        sendText(firstNameInput, firstName);
    }

    public void inputLastName(String lastname){
        sendText(lastNameInput, lastname);
    }

    public void inputEmail(String email){
        sendText(emailInput, email);
    }

    public void selectDropdownValue(String value){
        Select select = new Select(driver.findElement(stateDropdown));
        select.selectByVisibleText(value);
//        clickJS(driver.findElement(stateDropdown));
//        driver.findElement(stateInput).sendKeys(value);
//        driver.findElement(stateInput).sendKeys(Keys.ENTER);
    }

    public boolean selectGender(String gender){
        WebElement genderRadio = driver.findElement(By.xpath(String.format(genderXpath, gender)));
        genderRadio.click();
        return genderRadio.isSelected();
    }

    public void selectHobbies(String hobbie){
        driver.findElement(By.xpath(String.format(hobbieXpath,hobbie))).click();
    }

    public void inputAddress(String text){
        WebElement textareaElement = driver.findElement(textArea);
        js.executeScript("arguments[0].scrollIntoView(true);", textareaElement);
        textareaElement.sendKeys(text);
    }

    public void inputPhone(String text){
        driver.findElement(phonelInput).sendKeys(text);
    }

    public void chooseBirthdate(String day, String month, String year){
        driver.findElement(birthInput).click();
        Select yearSelect = new Select(driver.findElement(yearPicker));
        yearSelect.selectByValue(year);
        Select monthSelect = new Select(driver.findElement(monthPicker));
        int monthNumber = Integer.parseInt(month);
        String monthValue = String.valueOf(monthNumber - 1);
        monthSelect.selectByValue(monthValue);
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(day+"/"+month +"/" + year, inputFormat);
        String ariaLabel = buildAriaLabel(date);
        driver.findElement(By.xpath(String.format(dateXpath,ariaLabel))).click();
        driver.findElement(submitButton).click();
    }

    public String getSuccessText(){
        return driver.findElement(successText).getText();
    }

    public int selectMultiDropdown(String value1, String value2){
        WebElement dropdown = driver.findElement(multiSelect);
        Select select = new Select(dropdown);
        select.selectByValue(value1);
        select.selectByValue(value2);

        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        return selectedOptions.size();
    }
}
