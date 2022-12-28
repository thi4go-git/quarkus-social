package br.com.social.rest.controller;


import br.com.social.rest.dto.UsuarioDTO;
import br.com.social.service.impl.UsuarioServiceImpl;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.transform.Source;
import javax.xml.validation.Validator;

@Path("/usuarios")// Define o caminho da API rest
@Consumes(MediaType.APPLICATION_JSON)// informamos que será consumido o JSON na aplicação.
@Produces(MediaType.APPLICATION_JSON)// a API retornará JSON nas respostas.
public class UsuarioController {

    @Inject
    private UsuarioServiceImpl service;

    @POST
    public Response salvarUser(@Valid UsuarioDTO dto) {

        return service.salvarUser(dto);
    }

    @GET
    public Response listarTodos() {
        return service.listarTodos();
    }

    @DELETE
    @Path("{id}")
    public Response deletarUsuario(@PathParam("id") Long id) {
        return service.deletarUsuario(id);
    }

    @PUT
    @Path("{id}")
    public Response atualizarUsuario(@PathParam("id") Long id, UsuarioDTO dto) {
        return service.atualizarUsuario(id, dto);
    }

}
