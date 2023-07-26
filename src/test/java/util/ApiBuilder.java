package util;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
// La clase ApiBuilder tiene métodos para configurar la URL base de la API, el método HTTP que se utilizará (GET, POST, etc.) y el cuerpo de la solicitud (en caso de ser necesario). También tiene un método sendRequest() que enviará la solicitud API y devolverá el objeto Response de RestAssured.
public class ApiBuilder {
    private String apiUrl;
    private String method;
    private String body;

    public ApiBuilder withBaseUrl(String baseUrl) {
        this.apiUrl = baseUrl;
        return this;
    }

    public ApiBuilder withMethod(String method) {
        this.method = method;
        return this;
    }

    public ApiBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public Response sendRequest() {
        Response response;

        switch (method.toUpperCase()) {
            case "GET":
                response = given()
                        .get(apiUrl);
                break;
            case "POST":
                response = given()
                        .header("Content-Type", "application/json")
                        .body(body)
                        .post(apiUrl);
                break;
            // Agregar casos para otros métodos HTTP si es necesario (PUT, DELETE, etc.)
            default:
                throw new IllegalArgumentException("Método HTTP no válido: " + method);
        }

        return response;
    }
}
