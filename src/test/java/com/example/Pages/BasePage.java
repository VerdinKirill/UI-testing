package com.example.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Базовый класс для всех страниц приложения.
 * Инкапсулирует общую функциональность работы со страницами.
 */
public class BasePage {
	private static final String BASE_ELEMENT_XPATH = "//div[contains(@name,'%s')]";

	protected final SelenideElement basePage;
	protected final Class<? extends BasePage> pageClass;

	/**
	 * Конструктор базовой страницы.
	 * 
	 * @param pageClass               класс страницы (для рефлексии)
	 * @param uniqueElementIdentifier уникальный идентификатор элемента страницы
	 */
	protected BasePage(Class<? extends BasePage> pageClass, String uniqueElementIdentifier) {
		this.basePage = $x(String.format(BASE_ELEMENT_XPATH, uniqueElementIdentifier));
		this.pageClass = pageClass;
	}

	/**
	 * Проверяет, загружена ли страница.
	 * 
	 * @return true если базовый элемент страницы отображается, иначе false
	 */
	public boolean isLoaded() {
		return basePage.isDisplayed();
	}

	/**
	 * Обновляет текущую страницу.
	 * 
	 * @param pageClass класс страницы, которую нужно вернуть
	 * @return новый экземпляр обновлённой страницы
	 * @param <T> тип страницы
	 */
	public <T extends BasePage> T refresh(Class<T> pageClass) {
		Selenide.refresh();
		return page(pageClass);
	}

	
    /**
     * Создаёт экземпляр страницы указанного класса.
     * 
     * @param pageClass класс страницы
     * @return новый экземпляр страницы
     * @param <T> тип страницы
     */
	public <T extends BasePage> T page(Class<T> pageClass) {
		try {
			return pageClass.getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Failed to create page instance for " + pageClass.getSimpleName(), e);
		}
	}
}