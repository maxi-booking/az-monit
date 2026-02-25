package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import config.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.ScrollIntoViewOptions.Block.start;
import static com.codeborne.selenide.ScrollIntoViewOptions.instant;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Main extends TestBase {

    public void maximizeBrowserWindow() {
        if (!Configuration.headless) {
            WebDriverRunner.getWebDriver().manage().window().maximize();
        }
    }

    public void openMainPage(String url) {
        step("Open URL: " + url, () -> {
            open(url);
            maximizeBrowserWindow();
        });
    }
}