package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;


public class HerokuBaseApi {

    protected RequestSpecification specHeroku;

    @BeforeMethod
    public void setUp() {
        specHeroku =new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .addHeader("Accept","application/json")
                .setBaseUri("https://restful-booker.herokuapp.com/").build();
    }


}
