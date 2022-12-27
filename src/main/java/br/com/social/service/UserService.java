package br.com.social.service;

import br.com.social.model.entity.User;
import br.com.social.rest.dto.UserDTO;

public interface UserService {
    User salvarUser(UserDTO dto);
}
