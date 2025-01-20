Feature: Prueba de API - Negative Path

Scenario: Intentar obtener un recurso que no existe
  Given url 'https://jsonplaceholder.typicode.com/posts/0'
  When method GET
  Then status 404
  And match response == {}
