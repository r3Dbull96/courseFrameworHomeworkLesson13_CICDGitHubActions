package playwrightTests;

import configs.TestConfig;
import org.junit.jupiter.api.Test;
import playwrightPOM.LoginPage;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    void loginTest() {
        LoginPage loginPage = new LoginPage(page);
        TestConfig config = new TestConfig();


        loginPage
                .open()
                .enterName(config.getUsername())
                .enterPassword(config.getPassword())
                .submitForm();

        step("Проверка сообщения об успешном логине", () ->
        {
            assertEquals("Login successful", loginPage.successMessage());
        });
    }
}
