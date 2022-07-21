# greeting-project

This will hold the source code for the Springboot content from the Niue nology course.

### Resources

- [Mural Board](https://app.mural.co/t/nology9400/m/nology9400/1657524516083/1dfd300458c95df49ac17505b9de5495521951bb?sender=u8c6e1ccb69fb91445cd51551)

---

## Folders

- `./greeting-api` -> The Springboot Backend project.
- `./greeting-app` -> The React Frontend project.

---

## Branches

- `main` -> Current state of the project.
- `01-spring-intro-get-req` -> Lesson looking at spring boot & get requests, path variables and params.
- `02-MVC-CRUD` -> Lesson looking at the Model View Controller design pattern. We also added Create, Read, Update and Delete endpoints to our `GreetingController`.
- `03-repository-refactor` -> Lesson refactoring `GreetingController` to interact with `GreetingRepository`. We introduced `ResponseEntity` a way for us to control the status codes we send back. We add Error handling , and the ability to read from a json file.
- `04-react-hook-up` -> A front end has been added to the project that is able to GET all greetings and can POST a new greeting to the BE.
- `05-MYSQL-hook-up` -> A mySQL database has been added to the project, classes in the BE have been refactored to accommodate the hook up.
- `06-service-refactor` -> Lesson adding methods to `JPARepository`, creating a `GreetingService` to be the go between the Controller and Repository.
