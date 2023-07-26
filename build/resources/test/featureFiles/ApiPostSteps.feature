Feature: Auth - CreateToken

Scenario Outline: Validar codigo de estado 200 OK
Given hago una solicitud POST a la API https://restful-booker.herokuapp.com URI
When envio una solicitud POST y valido el body /auth endpoint
Then la respuesta debe tener codigo de estado "<responseMessage>"

Examples:
| responseMessage  |
| 200              |