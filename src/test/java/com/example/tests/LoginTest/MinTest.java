package com.example.tests.LoginTest;

import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
// import com.codeborne.selenide.Selenide;
// import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class MinTest {
	// @Test
	void openGoogle() {
		Configuration.browser = "chrome";
		Configuration.headless = false;

		open("https://ru.pinterest.com");
	}
}
