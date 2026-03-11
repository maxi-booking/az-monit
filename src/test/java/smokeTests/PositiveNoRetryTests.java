package smokeTests;

import annotations.NoRetry;
import config.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

@NoRetry
public class PositiveNoRetryTests extends TestBase {

    @Test
    @Feature("Search")
    @Owner("Kratakey")
    @Story("Checking if all the pictures are loaded")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("All the pictures are loaded")
    void checkSearchAllPics() {
        main.openPage(URL_FRONTEND);
        bkn.initializeTheSearch();
        src.confirmSearchResultsPageLoaded();
        src.confirmSearchResultsAreVisible();
        Map<Integer, Integer> imagesMap = src.scanImagesIntoLinkedHashMap();
        src.closeTheBanner();
        src.imageShouldBeLoaded(imagesMap);
    }
}