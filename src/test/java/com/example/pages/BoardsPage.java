package com.example.pages;

import com.example.elements.Button.Button;
import com.example.elements.MansoryContainer.MansoryContainer;

/**
 * Страница досок пользователя.
 * Предоставляет функционал для работы с досками и их сортировкой.
 */
public class BoardsPage extends BasePage {
    private static final String MAIN_CONTAINER_XPATH = "//*[@class=\"mainContainer\"]";
    private static final String MORE_OPTIONS_BUTTON_ARIA_LABEL = "Упорядочить";
    private static final String ALPHABETIC_ORDER_BUTTON_ID = "actionBarMenuButton-item-0";
    private static final String LAST_ADDED_ORDER_BUTTON_ID = "actionBarMenuButton-item-2";
    private static final String MASONRY_CONTAINER_CLASS = "masonryContainer";

    // Элементы страницы
    private final Button moreOptionsButton = Button.byAriaLabel(MORE_OPTIONS_BUTTON_ARIA_LABEL);
    private final Button alphabeticOrderButton = Button.byId(ALPHABETIC_ORDER_BUTTON_ID);
    private final Button lastAddedOrderButton = Button.byId(LAST_ADDED_ORDER_BUTTON_ID);
    private final MansoryContainer mansoryContainer = MansoryContainer.byClass(MASONRY_CONTAINER_CLASS);

    /**
     * Конструктор страницы досок.
     * Инициализирует страницу с валидационным XPath.
     */
    public BoardsPage() {
        super(BoardsPage.class, MAIN_CONTAINER_XPATH);
    }

    /**
     * Открывает меню дополнительных опций сортировки.
     */
    public void openSortingOptions() {
        moreOptionsButton.click();
    }

    /**
     * Выбирает сортировку досок по алфавиту.
     */
    public void sortAlphabetically() {
        alphabeticOrderButton.click();
    }

    /**
     * Выбирает сортировку досок по дате добавления (последние добавленные).
     */
    public void sortByLastAdded() {
        lastAddedOrderButton.click();
    }

    /**
     * Получает название первого превью доски в контейнере.
     *
     * @return название доски
     */
    public String getFirstBoardName() {
        return mansoryContainer.getPreviewName();
    }

}