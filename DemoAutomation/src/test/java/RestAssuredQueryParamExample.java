import com.jayway.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class RestAssuredQueryParamExample {

    @Test
    public void restExample()
    {
        RestAssured.given()
                .baseUri("https://reqres.in/api/users")
                .param("page","2")
                // When
                .when()
                .get()
                // Then
                .then().log().all()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("data.first_name[0]" , Matchers.equalToIgnoringCase("Michael"))
                  ;
    }
}
