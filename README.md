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

## JPA Lifecycle

![jpa-lifecycle](https://github.com/pybalt/JPA-Hibernate/assets/96897286/3f0964c2-d1e3-452b-bd25-737e38bc4e17)

The lifecycle model consists of the 4 states transient, managed, removed, and detached.

### New | Transient
The lifecycle state of a newly instantiated entity object is called transient. The entity hasn’t been persisted yet, so it doesn’t represent any database record.

Your persistence context doesn’t know about your newly instantiated object. Because of that, it doesn’t automatically perform an SQL INSERT statement or track any changes. As long as your entity object is in the lifecycle state transient, you can think of it as a basic Java object without any connection to the database and any JPA-specific functionality.

```Java
1 | Author author = new Author();
2 | author.setFirstName("Thorben");
3 | author.setLastName("Janssen");
```
That changes when you provide it to the EntityManager.find method. The entity object then changes its lifecycle state to managed and gets attached to the current persistence context.

### Managed

All entity objects attached to the current persistence context are in the lifecycle state managed. That means that your persistence provider, e.g. Hibernate, will detect any changes on the objects and generate the required SQL INSERT or UPDATE statements when it flushes the persistence context.

There are different ways to get an entity to the lifecycle state managed:

1. You can call the EntityManager.persist method with a new entity object.
```Java
1 | Author author = new Author();
2 | author.setFirstName("Thorben");
3 | author.setLastName("Janssen");
4 | em.persist(author);
```

2. You can load an entity object from the database using the EntityManager.find method, a JPQL query, a CriteriaQuery, or a native SQL query.
```Java
1 | Author author = em.find(Author.class, 1L);
```

3. You can merge a detached entity by calling the EntityManager.merge method or update it by calling the update method on your Hibernate Session.
```Java
1 | em.merge(author);
```

### Detached

An entity that was previously managed but is no longer attached to the current persistence context is in the lifecycle state detached.

An entity gets detached when you close the persistence context. That typically happens after a request is processed. Then the database transaction gets committed, the persistence context gets closed, and the entity object gets returned to the caller. The caller then retrieves an entity object in the lifecycle state detached.

You can also programmatically detach an entity by calling the detach method on the EntityManager.
```Java
1 | em.detach(author);
```

There are only very few performance-tuning reasons to detach a managed entity. If you decide to detach an entity, you should first flush the persistence context to avoid losing any pending changes.

### Reattaching an entity

You can reattach an entity by calling the update method on your Hibernate Session or the merge method on the EntityManager. There are a few subtle differences between these operations that I explain in great detail in What’s the difference between persist, save, merge, and update? Which one should you use?

In both cases, the entity changes its lifecycle state to manage.

### Removed

When you call the remove method on your EntityManager, the mapped database record doesn’t get removed immediately. The entity object only changes its lifecycle state to removed.

During the next flush operation, Hibernate will generate an SQL DELETE statement to remove the record from the database table.

```Java
1 |	em.remove(author);
```

## Methods

#### Persist

Is a method that synchronizes a model with its counterpart in the database.

#### Remove

This will remove the entity object from the database table.

#### Clear

This method sends current models to a detached state to save memory. You will have to retrieve them to commit them.  

#### Close

This method closes the connection, deleting the entity manager. You will have to create another instance of an entity manager to continue with transactions.

#### Flush

This method has similarities with commit, with the difference of having the possibility of making rollback in case of facing errors.

#### Commit

With this method, you will insert the changes from the entity to the database.
