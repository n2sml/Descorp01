package exemplo.jpa;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class AdministradorValidationTest extends Teste {   
    
    @Test(expected = ConstraintViolationException.class)
    public void persistirAdministradorInvalido(){
        Administrador administrador = null;
        try {
            administrador = new Administrador();
            administrador.setNickname("Eduard0");//Nome inválido (precisa de no minimo 5 caracteres e letras minúsculas)
            administrador.setEmail("email_invalido@");//email inválido
            administrador.setSenha("testesenhainvalida");//senha inválida
            administrador.setDataUltimoLogin(new Date());
            administrador.setDataCriacao(new Date());
           
            em.persist(administrador);
            em.flush();  
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> contraintViolations = ex.getConstraintViolations();
            
            contraintViolations.forEach(violation -> {
                assertThat(violation.getRootBeanClass() + "." + violation.getPropertyPath() + ": " + violation.getMessage(),
                        CoreMatchers.anyOf(
                                startsWith("class exemplo.jpa.Administrador.nickname: Deve possuir letras minúsculas e ao menos 5 caracteres"),
                                startsWith("class exemplo.jpa.Administrador.email: deve ser um endereço de e-mail bem formado"),
                                startsWith("class exemplo.jpa.Administrador.senha: A senha deve possuir pelo menos um caractere de: pontuação, maiúscula, minúscula e número")
                                
                        )    
                );
            });
            assertEquals(3,contraintViolations.size());
//            assertNull(administrador.getId()); 
            throw ex;
        }

    }

}
