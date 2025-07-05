package com.example.elements.MansoryContainer;

import com.example.elements.BaseElement;
import com.example.elements.ImagePreview.ImagePreview;

/**
 * Класс для работы с Masonry-контейнером изображений.
 * Представляет контейнер, содержащий превью изображений в виде сетки.
 */
public class MansoryContainer extends BaseElement {
    private static final String CLASS_XPATH = "//div[@class='%s']";
    private static final String IMAGE_PREVIEW_XPATH = "//*[@role=\"listitem\"][%d]";  // Updated with placeholder for index

    /**
     * Конструктор класса.
     *
     * @param xpath шаблон XPath для поиска элемента
     * @param param     параметр для подстановки в шаблон XPath
     */
    private MansoryContainer(String xpath, String param) {
        super(xpath, param);
    }

    /**
     * Получает ссылку на статью первого превью изображения в контейнере.
     *
     * @return URL статьи
     */
    public String getHrefOfFirstImage() {
        return getNthImagePreview(1).getArticleHref();
    }

    /**
     * Получает превью изображения по порядковому номеру.
     *
     * @param n порядковый номер превью (начиная с 1)
     * @return экземпляр превью изображения
     * @throws IllegalArgumentException если индекс меньше 1
     */
    public ImagePreview getNthImagePreview(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Index must be 1 or greater");
        }
        return ImagePreview.byXpath(String.format(IMAGE_PREVIEW_XPATH, n));
    }

    /**
     * Выполняет клик по первому превью изображения в контейнере.
     */
    public void clickOnImage() {// Uses getNthImagePreview instead of firstImagePreview
        getNthImagePreview(1).click();
    }

    /**
     * Получает название первого превью изображения в контейнере.
     *
     * @return название превью
     */
    public String getPreviewName() {
        return getNthImagePreview(1).getPreviewName();
    }

    /**
     * Получает значение атрибута aria-label статьи для n-го превью.
     *
     * @param n порядковый номер превью (начиная с 1)
     * @return значение атрибута aria-label
     */
    public String getNthArticleAriaLabel(int n) {
        return getNthImagePreview(n).getArticleAriaLabel();
    }

    /**
     * Находит Masonry-контейнер по названию класса.
     *
     * @param className название класса контейнера
     * @return экземпляр класса MansoryContainer
     */
    public static MansoryContainer byClass(String className) {
        return new MansoryContainer(CLASS_XPATH, className);
    }
}
