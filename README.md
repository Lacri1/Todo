# Todo List Web Application

This is a simple and efficient **Todo List Web Application** built with **Spring Boot** and **Gradle**. Users can add, update (toggle completion status), and delete tasks through the web interface. The backend is powered by Spring Boot with REST API endpoints, and the frontend uses basic HTML and JavaScript.

## Preview

[Todo.pdf](https://github.com/Lacri1/Todo/blob/main/Todo.pdf)


## Features

- Add new tasks to the Todo list.
- Toggle task completion status (mark as done/undone).
- Delete tasks from the list.
- Simple and user-friendly interface.

## Tech Stack

- **Backend**: Spring Boot, Hibernate, JPA
- **Frontend**: HTML, JavaScript
- **Build Tool**: Gradle
- **Database**: MySQL (or any other relational database)

## Project Setup

### Prerequisites
Make sure you have the following installed:
- **Java** (17 or higher)
- **Gradle** (6.0 or higher)
- **MySQL** (or any other relational database)

### Steps to Run the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/todo.git
   cd todo
   ```

2. Build and run the project using Gradle:
   ```bash
   ./gradlew build
   ./gradlew bootRun
   ```

3. Open your browser and go to [http://localhost:8080](http://localhost:8080).

### API Endpoints
- **GET /api/todos** - Fetch all Todo items.
- **POST /api/todos** - Create a new Todo item. Requires a JSON body with `task` and `completed` fields.
- **PUT /api/todos/{id}** - Update the completion status of a Todo item. Requires a JSON body with `completed` field.
- **DELETE /api/todos/{id}** - Delete a Todo item.

## Frontend Usage
The frontend is a simple HTML page with:
- A form to add tasks with a text input and a submit button.
- A button to toggle task completion status next to each task.
- An option to delete tasks with a delete button next to each task.
