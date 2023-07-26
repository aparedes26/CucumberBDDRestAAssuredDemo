Feature: Booking - UpdateBooking

  Scenario Outline: Validar codigo de estado 200 OK
    Given hago una solicitud PUT a la API https://restful-booker.herokuapp.com URI
    When envio una solicitud PUT y valido el body /booking/1 endpoint
    Then la respuesta debe tener codigo de estado "<responseMessage>"

    Examples:
      | responseMessage  |
      | 200              |