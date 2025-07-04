package com.example.tests.HideTest;

import com.example.pages.PinPage;
import org.junit.jupiter.api.Test;

import com.example.pages.MainPage;
import com.example.tests.BaseTest;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Тестовый класс для проверки функциональности скрытия постов.
 * Скрывает первый пост.
 */
public class HideTest extends BaseTest {
    private static final String SEARCH_STR = "Милые котики";
    private String login;
    private String password;

    @Test
    public void checkAuth() {
        initTestData();
        MainPage mainPage = auth(login, password);
        String hrefPreview = mainPage.getHrefOfFirstImage();
        System.out.println(hrefPreview);
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        pinPage.waitForPinPageLoad(hrefPreview);
        pinPage.clickMoreOptionsButton();
        pinPage.clickHidePinButton();
        pinPage.clickNotInterestedButton();
        pinPage.clickUndoActionButton();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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