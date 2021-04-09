package lesson6.enums;
import lesson6.base.SubMenuButtons;
import org.openqa.selenium.By;
public enum ProjectSubMenuButtons implements SubMenuButtons {
    MY_PROJECTS_REQUEST(".//span[@class='title' and text()='Мои проекты']");

    private final By by;

    ProjectSubMenuButtons(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}

