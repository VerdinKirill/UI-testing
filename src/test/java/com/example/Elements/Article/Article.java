package com.example.elements.Article;

import com.example.elements.BaseElement;

public class Article extends BaseElement {

	private static final String ARIA_LABEL_XPATH = "//a[@aria-label='%s']";

	private Article(String xpath, String param) {
		super(xpath, param);
	}

	public String getHref() {
		return baseElement.getAttribute("href");
	}

	public void click()
	{
		baseElement.click();
	}
	public static Article byAriaLabel(String ariaLabel) {
		return new Article(ARIA_LABEL_XPATH, ariaLabel);
	}


}
