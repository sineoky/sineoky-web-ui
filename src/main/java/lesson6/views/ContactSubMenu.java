package lesson6.views;
import lesson6.enums.ContactSubMenuButtons;
import lesson6.pages.AllContactsPage;
import org.openqa.selenium.WebDriver;
import lesson6.base.BaseView;
import lesson6.base.SubMenu;
import lesson6.base.SubMenuButtons;

public class ContactSubMenu extends SubMenu{
    public ContactSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ContactSubMenuButtons) {
            switch ((ContactSubMenuButtons) buttons) {
                case CONTACTS_REQUEST:
                driver.findElement(((ContactSubMenuButtons) buttons).getBy()).click();
                return new AllContactsPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}

