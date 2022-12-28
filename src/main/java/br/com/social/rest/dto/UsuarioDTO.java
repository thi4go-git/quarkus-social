package br.com.social.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO   {

    @NotBlank(message = "{campo.nome.obrigatorio}")// verifica se a String é nula ou vazia
    private String nome;

    @NotNull(message = "{campo.idade.nullo}")
    private Integer idade;


}
