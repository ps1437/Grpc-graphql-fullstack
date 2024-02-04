# Woo Ecommerce

Welcome to your awesome project! This project is built with Spring Boot, and it includes an H2 database. Here's how you can access the H2 Console for database interactions.

## Accessing H2 Console

1. Make sure your Spring Boot application is running.

2. Open your web browser and go to [http://localhost:8080/h2-console](http://localhost:8080/h2-console).

3. Fill in the following details in the H2 Console login page:
    - **JDBC URL:** `dbc:h2:mem:ecom-db`
    - **Username:** `sa`
    - **Password:** 

4. Click the "Connect" button.

5. You should now have access to the H2 Console for interacting with the embedded database.

## Important Note

- The H2 Console is enabled for development purposes. Make sure to secure it or disable it in production environments to prevent unauthorized access.


## Accessing Swagger UI

1. Make sure your Spring Boot application is running.

2. Open your web browser and go to [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

3. Explore the available API documentation, endpoints, and test API calls directly from the Swagger UI.
