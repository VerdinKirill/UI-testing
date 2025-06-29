package com.example.Elements.MansoryContainer;

import com.example.Elements.BaseElement;

public class MansoryContainer extends BaseElement {
	private static final String CLASS_XPATH = "//div[@class='%s']";

	private MansoryContainer(String xpath, String param) {
        super(xpath, param);
    }

	public static MansoryContainer byClass(String text) {
		return new MansoryContainer(CLASS_XPATH, text);
	}

}
