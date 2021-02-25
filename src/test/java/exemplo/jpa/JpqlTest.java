package exemplo.jpa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.*;

public class JpqlTest extends Teste {
//SELECT a FROM Jogador a WHERE a.nickname LIKE :nickname ORDER BY a.id
    @Test
    public void quantidadeJogadores() {
        System.out.println("Executando quantidadeJogadores()");
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM Jogador c WHERE c.id IS NOT NULL", Long.class);
        Long resultado = query.getSingleResult();
        System.out.println( "Resultado do Teste:" + resultado);
    }
    
     @Test
    public void quantidadeJogadoresADMs() {
        System.out.println("Executando quantidadeJogadoresADMs()");
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM Administrador c WHERE c.id IS NOT NULL", Long.class);
        Long resultado = query.getSingleResult();
        System.out.println( "Resultado do Teste:" + resultado);
    }
    
    
    @Test
        public void PrimeiroEUltimoCriado(){
        System.out.println("Executando PrimeiroEUltimoLogin()");
        Query query = em.createQuery(
            "SELECT MAX(c.dataCriacao), MIN(c.dataCriacao) FROM Jogador c");
        Object [] resultado = (Object []) query.getSingleResult();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String maiorData = dateFormat.format((Date) resultado[0]);
        String menorData = dateFormat.format((Date) resultado[1]);
        System.out.println(maiorData);
        System.out.println(menorData);
}
        
          @Test
        public void NomeQtdPontosUltimoJogadorLogado(){
            
        System.out.println("Executando NomeQtdPontosUltimoJogadorLogado()");
        Query query = em.createQuery(
            "SELECT c.nickname, c.pontos, c.dataUltimoLogin from Jogador c where c.dataUltimoLogin IN (SELECT MAX(c.dataUltimoLogin) FROM Jogador c)");
        
        Object [] resultado = (Object []) query.getSingleResult();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String nickname =    (String) resultado[0];
        int pontos =   (int) resultado[1];
        String dataUltimoLogin = dateFormat.format((Date) resultado[2]);
        System.out.println("Resultado:" + "Nick: "+nickname+ " Pontos: "+pontos+ " UltimoLogin " +dataUltimoLogin);

}
        
}


 


