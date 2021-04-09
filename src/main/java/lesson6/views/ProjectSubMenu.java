package lesson6.views;
import lesson6.enums.ProjectSubMenuButtons;
import lesson6.pages.AllProjectsPage;
import org.openqa.selenium.WebDriver;
import lesson6.base.BaseView;
import lesson6.base.SubMenu;
import lesson6.base.SubMenuButtons;

public class ProjectSubMenu extends SubMenu{
    public ProjectSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ProjectSubMenuButtons) {
            switch ((ProjectSubMenuButtons) buttons) {
                case MY_PROJECTS_REQUEST:
                    driver.findElement(((ProjectSubMenuButtons) buttons).getBy()).click();
                    return new AllProjectsPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}

