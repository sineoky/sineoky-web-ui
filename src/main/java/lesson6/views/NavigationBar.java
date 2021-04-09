package lesson6.views;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import lesson6.base.BaseView;
import lesson6.base.SubMenu;
import lesson6.enums.NavigationBarTabs;

public class NavigationBar extends BaseView {

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public SubMenu moveCursorToNavigationTab(NavigationBarTabs tab) {
        Actions actions = new Actions(driver);
        actions
            .moveToElement(driver.findElement(tab.getBy()))
            .build()
            .perform();
        switch (tab) {
            case COUNTER_PARTIES:
                return new ContactSubMenu(driver);
            case PROJECTS:
                return new ProjectSubMenu(driver);
            default:
                throw new IllegalArgumentException("Another tabs currently not implemented");
        }
    }

    public NavigationBar checkTabVisibility(NavigationBarTabs tab) {
        Assertions.assertTrue(driver.findElement(tab.getBy()).isDisplayed());
        return this;
    }
}
