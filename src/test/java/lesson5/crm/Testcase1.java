package lesson5.crm;
//Задание 3 Синеокая Марина
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Testcase1 {
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
    @DisplayName("when my login1")
    class MyLogin1 {
        @Test
        @Tag("TestMenuClick")
        void tCase1() throws InterruptedException {
            //mylogin();
            driver.get(MENU_PAGE_URL);
            driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[3]/a/span")).click();
            driver.findElement(By.xpath("//div[@id='main-menu']/ul/li[3]/ul/li[4]/a/span")).click();
            driver.findElement(By.xpath("//div[@id='container']/div/div/div/div[2]/div/div/a")).click();
            driver.findElement(By.name("crm_project[name]")).sendKeys("test");
            WebElement name=driver.findElement(By.name("crm_project[name]"));
            String name2 = name.getAttribute("value");
            assertEquals("test", name2);

            driver.findElement(By.xpath("//body")).click();
            driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]")).click();
            driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("123test");
            WebElement org1=driver.findElement(By.xpath("//div[@id='select2-drop']/div/input"));
            String org2 = org1.getAttribute("value");
            assertEquals("123test", org2);

            sleep(5000);
            driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
            sleep(5000);
            driver.findElement(By.xpath("//div[4]/div/div[2]/div/a")).click();
            sleep(5000);
            driver.findElement(By.xpath("//div[4]/div/div[2]/div/a")).sendKeys(Keys.ENTER);
            sleep(5000);

            driver.findElement(By.xpath("//div[5]/div[2]/div/select")).click();
            driver.findElement(By.xpath("//div[5]/div[2]/div/select")).sendKeys("Research & Development");
            driver.findElement(By.xpath("//div[5]/div[2]/div/select")).sendKeys(Keys.ENTER);
            WebElement dep=driver.findElement(By.xpath("//div[5]/div[2]/div/select"));
            String dep2 = dep.getText();
            //System.out.println("dept2"+dep2);
            Assertions.assertTrue(dep2.contains("Research & Development"));

            driver.findElement(By.xpath("//div[6]/div[2]/div/select")).click();
            //sleep(5000);
            driver.findElement(By.xpath("//div[6]/div[2]/div/select")).sendKeys("Карпов Руслан");
            driver.findElement(By.xpath("//div[6]/div[2]/div/select")).sendKeys(Keys.ENTER);
            WebElement name3=driver.findElement(By.xpath("//div[6]/div[2]/div/select"));
            String name4 = name3.getText();
            Assertions.assertTrue(name4.contains("Карпов Руслан"));

            driver.findElement(By.xpath("//div[7]/div[2]/div/select")).click();
            //sleep(5000);
            driver.findElement(By.xpath("//div[7]/div[2]/div/select")).sendKeys("Андреев Сергей");
            driver.findElement(By.xpath("//div[7]/div[2]/div/select")).sendKeys(Keys.ENTER);
            WebElement name5=driver.findElement(By.xpath("//div[7]/div[2]/div/select"));
            String name6 = name5.getText();
            Assertions.assertTrue(name6.contains("Андреев Сергей"));

            driver.findElement(By.xpath("//div[8]/div[2]/div/select")).click();
            driver.findElement(By.xpath("//div[8]/div[2]/div/select")).sendKeys("Исаева Анастасия");
            driver.findElement(By.xpath("//div[8]/div[2]/div/select")).sendKeys(Keys.ENTER);
            WebElement name7=driver.findElement(By.xpath("//div[8]/div[2]/div/select"));
            String name8 = name7.getText();
            //System.out.println("name8 "+name8);
            Assertions.assertTrue(name8.contains("Исаева Анастасия"));



            driver.findElement(By.xpath("//div[9]/div[2]/div/select")).click();
            driver.findElement(By.xpath("//div[9]/div[2]/div/select")).sendKeys("Антонов Дмитрий");
            WebElement name9=driver.findElement(By.xpath("//div[9]/div[2]/div/select"));
            driver.findElement(By.xpath("//div[9]/div[2]/div/select")).sendKeys(Keys.ENTER);
            String name10 = name9.getText();
            //System.out.println("name10 "+name10);
            Assertions.assertTrue(name10.contains("Антонов Дмитрий"));

            WebElement click1 = driver.findElement(By.xpath("//div[4]/button"));
            WebElement click2 = driver.findElement(By.xpath("//li/a"));
            WebElement click3 = driver.findElement(By.cssSelector("#user-menu > .dropdown-toggle"));

            //закрываем форму и выходим
            Actions builder1 = new Actions(driver);
            builder1
                    .click(click1) // кликаем
                    .pause(5000)
                    .click(click2)
                    .pause(5000)
                    .click(click3)
                    .build()
                    .perform();
            //ждем
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
            driver.close();
            driver.quit();

        }
    }

    @Nested
    @DisplayName("Mylogin1")
    class Mylogin {
        @Test
        @Tag("MyLogin1")
        void mylogin1() {
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