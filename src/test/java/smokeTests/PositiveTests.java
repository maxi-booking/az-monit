package smokeTests;

import config.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

public class PositiveTests extends TestBase {

    @Test
    @Feature("Main page")
    @Owner("Kratakey")
    @Story("Opening main page")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Main page can be opened and loaded")
    void openMainPage() {
        main.openMainPage(URL_PRODUCTION);
        src.verifySearchFormLoaded();
    }

    @Test
    @Feature("Search")
    @Owner("Kratakey")
    @Story("Finding search results")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Search results can be opened and displayed")
    void searchResultsCanBeLoaded() {
        main.openMainPage(URL_PRODUCTION);
        src.initializeTheSearch();
        src.confirmSearchResultsPageLoaded();
        src.confirmSearchResultsAreVisible();
    }

    @Test
    @Feature("Payment")
    @Owner("Kratakey")
    @Story("Visiting paying online page")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Pay online is loading")
    void payOnlineFormLoads() {
        main.openMainPage(URL_PRODUCTION);
        pay.clickPayOnline();
        pay.checkPayOnlinePage();
    }

    @Test
    @Feature("Payment")
    @Owner("Kratakey")
    @Story("Visiting paying online page")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Pay online is working")
    void payOnlineFormWorks() {
        main.openMainPage(URL_PRODUCTION);
        pay.clickPayOnline();
        pay.fillPayOnlineForm(data);
    }

    @Test
    @Feature("Search")
    @Owner("Kratakey")
    @Story("Starting room reservation process")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Can start reserving a room")
    void reserveARoomOpens() {
        main.openMainPage(URL_PRODUCTION);
        src.initializeTheSearch();
        src.clickReserveARoom(0);
        src.checkThatReservationPageIsOpened();
    }

    @Test
    @Tag("Impact")
    @Feature("Search")
    @Owner("Kratakey")
    @Story("Complete room reservation")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Reservation is working")
    void reserveARoomComplete() {
        main.openMainPage(URL_PRODUCTION);
        src.initializeTheSearch();
        src.clickReserveARoom(0);
        src.makeReservation(data);
        src.confirmReservation();
    }
}