package exemplo.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_USUARIO")
@Inheritance(strategy = InheritanceType.JOINED) 
@DiscriminatorColumn(name = "DISC_USUARIO", 
        discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    
    @Column(name = "TXT_NICKNAME")
    protected String nickname;
    
    @Column(name = "TXT_EMAIL")
    protected String email;
    
    @Column(name = "TXT_SENHA")
    protected String senha;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_CRIACAO", nullable = true)
    protected Date dataCriacao;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_ULTIMO_LOGIN", nullable = true)
    protected Date dataUltimoLogin;
    


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;

        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        sb.append(", ");
        sb.append(this.nickname);

        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataUltimoLogin() {
        return dataUltimoLogin;
    }

    public void setDataUltimoLogin(Date dataUltimoLogin) {
        this.dataUltimoLogin = dataUltimoLogin;
    }


}
