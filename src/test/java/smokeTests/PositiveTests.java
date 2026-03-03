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
    void mainPageCanBeOpenedAndLoaded() {
        main.openPage(URL_BOOKING_FORM);
        bkn.verifyBookingFormLoaded();
    }

    @Test
    @Feature("Booking form")
    @Owner("Kratakey")
    @Story("Opening booking form")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Booking form is loaded")
    void openBookingForm() {
        main.openPage(URL_BOOKING_FORM);
        bkn.verifyBookingFormLoaded();
    }

    @Test
    @Feature("Search")
    @Owner("Kratakey")
    @Story("Finding search results")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Search results can be opened and displayed")
    void searchResultsCanBeLoaded() {
        main.openPage(URL_FRONTEND);
        bkn.initializeTheSearch();
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
        main.openPage(URL_FRONTEND);
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
        main.openPage(URL_FRONTEND);
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
        main.openPage(URL_FRONTEND);
        bkn.initializeTheSearch();
        src.clickReserveARoom(0);
        src.checkThatReservationPageIsOpened();
    }

    @Test
    @Disabled
    @Tag("Impact")
    @Feature("Search")
    @Owner("Kratakey")
    @Story("Complete room reservation")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Reservation is working")
    void reserveARoomComplete() {
        main.openPage(URL_FRONTEND);
        bkn.initializeTheSearch();
        src.clickReserveARoom(0);
        src.makeReservation(data);
        src.confirmReservation();
    }

    @Test
    @Feature("Search")
    @Owner("Kratakey")
    @Story("Checking if the first picture is loaded")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("1st picture of the 1st card is loaded")
    void checkSearchFirstPic() {
        main.openPage(URL_FRONTEND);
        bkn.initializeTheSearch();
        src.imageShouldBeLoaded(0, 0);
    }
}