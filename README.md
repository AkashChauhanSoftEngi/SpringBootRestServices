# SpringBootRestServices

* Spring Boot{2.0.3.RELEASE} + + Rest Services(CRUD) {Create, Remove, Update, delete} + H2-Database Integration + MVC + HTML View with pure Java Configuration (no XML), using Maven build tool.

> **###1. Features**
* userService.saveUser(user) {userRepository.save(outUser)}
* userService.getAllUsers() {userRepository.findAll()}
* userService.findUserById(Long id) {userRepository.findUserById(id), UserRepo}
```java
      @Repository
      @Transactional
      public class UserRepoImpl implements UserRepo{

    	@Autowired
	    @PersistenceContext
	    EntityManager em;
	
	    @Override
	    public User findUserById(Long id) {
		  return em.find(User.class,id);
	    }
      }
```
* userService.updateUser(DtoUser) {userRepository.findUserById(id) & userRepository.save(dbUser)}
* userService.deleteUser() userRepository.deleteById(userId)}

> **###2. Advantages**
* It is very easy to develop Spring Based applications with Java or Groovy.
* It reduces lots of development time and increases productivity.
* Auto Configuration file creation, and @SpringBootApplication is being used in main class automatically
* No need of deployment on Tomcat as it happens automatically after adding necessary dependencies in POM file
* No need to setup, build path and all, as it happens automatically after initializing application using https://start.spring.io/
* By default jsp pages can be resided in template folder as this path is default path for such pages
* We can directly set the port of the server by adding server.port: 8080 in application.properties file
* We can use directly H2-Database in the application, it is very beneficial for testing purpose, also it is easy to integrate as well
* Easy to integrate all related databases
* Easy to maintain code and flow {As flow is quiet simple}
* Better code readability
* Less complex architecture
* No need to create database explicitely, as run time H2-Database will be created automatically
* Quiet easy to test application with run time database {H2-Database}

> **###3. Additional Details**
* The @ComponentScan annotation is used to automatically create beans for every class annotated with @Component, @Service, @Controller,   @RestController, @Repository, ... and adds them to the Spring container (allowing them to be @Autowired). It will not scan anything     else except IOC component
* The @EntityScan on the other hand does not create beans. It only identifies which classes should be used by a specific persistence     context.

> **###4. Technologies**
* Spring Boot 2.0.3.RELEASE (Latest)
* Rest Services(CRUD) {Create, Remove, Update, delete}
* H2-Database
* Maven 3.1
* JSTL 1.2

> **###5. To Run this project locally**
* $ git clone https://github.com/AkashChauhanSoftEngi/SpringBootRestServices
* $ mvn tomcat7:run

> **###6.  Access** 
* http://localhost:8080/user, http://localhost:8080/users/{id} for GET, http://localhost:8080/users/{id} for PUT, http://localhost:8080/users/{id} for DELETE 
