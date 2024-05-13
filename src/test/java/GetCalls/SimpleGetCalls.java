package GetCalls;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.Optional;

public class SimpleGetCalls {

    @Test
    public void GetCall(){
        String url = "https://dummy.restapiexample.com";

       Response response= RestAssured.given().baseUri(url).
                when().get("api/v1/employee/1").
                then().statusCode(200).and().
               contentType(ContentType.JSON).extract().response();

       String jsonResponse=response.asString();

        JsonPath responsebody=new JsonPath(jsonResponse);
        System.out.println(Optional.ofNullable(responsebody.get("status")));

    }
}
