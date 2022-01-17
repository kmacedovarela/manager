package org.studio.funcionario;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class FuncionarioResourceTest {
    
    @Inject
    FuncionarioRepository repository;

    @Test
    public void funcionarioEndpointExists() {
        given()
            .when().get("/funcionarios")
            .then()
            .statusCode(200);
    }

    @Test
    public void funcionariosListAll() {
        given()
                .when().get("/funcionarios")
                .then()
                .statusCode(200)
                .body("nome", containsInAnyOrder("Karina Varela","Andre Brandão","Hector B.","John Doe","Ian V."));
    }

}
