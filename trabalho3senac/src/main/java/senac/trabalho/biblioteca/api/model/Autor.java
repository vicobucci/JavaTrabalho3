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

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNotaBiografica() {
        return notaBiografica;
    }

    public void setNotaBiografica(String notaBiografica) {
        this.notaBiografica = notaBiografica;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Set<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Set<Livro> livros) {
        this.livros = livros;
    }
}