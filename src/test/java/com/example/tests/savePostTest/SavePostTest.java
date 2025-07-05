package com.example.tests.savePostTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SavePostTest extends BaseTest {
    private String login;
    private String password;

    @Test
    public void savePost() {
        initTestData();
        MainPage mainPage = auth(login, password);
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        pinPage.clickSaveButton();
        assertTrue(pinPage.isPostSaved());
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

}
