package com.example.tests.LoginTest;

import com.example.pages.BasePage;
import com.example.pages.LoginPage;
import com.example.pages.MainPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;

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

    //	@Test
    public void checkAuth() {
        initTestData();
        LoginPage.open().openLoginModal(LoginPage.class);
        shouldShowErrorWhenInvalidFormatEmail();
        shouldShowErrorWhenInvalidPassword();
        shouldSuccessfullyLoginWithValidCredentials();
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
     * Проверяет сценарий входа с неверным паролем.
     * Ожидает появление сообщения об ошибке.
     */
    private void shouldShowErrorWhenInvalidPassword() {
        LoginPage loginPage = performLogin(validLogin, FAKE_PASSWORD, LoginPage.class);
        assertTrue(loginPage.checkIsIncorrectPasswordMessageDisplayed());
    }

    /**
     * Проверяет сценарий входа с неверным email неверного формата.
     * Ожидает появление сообщения об ошибке.
     */
    private void shouldShowErrorWhenInvalidFormatEmail() {
        LoginPage loginPage = performLogin(INCORRECT_FORMAT_EMAIL, FAKE_PASSWORD, LoginPage.class);
        assertTrue(loginPage.checkIsIncorrectEmailMessageDisplayed());
    }

    /**
     * Проверяет сценарий входа с верными параметрами входа.
     * Ожидает выполнение аутентификации и прогрузку главной страницы.
     */
    private void shouldSuccessfullyLoginWithValidCredentials() {
        MainPage mainPage = performLogin(validLogin, validPassword, MainPage.class);
        assertTrue(mainPage.isDisplayed());
    }

    /**
     * Выполняет полный процесс аутентификации.
     *
     * @param username      логин пользователя
     * @param password      пароль пользователя
     * @param nextPageClass класс страницы
     * @return экземпляр класса страницы
     */
    private <T extends BasePage> T performLogin(String login, String password, Class<T> nextPageClass) {
        return LoginPage.open().enterLogin(login, LoginPage.class).enterPassword(password, LoginPage.class)
                .clickLoginButton(nextPageClass);
    }

}