# Student Task Manager App (STMA)

Welcome to the **Student Task Manager App**! This application is designed for university students to create, manage, and track their tasks. It provides functionality to register, login, and manage a list of tasks with features like setting task due dates, priorities, and categories.

## Features
- **User Authentication:** Allows students to register and login to the application.
- **Task Management:**
    - Create, view, and manage tasks.
    - Mark tasks as completed.
    - Set due dates, priorities, and categories for each task.
- **CRUD Operations for Tasks:**
    - Create, Read, Update, Delete tasks.
    - Filter and manage tasks based on priority, due dates, and categories.

## Project Structure

The project is structured as follows:
Student_Task_Manager_App/ │ ├── src/ │ ├── main/ │ │ ├── java/ │ │ │ ├── com/ │ │ │ │ ├── rashiktimalsina/ │ │ │ │ │ ├── authentication/ │ │ │ │ │ ├── config/ │ │ │ │ │ ├── task_manager/ │ │ │ │ │ └── utils/ │ │ │ ├── Main.java │ │ │ └── DatabaseConnection.java │ │ └── resources/ │ │ └── config.properties │ ├── test/ │ │ ├── java/ │ │ │ ├── com/ │ │ │ │ ├── rashiktimalsina/ │ │ │ │ │ ├── MainTest.java │ │ │ │ │ └── DatabaseConnectionTest.java └── .gitignore


## Requirements

To run this application, you need the following:

- **Java 8 or higher**
- **MySQL Database**
- **Maven or Gradle** for managing dependencies and building the project.
- **JUnit 5** for running tests.

## Getting Started

### 1. Clone the repository
To get started, clone the project using:

git clone https://github.com/RasbikTimalsina/Student_Task_Manager_App.git




### 2. Configure Database Connection
The application requires a MySQL database connection. To set this up:
1. **Create a database** called `student_task_manager` in MySQL.
2. **Update the `config.properties` file** with your database connection details:
    - `db.url`: The URL to your MySQL database.
    - `db.user`: Your MySQL username.
    - `db.password`: Your MySQL password.

Example:
```properties
db.url=jdbc:mysql://localhost:3306/student_task_manager?useSSL=false
db.user=yourusername
db.password=yourpassword

```

### 3. Configure Database
   1) Make sure MySQL is running on your system.
   2) Create a new database for the app:

    

```sql```

CREATE DATABASE student_task_manager;

    

   3) Set up your config.properties file with the necessary credentials in the src/main/resources directory.




### 4. Install Dependencies (Build Automation Tools)
   If you're using Maven, run:



```bash```

mvn install

`

For Gradle, run:

```bash```

gradle build



The JAR file will be created in the target directory for Maven or build/libs for Gradle.


### 5. Application Flow
1) Login / Register: When you run the app, you'll be prompted to either login with your existing credentials or register a new account.
2) Task Management: After login, you can manage your tasks, including creating, updating, and deleting tasks.
3) Exit: You can exit the application by choosing the 'Exit' option.


### 6. Contributing
We welcome contributions to enhance the functionality or improve the application. If you'd like to contribute, please fork the repository, make your changes, and create a pull request.


### 7. License
This project is licensed under the MIT License - see the LICENSE file for details.

### 8. Acknowledgements
1) MySQL Database
2) Maven / Gradle Build Tools
3) JUnit for unit testing
4) IntelliJ IDEA for development

