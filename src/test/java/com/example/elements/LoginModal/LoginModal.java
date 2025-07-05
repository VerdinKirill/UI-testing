package com.example.Elements.LoginModal;

import com.example.Elements.Button.Button;
import com.example.elements.BaseElement;
import com.example.elements.Input.Input;
import com.example.Elements.Text.Text;

/**
 * Класс для работы с модальным окном аутентификации.
 * Инкапсулирует функциональность элементов модального окна входа.
 */
public class LoginModal extends BaseElement {
    private static final String ARIA_LABEL_XPATH = "//div[@aria-label='%s']";

    private final Input loginInput = Input.byId("email");
    private final Input passwordInput = Input.byId("password");
    private final Button loginButton = Button.byType("submit");
    private final Text incorrectPasswordText = Text.byId("password-error");
    private final Text incorrectEmailFormatText = Text.byId("email-error");

    /**
     * Конструктор класса.
     *
     * @param xpath шаблон XPath для поиска элемента
     * @param param параметр для подстановки в шаблон XPath
     */
    private LoginModal(String xpath, String param) {
        super(xpath, param);
    }

    /**
     * Вводит текст в поле логина.
     *
     * @param text текст для ввода
     */
    public void enterTextInLoginInput(String text) {
        loginInput.fill(text);
    }

    /**
     * Вводит текст в поле пароля.
     *
     * @param text текст для ввода
     */
    public void enterTextInPasswordInput(String text) {
        passwordInput.fill(text);
    }

    /**
     * Нажимает кнопку входа.
     */

    public void clickLoginButton() {
        loginButton.click();
    }

    /**
     * Проверяет отображение сообщения о неверном пароле.
     *
     * @return true если сообщение видимо, иначе false
     */
    public boolean checkIsDisplayedIncorrectPasswordText() {
        return incorrectPasswordText.isDisplayed();
    }

    /**
     * Проверяет отображение сообщения о неверном формате email.
     *
     * @return true если сообщение видимо, иначе false
     */
    public boolean checkIsDisplayedIncorrectEmailFormatText() {
        return incorrectEmailFormatText.isDisplayed();
    }

    /**
     * Находит модальное окно по значению атрибута aria-label.
     *
     * @param text значение атрибута aria-label
     * @return экземпляр класса LoginModal
     */
    public static LoginModal byAriaLabel(String text) {
        return new LoginModal(ARIA_LABEL_XPATH, text);
    }

}
