package br.com.social.service;


import br.com.social.rest.dto.UsuarioDTO;

import javax.ws.rs.core.Response;

public interface UsuarioService {
    Response salvarUser(UsuarioDTO dto);
}
