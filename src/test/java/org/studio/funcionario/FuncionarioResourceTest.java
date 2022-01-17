package org.studio.funcionario;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class FuncionarioResourceTest {
    
    @Inject
    FuncionarioRepository repository;

    @Test
    @DisplayName("Deveria retornar HTTP 200 ao listar todos")
    public void pingTest() {
        given().
        when().
                get("/funcionarios").
        then().
                statusCode(200);
    }

    @Test
    @DisplayName("Deveria listar todos")
    public void shouldListAll() {
        given().
        when().
                get("/funcionarios").
        then().
                statusCode(200).
                body(
                        "nome", containsInAnyOrder("Karina Varela","Andre Brandão","Hector B.","John Doe","Ian V.")
                );
    }

    @Test
    @DisplayName("Deveria retornar HTTP 201 ao persistir com sucesso")
    public void shouldSave() {
        Funcionario novoFuncionario = new Funcionario("Rodolpo", "6198877665", "Rua 24 Casa 25", "CREF 024025-G/DF");

        given().
            contentType(ContentType.JSON).
            body(novoFuncionario).
        when().
            post( "/funcionarios/").
        then().
            statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    @DisplayName("Deveria persistir e retornar funcionario")
    public void shouldReturnSavedFuncionario() {
        Funcionario novoFuncionario = new Funcionario("Leobélio", "61988888999", "Rua 24 Casa 24", "CREF 024024-G/DF");

        given().
            contentType(ContentType.JSON).
            body(novoFuncionario).
        when().
            post( "/funcionarios/").
        then().
            statusCode(HttpStatus.SC_CREATED). //http code 201
            body(
                "nome", is(novoFuncionario.getNome()),
                "endereco",is(novoFuncionario.getEndereco()),
                "telefone",is(novoFuncionario.getTelefone()),
                "cref", is(novoFuncionario.getCref()),
                "id", notNullValue()
            );
    }

    @Test
    @DisplayName("Deveria buscar funcionario por cref")
    public void shouldFindByCref() {
        Funcionario funcionario = repository.findAll().firstResult();

        given().
            queryParam("cref", funcionario.getCref()).
        when().
            get( "/funcionarios/").
        then().
            statusCode(HttpStatus.SC_OK). //http code 200
            body(
                "nome", is(funcionario.getNome()),
                "cref", is(funcionario.getCref())
        );

    }
}
