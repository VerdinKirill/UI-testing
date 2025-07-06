package com.example.tests.commentTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.Wait;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс для проверки функциональности комментирования пинов.
 * Проверяет возможность добавления комментария с текстом и изображением.
 */
public class CommentTest extends BaseTest {
    private static final String COMMENT_TEXT = "Классный пост!";
    private static final String IMAGE_PATH = "./testAssets/commentTest.png";
    private static final Duration COMMENT_UPDATE_TIMEOUT = Duration.ofSeconds(10);

    private String login;
    private String password;

    /**
     * Инициализирует тестовые данные перед каждым тестом.
     * Загружает учетные данные из .env файла.
     */
    @BeforeEach
    protected void initTestData() {
        Dotenv dotenv = Dotenv.load();
        login = dotenv.get("USER_LOGIN");
        password = dotenv.get("USER_PASSWORD");
    }

    /**
     * Проверяет возможность добавления комментария с текстом и изображением.
     */
    @Test
    void shouldAddCommentWithTextAndImage() {
        System.out.println("[INFO] Начало теста: shouldAddCommentWithTextAndImage");

        // Аутентификация и открытие главной страницы
        System.out.println("[ACTION] Аутентификация пользователя");
        MainPage mainPage = auth(login, password);
        System.out.println("[SUCCESS] Пользователь аутентифицирован");

        // Открытие первого пина
        System.out.println("[ACTION] Открытие первого пина");
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);
        System.out.println("[SUCCESS] Пин открыт");

        // Ввод текста комментария
        System.out.println("[ACTION] Ввод текста комментария: " + COMMENT_TEXT);
        pinPage.fillText(COMMENT_TEXT);
        System.out.println("[SUCCESS] Текст комментария введён");

        // Загрузка изображения
        System.out.println("[ACTION] Нажатие на кнопку выбора фото");
        pinPage.clickChoosePhotoButton();
        System.out.println("[ACTION] Загрузка изображения из пути: " + IMAGE_PATH);
        pinPage.loadPhoto(new File(IMAGE_PATH));
        System.out.println("[SUCCESS] Изображение загружено");

        // Отправка комментария
        System.out.println("[ACTION] Получение текущего количества комментариев");
        String oldCount = pinPage.getCommentCount();
        System.out.println("[INFO] Старое количество комментариев: " + oldCount);

        System.out.println("[ACTION] Нажатие кнопки отправки комментария");
        pinPage.clickSendCommentButton();

        System.out.println("[WAIT] Ожидание обновления количества комментариев...");
        Wait().withTimeout(COMMENT_UPDATE_TIMEOUT)
                .until(d -> !pinPage.getCommentCount().equals(oldCount));
        System.out.println("[SUCCESS] Количество комментариев обновилось");

        String newCount = pinPage.getCommentCount();
        System.out.println("[INFO] Новое количество комментариев: " + newCount);

        assertNotEquals(oldCount, newCount);
        System.out.println("[ASSERTION PASSED] Количество комментариев изменилось");

        System.out.println("[INFO] Завершение теста: shouldAddCommentWithTextAndImage");
    }
}