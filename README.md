# JPA-Hibernate
A project with JPA instead of JBDC, an explanation of why choosing one instead of the other.

## JDBC Disadvantages
- Too much verbosity
- Too many code lines
- High coupling with the database

## What is JPA?

JPA is a standard, Java Persistence API, which applies to ORMs. It was created to not depend on specific implementations of each solution provided in the market as Hibernate or its alternatives. JPA is now the specification, while libraries such as Hibernate, EclipseLink, or OpenJPA, are their implementations.
It is important to remember that JPA is just an abstraction.


## What is Hibernate?

Hibernate is a library that was created as an alternative to JDBC/EJB2 to guarantee data persistence. This library tried to simplify JBDC.

## Which databases supports Hibernate?

- MySQL
- PostgresSQL
- Oracle
- SQL Server
- MongoDB
- NoSQL

And so on...