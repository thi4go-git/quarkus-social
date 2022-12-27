package br.com.social.rest.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/users")// Define o caminho da API rest
public class UserController {

    @POST
    public Response salvarUser() {
        return null;
    }

}
