package com.example.elements.Image;

import com.example.elements.BaseElement;

/**
 * Класс для работы с элементами типа "изображение".
 * Предоставляет методы для поиска изображений по различным атрибутам
 * и выполнения действий над ними.
 */
public class Image extends BaseElement {
    // Константы для шаблонов XPath
    private static final String ALT_XPATH = "//img[@alt='%s']";
    private static final String ELEMENT_TIMING_XPATH = "//img[@elementtiming='%s']";
    private static final String HREF_ATTRIBUTE = "href";
    private static final String SRC_ATTRIBUTE = "src";

    /**
     * Конструктор класса.
     *
     * @param xpathTemplate шаблон XPath для поиска элемента
     * @param parameter параметр для подстановки в шаблон XPath
     */
    private Image(String xpathTemplate, String parameter) {
        super(xpathTemplate, parameter);
    }

    /**
     * Выполняет клик по изображению.
     */
    public void click() {
        baseElement.click();
    }

    /**
     * Получает значение атрибута href изображения.
     * Примечание: используется, когда изображение является ссылкой.
     *
     * @return значение атрибута href
     */
    public String getHref() {
        return baseElement.getAttribute(HREF_ATTRIBUTE);
    }

    /**
     * Получает значение атрибута src изображения.
     *
     * @return значение атрибута src
     */
    public String getSrc() {
        return baseElement.getAttribute(SRC_ATTRIBUTE);
    }

    /**
     * Находит изображение по значению атрибута alt.
     *
     * @param alt значение атрибута alt
     * @return экземпляр класса Image
     */
    public static Image byAlt(String alt) {
        return new Image(ALT_XPATH, alt);
    }

    /**
     * Находит изображение по значению атрибута elementtiming.
     *
     * @param elementTiming значение атрибута elementtiming
     * @return экземпляр класса Image
     */
    public static Image byElementTiming(String elementTiming) {
        return new Image(ELEMENT_TIMING_XPATH, elementTiming);
    }

    /**
     * Находит изображение по указанному XPath.
     *
     * @param xPath XPath для поиска элемента
     * @return экземпляр класса Image
     */
    public static Image byXpath(String xPath) {
        return new Image("%s", xPath);
    }
}