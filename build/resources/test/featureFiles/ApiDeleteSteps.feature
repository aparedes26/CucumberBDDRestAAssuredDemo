Feature: Booking - UpdateBooking

  Scenario Outline: Validar codigo de estado 200 OK
    Given hago una solicitud DELETE a la API <url> URI
    When envio una solicitud DELETE y valido el body /booking/<id> endpoint
    Then la respuesta debe tener codigo de estado "<responseMessage>"

    Examples:
      | url                                  | id | responseMessage |
      | https://restful-booker.herokuapp.com | 30 | 201             |


  Scenario Outline: Validar codigo de estado 405 cuando se envia id en el patch variable ya eliminado
    Given hago una solicitud DELETE a la API <url> URI
    When envio una solicitud DELETE y valido el body /booking/<id> endpoint
    Then la respuesta debe tener codigo de estado "<responseMessage>"

    Examples:
      | url                                  | id | responseMessage |
      | https://restful-booker.herokuapp.com | 6  | 201             |

