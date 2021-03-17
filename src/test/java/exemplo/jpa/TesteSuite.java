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
    exemplo.jpa.JogadorValidationTest.class,
    exemplo.jpa.AdministradorValidationTest.class,
    exemplo.jpa.ConquistaValidationTest.class,
})
public class TesteSuite {
    
}