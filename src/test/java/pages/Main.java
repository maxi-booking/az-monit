package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import config.TestBase;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Main extends TestBase {

    public void maximizeBrowserWindow() {
        if (!Configuration.headless) {
            WebDriverRunner.getWebDriver().manage().window().maximize();
        }
    }

    public void openPage(String url) {
        step("Open URL: " + url, () -> {
            open(url);
            maximizeBrowserWindow();
        });
    }
}