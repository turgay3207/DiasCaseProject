package stepdefinitions;

import baseUrl.HerokuBaseApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HerokuStepDefinition extends HerokuBaseApi {


    @Test
    public void Tc01(){
        specHeroku.pathParams("first","booking","second",5);
        Response response=given(specHeroku).get("{first}/{second}");
        response.prettyPrint();

        response.then().statusCode(200).contentType("application/json;  charset=utf-8");
    }


}
