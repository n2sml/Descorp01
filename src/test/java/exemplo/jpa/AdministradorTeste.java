package exemplo.jpa;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdministradorTeste extends Teste {

    @Test
    public void persistirAdministrador() {
        Administrador administrador = new Administrador();
        administrador.setNickname("adminMortalKombat");
        administrador.setEmail("admin@mk.com");
        administrador.setSenha("M0RT4LK0MB4T");
        administrador.setDataCriacao(new Date());
        administrador.setDataUltimoLogin(new Date());
        em.persist(administrador);
        em.flush();

        assertNotNull(administrador.getId());
    }

    @Test
    public void consultarAdministrador() {
        Administrador administrador = em.find(Administrador.class, 4);
        assertNotNull(administrador);       
        assertEquals("mestresonic", administrador.getNickname());
        assertEquals("mastersonic@google.com", administrador.getEmail());
        assertEquals("sonic1234", administrador.getSenha());
    }
}
