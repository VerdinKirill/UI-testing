package com.example.tests.DownloadTest;

import com.example.pages.MainPage;
import com.example.pages.PinPage;
import com.example.tests.BaseTest;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.Wait;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadTest extends BaseTest {
    private String login;
    private String password;
    private final String pathToDownloadDir = "./downloads";

    @Test
    public void checkDownload() {
        System.out.println("[INFO] Инициализация тестовых данных...");
        initTestData();

        System.out.println("[ACTION] Проверка количества файлов .jpeg до скачивания...");
        int startJpegCount = checkNumJpegFiles(true);
        System.out.println("[INFO] Файлов .jpeg до скачивания: " + startJpegCount);

        System.out.println("[ACTION] Авторизация пользователя...");
        MainPage mainPage = auth(login, password);

        System.out.println("[ACTION] Переход к первому пину...");
        PinPage pinPage = mainPage.clickOnFirstImage(PinPage.class);

        System.out.println("[ACTION] Открытие дополнительных опций...");
        pinPage.clickMoreOptionsButton();

        System.out.println("[ACTION] Начало загрузки пина...");
        pinPage.clickDownloadPinButton();

        System.out.println("[WAIT] Ожидание обновления количества картинок...");
        Wait().withTimeout(Duration.ofSeconds(5))
                .until(d -> checkNumJpegFiles(false) != startJpegCount);
        System.out.println("[SUCCESS] Количество картинок обновилось");

        System.out.println("[ACTION] Проверка количества файлов .jpeg после скачивания...");
        int endJpegCount = checkNumJpegFiles(true);
        System.out.println("[INFO] Файлов .jpeg после скачивания: " + endJpegCount);

        System.out.println("[ASSERTION] Проверка, что количество файлов увеличилось");
        assertTrue(endJpegCount > startJpegCount, "[FAIL] Количество файлов после скачивания должно быть больше, чем до");

        System.out.println("[SUCCESS] Тест checkDownload успешно пройден");
    }

    /**
     * Инициализация тестовых данных.
     * Загружает учетные данные из .env файла.
     */
    protected void initTestData() {
        Dotenv dotenv = Dotenv.load();
        login = dotenv.get("USER_LOGIN");
        password = dotenv.get("USER_PASSWORD");
        System.out.println("Логин и пароль загружены из .env");
    }

    private int checkNumJpegFiles(boolean log) {
        File downloadDir = new File(pathToDownloadDir);
        if (!downloadDir.exists()) {
            System.out.println("Папка для загрузок не найдена: " + pathToDownloadDir);
            return 0;
        }
        int count = countJpegFilesRecursively(downloadDir);
        if (log) System.out.println("Найдено файлов .jpeg (включая подкаталоги): " + count);
        return count;
    }

    /**
     * Рекурсивно считает все файлы с расширением .jpeg в каталоге и подкаталогах.
     */
    private int countJpegFilesRecursively(File directory) {
        int count = 0;
        File[] filesAndDirs = directory.listFiles();
        if (filesAndDirs != null) {
            for (File file : filesAndDirs) {
                if (file.isDirectory()) {
                    count += countJpegFilesRecursively(file);
                } else if (file.isFile() && file.getName().toLowerCase().endsWith(".jpeg")) {
                    count++;
                }
            }
        }
        return count;
    }
}