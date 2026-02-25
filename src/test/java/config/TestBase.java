package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.Main;
import pages.Payment;
import pages.Search;


import static io.qameta.allure.Allure.step;

public class TestBase extends TestData {

    private static final WebDriverConfig config =
            ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static final String
            URL_PRODUCTION = "https://azovsky.ru/";

    public static Main main = new Main();
    public static Search src = new Search();
    public static Payment pay = new Payment();

    @BeforeAll
    public static void init() {
        Configuration.browser = config.getBrowserName();
        if (!config.getBrowserVersion().isEmpty()) {
            Configuration.browserVersion = config.getBrowserVersion();
        }
        if (!config.getRemote().isEmpty()) {
            Configuration.remote = config.getRemote();
        }
        Configuration.browserSize = config.getBrowserSize();
        Configuration.timeout = config.getTimeout();
        Configuration.headless = config.getHeadless();
    }

    @BeforeEach
    public void setupConfig() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        setRandomData();
    }

    @AfterEach
    public void tearDown() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            step("Close web driver", Selenide::closeWebDriver);
        }
    }
}