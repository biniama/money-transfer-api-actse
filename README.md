# Notes

## Object-Oriented Programming
[What are the main principles of OOP?](https://searchapparchitecture.techtarget.com/definition/object-oriented-programming-OOP)  
Object-oriented programming is based on the following principles:  
1. Encapsulation. This principle states that all important information is contained inside an object and only select information is exposed. The implementation and state of each object are privately held inside a defined class. Other objects do not have access to this class or the authority to make changes. They are only able to call a list of public functions or methods. This characteristic of data hiding provides greater program security and avoids unintended data corruption.  
2. Abstraction. Objects only reveal internal mechanisms that are relevant for the use of other objects, hiding any unnecessary implementation code. The derived class can have its functionality extended. This concept can help developers more easily make additional changes or additions over time.  
3. Inheritance. Classes can reuse code from other classes. Relationships and subclasses between objects can be assigned, enabling developers to reuse common logic while still maintaining a unique hierarchy. This property of OOP forces a more thorough data analysis, reduces development time and ensures a higher level of accuracy.  
4. Polymorphism. Objects are designed to share behaviors and they can take on more than one form. The program will determine which meaning or usage is necessary for each execution of that object from a parent class, reducing the need to duplicate code. A child class is then created, which extends the functionality of the parent class. Polymorphism allows different types of objects to pass through the same interface.  

## Dependencies required
* PostgreSQL Driver  
* Spring Data JPA  
* H2 Database  
* Spring Web  
* Validation  
* Spring Boot Actuator  
* Lombok  

### Acronyms
POJO - Plain Old Java Object

## Database Script
Connect to the database using username ‘Postgres’  
`psql -h localhost -Upostgres`

Create the database  
`CREATE DATABASE moneytransfer;`  
Expected Response: CREATE DATABASE

Create a user or role  
`CREATE ROLE moneytransfer WITH ENCRYPTED PASSWORD 'm0neytr4n5f3r';`  
Expected Response: CREATE ROLE  

Grant permissions/privileges to the user on the database  
`GRANT ALL PRIVILEGES ON DATABASE moneytransfer TO moneytransfer;`  
Expected Response: GRANT  

Grant permissions to the user to be able to login and create tables  
`ALTER USER moneytransfer WITH LOGIN;`   
Expected Response: ALTER  

https://code-with-me.jetbrains.com/6vUuhZCo0iVqPLtTuf_uFw#p=IU&fp=629F8212CD968BEA6C4A8B525CB0059699B4152533987920149CDB5E0208654D
