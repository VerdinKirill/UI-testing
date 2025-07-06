package com.example.tests.uploadTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadTest extends BaseTest {
    private String login;
    private String password;
    private final String pathToDownloadDir = "./downloads";

    @Test
    public void checkUpload() {
        int startJpegCount = checkNumJpegFiles();
        initTestData();
        MainPage mainPage = auth(login, password);
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        pinPage.clickMoreOptionsButton();
        pinPage.clickDownloadPinButton();
        int endJpegCount = checkNumJpegFiles();
        assertTrue(endJpegCount > startJpegCount);
    }


    /**
     * Инициализация тестовых данных.
     * Загружает учетные данные из .env файла.
     */
    protected void initTestData() {
        Dotenv dotenv = Dotenv.load();
        login = dotenv.get("USER_LOGIN");
        password = dotenv.get("USER_PASSWORD");
    }

    private int checkNumJpegFiles() {
        File downloadDir = new File(pathToDownloadDir);
        File[] jpegFiles = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpeg"));
        return jpegFiles != null ? jpegFiles.length : 0;
    }
}
