package com.example.elements.Button;

import com.example.elements.BaseElement;

/**
 * Класс для работы с элементами типа "кнопка".
 * Предоставляет методы для поиска кнопок по различным атрибутам
 * и выполнения действий над ними.
 */
public class Button extends BaseElement {
    // Константы для шаблонов XPath
    private static final String ID_XPATH = "//button[@id='%s']";
    private static final String TEXT_XPATH = "//button[contains(text(),'%s')]";
    private static final String CLASS_XPATH = "//button[@class='%s']";
    private static final String TYPE_XPATH = "//button[@type='%s']";
    private static final String ARIA_LABEL_XPATH = "//button[@aria-label='%s']";
    private static final String DATA_TEST_ID_XPATH = "//button[@data-test-id='%s']";

    /**
     * Конструктор класса.
     *
     * @param xpathTemplate шаблон XPath для поиска элемента
     * @param parameter параметр для подстановки в шаблон XPath
     */
    protected Button(String xpathTemplate, String parameter) {
        super(xpathTemplate, parameter);
    }

    /**
     * Выполняет клик по кнопке.
     */
    public void click() {
        baseElement.click();
    }

    /**
     * Находит кнопку по идентификатору.
     *
     * @param id идентификатор кнопки
     * @return экземпляр класса Button
     */
    public static Button byId(String id) {
        return new Button(ID_XPATH, id);
    }

    /**
     * Находит кнопку по тексту.
     *
     * @param text текст кнопки
     * @return экземпляр класса Button
     */
    public static Button byText(String text) {
        return new Button(TEXT_XPATH, text);
    }

    /**
     * Находит кнопку по названию класса.
     *
     * @param className название класса
     * @return экземпляр класса Button
     */
    public static Button byClass(String className) {
        return new Button(CLASS_XPATH, className);
    }

    /**
     * Находит кнопку по типу.
     *
     * @param type тип кнопки
     * @return экземпляр класса Button
     */
    public static Button byType(String type) {
        return new Button(TYPE_XPATH, type);
    }

    /**
     * Находит кнопку по значению атрибута aria-label.
     *
     * @param ariaLabel значение атрибута aria-label
     * @return экземпляр класса Button
     */
    public static Button byAriaLabel(String ariaLabel) {
        return new Button(ARIA_LABEL_XPATH, ariaLabel);
    }

    /**
     * Находит кнопку по указанному XPath.
     *
     * @param xPath XPath для поиска элемента
     * @return экземпляр класса Button
     */
    public static Button byXPath(String xPath) {
        return new Button("%s", xPath);
    }

    /**
     * Находит кнопку по значению атрибута data-test-id.
     *
     * @param dataTestId значение атрибута data-test-id
     * @return экземпляр класса Button
     */
    public static Button byDataTestId(String dataTestId) {
        return new Button(DATA_TEST_ID_XPATH, dataTestId);
    }
}