package br.com.social.service;

import br.com.social.rest.dto.PostagemDTO;

import javax.ws.rs.core.Response;

public interface PostagemService {

    Response salvarPostagem(Long idUser, PostagemDTO dto);

    Response listarPostsUser( Long userId);
}
