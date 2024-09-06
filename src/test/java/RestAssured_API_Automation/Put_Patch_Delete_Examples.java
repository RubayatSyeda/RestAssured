package RestAssured_API_Automation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Put_Patch_Delete_Examples {
    @Test
    public void testPut() {
        JSONObject request = new JSONObject();
        request.put("name", "Syeda Rubayat");
        request.put("job", "QA Tester");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api/";
        given()
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .put("users/2")
                .then()
                .statusCode(200)
                .body("name", equalTo("Syeda Rubayat"))
                .body("job", equalTo("QA Tester"));
    }

    @Test
    public void testPatch() {
        JSONObject request = new JSONObject();
        request.put("name", "Syeda Rubayat");
        request.put("job", "QA Tester");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api/";
        given()
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .patch("users/2")
                .then()
                .statusCode(200)
                .body("name", equalTo("Syeda Rubayat"))
                .body("job", equalTo("QA Tester"));
    }

    @Test
    public void testDelete() {
        baseURI = "https://reqres.in/api/";
        given()
                .when()
                .delete("users/2")
                .then()
                .statusCode(204);
    }
}
