package playwrightPOM;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LoginPage {
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    @Step("Открыть страницу Login")
    public LoginPage open() {
        page.navigate("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
        return this;
    }

    @Step("Ввести имя {0}")
    public LoginPage enterName(String name) {
        page.locator("#username").fill(name);
        return this;
    }

    @Step("Ввести пароль {0}")
    public LoginPage enterPassword(String password) {
        page.locator("#password").fill(password);
        return this;
    }

    @Step("Отправить форму")
    public void submitForm() {
        page.locator("button").click();
    }

    public String successMessage() {
        return  page.locator("#success").innerText();
    }

}
