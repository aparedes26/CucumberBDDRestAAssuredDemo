@postexample
Feature: API Booking - GetBooking

  Scenario Outline: Validar codigo de estado 200 OK
    Given hago una solicitud GET a la API "<url>"
    Then la respuesta debe tener codigo de estado "<responseMessage>"

    Examples:
      | url        | responseMessage  |
      | booking/2  | 200              |


  Scenario Outline: Validar que en el response del api GetBooking se visualice el atributo firstname
    Given hago una solicitud GET a la API "<url>"
    Then la respuesta debe tener codigo de estado "<responseMessage>"
    Then el atributo "<atributoresponse>" esta presente en la respuesta JSON

    Examples:
      | url       | atributoresponse | responseMessage |
      | booking/2 | firstname        | 200             |


  Scenario Outline: Validar codigo de estado 404 al enviar un id incorrecto
    Given hago una solicitud GET a la API "<url>"
    Then la respuesta debe tener codigo de estado "<responseMessage>"

    Examples:
      | url           | responseMessage |
      | booking/27777 | 404             |





