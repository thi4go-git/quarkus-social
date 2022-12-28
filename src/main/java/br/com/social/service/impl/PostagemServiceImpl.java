package br.com.social.service.impl;

import br.com.social.model.entity.Postagem;
import br.com.social.model.entity.Usuario;
import br.com.social.model.repository.PostagemRespository;
import br.com.social.model.repository.UsuarioRespository;
import br.com.social.rest.dto.PostagemDTO;
import br.com.social.rest.dto.PostagemDTOResponse;
import br.com.social.service.PostagemService;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Sort;
import org.jboss.logging.annotations.Pos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
public class PostagemServiceImpl implements PostagemService {

    @Inject
    private PostagemRespository postagemRespository;

    @Inject
    private UsuarioRespository usuarioRespository;

    @Override
    @Transactional
    public Response salvarPostagem(Long idUser, PostagemDTO dto) {
        Usuario usuario = usuarioRespository.findById(idUser);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Postagem postagem = new Postagem(dto.getTexto(), usuario);
        postagemRespository.persist(postagem);
        return Response.status(Response.Status.CREATED).build();
    }

    @Override
    public Response listarPostsUser(Long userId) {
        Usuario usuarioAchado = usuarioRespository.findById(userId);
        if (usuarioAchado == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        PanacheQuery<Postagem> lista = postagemRespository.find("usuario", Sort.by("data_postagem", Sort.Direction.Descending), usuarioAchado);

        var listaResposne = lista.stream()
                .map(PostagemDTOResponse::fromEntity)
                .collect(Collectors.toList());

        return Response.ok(listaResposne).build();
    }
}
