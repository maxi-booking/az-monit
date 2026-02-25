package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import config.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.ScrollIntoViewOptions.Block.start;
import static com.codeborne.selenide.ScrollIntoViewOptions.instant;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Payment extends TestBase {

    public void clickPayOnline() {
        step("Press 'Pay Online' button", () -> {
            $("#search-form .pay-online a").click();
            switchTo().window(1);
        });
    }

    public void checkPayOnlinePage() {
        step("'Pay Online' page is fully loaded", () -> {
            $(".OplataUslug").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            switchTo().frame($("#mbh-payment-form-wrapper-iframe"));
            $("div[id='mbh_bundle_onlinebundle_order_search_type']").scrollIntoView(instant().block(start)).shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#mbh_bundle_onlinebundle_order_search_type_paymentType").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#mbh_bundle_onlinebundle_order_search_type_paymentType #mbh_bundle_onlinebundle_order_search_type_paymentType_0").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#mbh_bundle_onlinebundle_order_search_type_paymentType #mbh_bundle_onlinebundle_order_search_type_paymentType_1").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#mbh_bundle_onlinebundle_order_search_type_numberOrder").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#mbh_bundle_onlinebundle_order_search_type_phoneOrEmail").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#mbh_bundle_onlinebundle_order_search_type_findOrder").shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            switchTo().defaultContent();
        });
    }

    public void fillPayOnlineForm(Data data) {
        step("'Pay Online' form negative functionality test", step -> {
            step.parameter("Payment type", data.paymentType);
            step.parameter("Order number", data.orderNumber);
            step.parameter(data.phoneOrEmail ? "Phone number" : "Email", data.phoneOrEmail ? data.phoneNumber : data.email);
            switchTo().frame($("#mbh-payment-form-wrapper-iframe"));
            $("div[id='mbh_bundle_onlinebundle_order_search_type']").scrollIntoView(instant().block(start)).shouldBe(visible, Duration.ofSeconds(MAX_WAIT_DURATION));
            $("#mbh_bundle_onlinebundle_order_search_type_findOrder").click();
            $$("#mbh_bundle_onlinebundle_order_search_type_paymentType input").get(data.paymentType).click();
            $("#mbh_bundle_onlinebundle_order_search_type_numberOrder").setValue(data.orderNumber);
            $("#mbh_bundle_onlinebundle_order_search_type_phoneOrEmail").setValue(
                    data.phoneOrEmail ? data.phoneNumber : data.email
            );
            $("#mbh_bundle_onlinebundle_order_search_type_findOrder").click();
            $("#result-search div").shouldHave(cssClass("bg-danger"));
            switchTo().defaultContent();
        });
    }
}