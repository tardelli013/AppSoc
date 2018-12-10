# AppSoc

## Sistema de cadastro de exames

##### Desenvolvido com:

* `Java 8`
* `Struts 2`
* `h2database`
* `Springboot`
* `Tomcat`
* `Swagger`

##### Instruções

* Efetuar o download o clone do pacote
* Importar no eclipse como Maven Project
* Rodar o comando `mvn clean install` para baixar as dependências
* Verificar se não existe outra aplicação rodando na porta local 8080
* No Eclipse, Encontrar a classe inicilizadora do Springboot "StarterSocApp.java"
* Clicar com direito do mouse e `Run As > Java Application`
* Ao inicializar, o sistema cria uma pequena massa de dados para teste.

O projeto irá inicilizar, abaixo os caminhos:

Home do Projeto - http://localhost:8080/home

Swagger com documentação da API Rest e exemplos de requisições - http://localhost:8080/swagger-ui.html

WSDL do WebService SOAP - http://localhost:8080/ws/exams.wsdl

