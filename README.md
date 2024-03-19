# SPRING-CLOUD-FUNCTION-CRUD-TEMPLATE

## English:

A CRUD template with:

- Spring Boot
- Java 21
- SQL / H2 Local Database Connection
- Maven

Optimized and ready to run on an Azure Function App.

### How to run locally

First and foremost, you must have Azure Function Core Tools, Java 21, and Maven installed on your computer.

### In VS Code
- Install the "Extension Pack for Java" extension pack.
- Install the "Spring Boot Extension Pack" extension pack.
- Install the "Azure Tools" extension pack.

### Environment Setup
To ensure the environment is correctly set up for development, follow these steps:

- Java 21: Verify that Java 21 is correctly installed on your system. You can check this by running java -version in your terminal.
- Maven: Maven is an essential tool for managing Java projects. Verify your installation with the mvn -v command.
- Azure Function Core Tools: Essential for locally testing Azure functions. Verify the installation with func.

### Configuring the Database
This project requires a connection to an SQL database. Configure the database connection properties in the application.properties file:

### Running the Project
To run the project locally, follow these steps:

- Open a terminal or command prompt.
- Navigate to the project's root folder.
- Execute the mvn clean package command to build the project.
- Start the application locally with mvn azure-functions:run.
- The application will now be running locally, and you can test the CRUD functions through HTTP calls to the exposed endpoints.

### Deploying to Azure Function App
To deploy the application to an Azure Function App, follow these steps:

- Configure your Azure account in VS Code using the "Azure Tools" extension.
- In VS Code, in the Azure tab, locate the Function App section.
- Right-click and select "Deploy to Function App...".
- Follow the on-screen instructions to select your subscription, create or select an existing Function App, and start the deployment.
- After deployment, your application will be available on Azure and can be accessed through the endpoints provided by the Azure Function App.

## Português:

Um template CRUD com:

- Spring Boot
  - Java 21
  - Conexão com banco de dados SQL / H2 Local
  - Maven

Otimizado e preparado para execução em um Azure Function App.

### Como executar localmente

Antes de tudo, você deve ter instalado em seu computador o Azure Function Core Tools, Java 21 e Maven.

### No VS Code
- Instale o pacote de extensões "Extension Pack for Java".
  - Instale o pacote de extensões "Spring Boot Extension Pack".
  - Instale o pacote de extensões "Azure Tools". 

### Configuração do Ambiente
Para garantir que o ambiente esteja corretamente configurado para desenvolvimento, siga estas etapas:

- Java 21: Verifique se o Java 21 está instalado corretamente em seu sistema. Você pode verificar isso executando java -version em seu terminal.
  - Maven: Maven é uma ferramenta essencial para a gestão de projetos Java. Verifique sua instalação com o comando mvn -v.
  - Azure Function Core Tools: Essencial para testar funções do Azure localmente. Verifique a instalação com func.

### Configurando o Banco de Dados
Este projeto requer uma conexão com um banco de dados SQL. Configure as propriedades de conexão do banco de dados no arquivo application.properties:

### Executando o Projeto
Para executar o projeto localmente, siga estes passos:

- Abra o terminal ou prompt de comando.
  - Navegue até a pasta raiz do projeto.
  - Execute o comando mvn clean package para construir o projeto.
  - Inicie a aplicação localmente com mvn azure-functions:run.
  - A aplicação agora estará rodando localmente e você pode testar as funções CRUD através de chamadas HTTP para os endpoints expostos.

## Deploy no Azure Function App
Para fazer o deploy da aplicação em um Azure Function App, siga estes passos:

Configure sua conta Azure no VS Code utilizando a extensão "Azure Tools".
No VS Code, na aba do Azure, localize a seção de Function App.
Clique com o botão direito e selecione "Deploy to Function App...".
Siga as instruções na tela para selecionar sua subscrição, criar ou selecionar um Function App existente e iniciar o deploy.
Após o deploy, sua aplicação estará disponível no Azure e poderá ser acessada através dos endpoints fornecidos pelo Azure Function App.