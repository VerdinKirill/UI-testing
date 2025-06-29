package com.example.Pages.MainPage;

import com.example.Elements.MansoryContainer.MansoryContainer;
import com.example.Pages.BasePage;

//Класс главной страницы, где уже есть картинки, насследуется от BasePage

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
