package selenidePOM;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    @Step("Открыть страницу Login")
    public LoginPage open() {
        Selenide.open("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
        return this;
    }

    @Step("Ввести имя")
    public LoginPage enterName(String name) {
        $(By.id("username")).sendKeys(name);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage enterPassword(String password) {
        $(By.id("password")).sendKeys(password);
        return this;
    }

    @Step("Отправить форму")
    public void submitForm() {
        $(By.xpath("//button[@type='submit']")).click();
    }

    public String successMessage() {
        return  $(By.id("success")).getText();
    }
}
