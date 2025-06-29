//Простой тест, чтобы вообще понять работает ли сборка или нет, расскомитьте @Test

package com.example.tests.LoginTest;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.*;

public class MinTest {
	// @Test
	void openGoogle() {
		Configuration.browser = "chrome";
		Configuration.headless = false;

		open("https://ru.pinterest.com");
	}
}
