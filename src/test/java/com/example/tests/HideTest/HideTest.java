package com.example.tests.HideTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестовый класс для проверки функциональности скрытия пинов.
 * Проверяет возможность скрытия пина и отмены этого действия.
 */
public class HideTest extends BaseTest {
    private String login;
    private String password;

    /**
     * Проверяет функциональность скрытия пина и отмены этого действия.
     */
    @Test
    public void checkHidePost() {
        initTestData();
        MainPage mainPage = auth(login, password);
        String hrefPreview = mainPage.getHrefOfFirstImage();
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        pinPage.waitForPinPageLoad(hrefPreview);
        pinPage.clickMoreOptionsButton();
        pinPage.clickHidePinButton();
        mainPage = pinPage.clickNotInterestedButton(MainPage.class);
        assertTrue(mainPage.undoDisplayed());
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