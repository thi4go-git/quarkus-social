package br.com.social.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostagemDTO {

    @NotBlank(message = "{campo.texto.obrigatorio}")// verifica se a String é nula ou vazia
    private String texto;
}
