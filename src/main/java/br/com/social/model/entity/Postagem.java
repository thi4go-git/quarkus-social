package br.com.social.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String texto;

    @Column
    private LocalDateTime data_postagem;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private Usuario usuario;

    public Postagem(String texto, Usuario usuario) {
        this.texto = texto;
        this.usuario = usuario;
        this.data_postagem = LocalDateTime.now();
    }

}
