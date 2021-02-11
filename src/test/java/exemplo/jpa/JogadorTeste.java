package exemplo.jpa;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class JogadorTeste extends Teste {

    @Test
    public void persistirJogador() {
        Jogador jogador = new Jogador();
        jogador.setNickname("niicolas123");
        jogador.setEmail("nicolas@teste.com");
        jogador.setSenha("doom666");
        jogador.setDataCriacao(new Date());
        jogador.setDataUltimoLogin(new Date());
        jogador.setPontos(666);
        em.persist(jogador);
        em.flush();

        assertNotNull(jogador.getId());
    }

    @Test
    public void consultarJogador() {
        Jogador jogador = em.find(Jogador.class, 1);
        assertNotNull(jogador);
       
        assertEquals("zxasddd", jogador.getNickname());
        assertEquals("zxasddd@gmail.com", jogador.getEmail());
        assertEquals("megadrive", jogador.getSenha());
        assertEquals(1000, jogador.getPontos());
    }
}
