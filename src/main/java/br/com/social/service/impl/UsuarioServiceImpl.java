package br.com.social.service.impl;

import br.com.social.model.entity.Usuario;
import br.com.social.rest.dto.UsuarioDTO;
import br.com.social.service.UsuarioService;

import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

public class UsuarioServiceImpl implements UsuarioService {

    @Override
    @Transactional
    public Response salvarUser(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto.getNome(), dto.getIdade());
        usuario.persist();
        return Response.ok(usuario).build();
    }
}
