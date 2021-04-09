package lesson6.enums;

import lesson6.base.SubMenuButtons;
import org.openqa.selenium.By;

public enum ContactSubMenuButtons implements SubMenuButtons {
    CONTACTS_REQUEST(".//span[@class='title' and text()='Контактные лица']");

    private final By by;

    ContactSubMenuButtons(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}

