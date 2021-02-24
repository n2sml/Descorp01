package exemplo.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "TB_CONSOLE")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Console.porNome",
                    query = "SELECT c FROM Console c WHERE c.nome LIKE :nome ORDER BY c.id"
            )
        }
)
public class Console implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TXT_NOME", length = 15, nullable = false)
    private String nome;

    @Column(name = "NUM_ANO", nullable = false)
    private int ano;

    @Column(name = "TXT_FABRICANTE", length = 15, nullable = false)
    private String fabricante;

    @OneToMany(mappedBy = "console", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jogo> jogos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

}
