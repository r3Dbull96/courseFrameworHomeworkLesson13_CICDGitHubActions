package selenideTests;

import configs.TestConfig;
import org.junit.jupiter.api.Test;
import selenidePOM.LoginPage;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    @Test
    void loginTest() {
        LoginPage loginPage = new LoginPage().open();
        TestConfig config = new TestConfig();

        loginPage
                .enterName(config.getUsername())
                .enterPassword(config.getPassword())
                .submitForm();

        step("Проверка сообщения об успешном логине", () ->
        {
            assertEquals("Login successful", loginPage.successMessage());
        });
    }
}
