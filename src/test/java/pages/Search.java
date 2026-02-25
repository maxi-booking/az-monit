package pages;

import config.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.ScrollIntoViewOptions.Block.start;
import static com.codeborne.selenide.ScrollIntoViewOptions.instant;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Search extends TestBase {

    public void verifySearchFormLoaded() {
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

    public void confirmSearchResultsPageLoaded() {
        step("Search result page is opened", () -> {
            $(".body-mbresults").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#search-form").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
        });
    }

    public void confirmSearchResultsAreVisible() {
        step("Search result are visible", () -> {
            $("#online-booking-search").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION)).scrollIntoView(instant().block(start));
            $("section.s_results").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
        });
    }

    public void clickReserveARoom(int order) {
        step("Click to reserve a room", () -> {
            $$("#online-booking-search section.s_results").get(order).scrollIntoView(instant().block(start)).
                    $(".btns-container .btn-booking-reservation").click();
        });
    }

    public void checkThatReservationPageIsOpened() {
        step("Reservation page opens", () -> {
            $("#sign-page #form").scrollIntoView(instant().block(start)).shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#sign-page #form #form_firstName").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#sign-page #form #form_lastName").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#sign-page #form #form_phone").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#sign-page #form #form_email").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#sign-page #form #form_accept").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#sign-page #form #form_cash").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#sign-page div.submit button.bkbutton").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
        });
    }

    public void makeReservation(Data data) {
        step("Complete reservation with data", step -> {
            step.parameter("First name", data.firstName);
            step.parameter("Last name", data.lastName);
            step.parameter("Phone number", data.phoneNumber);
            step.parameter("Email", data.email);
            $("#sign-page #form").scrollIntoView(instant().block(start)).shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#sign-page #form #form_firstName").setValue(data.firstName);
            $("#sign-page #form #form_lastName").setValue(data.lastName);
            $("#sign-page #form #form_phone").setValue(data.phoneNumber);
            $("#sign-page #form #form_email").setValue(data.email);
            $("#sign-page #form #form_accept").click();
            $("#sign-page div.submit button.bkbutton").click();
        });
    }

    public void confirmReservation() {
        step("Complete reservation with data", () -> {
            $("#sign-page #form").shouldNotBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $$("article div.maxi[itemprop='articleBody'] p").get(54).shouldHave(exactText(" Спасибо, что Вы выбрали нас!"));
            $$("div.maxi[itemprop='articleBody'] p").get(55).shouldHave(exactText("В скором времени с Вами свяжутся наши менеджеры."));
        });
    }
}