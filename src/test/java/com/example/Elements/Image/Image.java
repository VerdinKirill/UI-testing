package com.example.elements.Image;

import com.example.elements.BaseElement;

/**
 * Класс для работы с элементами типа "поле ввода".
 * Предоставляет методы для поиска полей ввода по различным атрибутам
 * и выполнения действий над ними.
 */
public class Image extends BaseElement {
	private static final String ALT_XPATH = "//img[@alt='%s']";
	private static final String ELEMENT_TIMING_XPATH = "//img[@elementtiming='%s']";

	/**
	 * Конструктор класса.
	 * 
	 * @param xpath шаблон XPath для поиска элемента
	 * @param param параметр для подстановки в шаблон XPath
	 */
	private Image(String xpath, String param) {
		super(xpath, param);
	}

	public void click() {
		baseElement.click();
	}

	public String getHrefOfImage() {
		return baseElement.getAttribute("href");
	}

	/**
	 * Находит поле ввода по названию класса.
	 * 
	 * @param alt название alt
	 * @return экземпляр класса Image
	 */
	public static Image byAlt(String alt) {
		return new Image(ALT_XPATH, alt);
	}

	public static Image byAlt(String prevXpath, String alt) {
		return new Image(prevXpath + ALT_XPATH, alt);
	}

	public static Image byXpath(String xPath) {
		return new Image("%s", xPath);
	}

	public static Image byElementTiming(String elementTiming) {
		return new Image(ELEMENT_TIMING_XPATH, elementTiming);
	}

}