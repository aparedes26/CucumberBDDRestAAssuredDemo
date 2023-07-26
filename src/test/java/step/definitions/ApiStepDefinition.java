package step.definitions;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.junit.Assert;

import java.io.File;
import java.net.URI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;


public class ApiStepDefinition {

    private Scenario scenario;
    private Response response;
    private final String BASE_URL = "https://restful-booker.herokuapp.com/";
    private String requestBody;
    private static RequestSpecification request;
    @Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
    }

    @Given("hago una solicitud GET a la API {string}")
    public void get_call_to_url(String url) throws Exception {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification req = given();
        response = req.when().get(new URI(url));
    }

    @Then("la respuesta debe tener codigo de estado {string}")
    public void response_is_validated(String responseMessage) {
        int responseCode = response.then().extract().statusCode();
        Assert.assertEquals(responseMessage, responseCode+"");
    }

    @Then("Response  is array total {string}")
    public void responseIsArrayWith(String arg0) {
        response.then().statusCode(200);
        response = response.then().extract().response();
        scenario.log("Response Received == " + response.asPrettyString());
        JSONArray resJson = new JSONArray(response.asString());
        Assert.assertEquals(resJson.length()+"",arg0);


    }

    @Then("el atributo firstname en el JSON response debe ser Susan {string}")
    public void responseBookingIs(String arg0) {
      String firstname = response.then().extract().path("firstname");
      Assert.assertEquals(firstname, arg0);
    }

    @And("el cuerpo de la solicitud es:")
    public void elCuerpoDeLaSolicitudEs(String requestBody) {
        this.requestBody = requestBody;
    }


    @Given("hago una solicitud POST a la API {string}")
    public void hagoUnaSolicitudPOSTALaAPI(String url) {
        RestAssured.baseURI = BASE_URL;
        request = given()
                .contentType(ContentType.JSON).baseUri(url)
                .log().all();
    }

    @When("envio una solicitud POST y valido el body (.+) endpoint$")
    public void envioUnaSolicitudPOSTYValidoElBodyAuth(String endpoint) {
        File requestBody = new File("src/test/resources/json/Auth.json");
        response = request.when().body(requestBody).post(endpoint).prettyPeek();
    }

    @Given("hago una solicitud POST a la API (.+) URI$") // (.+) EXPRESION REGULAR ES UN STRING
    public void hagoUnaSolicitudPOSTALaAPIHttpsRestfulBookerHerokuappComURI(String URI) {
        request = given()
                .contentType(ContentType.JSON).baseUri(URI)
                .log().all();
    }

    @Then("el atributo {string} está presente en el JSON response")
    public void validoElTokenEnElResponse(String attribute) {
        response.then().assertThat().body(Matchers.hasKey(attribute));
    }

    @When("envio una solicitud PATCH y valido el body (.+) endpoint$")
    public void envioUnaSolicitudPATCHYValidoElBodyAuthEndpoint(String endpoint) {
        File requestBody = new File("src/test/resources/json/BookingPartialUpdateBooking.json");
        response = request.when().body(requestBody).patch(endpoint).prettyPeek();
    }

    @Given("hago una solicitud PATCH a la API (.+) URI$")
    public void hagoUnaSolicitudPATCHALaAPIHttpsRestfulBookerHerokuappComURI(String URI) {
        request = given().header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON)
                .baseUri(URI)
                .log().all();
    }

    @Given("hago una solicitud PUT a la API (.+) URI$")
    public void hagoUnaSolicitudPUTALaAPIHttpsRestfulBookerHerokuappComURI(String URI) {
        request = given().header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON)
                .baseUri(URI)
                .log().all();
    }

    @When("envio una solicitud PUT y valido el body (.+) endpoint$")
    public void envioUnaSolicitudPUTYValidoElBodyBookingEndpoint(String endpoint) {
        File requestBody = new File("src/test/resources/json/BookingUpdateBooking.json");
        response = request.when().body(requestBody).put(endpoint).prettyPeek();
    }

    @Given("hago una solicitud DELETE a la API (.+) URI$")
    public void hagoUnaSolicitudDELETEALaAPIHttpsRestfulBookerHerokuappComURI(String URI) {
        request = given().header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON)
                .baseUri(URI)
                .log().all();
    }

    @When("envio una solicitud DELETE y valido el body (.+) endpoint$")
    public void envioUnaSolicitudDELETEYValidoElBodyBookingEndpoint(String endpoint) {
        response = request.when().delete(endpoint).prettyPeek();
    }
}

