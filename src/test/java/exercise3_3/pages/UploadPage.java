package exercise3_3.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.StringJoiner;

public class UploadPage extends BasePage {

    By uploadButton = By.id("uploadFile");
    By textMessage = By.id("uploadedFilePath");
    By downloadButton = By.id("downloadButton");
    private String projectPath = System.getProperty("user.dir");
    private String downloadFolder = projectPath + File.separator + "src" + File.separator + "test" + File.separator + "download";

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public String sendFile(String relativePath){
        actions.scrollByAmount(200,200).perform();
        String fullPath = projectPath + File.separator + relativePath;
        driver.findElement(uploadButton).sendKeys(fullPath);
        return driver.findElement(textMessage).getText();
    }

    public String uploadMultipleFiles(List<String> relativePaths) {
        StringJoiner joiner = new StringJoiner("\n");

        for (String path : relativePaths) {
            String fullPath = projectPath + File.separator + path;
            joiner.add(fullPath);
        }

        driver.findElement(uploadButton).sendKeys(joiner.toString());
        return driver.findElement(textMessage).getText();
    }

    public void downloadFile(){
        actions.scrollByAmount(200,200).perform();
        driver.findElement(downloadButton).click();
    }

    public String checkFileExist(String fileName){
        File downloadedFile = new File(downloadFolder + File.separator + fileName);

        if(downloadedFile.exists()){
            return downloadedFile.getPath();
        }
        return "";
    }

    public long checkSize(String path){
        File downloadedFile = new File(path);
        if(downloadedFile.exists()){
            return downloadedFile.length();
        }
        return 0;
    }

    public String waitFileDownloaded(String fileName, int timeoutSeconds) {
        File file = new File(downloadFolder + File.separator + fileName);

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        wait.until(driver -> file.exists() && file.length() > 0);

        return file.getAbsolutePath();
    }

    public void deleteDownloadedFile(String fileName){
        File file = new File(downloadFolder + File.separator + fileName);
        if(file.exists()){
            file.delete();
        }
    }
}
