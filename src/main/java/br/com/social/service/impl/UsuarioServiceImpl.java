package br.com.social.service.impl;

import br.com.social.model.entity.Usuario;
import br.com.social.model.repository.UsuarioRespository;
import br.com.social.rest.dto.UsuarioDTO;
import br.com.social.service.UsuarioService;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioRespository usuarioRespository;

    @Override
    @Transactional
    public Response salvarUser(UsuarioDTO dto) {
        Usuario user = new Usuario(dto.getNome(), dto.getIdade());
        usuarioRespository.persist(user);
        return Response.ok(user).build();
    }

    @Override
    public Response listarTodos() {
        PanacheQuery<Usuario> lista = usuarioRespository.findAll();
        return Response.ok(lista.list()).build();
    }

    @Override
    @Transactional
    public Response deletarUsuario(Long id) {

        usuarioRespository.
                findByIdOptional(id)
                .map(cliente -> {
                    usuarioRespository.delete(cliente);
                    return Response.ok(cliente).build();
                });
        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @Override
    @Transactional
    public Response atualizarUsuario(Long id, UsuarioDTO dto) {
        usuarioRespository.
                findByIdOptional(id)
                .map(cliente -> {
                    cliente.setIdade(dto.getIdade());
                    cliente.setNome(dto.getNome());
                    return Response.ok(cliente).build();
                });
        return Response.status(Response.Status.NOT_FOUND).build();
    }


}
