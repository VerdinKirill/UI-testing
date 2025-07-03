package com.example.Elements.Button;

import com.example.Elements.BaseElement;

/**
 * Класс для работы с элементами типа "кнопка".
 * Предоставляет методы для поиска кнопок по различным атрибутам
 * и выполнения действий над ними.
 */
public class Button extends BaseElement {
	private static final String ID_XPATH = "//button[@id='%s']";
	private static final String TEXT_XPATH = "//button[contains(text(),'%s')]";
	private static final String CLASS_XPATH = "//button[@class='%s']";
	private static final String TYPE_XPATH = "//button[@type='%s']";

	/**
	 * Конструктор класса.
	 * 
	 * @param xpath шаблон XPath для поиска элемента
	 * @param param параметр для подстановки в шаблон XPath
	 */
	private Button(String xpath, String param) {
		super(xpath, param);
	}

	/**
	 * Выполняет клик по кнопке.
	 */
	public void click() {
		baseElement.click();
	}

	/**
	 * Находит кнопку по идентификатору.
	 * 
	 * @param id идентификатор кнопки
	 * @return экземпляр класса Button
	 */
	public static Button byId(String id) {
		return new Button(ID_XPATH, id);
	}

	/**
	 * Находит кнопку по тексту.
	 * 
	 * @param text текст кнопки
	 * @return экземпляр класса Button
	 */
	public static Button byText(String text) {
		return new Button(TEXT_XPATH, text);
	}

	/**
	 * Находит кнопку по названию класса.
	 * 
	 * @param className название класса
	 * @return экземпляр класса Button
	 */
	public static Button byClass(String text) {
		return new Button(CLASS_XPATH, text);
	}

	/**
	 * Находит кнопку по типу.
	 * 
	 * @param type тип кнопки
	 * @return экземпляр класса Button
	 */
	public static Button byType(String text) {
		return new Button(TYPE_XPATH, text);
	}

	/**
	 * Находит кнопку по указанному XPath.
	 * 
	 * @param xpath XPath для поиска элемента
	 * @return экземпляр класса Button
	 */
	public static Button byXPath(String xpath) {
		return new Button("%s", xpath);
	}
}
