Feature: Auth - CreateToken

Scenario Outline: Validar codigo de estado 200 OK
Given hago una solicitud POST a la API <url> URI
When envio una solicitud POST y valido el body <patch> endpoint
Then la respuesta debe tener codigo de estado "<responseMessage>"

Examples:
  | url                                  | patch | responseMessage |
  | https://restful-booker.herokuapp.com | /auth | 200             |


  Scenario Outline: Validar codigo de respuesta con error 404 al enviar la peticion con el patch incorrecto
    Given hago una solicitud POST a la API <url> URI
    When envio una solicitud POST y valido el body <patch> endpoint
    Then la respuesta debe tener codigo de estado "<responseMessage>"

    Examples:
      | url                                  | patch | responseMessage |
      | https://restful-booker.herokuapp.com | /aut  | 404             |


