# spring-cloud-function-crud-template
A CRUD template with:

- Spring Boot
- Java 21
- SQL / H2 Local Database Connection
- Maven

Optimized and ready to run on an Azure Function App.

# How to run locally

First and foremost, you must have Azure Function Core Tools, Java 21, and Maven installed on your computer.

# In VS Code
- Install the "Extension Pack for Java" extension pack.
- Install the "Spring Boot Extension Pack" extension pack.
- Install the "Azure Tools" extension pack.

# Environment Setup
To ensure the environment is correctly set up for development, follow these steps:

- Java 21: Verify that Java 21 is correctly installed on your system. You can check this by running java -version in your terminal.
- Maven: Maven is an essential tool for managing Java projects. Verify your installation with the mvn -v command.
- Azure Function Core Tools: Essential for locally testing Azure functions. Verify the installation with func.

# Configuring the Database
This project requires a connection to an SQL database. Configure the database connection properties in the application.properties file:

# Running the Project
To run the project locally, follow these steps:

- Open a terminal or command prompt.
- Navigate to the project's root folder.
- Execute the mvn clean package command to build the project.
- Start the application locally with mvn azure-functions:run.
- The application will now be running locally, and you can test the CRUD functions through HTTP calls to the exposed endpoints.

# Deploying to Azure Function App
To deploy the application to an Azure Function App, follow these steps:

- Configure your Azure account in VS Code using the "Azure Tools" extension.
- In VS Code, in the Azure tab, locate the Function App section.
- Right-click and select "Deploy to Function App...".
- Follow the on-screen instructions to select your subscription, create or select an existing Function App, and start the deployment.
- After deployment, your application will be available on Azure and can be accessed through the endpoints provided by the Azure Function App.
