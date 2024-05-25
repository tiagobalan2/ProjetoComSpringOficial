## Projeto acadêmico desenvolvido por: Tiago Leomil Balan, Lucas Leonardo Sambati e Miguel Mazini Bonilha
# API de Veículos

Esta é uma API de veículos desenvolvida em Java utilizando Spring Boot. Ela oferece operações CRUD (Criar, Ler, Atualizar, Deletar) para carros, ônibus e bicicletas, bem como outras funcionalidades específicas, como listar por marca e por filtro de preço.

## Endpoints

### Carros

- **GET /carros**: Lista todos os carros.
- **GET /carros/{id}**: Retorna um carro específico pelo ID.
- **POST /carros**: Cria um novo carro.
- **PUT /carros/{id}**: Atualiza as informações de um carro existente pelo ID.
- **DELETE /carros/{id}**: Deleta um carro existente pelo ID.
- **GET /carros/marca/{marca}**: Lista carros por uma marca específica.
- **GET /carros/precoMaiorQue10K**: Lista carros com preço maior que $10,000.

### Ônibus

- **GET /onibus**: Lista todos os ônibus.
- **GET /onibus/{id}**: Retorna um ônibus específico pelo ID.
- **POST /onibus**: Cria um novo ônibus.
- **PUT /onibus/{id}**: Atualiza as informações de um ônibus existente pelo ID.
- **DELETE /onibus/{id}**: Deleta um ônibus existente pelo ID.
- **GET /onibus/marca/{marca}**: Lista ônibus por uma marca específica.
- **GET /onibus/precoMaiorQue10K**: Lista ônibus com preço maior que $10,000.

### Bicicletas

- **GET /bicicletas**: Lista todas as bicicletas.
- **GET /bicicletas/{id}**: Retorna uma bicicleta específica pelo ID.
- **POST /bicicletas**: Cria uma nova bicicleta.
- **PUT /bicicletas/{id}**: Atualiza as informações de uma bicicleta existente pelo ID.
- **DELETE /bicicletas/{id}**: Deleta uma bicicleta existente pelo ID.
- **GET /bicicletas/marca/{marca}**: Lista bicicletas por uma marca específica.
- **GET /bicicletas/precoMaiorQue10K**: Lista bicicletas com preço maior que $10,000.


## Exemplos de Uso

### Listar Carros por Marca
GET /carros/marca/Ford
Retorna todos os carros da marca Ford.

### Listar Carros com Preço Maior que $10,000
GET /carros/precoMaiorQue10K
Retorna todos os carros com preço maior que $10,000.

## Como Executar

1. Clone este repositório para sua máquina local.
2. Importe o projeto em sua IDE preferida.
3. Certifique-se de ter o Java e o Spring Boot configurados.
4. Execute a aplicação. O banco de dados utilizado é o H2, um banco de dados temporário em memória.
5. Acesse os endpoints conforme documentado acima.

## Contato

Se você tiver alguma dúvida ou feedback sobre esta API, sinta-se à vontade para entrar em contato comigo.
