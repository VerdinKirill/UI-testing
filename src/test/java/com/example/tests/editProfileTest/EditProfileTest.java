package com.example.tests.editProfileTest;

import com.example.pages.MainPage;
import com.example.pages.SettingsPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditProfileTest extends BaseTest {
    private final String firstName = "UI";
    private final String lastName = "testing";
    private final String about = "testing";
    private String login;
    private String password;

    @Test
    public void editProfileTest() {
        initTestData();
        MainPage mainPage = auth(login, password);
        mainPage.clickSettingsModalButton();
        SettingsPage settingsPage = mainPage.clickAccountButton(SettingsPage.class);
        settingsPage.fillFirstName(firstName);
        settingsPage.fillLastName(lastName);
        settingsPage.fillAbout(about);
        settingsPage.clickSaveButton();
        settingsPage = settingsPage.refresh(SettingsPage.class);
        String actualFirstName = settingsPage.getFirstName();
        String actualLastName = settingsPage.getLastName();
        String actualAbout = settingsPage.getAbout();
        assertAll("Edit profile", () -> assertEquals(firstName, actualFirstName), () -> assertEquals(lastName, actualLastName), () -> assertEquals(about, actualAbout));
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
