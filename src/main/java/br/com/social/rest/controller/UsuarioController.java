package br.com.social.rest.controller;

import br.com.social.model.entity.Usuario;
import br.com.social.rest.dto.UsuarioDTO;
import br.com.social.service.impl.UsuarioServiceImpl;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")// Define o caminho da API rest
@Consumes(MediaType.APPLICATION_JSON)// informamos que será consumido o JSON na aplicação.
@Produces(MediaType.APPLICATION_JSON)// a API retornará JSON nas respostas.
public class UsuarioController {

    @POST
    @Transactional
    public Response salvarUser(UsuarioDTO dto) {
        System.out.println(dto.toString());
        Usuario user = new Usuario(dto.getNome(), dto.getIdade());
        user.persist();
        return Response.ok(user).build();
    }

 
}
