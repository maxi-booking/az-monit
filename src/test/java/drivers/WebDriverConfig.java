package drivers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:config/${environment}.properties",
        "classpath:config/local_chrome.properties"
})
public interface WebDriverConfig extends Config {

    @Config.Key("threads")
    @Config.DefaultValue("8")
    int getThreads();

    @Config.Key("browserName")
    @Config.DefaultValue("chrome")
    String getBrowserName();

    @Config.Key("browserVersion")
    @Config.DefaultValue("")
    String getBrowserVersion();

    @Config.Key("browserSize")
    @Config.DefaultValue("1920x1080")
    String getBrowserSize();

    @Config.Key("headless")
    @Config.DefaultValue("false")
    Boolean getHeadless();

    @Config.Key("timeout")
    @Config.DefaultValue("10000")
    long getTimeout();

    @Config.Key("remote")
    String getRemote();

    @Config.Key("browser")
    @Config.DefaultValue("all")
    Boolean getBrowser();
}