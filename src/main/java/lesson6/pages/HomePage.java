package lesson6.pages;

import org.openqa.selenium.WebDriver;
import lesson6.base.BaseView;
import lesson6.views.NavigationBar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage extends BaseView {

    private NavigationBar navigationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    public void checkUrl(String url) {
        assertEquals(driver.getCurrentUrl(), url);
    }

    public NavigationBar getPageNavigation() {
        return navigationBar;
    }
}
