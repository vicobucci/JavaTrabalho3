package senac.trabalho.biblioteca.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "edicoes")
public class Edicao {
    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "ano")
    private Short ano;

    @Column(name = "quantidadeestoque")
    private short quantidadeEstoque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "editora_codigo")
    private Editora editora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_codigo")
    private Livro livro;
}