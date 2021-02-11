package exemplo.jpa;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

public class JogoTeste extends Teste {

    @Test
    public void persistirJogo() {

        //Inserindo um jogo de Nintendo 64
        Console console = em.find(Console.class, 3);
        //Garantindo ter pego o certo
        assertEquals("Nintendo 64", console.getNome());

        Jogo jogo = new Jogo();
        jogo.setNome("007 Goldeneye");
        jogo.setDataLancamento(new Date());
        jogo.setConsole(console);

        em.persist(jogo);
        em.flush();
        System.out.println("JogoTeste - flush");

        assertNotNull(jogo.getId());

        System.out.println("JogoTeste - jogo Id:" + jogo.getId());
    }

    @Test
    public void consultarJogo() {
        System.out.println("JogoTeste - Iniciando consultarJogo");
        //No Dataset, o quarto jogo é o Earthbound
        Jogo jogo = em.find(Jogo.class, 4);
        assertNotNull(jogo);
        assertEquals("Earthbound", jogo.getNome());

        System.out.println("JogoTeste - Terminando consultarJogo");
    }
}
