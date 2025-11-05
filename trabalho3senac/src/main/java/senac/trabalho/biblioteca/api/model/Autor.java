package senac.trabalho.biblioteca.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    @Column(name = "notabiografica")
    private String notaBiografica;

    @Column(name = "sexo")
    private Character sexo;

    @ManyToOne
    @JoinColumn(name = "pais_codigo")
    private Pais pais;

    @ManyToMany(mappedBy = "autores")
    @JsonIgnore
    private Set<Livro> livros;
}