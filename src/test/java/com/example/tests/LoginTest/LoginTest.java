package com.example.tests.LoginTest;

import com.example.pages.BasePage;
import com.example.pages.LoginPage;
import com.example.pages.MainPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестовый класс для проверки функциональности аутентификации.
 * Проверяет сценарии входа с неверными и верными учетными данными.
 */
public class LoginTest extends BaseTest {
    private static final String FAKE_PASSWORD = "aboba";
    private static final String INCORRECT_FORMAT_EMAIL = "aaaa";
    private String validLogin;
    private String validPassword;

    @Test
    public void checkAuth() {
        System.out.println("[INFO] Начало теста: checkAuth");

        // Инициализация данных
        System.out.println("[ACTION] Инициализация тестовых данных");
        initTestData();
        System.out.println("[SUCCESS] Данные инициализированы: login=" + validLogin);

        // Открытие страницы входа
        System.out.println("[ACTION] Открытие страницы логина");
        LoginPage.open().openLoginModal(LoginPage.class);
        System.out.println("[SUCCESS] Модальное окно логина открыто");

        // Проверка ошибки при некорректном email
        shouldShowErrorWhenInvalidFormatEmail();

        // Проверка ошибки при неправильном пароле
        shouldShowErrorWhenInvalidPassword();

        // Проверка успешного входа
        shouldSuccessfullyLoginWithValidCredentials();

        System.out.println("[INFO] Завершение теста: checkAuth");
    }

    /**
     * Проверяет сценарий входа с неверным паролем.
     * Ожидает появление сообщения об ошибке.
     */
    private void shouldShowErrorWhenInvalidPassword() {
        System.out.println("[ACTION] Попытка входа с правильным логином и неправильным паролем");
        LoginPage loginPage = performLogin(validLogin, FAKE_PASSWORD, LoginPage.class);
        boolean isErrorShown = loginPage.checkIsIncorrectPasswordMessageDisplayed();
        System.out.println("[ASSERTION] Отображается сообщение об ошибке пароля: " + isErrorShown);
        assertTrue(isErrorShown);
        System.out.println("[ASSERTION PASSED] Ошибка при неверном пароле отображается корректно");
    }

    /**
     * Проверяет сценарий входа с неверным email неверного формата.
     * Ожидает появление сообщения об ошибке.
     */
    private void shouldShowErrorWhenInvalidFormatEmail() {
        System.out.println("[ACTION] Попытка входа с email в неправильном формате");
        LoginPage loginPage = performLogin(INCORRECT_FORMAT_EMAIL, FAKE_PASSWORD, LoginPage.class);
        boolean isErrorShown = loginPage.checkIsIncorrectEmailMessageDisplayed();
        System.out.println("[ASSERTION] Отображается сообщение об ошибке формата email: " + isErrorShown);
        assertTrue(isErrorShown);
        System.out.println("[ASSERTION PASSED] Ошибка при неправильном формате email отображается корректно");
    }

    /**
     * Проверяет сценарий входа с верными параметрами входа.
     * Ожидает выполнение аутентификации и прогрузку главной страницы.
     */
    private void shouldSuccessfullyLoginWithValidCredentials() {
        System.out.println("[ACTION] Попытка входа с валидными учетными данными");
        MainPage mainPage = performLogin(validLogin, validPassword, MainPage.class);
        boolean isMainPageVisible = mainPage.isDisplayed();
        System.out.println("[ASSERTION] Главная страница отображается: " + isMainPageVisible);
        assertTrue(isMainPageVisible);
        System.out.println("[ASSERTION PASSED] Успешный вход с валидными учетными данными");
    }

    /**
     * Инициализация тестовых данных.
     * Загружает учетные данные из .env файла.
     */
    protected void initTestData() {
        Dotenv dotenv = Dotenv.load();
        validLogin = dotenv.get("USER_LOGIN");
        validPassword = dotenv.get("USER_PASSWORD");
    }

    /**
     * Выполняет полный процесс аутентификации.
     *
     * @param login      логин пользователя
     * @param password      пароль пользователя
     * @param nextPageClass класс страницы
     * @return экземпляр класса страницы
     */
    private <T extends BasePage> T performLogin(String login, String password, Class<T> nextPageClass) {
        return LoginPage.open().enterLogin(login, LoginPage.class).enterPassword(password, LoginPage.class)
                .clickLoginButton(nextPageClass);
    }

}