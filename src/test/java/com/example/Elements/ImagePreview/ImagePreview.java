package com.example.elements.ImagePreview;

import com.example.elements.BaseElement;
import com.example.elements.Article.Article;
import com.example.elements.Image.Image;

public class ImagePreview extends BaseElement {

	private final String ALT_IMAGE = "Пин содержит это изображение: ";
	private static final String ROLE_XPATH = "//div[@role='%s']";

	private final Article article = Article.byAriaLabel("Пин");
	private final Image image = Image.byAlt(ALT_IMAGE);

	private ImagePreview(String xpath, String param) {
		super(xpath, param);
	}

	public void click() {
		image.click();
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
		return new ImagePreview(ROLE_XPATH, role);
	}

		public static ImagePreview byXpath(String xPath) {
		return new ImagePreview(xPath, "");
	}

}
