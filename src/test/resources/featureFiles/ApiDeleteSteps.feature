Feature: Booking - UpdateBooking

  Scenario Outline: Validar codigo de estado 201 OK Delete
    Given hago una solicitud DELETE a la API <url> URI
    When envio una solicitud DELETE y valido el body /booking/<id> endpoint
    Then la respuesta debe tener codigo de estado "<responseMessage>"

    Examples:
      | url                                  | id | responseMessage |
      | https://restful-booker.herokuapp.com | 115 | 201             |
      | https://restful-booker.herokuapp.com | 115 | 405             |




