# Desafio

## Cenário

No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação. A partir disso, você precisa criar uma solução back-end para gerenciar essas sessões de votação. Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de uma API REST:

É importante que as pautas e os votos sejam persistidos e que não sejam perdidos com o restart da aplicação.

## APIs

- Cadastrar uma nova pauta;
- Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default);
- Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta);
- Contabilizar os votos e dar o resultado da votação na pauta.
- Para fins de exercício, a segurança das interfaces pode ser abstraída e qualquer chamada para as interfaces pode ser considerada como autorizada. A escolha da linguagem, frameworks e bibliotecas é livre (desde que não infrinja direitos de uso).

* Bonus:
    - Tópicos e mensagens com rabbitmq [IMPLEMENTADO];
    - Scheduled Jobs com Spring Schedule [IMPLEMENTADO];
    - Criteria API [NÃO-IMPLEMENTADO];
    - Testes unitários (Mockito e JUnit) e testes integrados (RestAssured + TestContainer) [NÃO-IMPLEMENTADO];

## Instruções de execução e uso da aplicação

- Para este projeto, o uso de docker-containers foi utilizado para estabelecer um "ambiente" integrado entre as tecnologias MySQL, Spring Boot e RabbitMQ.

1) Buildar o snapshot da aplicação em Spring Boot (rodar na pasta raiz do projeto)

```
mvn clean package install
```

2) Instalando o docker-compose | * obs: Este passo somente é necessário caso o Docker-Compose ainda não esteja instalado em sua máquina.

```
sudo curl -L "https://github.com/docker/compose/releases/download/1.25.5/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose
```

3) Executando ambiente integrado utilizando o Docker-Compose | * Atenção: executar este comando na pasta raíz do projeto.

```
docker-compose -f environment.yml up -d --build
```

- Após subir o ambiente, é possível encontrar a documentação das APIs da aplicação através da URL: `http://localhost:8080/swagger-ui.html`.
- Para verificar o status das filas, acessar URL: `http://localhost:15672/#/queues`. 
- Para estabelecer uma conexão com o banco de dados utilizando uma ferramenta (Dbeaver, Squirrel), abra uma conexão para a URL `http://localhost:13306` com as credenciais root/root.

### ENDPOINTS

#### Criar Pauta

``POST http://localhost:8080/api/v1/scores``

Criação de uma nova pauta.

* name: Nome da pauta.
* subject: Assunto (tema) da pauta.

JSON de criação:
`{
    "name": ?,
    "subject": ?
}`

JSON de resposta:
`{
  "id": "?",
  "name": "?",
  "subject": "?"
}`

#### Abrir Pauta

``POST http://localhost:8080/api/v1/scores/open``

Abertura de uma pauta para receber votações.

* durationInMinutes: Tempo em minutos para a pauta permanecer aberta.
* scoreId: Identificador único da pauta.

JSON de criação:
`{
   durationInMinutes": ?,
  "scoreId": "?"
}`

* openAt: Data de abertura da pauta;
* closeAt: Data prevista para fechamento da pauta;

JSON de resposta:
`{
  "id": "3144f957-8677-4256-9eb8-d6943c119f68",
  "openAt": "2020-06-02T21:00:44.445",
  "closeAt": "2020-06-02T21:10:44.445"
}`

#### Votar em uma Pauta

``POST http://localhost:8080/api/v1/score-votes``

Enviar voto para uma pauta.

* agreed: Voto do usuário representado por um booleano (TRUE/FALSE), ou seja, se concorda ou não com o tema da pauta.
* federalIdentification: CPF do associado.
* scoreId: Identificador único da pauta. 

JSON de criação:
`{
  "agreed": true/false,
  "federalIdentification": "?",
  "scoreId": "?"
}`

* name: Nome da pauta.
* subject: Assunto (tema) da pauta.

JSON de resposta:
`{
  "id": "?",
  "name": "?",
  "subject": "?"
}`

#### Obter resultado de todas as pautas

``POST http://localhost:8080/api/v1/scores-close/find-all``

Lista o resultado das pautas criadas.

* scoreName: Nome da pauta.
* scoreSubject: Assunto (tema) da pauta.
* closeAt: Data de fechamento da pauta.
* agreedResult: Quantidade de votos do tipo SIM.
* denyResult: Quantidade de votos do tipo NÃO.
* approved: Booleano responsável por indicar se a pauta foi aprovada ou não. Caso o número de votos da pauta seja = 0, este parâmetro é nulo.

JSON de resposta:
`{
  "items": [
    {
      "scoreName": "?",
      "scoreSubject": "?",
      "closeAt": "?",
      "agreedResult": ?,
      "denyResult": ?,
      "approved": ?
    }
  ]
}`

#### Obter resultado de uma pauta por identificador

``POST http://localhost:8080/api/v1/scores-close/find-by-score/{id}``

* Parâmetro {id}: identificador único da pauta.

* scoreName: Nome da pauta.
* scoreSubject: Assunto (tema) da pauta.
* closeAt: Data de fechamento da pauta.
* agreedResult: Quantidade de votos do tipo SIM.
* denyResult: Quantidade de votos do tipo NÃO.
* approved: Booleano responsável por indicar se a pauta foi aprovada ou não. Caso o número de votos da pauta seja = 0, este parâmetro é nulo.

JSON de resposta:
`{
  "items": [
    {
      "scoreName": "?",
      "scoreSubject": "?",
      "closeAt": "?",
      "agreedResult": ?,
      "denyResult": ?,
      "approved": ?
    }
  ]
}`
