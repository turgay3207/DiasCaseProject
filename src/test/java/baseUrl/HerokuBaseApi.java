package baseUrl;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class HerokuBaseApi {

    public static RequestSpecification spec;


    public static  void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com/").
               setContentType(ContentType.JSON).
                build();
    }




}
