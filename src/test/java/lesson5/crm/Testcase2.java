package lesson5.crm;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testcase2 {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String MENU_PAGE_URL = "https://crm.geekbrains.space";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static final WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Nested
    @DisplayName("when my login2")
    class MyLogin2 {
        @Test
        @Tag("TestMenuClick2")
        void tCase2() throws InterruptedException {
            //login();
            driver.get(MENU_PAGE_URL);
            driver.findElement(By.xpath("//span[contains(.,'Контрагенты')]")).click();
            driver.findElement(By.xpath("//span[contains(.,'Контактные лица')]")).click();
            driver.findElement(By.xpath("//div[@id='container']/div/div/div/div[2]/div/div/a")).click();
            driver.findElement(By.xpath("//div/div/div[2]/input")).click();
            driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Иванов");
            WebElement fio=driver.findElement(By.name("crm_contact[lastName]"));
            String name = fio.getAttribute("value");
            //сравниваем его с логином из файла настроек
            assertEquals("Иванов", name);

            driver.findElement(By.xpath("//div[2]/div[2]/input")).click();
            driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Иван");
            WebElement firstname=driver.findElement(By.name("crm_contact[firstName]"));
            String name1=firstname.getAttribute("value");
            assertEquals("Иван", name1);
            driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]")).click();

            driver.findElement(By.cssSelector(".select2-input")).sendKeys("1234");
            WebElement org= driver.findElement(By.cssSelector(".select2-input"));
            String org1=org.getAttribute("value");
            assertEquals("1234", org1);

            sleep(5000);
            driver.findElement(By.cssSelector(".select2-input")).sendKeys(Keys.ENTER);
            driver.findElement(By.xpath("//div[2]/div[2]/div[2]/input")).click();
            driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("инженер");
            WebElement prof=driver.findElement(By.name("crm_contact[jobTitle]"));
            String prof1= prof.getAttribute("value");
            assertEquals("инженер", prof1);

            WebElement click1 = driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn"));
            WebElement click2 = driver.findElement(By.cssSelector("#user-menu > .dropdown-toggle"));
            //WebElement click3 = driver.findElement(By.cssSelector("#.last > .no-hash"));
            //закрываем форму и выходим
            Actions builder2 = new Actions(driver);
            builder2
                    .click(click1) // кликаем
                    .pause(5000)
                    .click(click2)
                    .pause(5000)
                    .build()
                    .perform();

            driver.findElement(By.cssSelector(".last > .no-hash")).click();

            //ждем
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
            driver.close();
            driver.quit();

        }
    }

    @Nested
    @DisplayName("Mylogin2")
    class Mylogin {
        @Test
        @Tag("MyLogin2")
        void mylogin2() {
        driver.get(LOGIN_PAGE_URL);

        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);
            String user = loginTextInput.getAttribute("value");
            //сравниваем его с логином из файла настроек
            assertEquals(STUDENT_LOGIN, user);


        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);
            String password = passwordTextInput.getAttribute("value");
            assertEquals(STUDENT_PASSWORD, password);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();
    }
}
}