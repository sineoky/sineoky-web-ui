package lesson6.features.testcases;
import lesson6.enums.ContactSubMenuButtons;
import lesson6.pages.AllContactsPage;
import org.junit.jupiter.api.Test;
import lesson6.base.BaseUITest;
import lesson6.common.Configuration;
import lesson6.enums.NavigationBarTabs;
import lesson6.pages.LoginPage;
//Задание 6 Синеокая Марина
public class NewContactTest extends BaseUITest {

    @Test
    public void createNewContactPositiveTest() throws InterruptedException {
        AllContactsPage contactScreen = (AllContactsPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.COUNTER_PARTIES)
                .clickSubMenuButton(ContactSubMenuButtons.CONTACTS_REQUEST);

        contactScreen
                .clickOnCreateNewContactButton()
                .enterLastName("Иванов")
                .enterFirstName("Иван")
                .selectExpenditure("1234")
                .enterPosition("инженер")
                .clickSubmit()
                .checkNewContactPop();
    }

}


