package com.example.elements.Article;

import com.example.elements.BaseElement;

/**
 * Класс, представляющий элемент статьи на веб-странице.
 * Инкапсулирует функциональность для работы со статьями.
 */
public class Article extends BaseElement {
    private static final String ARIA_LABEL_XPATH = "//a[@aria-label='%s']";
    private static final String HREF_ATTRIBUTE = "href";
    private static final String ARIA_LABEL_ATTRIBUTE = "aria-label";

    /**
     * Конструктор элемента статьи.
     *
     * @param xpathTemplate шаблон XPath для поиска элемента
     * @param parameter параметр для подстановки в шаблон XPath
     */
    private Article(String xpathTemplate, String parameter) {
        super(xpathTemplate, parameter);
    }

    /**
     * Получает значение атрибута href элемента статьи.
     *
     * @return значение атрибута href
     */
    public String getHref() {
        return baseElement.getAttribute(HREF_ATTRIBUTE);
    }

    /**
     * Получает значение атрибута aria-label элемента статьи.
     *
     * @return значение атрибута aria-label
     */
    public String getAriaLabel() {
        return baseElement.getAttribute(ARIA_LABEL_ATTRIBUTE);
    }

    /**
     * Выполняет клик по элементу статьи.
     */
    public void click() {
        baseElement.click();
    }

    /**
     * Находит элемент статьи по значению атрибута aria-label.
     *
     * @param ariaLabel значение атрибута aria-label
     * @return экземпляр элемента статьи
     */
    public static Article byAriaLabel(String ariaLabel) {
        return new Article(ARIA_LABEL_XPATH, ariaLabel);
    }

    /**
     * Находит элемент статьи по XPath.
     *
     * @param xPath XPath элемента
     * @return экземпляр элемента статьи
     */
    public static Article byXpath(String xPath) {
        return new Article("%s", xPath);
    }
}