# datajpademo1
Java Persistence API (JPA) - In-Depth Notes
✅ What is JPA?
JPA stands for Java Persistence API, a specification that helps manage relational data in Java applications using ORM (Object Relational Mapping).

JPA is just a specification (like an interface) — it does not provide the actual implementation. The implementation is provided by tools like:

Hibernate (most popular)

EclipseLink

OpenJPA

JPA allows you to:

Map Java objects to database tables.

Interact with the database using Java objects, rather than SQL queries directly.

🛠️ Different Ways to Communicate with Databases in Java

Method	Description
JDBC	Low-level API. We manually manage connections, write SQL, and handle exceptions. Lot of boilerplate code.
Spring JDBC	A little abstraction over JDBC. Still write SQL, but error handling and connection management are simplified.
Hibernate	Object Relational Mapping (ORM). No need to write SQL, works with objects directly.
Spring ORM	Integration of Spring with ORM tools like Hibernate.
Spring Data JPA	Built on top of JPA and Hibernate. Provides Repository interfaces with ready-made methods. Very developer-friendly.
📦 Core JPA Components
1️⃣ What is a DataSource?
DataSource represents a connection pool (a set of DB connections reused for performance).

Spring Boot automatically manages DataSource using application.properties config.

🔧 Example (MySQL):
properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=yourpassword

# Extra options for JPA & Hibernate
spring.jpa.show-sql=true               # Logs SQL statements in the console
spring.jpa.hibernate.ddl-auto=update  # Automatically creates/updates schema (can be create, update, validate, none)
spring.jpa.properties.hibernate.format_sql=true
2️⃣ What is an Entity?
Entity is a POJO (Plain Old Java Object) class that maps to a database table.

This is the core of ORM — it allows you to work with Java objects and let JPA map them to actual DB records.

✍️ Sample Entity
java
Copy
Edit
import jakarta.persistence.*;

@Entity                     // Marks class as a database entity
@Table(name = "employees")  // Optional: Maps to specific table name
public class Employee {

    @Id                    // Marks this field as the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private int empId;

    @Column(name = "name")  // Optional: Map to specific column name
    private String empName;

    private Double empSalary;  // Column name will default to "empSalary"

    // Getters and Setters
}
3️⃣ What is a Repository?
Repository is a Spring Data interface used to perform CRUD operations on entities.

You don’t need to write SQL — Spring Data provides built-in methods like:

save()

findById()

findAll()

deleteById()

🧠 Two Main Interfaces:

Interface	Features
CrudRepository<T, ID>	Basic CRUD methods
JpaRepository<T, ID>	All CrudRepository methods + Sorting, Pagination, and Query by Example (QBE)
🏗️ Step-by-Step: Your First Spring Data JPA Application
Step 1: Create Spring Boot Project with Dependencies
✅ Required Dependencies in pom.xml (if using Maven):


<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
You can also add these using Spring Initializr.

Step 2: Configure application.properties
properties

spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
Step 3: Create Entity Class

@Entity
public class Employee {

    @Id
    private int empId;
    private String empName;
    private Double empSalary;

    // Constructors, Getters, Setters
}
Step 4: Create Repository Interface

import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<Employee, Integer> {
    // You can define custom query methods here
}
Step 5: Save Data using CommandLineRunner

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyAppRunner implements CommandLineRunner {

    private final EmpRepository empRepository;

    public MyAppRunner(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee e = new Employee();
        e.setEmpId(1);
        e.setEmpName("John Doe");
        e.setEmpSalary(55000.0);
        empRepository.save(e); // Inserts the data into DB
    }
}
📋 CRUD Methods from CrudRepository

Method	Description
save(entity)	Insert or update entity
findById(id)	Fetch entity by PK
findAll()	Return all entities
deleteById(id)	Delete entity
count()	Return total row count
