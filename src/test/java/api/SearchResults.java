package api;

import config.TestBase;

import static io.restassured.RestAssured.given;

public class SearchResults extends TestBase {

    public static void checkBackendSearch(Data data) {

        StringBuilder body = new StringBuilder("https://az.maxibooking.ru/online_booking/?");
        body
                .append("search_form[hotel]=").append(data.hotel)
                .append("&search_form[begin]=").append(data.startDate)
                .append("&search_form[end]=").append(data.endDate)
                .append("&search_form[adults]=").append(data.adults)
                .append("&search_form[children]=").append(data.children);
        if (data.children > 0) {
            int i = 0;
            while (i < data.children) {
                body.append("&search_form[children_age][").append(i + 1).append("]=").append(data.ages[i]);
                i++;
            }
        }
        if (data.showSpecs > 0) {
            body.append("&search_form[showSpecs]=").append(data.showSpecs);
        }
        body
                .append("&submit=").append(data.submit);

        given()
                .when()
                .get(body.toString())
                .then()
                .statusCode(200);
    }

    public static String getURLBackendSearch(Data data) {

        StringBuilder body = new StringBuilder("https://az.maxibooking.ru/online_booking/?");
        body
                .append("search_form[hotel]=").append(data.hotel)
                .append("&search_form[begin]=").append(data.startDate)
                .append("&search_form[end]=").append(data.endDate)
                .append("&search_form[adults]=").append(data.adults)
                .append("&search_form[children]=").append(data.children);
        if (data.children > 0) {
            int i = 0;
            while (i < data.children) {
                body.append("&search_form[children_age][").append(i + 1).append("]=").append(data.ages[i]);
                i++;
            }
        }
        if (data.showSpecs > 0) {
            body.append("&search_form[showSpecs]=").append(data.showSpecs);
        }
        body
                .append("&submit=").append(data.submit);

        given()
                .when()
                .get(body.toString())
                .then()
                .statusCode(200);

        return body.toString();
    }
}