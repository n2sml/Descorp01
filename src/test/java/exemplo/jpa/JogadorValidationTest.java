package exemplo.jpa;

import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class JogadorValidationTest extends Teste {
   /*  
    @Test (expected = ConstraintViolationException.class)
 public void persistirJogadorInvalido(){
    Jogador jogador = null;
   
        try {
            jogador = new Jogador();
            jogador.setNickname("AA");//nome Inválido   
            jogador.setEmail("aaa@");//email inválido
            jogador.setSenha("teste");//senha inválida
            em.persist(jogador);
            em.flush();  
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> contraintViolations = ex.getConstraintViolations();
            
            contraintViolations.forEach(violation -> {
                assertThat(violation.getRootBeanClass() + "." + violation.getPropertyPath() + ": " + violation.getMessage(),
                        CoreMatchers.anyOf(
                                startsWith("class exemplo.jpa.Jogador.nickname: Deve possuir mais de 3 letra"),
                                startsWith("class exemplo.jpa.Jogador.email: email válido"),
                                startsWith("class exemplo.jpa.Jogador.senha: Deve possuir de 8 a 12 caracteres")
                        )    
                );
            });
            assertEquals(3,contraintViolations.size());
            assertNull(jogador.getId()); 
            throw ex;
        }

    }
*/
}
