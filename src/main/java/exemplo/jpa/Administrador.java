package exemplo.jpa;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ADMINISTRADOR")
@DiscriminatorValue(value = "A")
@PrimaryKeyJoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
public class Administrador extends Usuario implements Serializable {

    @Override
    public String toString() {
        return "ToStringAdmin[ id=" + id + " ]";
    }

}
