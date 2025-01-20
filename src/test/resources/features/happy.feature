Feature: Prueba de API - Happy Path

Scenario: Obtener un recurso exitosamente
  Given url 'https://jsonplaceholder.typicode.com/posts/1'
  When method GET
  Then status 200
  And match response.id == 1
  And match response.title != null
