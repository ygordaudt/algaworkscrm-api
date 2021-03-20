<h2>Sistema de gerenciamento de clientes desenvolvido em API REST com o framework Spring Boot e persistência em memória com H2 DataBase</h2>

Este sistema foi desenvolvido com o intuito de estudar as referidas tecnologias de Java durante um treinamento realizado pelo AlgaWorks.

Passo a Passo:

1) Criar novo projeto Spring Innitializer

2) Deve conter as opções/FACETS marcadas:
   Spring Boot / DevTools
   Spring Web
   Spring Data JPA (ajuda a criar repositórios para comunicação com o banco de dados)

2.1) adicionar as dependencias do banco de dados em pom.xml

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>


3) Criar os pacotes model, controller e repository em SRC\MAIN\JAVA\COM....
   Em seguida, criar as classes Cliente, ClienteController e ClienteRepository (interface) nas respectivas pastas

4) Na classe controller, Adicionar as anotações:

na classe:
@RestController (vai dizer que é uma classe que vai receber requisições para os endpoints);
@RequestMapping("/clientes") (vai mapear os endpoints para receber as requisições com /clientes);

nos métodos:
@GetMapping (adicionar no método que vai responder a requisição GET da uri @RequestMapping

Quando um método vai receber algo no Body, a anotação @RequestBody deverá ser informada dentro do parâmetro do método.
Ex:
@PostMapping // método POST
@ResponseStatus(HttpStatus.CREATED) // ResponseStatus a ser retornado
public Cliente adicionar(@RequestBody Cliente cliente) {
return clienteRepository.save(cliente);
}


5) Na classe model Cliente

adicionar a anotação @Entity na classe (se ficar vermelho, passar o mouse em cima e marcar a opção de baixar o JPA)

adicionar as anotações @Id e     @GeneratedValue(strategy = GenerationType.IDENTITY) nos atributos, sendo este último para dizer que a responsabilidade de autoincremento será pelo banco de dados

bem como o @Column(nullable = false). Este não é necessário, mas pode-se fazer para facilitar o entendimento das tabelas do banco de dados

Gerar os gets and setters dos atributos, bem como o hascode para o id.
Tem a opção de utilizar o plugin Lombok para não precisar digitar os gets and setters, e tal. Ao instalar, é só usar a anotação @Data na classe, instalar e pronto

6) a interface ClienteRepository deve estender o JpaRepository<Cliente, Long> e ter a anotação @Repository.

Em seguida, adicionar um objeto ClienteRepository com a anotação @Autowired na classe ClienteController.java
Isso irá criar uma instância da implementação em tempo de execução da interface e funcionará como uma injeção de dependência, pondendo realizar as operações JPA pelo objeto clienteRepository.

No término, deverá ser exportado o arquivo JAR do projeto através de:

Build -> Build Artifacts, selecionar o seu jar e a opção build.

O arquivo será gerado na pasta out/artifacts/.

Para executar, utilizar o comando:
java -jar <nome do seu projeto>

Obs: Deverá se atentar à versão JAVA configurada nas variáveis de ambiente.

Dicas:
1) Adicionar o comando spring.jpa.show-sql=true em src\main\resources\application.properties para exibir o log de comandos SQL executados durante as requisições REST.




