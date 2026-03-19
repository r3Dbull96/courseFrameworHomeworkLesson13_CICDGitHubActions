package selenideTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    @BeforeEach
    void setUp() {
        String remoteUrl = System.getenv("SELENIUM_REMOTE_URL");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;

        if (remoteUrl != null && !remoteUrl.isBlank()) {
            Configuration.remote = remoteUrl;
        }
    }
}
