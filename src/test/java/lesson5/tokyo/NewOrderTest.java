package lesson5.tokyo;
//логинимся, выбираем ролл из меню, добавляем в корзину и в нее переходим
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
public class NewOrderTest {
    private static final String LOGIN_PAGE_URL = "https://www.tokyo-city.ru/";
    private static final String STUDENT_LOGIN = "grvik5@mail.ru";
    private static final String STUDENT_PASSWORD = "Qwerty123456";
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
    @DisplayName("when login")
    class WhenLogin {

        @Test
        @Tag("TestOrder")
        void menuClick() throws InterruptedException {
            driver.get(LOGIN_PAGE_URL);
            //переход по меню и добавление в корзину
            driver.findElement(By.xpath("//header/div/nav/ul/li[2]/a")).click();
            sleep(5000);
            driver.findElement(By.xpath("//ul[4]/li/a")).click();
            driver.findElement(By.cssSelector(".item:nth-child(1) .btn")).click();
            sleep(5000);

            //войти в корзину
            WebElement cart= driver.findElement(By.xpath("//div[@id='wrapper__col']/header/div/div/a"));
            Actions builder2 = new Actions(driver);
            builder2
                    .moveToElement(cart)
                    .pause(5000)
                    .click(cart)
                    .pause(5000)
                    .build()
                    .perform();

            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
            driver.close();
        }

    }

    @Nested
    @DisplayName("login")
    class MenuClick {
        @Test
        @Tag("TestLogin")
        void login() {
            driver.get(LOGIN_PAGE_URL);
            driver.findElement(By.cssSelector(".user-block:nth-child(3) > .user-block__login")).click();

            WebElement loginTextInput = driver.findElement(By.xpath("//div[6]/div[2]/form/input"));
            loginTextInput.sendKeys(STUDENT_LOGIN);
            String user = loginTextInput.getAttribute("value");
            //сравниваем его с логином из файла настроек
            assertEquals(STUDENT_LOGIN, user);
            //assertEquals(STUDENT_LOGIN, "233444");

            WebElement passwordTextInput = driver.findElement(By.xpath("//input[@name='su_pass']"));
            passwordTextInput.sendKeys(STUDENT_PASSWORD);
            String password = passwordTextInput.getAttribute("value");
            assertEquals(STUDENT_PASSWORD, password);

            WebElement enter = driver.findElement(By.xpath("//form[@id='loginFrom']/input[3]"));
            Actions builder = new Actions(driver);
            builder
                    .click(enter) // кликаем
                    .build()
                    .perform();
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

        }

    }

}

