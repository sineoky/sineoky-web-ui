package lesson6.features.login;

import org.junit.jupiter.api.Test;
import lesson6.base.BaseUITest;
import lesson6.pages.LoginPage;

import static lesson6.common.Configuration.BASE_URL;
import static lesson6.common.Configuration.STUDENT_LOGIN;
import static lesson6.common.Configuration.STUDENT_PASSWORD;

public class PositiveLoginTest extends BaseUITest {

    @Test
    public void loginWithBaseUserTest() {
        new LoginPage(driver)
            .enterLogin(STUDENT_LOGIN)
            .enterPassword(STUDENT_PASSWORD)
            .clickLoginButton()
            .checkUrl(BASE_URL);
    }
}
