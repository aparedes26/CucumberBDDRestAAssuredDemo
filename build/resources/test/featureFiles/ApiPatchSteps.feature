Feature: Booking - PartialUpdateBooking

  Scenario Outline: Validar codigo de estado 200 OK
    Given hago una solicitud PATCH a la API https://restful-booker.herokuapp.com URI
    When envio una solicitud PATCH y valido el body /booking/1 endpoint
    Then la respuesta debe tener codigo de estado "<responseMessage>"

    Examples:
      | responseMessage  |
      | 200              |