# SUPERA---Desafio-Pratico-Back-End-Banco

## Descrição

Este teste consiste em construir uma camada de serviço, para uma operação muito realizada em bancos, para emissão de extrato bancário.

## Execução da aplicação

Executar a aplicação de acordo com sua IDE (Eclipse, IntelliJ, NetBeans), procurar o arquivo application.properties -> src/main/resources, e configurar para conexão com 
banco de dados:
- spring.datasource.username - > seu usuario no banco de dados
- spring.datasource.password -> sua senha
- spring.datasource.url -> verificar se esta na porta correta do banco de dados

## Testes API
- Instalar o postman para testes da API - link -> https://www.postman.com/
- Depois de instalado importar a collection armazenado na pasta POSTMAN do repositório
<div alingn-"center">
<img src="https://user-images.githubusercontent.com/91353097/165001755-20c8fe90-b6f9-41dd-a2a8-9ec1bb1005e1.png" width="300"/>
</div>

- Nome do arquivo:
<div alingn-"center">
<img src="https://user-images.githubusercontent.com/91353097/165002514-8b97af8c-fc94-4fda-85c6-97f0f5d1c7a1.png" width="600"/>
</div>

- Depois de importado note que aparecera as collection no lado esquerdo com os metodo http GET e POST criado
<div alingn-"center">
<img src="https://user-images.githubusercontent.com/91353097/165001923-b79890af-1c54-4f79-a2b2-25ef056ff065.png" width="300"/>
</div>

- A cada pesquisa aperte no botão SEND
<div alingn-"center">
<img src="https://user-images.githubusercontent.com/91353097/165002068-fe2234fd-c1ae-457f-922a-bc4b509fb7d1.png" width="600"/>
</div>

- Existira pesquisas personalizada nos campos KEY = parametro e VALUE = (valor da busca) referenciando ao periodo e nome do extrato, mude o campo VALUE para diferentes buscas
<div alingn-"center">
<img src="https://user-images.githubusercontent.com/91353097/165002288-d7f62be1-1eae-42c0-93cc-78b83be901dd.png" width="500"/>
</div>
Obs.: Não mude as configuração do KEY pois esta de acordo com os nomes do back-end do banco.
