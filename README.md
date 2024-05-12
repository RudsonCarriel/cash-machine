
## Cash-machine

O projeto visa foi desenvolvido para representar um caixa eletrônico, simulando a entrega de notas quando um cliente efetuar um saque os requisitos são:

- Entregar o menor número de notas
- É possível sacar o valor solicitado com as notas disponíveis
- Saldo do cliente infinito
- Quantidade de notas finitas
- Notas disponíveis de R$100, R$50, R$20, R$10


## Arquitetura da Api

Foi desenvolvido em Clean Architecture, pois é uma excelente arquitetura,que tem com intuito de colocar a lógica de negócio no centro da aplicação, tornado assim um sistema mais flexível e de fácil manutenção,nao estando acoplado a framework

## SOLID

Já o desenvolvimento foi implementado os conceitos do SOLID, para ter um código mais limpo e coeso de forma que os próximos desenvolvedores, consiga entender facilmente e assim facilitando a implementação de novos requisitos
## Tecnologias

- Spring Boot
- Lombok
- Spring Data JDBC
- H2

## Como Executar

- Clonar repositório git:
```
git clone https://github.com/RudsonCarriel/cash-machine.git
```
- Instale as dependências do pom.xml (Maven)
```
mvn clean install -U
```
- Executar:
```
mvn spring-boot:run
```

- Endpoint:
 ```
  http://localhost:8080/cashMachine/withdraw
```
- Request:
```
{
    
    "value": Dlouble

}
```
- Response:
```
{
    
    {
    "data": [
        {
            "cash": Integer,
            "quantity": Integer
        }
    ],
    "message": String
}

}
```

- URL do h2 Ja tem dados inseridos para teste:
```
localhost:8080/h2-console
```
## Contato


[https://www.linkedin.com/in/rudson-da-fonseca-carriel-68976813a/](https://www.linkedin.com/in/rudson-da-fonseca-carriel-68976813a/)
