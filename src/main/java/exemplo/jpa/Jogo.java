package exemplo.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "TB_JOGO")
public class Jogo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*
      Cada jogo pertence a um console.
      Embora existam exemplos de jogos que sairam pra mais de um console,
      as conquistas não necessariamente são as mesmas.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CONSOLE", referencedColumnName = "ID")
    private Console console;

    @OneToMany(mappedBy = "jogo", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conquista> conquistas;

    @Column(name = "TXT_NOME", nullable = false)
    protected String nome;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_LANCAMENTO", nullable = true)
    protected Date dataLancamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public List<Conquista> getConquistas() {
        return conquistas;
    }

    public void setConquistas(List<Conquista> conquistas) {
        this.conquistas = conquistas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }    
}
