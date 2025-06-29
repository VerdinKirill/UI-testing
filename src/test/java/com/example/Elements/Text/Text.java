package com.example.Elements.Text;

import com.example.Elements.BaseElement;

public class Text extends BaseElement {
	private static final String ID_PATH = "//span[@id='%s']";

	private Text(String xpath, String param) {
		super(xpath, param);
	}

	public static Text byId(String text) {
		return new Text(ID_PATH, text);
	}

	public boolean containsText(String text) {
		return this.baseElement.getText().contains(text);
	}

}
