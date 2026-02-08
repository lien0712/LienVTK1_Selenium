package exercise3_3.pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;
import java.util.StringJoiner;

public class UploadPage extends BasePage {

    By uploadButton = By.id("uploadFile");
    By textMessage = By.id("uploadedFilePath");
    By downloadButton = By.id("downloadButton");
    private String downloadFolder = System.getProperty("user.home") + File.separator + "Downloads";

    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public String sendFile(String path){
        WebElement uploadButtonWE = driver.findElement(uploadButton);
        uploadButtonWE.sendKeys(path);
        return driver.findElement(textMessage).getText();
    }

    public String uploadMultipleFiles(List<String> filePaths) {
        StringJoiner joiner = new StringJoiner("\n");

        for (String path : filePaths) {
            joiner.add(path);
        }

        driver.findElement(uploadButton).sendKeys(joiner.toString());
        return driver.findElement(textMessage).getText();
    }

    public void downloadFile(){
        driver.findElement(downloadButton).click();
    }

    public String checkFileExist(){
        String path="";
        File downloadedFile = new File(downloadFolder + File.separator + "sampleFile.jpeg");
        if (downloadedFile.exists()){
            path = downloadedFile.getPath();
            return path;
        }
        return path;
    }

    public long checkSize(String path){
        long fileSize = 0;
        File downloadedFile = new File(path);
        if (downloadedFile.exists()) {
            fileSize = downloadedFile.length();
            return fileSize;
        } else {
            return fileSize;
        }
    }
}
