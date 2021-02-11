package exemplo.jpa;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConsoleTeste extends Teste {

    @Test
    public void persistirConsole() {
        System.out.println("ConsoleTeste - Iniciando persistirConsole");
        Console console = new Console();
        console.setNome("PlayStation 2");
        console.setFabricante("Sony");
        console.setAno(1999);

        em.persist(console);
        em.flush();
        System.out.println("ConsoleTeste - persistirConsole flush");

        assertNotNull(console.getId());

        System.out.println("ConsoleTeste - console Id:" + console.getId());
        System.out.println("ConsoleTeste - Terminando persistirConsole");
    }

    @Test
    public void consultarConsole() {
        System.out.println("ConsoleTeste - Iniciando consultarConsole");
        //No Dataset, o primeiro console é o Mega Drive
        Console console = em.find(Console.class, 1);
        assertNotNull(console);
        assertEquals("Mega Drive", console.getNome());
        assertEquals("Sega", console.getFabricante());

        System.out.println("ConsoleTeste - Terminando consultarConsole");
    }
}
