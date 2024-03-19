# spring-cloud-function-crud-template
Um template CRUD com:

- Spring Boot
  - Java 21
  - Conexão com banco de dados SQL / H2 Local
  - Maven

Otimizado e preparado para execução em um Azure Function App.

# Como executar localmente

Antes de tudo, você deve ter instalado em seu computador o Azure Function Core Tools, Java 21 e Maven.

# No VS Code
- Instale o pacote de extensões "Extension Pack for Java".
  - Instale o pacote de extensões "Spring Boot Extension Pack".
  - Instale o pacote de extensões "Azure Tools". 

# Configuração do Ambiente
Para garantir que o ambiente esteja corretamente configurado para desenvolvimento, siga estas etapas:

- Java 21: Verifique se o Java 21 está instalado corretamente em seu sistema. Você pode verificar isso executando java -version em seu terminal.
  - Maven: Maven é uma ferramenta essencial para a gestão de projetos Java. Verifique sua instalação com o comando mvn -v.
  - Azure Function Core Tools: Essencial para testar funções do Azure localmente. Verifique a instalação com func.

# Configurando o Banco de Dados
Este projeto requer uma conexão com um banco de dados SQL. Configure as propriedades de conexão do banco de dados no arquivo application.properties:

# Executando o Projeto
Para executar o projeto localmente, siga estes passos:

- Abra o terminal ou prompt de comando.
  - Navegue até a pasta raiz do projeto.
  - Execute o comando mvn clean package para construir o projeto.
  - Inicie a aplicação localmente com mvn azure-functions:run.
  - A aplicação agora estará rodando localmente e você pode testar as funções CRUD através de chamadas HTTP para os endpoints expostos.

# Deploy no Azure Function App
Para fazer o deploy da aplicação em um Azure Function App, siga estes passos:

Configure sua conta Azure no VS Code utilizando a extensão "Azure Tools".
No VS Code, na aba do Azure, localize a seção de Function App.
Clique com o botão direito e selecione "Deploy to Function App...".
Siga as instruções na tela para selecionar sua subscrição, criar ou selecionar um Function App existente e iniciar o deploy.
Após o deploy, sua aplicação estará disponível no Azure e poderá ser acessada através dos endpoints fornecidos pelo Azure Function App.