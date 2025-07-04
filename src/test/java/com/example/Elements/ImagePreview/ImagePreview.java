package com.example.elements.ImagePreview;

import com.example.elements.BaseElement;
import com.example.elements.Article.Article;
import com.example.elements.Image.Image;

public class ImagePreview extends BaseElement {

	private static final String ROLE_XPATH = "//div[@role='%s']";
	private static final String IMG_XPATH_SUFFIX = "//img";
	private static final String ARTICLE_XPATH_SUFFIX = "//a";

	private final Article article;
	private final Image image;

	private ImagePreview(String xpath, String param) {
		super(xpath, param);
		// Construct child elements using derived XPaths
		this.image = Image.byXpath(xpath + IMG_XPATH_SUFFIX);
		this.article = Article.byXpath(xpath + ARTICLE_XPATH_SUFFIX);
	}

	public void click() {
		article.click();
	}

	public void hover() {
		baseElement.hover();
	}

	public String getHrefOfImage() {
		return image.getHrefOfImage();
	}

	public String getHrefOfArticle() {
		return article.getHref();
	}

	public static ImagePreview byRole(String role) {
		String xpath = String.format(ROLE_XPATH, role);
		return new ImagePreview(xpath, role);
	}

	public static ImagePreview byXpath(String xPath) {
		return new ImagePreview(xPath, "");
	}
}