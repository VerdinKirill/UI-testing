package com.example.pages;

import com.example.elements.Button.Button;
import com.example.elements.TextArea.TextArea;
import com.example.elements.Input.Input;

public class SettingsPage extends BasePage {
    private static final String PAGE_VALIDATION_XPATH = "//*[@id=\"fullpage\"]";
    private static final String FIRST_NAME_INPUT_NAME = "first_name";
    private static final String LAST_NAME_INPUT_NAME = "last_name";
    private static final String ABOUT_TEXTAREA_ID = "about";
    private static final String SAVE_BUTTON_XPATH = "//div[@data-test-id=\"done-button\"]/button";
    private static final String CANCEL_BUTTON_XPATH = "//div[@data-test-id=\"cancel-button\"]/button";
    private static final String VALUE_ATTRIBUTE = "value";

    // Элементы страницы
    private final Input firstNameInput = Input.byName(FIRST_NAME_INPUT_NAME);
    private final Input lastNameInput = Input.byName(LAST_NAME_INPUT_NAME);
    private final TextArea aboutTextArea = TextArea.byId(ABOUT_TEXTAREA_ID);
    private final Button saveButton = Button.byXPath(SAVE_BUTTON_XPATH);
    private final Button cancelButton = Button.byXPath(CANCEL_BUTTON_XPATH);

    /**
     * Конструктор страницы настроек.
     * Инициализирует страницу с валидационным XPath.
     */
    public SettingsPage() {
        super(LoginPage.class, PAGE_VALIDATION_XPATH);
    }

    /**
     * Вводит имя пользователя.
     *
     * @param firstName имя пользователя
     */
    public void fillFirstName(String firstName) {
        firstNameInput.fill(firstName);
    }

    /**
     * Вводит фамилию пользователя.
     *
     * @param lastName фамилия пользователя
     */
    public void fillLastName(String lastName) {
        lastNameInput.fill(lastName);
    }

    /**
     * Вводит информацию "О себе".
     *
     * @param about информация о пользователе
     */
    public void fillAbout(String about) {
        aboutTextArea.fill(about);
    }

    /**
     * Сохраняет изменения профиля.
     */
    public void clickSaveButton() {
        saveButton.click();
    }

    /**
     * Отменяет изменения профиля.
     */
    public void clickCancelButton() {
        cancelButton.click();
    }

    /**
     * Получает текущее значение имени пользователя.
     *
     * @return текущее имя
     */
    public String getFirstName() {
        return firstNameInput.getAttribute("value");
    }

    /**
     * Получает текущее значение фамилии пользователя.
     *
     * @return текущая фамилия
     */
    public String getLastName() {
        return lastNameInput.getAttribute("value");
    }

    /**
     * Получает текущую информацию "О себе".
     *
     * @return текущая информация "О себе"
     */
    public String getAbout() {
        return aboutTextArea.getText();
    }
}
