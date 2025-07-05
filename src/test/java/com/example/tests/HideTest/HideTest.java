package com.example.tests.HideTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

/**
 * Тестовый класс для проверки функциональности скрытия постов.
 * Скрывает первый пост.
 */
public class HideTest extends BaseTest {
    private static final String SEARCH_STR = "Милые котики";
    private String login;
    private String password;

//    @Test
    public void checkHidePost() {
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