package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    public static Response performPost(String endpoint, String requestPayload, Map<String, String>header){



    return RestAssured.given().log().all().baseUri(endpoint).
            headers(header).
                contentType(ContentType.JSON).
                body(requestPayload).
                when().post().
                then().log().all().extract().response();

    }
}
