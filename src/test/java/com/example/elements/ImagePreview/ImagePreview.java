package com.example.elements.ImagePreview;

import com.example.elements.Article.Article;
import com.example.elements.BaseElement;
import com.example.elements.H2.H2;

/**
 * Класс для работы с превью изображений.
 * Представляет составной элемент, содержащий связанную статью и заголовок.
 */
public class ImagePreview extends BaseElement {
    // Константы для XPath суффиксов
    private static final String ARTICLE_XPATH_SUFFIX = "//a";
    private static final String H2_XPATH_SUFFIX = "//h2";

    private final Article article;
    private final H2 h2;

    /**
     * Конструктор класса.
     *
     * @param xpathTemplate базовый XPath для превью изображения
     * @param parameter параметр для подстановки в шаблон XPath
     */
    private ImagePreview(String xpathTemplate, String parameter) {
        super(xpathTemplate, parameter);
        this.article = Article.byXpath(xpathTemplate + ARTICLE_XPATH_SUFFIX);
        this.h2 = H2.byXPath(xpathTemplate + H2_XPATH_SUFFIX);
    }

    /**
     * Получает заголовок превью изображения.
     *
     * @return текст заголовка
     */
    public String getPreviewName() {
        return h2.getText();
    }

    /**
     * Получает значение атрибута aria-label связанной статьи.
     *
     * @return значение атрибута aria-label
     */
    public String getArticleAriaLabel() {
        return article.getAriaLabel();
    }

    /**
     * Получает ссылку на связанную статью.
     *
     * @return URL статьи
     */
    public String getArticleHref() {
        return article.getHref();
    }

    /**
     * Выполняет переход по ссылке превью изображения.
     */
    public void click() {
        article.click();
    }

    /**
     * Находит превью изображения по указанному XPath.
     *
     * @param xPath XPath для поиска элемента
     * @return экземпляр класса ImagePreview
     */
    public static ImagePreview byXpath(String xPath) {
        return new ImagePreview(xPath, "");
    }
}