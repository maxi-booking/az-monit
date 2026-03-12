package smokeTests;

import annotations.RetryWithDelay;
import config.TestBase;
import extensions.RetryDelayExtension;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static api.SearchResults.*;

@ExtendWith(RetryDelayExtension.class)
@RetryWithDelay()
public class PositiveAPITests extends TestBase {

    @Test
    @Feature("API")
    @Owner("Kratakey")
    @Story("Checking that server returns 200 OK")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Backend is working")
    void checkBackend200OK() {
        checkBackendSearch(data);
    }

    @Test
    @Feature("API")
    @Owner("Kratakey")
    @Story("Checking that server returns a correct HTML page")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Search results via API")
    void getHTMLWithSearchResults() {
        String url = getURLBackendSearch(data);
        System.out.println(url);
        main.openPage(url);
        src.confirmSearchResultsAreVisible();
    }
}
