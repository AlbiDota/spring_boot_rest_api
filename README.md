# APP2000 - spring_boot_rest_api
Using an older assignment as a placeholder and template to start with.

[github.com/AlbiDota/react-bert](https://github.com/AlbiDota/react-bert)

## Tech Stack

- Java 21
- Spring Boot 3.2.2
- PostgreSQL
- OpenAPI (Swagger) for documentation
- MapStruct for object mapping
- Lombok for reducing boilerplate code
- OAuth2.0 for google auth

## Prerequisites

Before you begin, ensure you have:
- JDK 21
- Maven
- PostgreSQL
- IntelliJ IDEA
- [Google Cloud Console](https://console.cloud.google.com/)


1. Head over to [Google Cloud Console](https://console.cloud.google.com/), and create a project. (Name is not relevant)
2. Locate the 'Credentials' tab on the left side, 
3. Click 'Create Credentials' then 'OAuth Client ID'
4. Under 'Application Type' you should select 'Web app'
5. Make sure 'Authorized JS origins' has the following URI
```Authorized JavaScript Origins
http://localhost:8080
```
6. And 'Authorized redirect URI' has
```Authorized JavaScript Origins
http://localhost:8080/login/oauth2/code/google
```

7. Click 'Create' and get your Client ID and Client Secret. These can be downloaded in a JSON file for later.
8. The rest of this setup continues from 'step 4' in 'Getting Started'


## Getting Started

1. Clone the repository
2. Create PostgreSQL database:
```sql
CREATE DATABASE app2000oblig2;
```

3. Configure database connection in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/app2000oblig2
spring.datasource.username=your_username (most likely 'postgres')
spring.datasource.password=your_password
```

4. Make sure to swap out the placeholder ID and SECRET with the ones you got earlier
```properties
spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
```
AND MAKE SURE TO CHANGE THESE BACK IF YOU ARE EVER TO SHARE THIS CODE!! 

This would more optimally be done with secrets in a `.env` file along with the database password, but not needed right now

THE ID AND SECRET SHOULD NEVER BE SHARED ONLINE!! THIS IS ONLY FOR RUNNING IT LOCALLY!!!


5. Make sure the last line looks like this:
```properties
spring.jpa.hibernate.ddl-auto=create
```

6. Build the project:
```bash
mvn clean install
```

7. Run the application:
```bash
mvn spring-boot:run
```

8. Afterwards you should change this line from:
```properties
spring.jpa.hibernate.ddl-auto=create
```
to 
```properties
spring.jpa.hibernate.ddl-auto=update
```

The application will be available at `http://localhost:8080`

## API Documentation

Access the Swagger UI to explore and test the API:
- Swagger UI: `http://localhost:8080/swagger-ui.html/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

### Testing with Swagger UI

1. Start your Spring Boot application
2. Go to `http://localhost:8080/swagger-ui.html` in your browser
3. Sign in with your google account
4. Explore and test the available endpoints:
    - Expand the "Exercise Controller" section to see all endpoints related to it
    - Click on an endpoint (e.g., GET `/api/exercise/get/{name}`)
    - Click "Try it out", type in something like "Running", then "Execute"
    - View the response

### Testing with Postman

1. Download and install [Postman](https://www.postman.com/downloads/)
2. Create requests for the following endpoints:


   #### Workouts
- DELETE `/api/workout/delete-id/{workoutid}` - Delete workout by ID
- GET `/api/workout/get-user/{userfk}` - Get workout by user ID
- GET `/api/workout/get-id/{workoutid}` - Get workout by workout ID
- GET `/api/workout/get-exercise/` - Get workouts with specific exercise
- GET `/api/workout/get-all/` - Get all workouts
- POST `/api/workout` - Create workout
- PUT `/api/workout/{workoutid}` - Update workout



   #### Exercises
- DELETE `/api/exercise/delete-id/{exerciseid}` - Delete exercise by ID
- GET `/api/exercise/get/{name}` - Get exercise by name
- GET `/api/exercise/get-all/` - Get all exercises
- POST `/api/exercise` - Create exercise
- PUT `/api/exercise/{exerciseid}` - Update exercise


   #### Users
- DELETE `/api/user/delete-id/{id}` - Delete user by ID
- DELETE `/api/user/delete-email/{email}` - Delete user by email
- GET `/api/user/get-name/{username}` - Get all users with matching name
- GET `/api/user/get-id/{id}` - Get user by ID
- GET `/api/user/get-email/{email}` - Get user by email
- GET `/api/user/current-user` - Get info about yourself
- POST `/api/user` - Create user
- PUT `/api/user/{userid}` - Update user



Example POST request body (exercise):
(the ID of the exercise is not included in the form, as it is auto-generated behind the scenes)
```json
{
  "name": "String",
  "descr": "String"
}
```

## Project Structure

```
src/main/java/com/myproject/
├── config/          # Configuration classes
├── controller/      # REST controllers
├── dto/             # Data Transfer Objects
├── exception/       # Exception handling
├── mapper/          # Object mappers 
├── model/           # Entity classes
├── repository/      # Data access layer
└── service/         # Business logic 
```

## Key Components

### Entity
The `Workout` entity represents a workout in the database with fields:
- workoutid (primary key)
- title
- content
- workoutdate
- userfk
- exercisefk

The `User` entity represents a user in the database with fields:
- userid (primary key)
- username
- email
- birthday

The `Exercise` entity represents an exercise in the database with fields:
- exerciseid (primary key)
- name
- desc

### Repository
The `exerciseRepository`, `UserRepository` and `WorkoutRepository` provides data access methods:
- Basic CRUD operations (from JpaRepository)
- Custom finder methods

### Service
The `WorkoutService` implements business logic:
- Get all workouts
- Get workout by ID
- Workouts by userid
- Workouts with exerciseid
- Create workout
- Delete workout


The `ExerciseService` implements business logic:
- Get all exercises
- Get exercises by name
- Update exercise
- Create exercise
- Delete exercise


The `UserService` implements business logic:
- Get all users
- Get user by ID
- Get user by email
- Create new user
- Update existing user
- Delete user by ID
- Delete user by email


### Controller

The `WorkoutController` defines REST endpoints:
- DELETE `/api/workout/delete-id/{workoutid}` - Delete workout by ID
- GET `/api/workout/get-user/{userfk}` - Get workout by user ID
- GET `/api/workout/get-id/{workoutid}` - Get workout by workout ID
- GET `/api/workout/get-exercise/` - Get workouts with specific exercise
- GET `/api/workout/get-all/` - Get all workouts
- POST `/api/workout` - Create workout
- PUT `/api/workout/{workoutid}` - Update workout



The `ExerciseController` defines REST endpoints:
- DELETE `/api/exercise/delete-id/{exerciseid}` - Delete exercise by ID
- GET `/api/exercise/get/{name}` - Get exercise by name
- GET `/api/exercise/get-all/` - Get all exercises
- POST `/api/exercise` - Create exercise
- PUT `/api/exercise/{exerciseid}` - Update exercise


The `UserController` defines REST endpoints:
- DELETE `/api/user/delete-id/{id}` - Delete user by ID
- DELETE `/api/user/delete-email/{email}` - Delete user by email
- GET `/api/user/get-name/{username}` - Get all users with matching name
- GET `/api/user/get-id/{id}` - Get user by ID
- GET `/api/user/get-email/{email}` - Get user by email
- GET `/api/user/current-user` - Get info about yourself
- POST `/api/user` - Create user
- PUT `/api/user/{userid}` - Update user
