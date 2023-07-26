Feature: Booking - PartialUpdateBooking

  Scenario Outline: Validar codigo de estado 200 OK
    Given hago una solicitud PATCH a la API <url> URI
    When envio una solicitud PATCH y valido el body <patch> endpoint
    Then la respuesta debe tener codigo de estado "<responseMessage>"

    Examples:
      | url                                  | patch      | responseMessage |
      | https://restful-booker.herokuapp.com | /booking/1 | 200             |


  Scenario Outline: Validar codigo de estado 404 cuando se envia id en el patch variable nulo
    Given hago una solicitud PATCH a la API <url> URI
    When envio una solicitud PATCH y valido el body <patch> endpoint
    Then la respuesta debe tener codigo de estado "<responseMessage>"

    Examples:
      | url                                  | patch     | responseMessage |
      | https://restful-booker.herokuapp.com | /booking/ | 404             |


  Scenario Outline: Validar la existencia de un atributo específico en la respuesta JSON
    Given hago una solicitud PATCH a la API <url> URI
    When envio una solicitud PATCH y valido el body <patch> endpoint
    Then la respuesta debe tener codigo de estado "<responseMessage>"
    Then el atributo "<atributoresponse>" esta presente en la respuesta JSON

    Examples:
      | url                                  | patch      | responseMessage | atributoresponse |
      | https://restful-booker.herokuapp.com | /booking/1 | 200             | firstname        |
      | https://restful-booker.herokuapp.com | /booking/1 | 200             | lastname         |
      | https://restful-booker.herokuapp.com | /booking/1 | 200             | totalprice       |
      | https://restful-booker.herokuapp.com | /booking/1 | 200             | depositpaid      |




