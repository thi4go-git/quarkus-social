package br.com.social.model.repository;

import br.com.social.model.entity.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped//Cria uma instancia do Repositorio no contexto para ser Injetado.
public class UsuarioRespository implements PanacheRepository<Usuario> {

}
