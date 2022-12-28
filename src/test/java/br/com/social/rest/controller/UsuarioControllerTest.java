package br.com.social.rest.controller;

import br.com.social.rest.dto.UsuarioDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UsuarioControllerTest {

    @Test
    @DisplayName("Deve Criar usuário POST")
    public void criarUsuarioTest() {
        var userDTO = new UsuarioDTO();
        userDTO.setIdade(15);
        userDTO.setNome("Thiago junior");
        //
        var resposta = given()
                .contentType(ContentType.JSON)
                .body(userDTO)
                .when()
                .post("/usuarios")
                .then()
                .extract().response();
        //
        assertEquals(201, resposta.statusCode());
        assertNotNull(resposta.jsonPath().getString("id"));
    }

}