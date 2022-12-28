package br.com.social.rest.controller;

import br.com.social.rest.dto.UsuarioDTO;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;



import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestHTTPEndpoint(UsuarioController.class)
class UsuarioControllerTest {

    @Test
    @DisplayName("Deve Criar usuário")
    @Order(1)
    public void criarUsuarioTest() {
        var userDTO = new UsuarioDTO();
        userDTO.setIdade(15);
        userDTO.setNome("Thiago junior");
        //
        var resposta = given()
                .contentType(ContentType.JSON)
                .body(userDTO)
                .when()
                .post()
                .then()
                .extract().response();
        //
        assertEquals(201, resposta.statusCode());
        assertNotNull(resposta.jsonPath().getString("id"));
    }


    @Test
    @DisplayName("deve Listar Todos Usuarios")
    @Order(2)
    public void deveListarTodosUsuarios() {
        var resposta = given()
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .body("size()", Matchers.is(1));
    }

}