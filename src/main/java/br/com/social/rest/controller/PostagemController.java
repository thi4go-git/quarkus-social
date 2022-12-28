package br.com.social.rest.controller;

import br.com.social.rest.dto.PostagemDTO;
import br.com.social.service.PostagemService;
import br.com.social.service.impl.PostagemServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/usuarios/{userId}/posts")// Define o caminho da API rest
@Consumes(MediaType.APPLICATION_JSON)// informamos que será consumido o JSON na aplicação.
@Produces(MediaType.APPLICATION_JSON)// a API retornará JSON nas respostas.
public class PostagemController {

    @Inject
    private PostagemServiceImpl postagemService;

    @POST
    public Response salvarPostagem(
            @PathParam("userId") Long userId, PostagemDTO dto
    ) {
        return postagemService.salvarPostagem(userId, dto);
    }

    @GET
    public Response listarTodos(@PathParam("userId") Long userId) {
        return postagemService.listarPostsUser(userId);
    }

}
