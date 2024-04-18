package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.entities.UserBuilderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BuilderEntityTest {
    @Test
    public void notRegisterCPFInvalidFormat() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("123456.789-99", "Gleides", LocalDate.parse("1979-12-21"), "gleidev@gmail.com", null)
        );
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("", "Gleides", LocalDate.parse("1979-12-21"), "gleidev@gmail.com", null)
        );
    }

    @Test
    public void mustCreateUserWithUserFactory() {
        var user = new UserBuilderImpl.Builder()
                .withNameCpfBirthDate("Emily", "654.123.897-88", LocalDate.parse("1996-10-20"))
                .build();


        Assertions.assertEquals("Emily", user.getName());

        user = new UserBuilderImpl.Builder()
                .includeAddress("12345-999", 40, "Apto 401")
                .build();

        Assertions.assertEquals("Apto 401", user.getAddress().getComplement());

    }
    @Test
    public void mustNotRegisterUserUnder18YearsAge() {

        // Crio uma data de nascimento que subtrai 17 anos da data atual
        LocalDate birthDate = LocalDate.now().minusYears(17);  // Um usuário com 17 anos

        // Crio uma exceção e atribuo a ela o resultado do teste de idade mínima, pois o correto é que a exceção seja lançada.
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new User("Fulano","123.456.789-00", birthDate, "fulano@example.com", null);
        });

        // Confiro se a mensagem da exceção é a mensagem que eu esperava, referente à idade inferior
        Assertions.assertEquals("Usuário deve ter pelo menos 18 anos de idade!", exception.getMessage());
    }

}
