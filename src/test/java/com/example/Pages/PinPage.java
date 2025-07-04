package com.example.pages;

import com.example.elements.Button.Button;
import com.example.elements.Image.Image;

public class PinPage extends BasePage {

	private final Button backButton = Button.byAriaLabel("Назад");
	private final Button likeButton = Button.byAriaLabel("Отреагировать");
	private final Image image = Image.byElementTiming("closeup-image-main-MainPinImage");

	public PinPage() {
		super(PinPage.class, "//*[@data-test-id=\"closeup-container\"]");
	}

	public String getImageHref() {
		return image.getHrefOfImage();
	}

	public <T extends BasePage> T clickBackButton(Class<T> className) {
		backButton.click();
		return page(className);
	}

}
