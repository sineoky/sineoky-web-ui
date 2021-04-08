package lesson6.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import lesson6.base.BaseView;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class NewProjectPage extends BaseView {

    @FindBy(name = "crm_project[name]")
    private WebElement nameProject;

    @FindBy(xpath = "//span[contains(.,'Укажите организацию')]")
    private WebElement orgNameSelect;
    @FindBy(xpath = "//div[@id='select2-drop']/div/input")
    private WebElement orgNameType;
    @FindBy(xpath = "//div[@id='select2-drop']/div/input")
    private WebElement orgNameSelectEnter;

    @FindBy(xpath = "//div[4]/div/div[2]/div/a")
    private WebElement mainContactSelect;
    @FindBy(xpath = "//div[@id='select2-drop']/div/input")
    private WebElement mainContactClick;


    @FindBy(xpath = "//div[5]/div[2]/div/select")
    private WebElement contactDropDown;

    @FindBy(xpath = "//div[6]/div[2]/div/select")
    private WebElement headProject;

    @FindBy(xpath = "//div[7]/div[2]/div/select")
    private WebElement bossProject;

    @FindBy(xpath = "//div[8]/div[2]/div/select")
    private WebElement adminProject;

    @FindBy(xpath = "//div[9]/div[2]/div/select")
    private WebElement managerProject;

    //@FindBy(xpath = "//div[4]/button")
    //@FindBy(xpath = "//body/div[7]")
    @FindBy(css = ".btn-group:nth-child(4) > .btn")
    private WebElement submitButton2;

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    public NewProjectPage enterName(String description) {
        nameProject.sendKeys(description);
        return this;
    }

    public NewProjectPage enterOrganization(String description) throws InterruptedException {
        orgNameSelect.click();
        orgNameType.sendKeys(description);
        sleep(5000);
        orgNameSelectEnter.sendKeys(Keys.ENTER);
        sleep(5000);
        return this;
    }

    public NewProjectPage enterContact(String description) throws InterruptedException {
        mainContactSelect.click();
        mainContactClick.sendKeys(description);
        sleep(5000);
        mainContactClick.sendKeys(Keys.ENTER);
        return this;
    }


    public NewProjectPage enterDept(String description) {
        contactDropDown.click();
        contactDropDown.sendKeys(description);
        contactDropDown.sendKeys(Keys.ENTER);
        return this;
    }

    public NewProjectPage enterHead(String description) {
        headProject.click();
        headProject.sendKeys(description);
        headProject.sendKeys(Keys.ENTER);
        return this;
    }


    public NewProjectPage enterBoss(String description) {
        bossProject.click();
        bossProject.sendKeys(description);
        bossProject.sendKeys(Keys.ENTER);
        return this;
    }

    public NewProjectPage enterAdmin(String description) {
        adminProject.click();
        adminProject.sendKeys(description);
        adminProject.sendKeys(Keys.ENTER);
        return this;
    }

    public NewProjectPage enterManager(String description) throws InterruptedException {
        managerProject.click();
        managerProject.sendKeys(description);
        managerProject.sendKeys(Keys.ENTER);
        return this;
    }

    public AllProjectsPage clickSubmit() throws InterruptedException{
        submitButton2.click();
        return new AllProjectsPage(driver);
    }


}




