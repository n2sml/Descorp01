package exemplo.jpa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    exemplo.jpa.AdministradorTeste.class,
    exemplo.jpa.ConquistaTeste.class,
    exemplo.jpa.ConsoleTeste.class,
    exemplo.jpa.JogadorTeste.class,
    exemplo.jpa.JogoTeste.class,
})
public class TesteSuite {
    
}