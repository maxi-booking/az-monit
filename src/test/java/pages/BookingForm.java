package pages;

import config.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class BookingForm extends TestBase {

    public void verifyBookingFormLoaded() {
        step("Check that the form is loaded correctly with all the necessary elements", () -> {
            $("#search-form").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#search-form label[for='search_form_hotel']").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#search-form #search_form_begin").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#search-form #search_form_end").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#search-form label[for='search_form_adults']").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#search-form label[for='search_form_children']").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#search-form #search_form_showSpecs").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#search-form .booking-submit").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#search-form .pay-online").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
        });
    }

    public void initializeTheSearch() {
        step("Press 'Search' button", () -> {
           $("#search-form .booking-submit input[type='submit']").click();
        });
    }
}