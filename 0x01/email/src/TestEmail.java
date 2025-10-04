import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteEmail {

    @Test
    public void testar_email_com_arroba() {
        boolean resultado = Pessoa.emailValid("email_teste@dominio.com.br");
        assertTrue(resultado, "O email com '@' deve ser considerado válido");
    }

    @Test
    public void testar_email_sem_arroba() {
        boolean resultado = Pessoa.emailValid("email_testedominio.com.br");
        assertFalse(resultado, "O email sem '@' deve ser considerado inválido");
    }

    @Test
    public void testar_email_mais_50_caracteres() {
        String emailLongo = "email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br";
        boolean resultado = Pessoa.emailValid(emailLongo);
        assertEquals(false, resultado, "O email com mais de 50 caracteres deve ser inválido");
    }
}
