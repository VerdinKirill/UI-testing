package com.example.Elements.Button;

import com.example.Elements.BaseElement;

//Класс Button - наследник класса BaseElement
//Представляет собой элемент кнопки
public class Button extends BaseElement {
	private static final String ID_XPATH = "//button[@id='%s']";
	private static final String TEXT_XPATH = "//button[contains(text(),'%s')]";
	private static final String CLASS_XPATH = "//button[@class='%s']";
	private static final String TYPE_XPATH = "//button[@type='%s']";

	private Button(String xpath, String param) {
		super(xpath, param);
	}

	// метод клика на кнопку (по факту в дальнейшем мб заменить на интерфейс пока не
	// поздно)
	public void click() {
		baseElement.click();
	}

	// Получение элемента кнопки по айди
	public static Button byId(String id) {
		return new Button(ID_XPATH, id);
	}

	// Получение элемента кнопки по тексту внутри
	public static Button byText(String text) {
		return new Button(TEXT_XPATH, text);
	}

	// Получение элемента кнопки по названию класса
	public static Button byClass(String text) {
		return new Button(CLASS_XPATH, text);
	}

	// Получение элемента кнопки по типу кнопки
	public static Button byType(String text) {
		return new Button(TYPE_XPATH, text);
	}

	// Получение элемента кнопки по xpath
	public static Button byXPath(String xpath) {
		return new Button("%s", xpath);
	}
}
