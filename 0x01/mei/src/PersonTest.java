package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setup() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.JANUARY, 1); // Ano 2000
        Date birthDate = cal.getTime();

        person = new Person(
                "Diego",
                "Cardoso",
                birthDate,
                true,   // anotherCompanyOwner
                true,   // pensioner
                true    // publicServer
        );

        person.setSalary(1200); // Salário mensal inicial
    }

    @Test
    public void show_full_name() {
        assertEquals("Diego Cardoso", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        assertEquals(14400, person.calculateYearlySalary(), 0.001);
    }

    @Test
    public void person_is_MEI() {
        // Ajusta os dados para tornar a pessoa elegível
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setSalary(10000 / 12f); // Salário anual < 130000

        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        // Salário alto para não ser MEI
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setSalary(15000); // anual > 130000

        assertFalse(person.isMEI());
    }
}
