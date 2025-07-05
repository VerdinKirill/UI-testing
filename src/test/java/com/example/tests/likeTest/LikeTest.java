package com.example.tests.likeTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
 * Тестовый класс для проверки функциональности сортировки досок.
 * Проверяет сортировку по нажатию.
 */
public class LikeTest extends BaseTest {
    private String login;
    private String password;

    @Test
    public void checkLike() {
        initTestData();
        MainPage mainPage = auth(login, password);
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        String dPath = pinPage.getDLikeButton();
        pinPage.clickLikeButton();
        String likedDPath = pinPage.getDLikeButton();
        assertNotSame(dPath, likedDPath);
        pinPage = pinPage.refresh(PinPage.class);
        assertEquals(likedDPath, pinPage.getDLikeButton());
        pinPage.clickLikeButton();
        assertEquals(dPath, pinPage.getDLikeButton());
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