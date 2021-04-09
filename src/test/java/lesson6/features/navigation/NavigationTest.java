package lesson6.features.navigation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import lesson6.base.BaseUITest;
import lesson6.common.Configuration;
import lesson6.enums.NavigationBarTabs;
import lesson6.pages.LoginPage;

public class NavigationTest extends BaseUITest  {

    @ParameterizedTest
    @MethodSource("navigationTabProvider")
    public void checkMainNavigationTabsTest(NavigationBarTabs barTab) {
        new LoginPage(driver)
            .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
            .getPageNavigation()
            .checkTabVisibility(barTab);

    }

    static NavigationBarTabs[] navigationTabProvider() {
        return NavigationBarTabs.values();
    }

}
