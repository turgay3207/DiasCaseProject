package hooks;

import baseUrl.HerokuBaseApi;
import io.cucumber.java.Before;


public class Hooks {

    @Before
    public  void setUp() {
        HerokuBaseApi.setUp();
    }

}
