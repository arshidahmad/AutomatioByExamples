import com.jayway.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class RestAssuredPathParam {

    @Test
    public void pathParamTest()
    {
        String season = "2017";
        int numberOfRaces = 20;

        RestAssured.given().
                pathParam("raceSeason",season).
                when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().log().all().statusCode(200)
                .body("MRData.CircuitTable.Circuits.circuitId", Matchers.hasSize(numberOfRaces));

    }
}
