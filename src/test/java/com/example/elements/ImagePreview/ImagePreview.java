package com.example.elements.ImagePreview;

import com.example.elements.Article.Article;
import com.example.elements.BaseElement;
import com.example.elements.H2.H2;
import com.example.elements.Image.Image;

public class ImagePreview extends BaseElement {
    private static final String ARTICLE_XPATH_SUFFIX = "//a";
    private static final String H2_XPATH_SUFFIX = "//h2";

    private final Article article;
    private final H2 h2;

    private ImagePreview(String xpath, String param) {
        super(xpath, param);
        // Construct child elements using derived XPaths
        this.article = Article.byXpath(xpath + ARTICLE_XPATH_SUFFIX);
        this.h2 = H2.byXPath(xpath + H2_XPATH_SUFFIX);
    }

    public void click() {
        article.click();
    }

    public String getHrefOfArticle() {
        return article.getHref();
    }

    public static ImagePreview byXpath(String xPath) {
        return new ImagePreview(xPath, "");
    }

    public String getPreviewName() {
        return h2.getText();
    }
}