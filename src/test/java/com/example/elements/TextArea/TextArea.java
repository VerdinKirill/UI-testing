package com.example.Elements.TextArea;

import com.example.elements.BaseElement;
import org.openqa.selenium.Keys;

/**
 * Класс для работы с текстовыми элементами.
 * Предоставляет методы для поиска текстовых элементов и проверки их
 * содержимого.
 */
public class TextArea extends BaseElement {
    private static final String ID_XPATH = "//textarea[@id='%s']";
    private static final String CLASS_XPATH = "//textarea[@class='%s']";
    private static final String TEXT_XPATH = "//textarea[contains(text(),'%s')]";

    /**
     * Конструктор класса.
     *
     * @param xpath шаблон XPath для поиска элемента
     * @param param параметр для подстановки в шаблон XPath
     */
    private TextArea(String xpath, String param) {
        super(xpath, param);
    }

    /**
     * Проверяет, содержит ли элемент указанный текст.
     *
     * @param text текст для проверки
     * @return true если элемент содержит указанный текст, иначе false
     */
    public boolean contains(String text) {
        return baseElement.getText().contains(text);
    }

    /**
     * Проверяет точное соответствие текста элемента.
     *
     * @param text ожидаемый текст
     * @return true если текст элемента точно соответствует ожидаемому, иначе false
     */
    public boolean hasExactText(String text) {
        return baseElement.getText().equals(text);
    }

    /**
     * Возвращает текст элемента.
     *
     * @return текст элемента
     */
    public String getText() {
        return baseElement.getText();
    }

    public void clear() {
        while (!baseElement.getAttribute("value").equals("")) {
            baseElement.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void fill(String value) {
        clear();
        baseElement.sendKeys(value);
    }

    /**
     * Находит текстовый элемент по идентификатору.
     *
     * @param id идентификатор элемента
     * @return экземпляр класса Text
     */
    public static TextArea byId(String id) {
        return new TextArea(ID_XPATH, id);
    }

    /**
     * Находит текстовый элемент по названию класса.
     *
     * @param className название класса
     * @return экземпляр класса Text
     */
    public static TextArea byClass(String className) {
        return new TextArea(CLASS_XPATH, className);
    }

    /**
     * Находит текстовый элемент по содержащемуся тексту.
     *
     * @param text текст элемента
     * @return экземпляр класса Text
     */
    public static TextArea byText(String text) {
        return new TextArea(TEXT_XPATH, text);
    }

}