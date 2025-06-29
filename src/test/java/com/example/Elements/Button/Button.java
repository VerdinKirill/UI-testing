package com.example.Elements.Button;

import com.example.Elements.BaseElement;

public class Button extends BaseElement {
	private static final String ID_XPATH = "//button[@id='%s']";
	private static final String TEXT_XPATH = "//button[contains(text(),'%s')]";
	private static final String CLASS_XPATH = "//button[@class='%s']";
	private static final String TYPE_XPATH = "//button[@type='%s']";

	private Button(String xpath, String param) {
		super(xpath, param);
	}



	public void click() {
		baseElement.click();
	}

	public static Button byId(String id) {
		return new Button(ID_XPATH, id);
	}

	public static Button byText(String text) {
		return new Button(TEXT_XPATH, text);
	}

	public static Button byClass(String text) {
		return new Button(CLASS_XPATH, text);
	}

	public static Button byType(String text) {
		return new Button(TYPE_XPATH, text);
	}
	public static Button byXPath(String xpath) {
		return new Button("%s", xpath);
	}
}
