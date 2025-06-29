package com.example.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

//Класс базовой страницы, взаимодействует с элементами страницы
public class BasePage {
	private static final String BASE_ELEMENT_XPATH = "//div[contains(@name,'%s')]";

	protected final SelenideElement basePage;
	protected final Class<? extends BasePage> pageClass;

	protected BasePage(Class<? extends BasePage> pageClass, String type) {
		this.basePage = $x(String.format(BASE_ELEMENT_XPATH, type));
		this.pageClass = pageClass;
	}

	// Refresh and return the current page
	public <T extends BasePage> T refresh(Class<T> pageClass) {
		Selenide.refresh();
		return page(pageClass);
	}

	// Initialize a new instance of the page
	public <T extends BasePage> T page(Class<T> pageClass) {
		try {
			return pageClass.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Failed to create page instance for " + pageClass.getSimpleName(), e);
		}
	}
}