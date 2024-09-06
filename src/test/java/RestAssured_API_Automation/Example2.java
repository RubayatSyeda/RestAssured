package RestAssured_API_Automation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Example2 {
    @Test
    public void test2() {
        get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data[1].id", equalTo(8))
                .body("data.first_name", hasItem("Lindsay")).
                log().all();

    }
}
