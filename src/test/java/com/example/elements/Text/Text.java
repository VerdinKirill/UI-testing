package com.example.elements.Text;

import com.example.elements.BaseElement;

/**
 * Класс длsя работы с текстовыми элементами.
 * Предоставляет методы для поиска текстовых элементов и проверки их
 * содержимого.
 */
public class Text extends BaseElement {
    private static final String ID_XPATH = "//span[@id='%s']";
    private static final String CLASS_XPATH = "//span[@class='%s']";
    private static final String TEXT_XPATH = "//span[contains(text(),'%s')]";

    /**
     * Конструктор класса.
     *
     * @param xpath шаблон XPath для поиска элемента
     * @param param параметр для подстановки в шаблон XPath
     */
    private Text(String xpath, String param) {
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

    /**
     * Находит текстовый элемент по идентификатору.
     *
     * @param id идентификатор элемента
     * @return экземпляр класса Text
     */
    public static Text byId(String id) {
        return new Text(ID_XPATH, id);
    }

    /**
     * Находит текстовый элемент по названию класса.
     *
     * @param className название класса
     * @return экземпляр класса Text
     */
    public static Text byClass(String className) {
        return new Text(CLASS_XPATH, className);
    }

    /**
     * Находит текстовый элемент по содержащемуся тексту.
     *
     * @param text текст элемента
     * @return экземпляр класса Text
     */
    public static Text byText(String text) {
        return new Text(TEXT_XPATH, text);
    }
}