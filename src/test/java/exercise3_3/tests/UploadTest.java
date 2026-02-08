package exercise3_3.tests;

import base.BaseTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import exercise3_3.pages.UploadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        String path = con.getDataInput("filepath");
        String message = uploadPage.sendFile(path);
        Assert.assertTrue(message.contains("C:\\fakepath\\"));
    }

    @Test
    public void testDownloadFile(){
//        uploadPage.downloadFile();
        String path = uploadPage.checkFileExist();
        Assert.assertEquals(path, con.getDataInput("DOWNLOAD_FILE"));
        long size = uploadPage.checkSize(path);
        long expectedSize = Long.parseLong(con.getDataInput("FILE_SIZE"));
        Assert.assertEquals(size,expectedSize);
    }

    @Test
    public void testMultipleUpload(){
        List<String> filePaths = new ArrayList<>();
        filePaths.add(con.getDataInput("UPLOAD_MULTIPLE1"));
        filePaths.add(con.getDataInput("UPLOAD_MULTIPLE2"));
        String message = uploadPage.uploadMultipleFiles(filePaths);
        Assert.assertTrue(message.contains("C:\\fakepath\\"));
    }
}
