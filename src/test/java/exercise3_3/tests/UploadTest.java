package exercise3_3.tests;

import base.BaseTest;
import exercise3_3.pages.UploadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UploadTest extends BaseTest {
    UploadPage uploadPage;

    @BeforeMethod
    public void initPage(){
        driver.get(con.getDataInput("uploadDownloadUrl"));
        uploadPage = new UploadPage(driver);
    }

    @Test
    public void testUploadFile(){
        String relativePath  = con.getDataInput("UPLOAD_FILE");
        String message = uploadPage.sendFile(relativePath);
        String fileName = new File(relativePath).getName();
        Assert.assertTrue(message.contains(fileName), "Uploaded filename should be displayed");
    }

    @Test
    public void testDownloadFile(){
        uploadPage.deleteDownloadedFile(con.getDataInput("DOWNLOAD_FILE"));
        uploadPage.downloadFile();
        String downloadedPath = uploadPage.waitFileDownloaded(
                con.getDataInput("DOWNLOAD_FILE"),
                15
        );
        Assert.assertFalse(downloadedPath.isEmpty());
        long size = uploadPage.checkSize(downloadedPath);
        long expectedSize = Long.parseLong(con.getDataInput("FILE_SIZE"));
        Assert.assertTrue(size > 0, "Downloaded file should not be empty");
    }

    @Test
    public void testMultipleUpload(){
        List<String> filePaths = new ArrayList<>();
        filePaths.add(con.getDataInput("UPLOAD_MULTIPLE1"));
        filePaths.add(con.getDataInput("UPLOAD_MULTIPLE2"));
        String message = uploadPage.uploadMultipleFiles(filePaths);
        Assert.assertTrue(message.contains("fakepath"));
    }
}
