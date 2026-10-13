# Task Management Application | Java EJB Backend

**Academic group project · INT316D · Tshwane University of Technology (TUT)**

A backend module developed for a task management application as part of the INT316D module at TUT. The work was divided between two students: **I was responsible for the Java backend**, while my teammate worked on the frontend.

This repository contains the backend contribution, **not the complete application**.

## Project Overview

The backend models users and tasks and provides an Enterprise JavaBeans (EJB) persistence layer for managing those records. It applies Java Enterprise Edition concepts introduced during the module, including Java Persistence API (JPA) entities, stateless session beans and facade classes.

## My Contribution

- Created the `User` and `Task` entity models for persistence.
- Worked with a one-to-many relationship from users to tasks.
- Implemented facade interfaces and stateless EJB classes for accessing user and task records.
- Used a generic `AbstractFacade` to provide reusable create, edit, remove, find, list and count operations.
- Configured the persistence unit and JPA database connection settings.
- Developed the backend separately from the teammate responsible for the frontend.

## Technical Stack

| Technology | Use |
| --- | --- |
| Java | Backend programming and object-oriented design |
| Enterprise JavaBeans (EJB) | Stateless session beans and local interfaces |
| Java Persistence API (JPA) | Entity mapping and persistence operations |
| EclipseLink | JPA provider configured in the project |
| Apache Derby | Database targeted by the persistence configuration |
| NetBeans / Apache Ant | IDE project structure and build configuration |

The project configuration targets Java EE 7 and Java 7-era tooling.

## Repository Structure

```text
UserEJBModule/
├── src/
│   ├── java/ac/za/tut/
│   │   ├── entities/
│   │   │   ├── User.java
│   │   │   └── Task.java
│   │   └── bl/
│   │       ├── AbstractFacade.java
│   │       ├── UserFacade.java
│   │       ├── UserFacadeLocal.java
│   │       ├── TaskFacade.java
│   │       └── TaskFacadeLocal.java
│   └── conf/
│       └── persistence.xml
├── nbproject/
├── build/
├── dist/
└── build.xml
```

`build/` and `dist/` contain generated build artefacts from the original NetBeans project.

## Backend Design

### Entities

- **User:** Email identifier, first name, last name, password field and a collection of tasks
- **Task:** Generated identifier, title, date field and description

### Persistence and Business Layer

- `AbstractFacade<T>` defines reusable CRUD, listing, range and counting operations through JPA's `EntityManager`.
- `UserFacade` provides the user-specific stateless EJB backed by the `User` entity.
- `TaskFacade` provides the task-specific stateless EJB and includes additional methods for retrieving task records.
- Local facade interfaces define operations exposed to other components within the application.

## Setup Notes

This is a legacy **EJB module**, not a standalone runnable frontend or Spring Boot application. It was structured for NetBeans with a Java EE-compatible application server and a configured JTA datasource named `jdbc/__default`.

To explore it, open the project in a compatible NetBeans/Java EE environment and inspect `src/conf/persistence.xml` before attempting deployment. The exact original runtime environment is not documented here, and a successful build or deployment has not been independently verified.

**Do not deploy the original persistence configuration against a database containing important data:** it specifies schema drop-and-create behaviour.

## Known Implementation Limitations

This repository preserves the academic implementation. During a source review, the following items were identified:

- `TaskFacade.getTask()` uses `Tak` rather than the `Task` entity name in a JPQL query.
- `User.email` is a `String` identifier annotated with `@GeneratedValue`, which is not an appropriate automatic identifier strategy as currently written.
- A password field exists in the `User` entity, but secure password hashing and authentication are not demonstrated in this module.
- The repository does not include the separate frontend, integration tests or evidence confirming the full application's final deployed state.

These are documented for transparency; the original coursework source has not been refactored.

## Learning Outcomes

This project gave me practical experience with enterprise Java application structure, JPA entity mapping, reusable persistence operations and collaboration on a project with separate frontend and backend responsibilities.

---

**Backend contribution:** [Botlhale Mpatlanyane](https://github.com/Bo-tlhale)  
**Institution:** Tshwane University of Technology (TUT)  
**Module:** INT316D
