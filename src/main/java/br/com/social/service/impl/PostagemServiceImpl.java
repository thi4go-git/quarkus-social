package br.com.social.service.impl;

import br.com.social.model.repository.PostagemRespository;
import br.com.social.model.repository.UsuarioRespository;
import br.com.social.rest.dto.PostagemDTO;
import br.com.social.service.PostagemService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class PostagemServiceImpl implements PostagemService {

    @Inject
    private PostagemRespository postagemRespository;

    @Inject
    private UsuarioRespository usuarioRespository;

    @Override
    public Response salvarPostagem(PostagemDTO dto) {
        return null;
    }
}
