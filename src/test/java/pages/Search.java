package pages;

import config.TestBase;
import helpers.Attach;
import org.assertj.core.api.SoftAssertions;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.ScrollIntoViewOptions.Block.start;
import static com.codeborne.selenide.ScrollIntoViewOptions.instant;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Search extends TestBase {
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

    public void imageShouldBeLoaded(int cardIndex, int imageIndex) {
        step("Check that image in the card number " + cardIndex + " with index-" + imageIndex + " is loaded", () -> {
            $$("#online-booking-search .s_results").get(cardIndex).$$(".imghotel img").get(imageIndex).shouldBe(image);
        });
    }

    public void imageShouldBeLoaded(Map<Integer, Integer> imagesMap) {
        int totalCards = imagesMap.size();
        int totalImages = imagesMap.values().stream().mapToInt(Integer::intValue).sum();
        step("Check that images on the whole page are loaded. Map size: total cards - " + totalCards + ", total images - " + totalImages, () -> {
            SoftAssertions assertion = new SoftAssertions();
            imagesMap.forEach((cardIndex, imageCount) -> {
                for (int imageIndex = 0; imageIndex < imageCount; imageIndex++){
                    var card = $$("#online-booking-search .s_results").get(cardIndex);
                    var img = card.$$(".imghotel img").get(imageIndex);

                    //attach image if failed
                    if (!img.is(image)) {
                        img.scrollTo();
                        for (int click = 0; click < imageIndex; click++) {
                            card.$(".imghotel .jssright").click();
                        }
                        Attach.screenshotAs("card[%d] img[%d] src=%s"
                                .formatted(cardIndex, imageIndex, img.getAttribute("src")));
                    }

                    assertion.assertThat(img.is(image))
                            .as("card[%d] img[%d] %s".formatted(cardIndex, imageIndex, img.getAttribute("src")))
                            .isTrue();
                }
            });
            assertion.assertAll();
        });
    }

    public Map<Integer, Integer> scanImagesIntoLinkedHashMap() {
        Map<Integer, Integer> results = new LinkedHashMap<>();
        var cards = $$("#online-booking-search .s_results");
        for (int i = 0; i < cards.size(); i++) {
            int imageCount = cards.get(i).$$(".imghotel img").size();
            if (imageCount > 0) {
                results.put(i, imageCount);
            }
        }
        return results;
    }
}