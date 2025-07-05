package com.example.elements.H2;

import com.example.elements.BaseElement;

/**
 * Класс для работы с текстовыми элементами.
 * Предоставляет методы для поиска текстовых элементов и проверки их
 * содержимого.
 */
public class H2 extends BaseElement {
    private static final String ID_XPATH = "//h2[@id='%s']";
    private static final String CLASS_XPATH = "//h2[@class='%s']";
    private static final String TEXT_XPATH = "//h2[contains(text(),'%s')]";

    /**
     * Конструктор класса.
     *
     * @param xpath шаблон XPath для поиска элемента
     * @param param параметр для подстановки в шаблон XPath
     */
    private H2(String xpath, String param) {
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
     * @return экземпляр класса H2
     */
    public static H2 byId(String id) {
        return new H2(ID_XPATH, id);
    }

    /**
     * Находит текстовый элемент по названию класса.
     *
     * @param className название класса
     * @return экземпляр класса H2
     */
    public static H2 byClass(String className) {
        return new H2(CLASS_XPATH, className);
    }

    /**
     * Находит H2 по указанному XPath.
     *
     * @param xpath XPath для поиска элемента
     * @return экземпляр класса H2
     */
    public static H2 byXPath(String xpath) {
        return new H2("%s", xpath);
    }
}