package com.example.elements.MansoryContainer;

import com.example.elements.ImagePreview.ImagePreview;
import com.example.elements.BaseElement;
import io.qameta.allure.Step;

public class MansoryContainer extends BaseElement {
    private static final String CLASS_XPATH = "//div[@class='%s']";
    private static final String IMAGE_PREVIEW_XPATH = "//*[@role=\"listitem\"][%d]";  // Updated with placeholder for index

    private MansoryContainer(String xpath, String param) {
        super(xpath, param);
    }

    public String getHrefOfFirstImage() {
        return getNthImagePreview(1).getHrefOfArticle();
    }

    public ImagePreview getNthImagePreview(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Index must be 1 or greater");
        }
        return ImagePreview.byXpath(String.format(IMAGE_PREVIEW_XPATH, n));
    }

    @Step("Click on Image")
    public void clickOnImage() {
        System.out.println("firstImagePreview");
        System.out.println(getNthImagePreview(1).isDisplayed());  // Uses getNthImagePreview instead of firstImagePreview
        getNthImagePreview(1).click();
    }

    public static MansoryContainer byClass(String text) {
        return new MansoryContainer(CLASS_XPATH, text);
    }

    public String getPreviewName() {
        return getNthImagePreview(1).getPreviewName();
    }

    public String getNthArticleAriaLabel(int n) {
        return getNthImagePreview(n).getArticleAriaLabel();
    }

}