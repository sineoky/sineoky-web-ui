package lesson6.features.testcases;
import lesson6.enums.ProjectSubMenuButtons;
import lesson6.pages.AllProjectsPage;
import org.junit.jupiter.api.Test;
import lesson6.base.BaseUITest;
import lesson6.common.Configuration;
import lesson6.enums.NavigationBarTabs;
import lesson6.pages.LoginPage;

//Задание 6 Синеокая Марина
public class NewProjectTest extends BaseUITest {
    @Test
    public void createNewProjectPositiveTest() throws InterruptedException {
        AllProjectsPage projectScreen = (AllProjectsPage)  new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.PROJECTS)
                .clickSubMenuButton(ProjectSubMenuButtons.MY_PROJECTS_REQUEST);

        projectScreen
                .clickOnCreateNewProjectButton()
                //.enterName("Test")
                //чтобы тест не падал, генерирую случайное имя
                .enterName(getRandomWord(5))
                .enterOrganization("123test")
                .enterContact("John Smith")
                .enterDept("Research & Development")
                .enterHead("Карпов Руслан")
                .enterBoss("Андреев Сергей")
                .enterAdmin("Исаева Анастасия")
                .enterManager("Антонов Дмитрий")
                .clickSubmit()
                .checkNewProjectPopUp();
    }

    //случайное имя
    String getRandomWord(int length) {
        String r = "";
        for(int i = 0; i < length; i++) {
            r += (char)(Math.random() * 26 + 97);
        }
        return r;
    }
}



