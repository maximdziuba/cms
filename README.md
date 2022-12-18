### Custom fullstack(maybe) CMS App

## App is in the development stage!!!

There is JWT-based authentication. Also you can see the swagger-documentation.\

To test the app, you have to run frontend and backend apps. To do it:
1. Open terminal in the project's root folder
2. To run the Backend with Maven-wrapper\
    On Mac/Linux:
    ```./mvnw spring-boot:run```\
    On Windows:
    ```mvnw.cmd spring-boot:run```
3. To run the Frontend(npm is required):
    1. At first install all the dependencies(only at 1st launch):
        ```npm install```
    2. Run the app
        ```npm start```
4. The app is available on ```localhost:3000```
5. If you want to test the API, it available on ```localhost:8080```.\
Swagger documentation is available on ```http://localhost:8080/swagger-ui.html```


Docker will be soon!!!