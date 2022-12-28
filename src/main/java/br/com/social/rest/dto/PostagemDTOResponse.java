package br.com.social.rest.dto;

import br.com.social.model.entity.Postagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostagemDTOResponse {
    private String texto;
    private LocalDateTime data_postagem;

    public static PostagemDTOResponse fromEntity(Postagem postagem) {
        var postagemDTOResponse = new PostagemDTOResponse();
        postagemDTOResponse.setTexto(postagem.getTexto());
        postagemDTOResponse.setData_postagem(postagem.getData_postagem());
        return postagemDTOResponse;
    }
}
