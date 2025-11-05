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

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    public Lingua getLingua() {
        return lingua;
    }

    public void setLingua(Lingua lingua) {
        this.lingua = lingua;
    }

    public List<Edicao> getEdicoes() {
        return edicoes;
    }

    public void setEdicoes(List<Edicao> edicoes) {
        this.edicoes = edicoes;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }
}