package com.example.pages;

import com.example.Elements.Button.Button;
import com.example.Elements.LoginModal.LoginModal;

/**
 * Страница аутентификации пользователя.
 * Предоставляет методы для взаимодействия с элементами входа.
 */
public class LoginPage extends BasePage {
    private static final String LOGIN_BUTTON_XPATH = "//*[@id=\"__PWS_ROOT__\"]/div[1]/div[1]/div[2]/div/div[2]/div[2]/button";
    private static final String PAGE_VALIDATION_XPATH = "//*[@id=\"fullpage\"]";

    private final Button loginModalButton = Button
            .byXPath(LOGIN_BUTTON_XPATH);
    private final LoginModal loginModal = LoginModal.byAriaLabel("modal");

    /**
     * Конструктор класса.
     * Инициализирует страницу с валидационным XPath.
     */
    public LoginPage() {
        super(LoginPage.class, PAGE_VALIDATION_XPATH);
    }

    /**
     * Открывает модальное окно аутентификации.
     *
     * @param nextPageClass класс возращаемой страницы
     * @param <T>           тип страницы
     * @return текущий экземпляр страницы
     */
    public <T extends BasePage> T openLoginModal(Class<T> nextPageClass) {
        // System.out.print(loginModalButton.isDisplayed());
        loginModalButton.click();
        return page(nextPageClass);
    }

    /**
     * Проверяет отображение модального окна аутентификации.
     *
     * @return true если модальное окно отображается, иначе false
     */
    public boolean isLoginModalDisplayed() {
        return loginModal.isDisplayed();
    }

    public boolean checkIsLoginModalDisplayed() {
        return loginModal.isDisplayed();
    }

    /**
     * Вводит логин в поле ввода.
     *
     * @param login         логин пользователя
     * @param nextPageClass класс возращаемой страницы
     * @param <T>           тип страницы
     * @return текущий экземпляр страницы
     */
    public <T extends BasePage> T enterLogin(String login, Class<T> nextPageClass) {
        loginModal.enterTextInLoginInput(login);
        return page(nextPageClass);
    }

    /**
     * Вводит пароль в поле ввода.
     *
     * @param password      пароль пользователя
     * @param nextPageClass класс возращаемой страницы
     * @param <T>           тип страницы
     * @return текущий экземпляр страницы
     */
    public <T extends BasePage> T enterPassword(String password, Class<T> nextPageClass) {
        loginModal.enterTextInPasswordInput(password);
        return page(nextPageClass);
    }

    /**
     * Нажимает кнопку входа.
     *
     * @param nextPageClass класс возраща
     * @param <T>           тип страницы
     * @return экземпляр главной страницы
     */
    public <T extends BasePage> T clickLoginButton(Class<T> nextPageClass) {
        loginModal.clickLoginButton();
        return page(nextPageClass);
    }

    /**
     * Проверяет отображение сообщения о неверном пароле.
     *
     * @return true если сообщение отображается, иначе false
     */
    public boolean checkIsIncorrectPasswordMessageDisplayed() {
        return loginModal.checkIsDisplayedIncorrectPasswordText();
    }

    /**
     * Проверяет отображение сообщения о неверном формате email.
     *
     * @return true если сообщение отображается, иначе false
     */
    public boolean checkIsIncorrectEmailMessageDisplayed() {
        return loginModal.checkIsDisplayedIncorrectEmailFormatText();
    }

    /**
     * Открывает страницу аутентификации.
     *
     * @return экземпляр страницы аутентификации
     */

    public static LoginPage open() {
        return new LoginPage();
    }

}
