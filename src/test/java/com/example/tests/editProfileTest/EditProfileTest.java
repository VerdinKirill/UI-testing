package com.example.tests.editProfileTest;

import com.example.pages.MainPage;
import com.example.pages.SettingsPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тестовый класс для проверки функциональности редактирования профиля пользователя.
 * Проверяет возможность изменения имени, фамилии и информации "О себе".
 */
public class EditProfileTest extends BaseTest {
    // Константы для тестовых данных
    private static final String NAME_SUFFIX = "I";
    private static final String SURNAME_SUFFIX = "g";
    private static final String ABOUT_TEXT = "testing";

    private String login;
    private String password;
    private String originalFirstName;
    private String originalLastName;
    private String originalAbout;

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
     * Проверяет возможность редактирования профиля пользователя.
     */
    @Test
    public void shouldSuccessfullyEditUserProfile() {
        // Аутентификация и открытие главной страницы
        MainPage mainPage = auth(login, password);

        // Открытие страницы настроек
        mainPage.clickSettingsModalButton();
        SettingsPage settingsPage = mainPage.clickSettings(SettingsPage.class);

        // Сохранение исходных значений
        saveOriginalProfileValues(settingsPage);

        try {
            // Подготовка новых значений
            String newFirstName = originalFirstName + NAME_SUFFIX;
            String newLastName = originalLastName + SURNAME_SUFFIX;

            // Изменение данных профиля
            updateProfileValues(settingsPage, newFirstName, newLastName, ABOUT_TEXT);

            // Обновление страницы для проверки сохранения
            settingsPage = settingsPage.refresh(SettingsPage.class);

            // Проверка обновленных значений
            verifyProfileValues(settingsPage, newFirstName, newLastName, ABOUT_TEXT);
        } finally {
            // Восстановление исходных значений
            restoreOriginalProfileValues(settingsPage);
        }
    }

    /**
     * Сохраняет исходные значения профиля.
     *
     * @param settingsPage экземпляр страницы настроек
     */
    private void saveOriginalProfileValues(SettingsPage settingsPage) {
        originalFirstName = settingsPage.getFirstName();
        originalLastName = settingsPage.getLastName();
        originalAbout = settingsPage.getAbout();
    }

    /**
     * Обновляет значения профиля.
     *
     * @param settingsPage экземпляр страницы настроек
     * @param firstName    новое имя
     * @param lastName     новая фамилия
     * @param about        новая информация "О себе"
     */
    private void updateProfileValues(SettingsPage settingsPage, String firstName,
                                     String lastName, String about) {
        settingsPage.fillFirstName(firstName);
        settingsPage.fillLastName(lastName);
        settingsPage.fillAbout(about);
        settingsPage.clickSaveButton();
    }

    /**
     * Проверяет значения профиля.
     *
     * @param settingsPage      экземпляр страницы настроек
     * @param expectedFirstName ожидаемое имя
     * @param expectedLastName  ожидаемая фамилия
     * @param expectedAbout     ожидаемая информация "О себе"
     */
    private void verifyProfileValues(SettingsPage settingsPage, String expectedFirstName,
                                     String expectedLastName, String expectedAbout) {
        String actualFirstName = settingsPage.getFirstName();
        String actualLastName = settingsPage.getLastName();
        String actualAbout = settingsPage.getAbout();

        assertAll("Проверка обновленных значений профиля",
                () -> assertEquals(expectedFirstName, actualFirstName, "Имя должно соответствовать"),
                () -> assertEquals(expectedLastName, actualLastName, "Фамилия должна соответствовать"),
                () -> assertEquals(expectedAbout, actualAbout, "Информация 'О себе' должна соответствовать")
        );
    }

    /**
     * Восстанавливает исходные значения профиля.
     *
     * @param settingsPage экземпляр страницы настроек
     */
    private void restoreOriginalProfileValues(SettingsPage settingsPage) {
        settingsPage.fillFirstName(originalFirstName);
        settingsPage.fillLastName(originalLastName);
        settingsPage.fillAbout(originalAbout);
        settingsPage.clickSaveButton();
    }
}