package adapters;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    static String BASE_URL = "https://api.qase.io/";

    public static void post(String body, String uri, int expectedStatusCode){
        given().
                header("Content-Type", "application/json").
                header("Token", "ff3acde1d3492edc0622524f4d47ae08c9d40cfa").
                body(body).
                when().
                post(BASE_URL + uri).
                then().
                log().all().
                statusCode(expectedStatusCode);
    }

    public static void delete(String code){
        given().
                header("Content-Type", "application/json").
                header("Token", "ff3acde1d3492edc0622524f4d47ae08c9d40cfa").
                when().
                delete(BASE_URL + code).
                then().
                log().all().
                statusCode(200);
    }

    public String get(String uri) {
        String body =
                given().
                        header("Content-Type", "application/json").
                        header("Token", "ff3acde1d3492edc0622524f4d47ae08c9d40cfa").
                        when().
                        get(BASE_URL + uri).
                        then().
                        log().all().
                        statusCode(200).
                        extract().body().asString();
        return body;
    }
}
