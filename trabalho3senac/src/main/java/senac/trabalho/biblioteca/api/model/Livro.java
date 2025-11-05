package senac.trabalho.biblioteca.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "titulo")
    private String titulo; // Corrigido para String

    @Column(name = "ano")
    private Short ano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lingua_codigo")
    private Lingua lingua;

    @OneToMany(mappedBy = "livro")
    @JsonIgnore
    private List<Edicao> edicoes;

    @ManyToMany
    @JoinTable(
            name = "autores_livros",
            joinColumns = @JoinColumn(name = "livro_codigo"),
            inverseJoinColumns = @JoinColumn(name = "autor_codigo")
    )
    private Set<Autor> autores;

}