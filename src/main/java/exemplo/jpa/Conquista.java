package exemplo.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CONQUISTA")
public class Conquista implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TXT_NOME")
    private String nome;

    @Column(name = "TXT_DESCRICAO")
    private String descricao;

    @Column(name = "BYTE_ICONE", nullable = true)
    private byte[] icone;

    @Column(name = "NUM_PONTOS")
    private int pontos;
    
    //A qual jogo pertence    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_JOGO", referencedColumnName = "ID")
    private Jogo jogo;
    
    //O autor da conquista
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ADMINISTRADOR", referencedColumnName = "ID")
    private Administrador administrador;
    

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getIcone() {
        return icone;
    }

    public void setIcone(byte[] icone) {
        this.icone = icone;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    
}
