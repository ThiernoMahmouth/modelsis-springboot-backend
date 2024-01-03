Ceci est un mini-projet réalisé dans le cadre du TEST de Modelsis. IL s'agit de concevoir une api rest de gestion des produits.

La tack utilisée est:
- Java 17
- Spring Boot 3.2.1
- Spring Data JPA
- Spring Data Validation
- Lombok
- Postgres 14


  Pour exécuter le projet, il faut exécuter les commandes ci-après dans le répertoire product-service:
  ## ./mvn spring-boot:run
  ## Ou en exécutant le jar (java -jar  product-service-0.0.1-SNAPSHOT.jar
  ### L'installation via docker-compose n'a pas pu être terminée malheureusement

  Après installation les tests peuvent être fait via:
  - SWAGGER: http://localhost:8099/swagger-ui/index.html#/
  - POSTMAN: http://localhost:8099/api/v1/product (par exple)
