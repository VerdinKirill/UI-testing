package com.example.pages;

import com.example.elements.MansoryContainer.MansoryContainer;

//Класс главной страницы, где уже есть картинки, наследуется от BasePage

public class MainPage extends BasePage {
	private final MansoryContainer mansoryContainer = MansoryContainer.byClass("masonryContainer");

	public MainPage() {
		super(MainPage.class, "//*[@role=main]");
	}

	public boolean isDisplayed() {
		return mansoryContainer.isDisplayed();
		// return welcomeMessage.exists() && welcomeMessage.isDisplayed();
	}
}
