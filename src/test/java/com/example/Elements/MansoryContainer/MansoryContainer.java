package com.example.Elements.MansoryContainer;

import com.example.Elements.BaseElement;


//Mansory container - наследуется от BaseElement
//является классом контейнером для всех картинок на MainPage
//100% в дальнейшем будет составным элементом, а пока что нужен чисто для того, чтобы проверять прогрузилась ли Главная страница после авторизации
public class MansoryContainer extends BaseElement {
	private static final String CLASS_XPATH = "//div[@class='%s']";

	private MansoryContainer(String xpath, String param) {
        super(xpath, param);
    }

	public static MansoryContainer byClass(String text) {
		return new MansoryContainer(CLASS_XPATH, text);
	}

}
