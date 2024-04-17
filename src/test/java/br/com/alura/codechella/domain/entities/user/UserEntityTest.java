package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserEntityTest {
    @Test
    public void notRegisterCPFInvalidFormat() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new UserEntity("123456.789-99", "Gleides", LocalDate.parse("1979-12-21"), "gleidev@gmail.com", null)
        );
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new UserEntity("", "Gleides", LocalDate.parse("1979-12-21"), "gleidev@gmail.com", null)
        );
    }

    @Test
    public void mustCreateUserWithUserFactory() {
        var userBuilder = new User.UserBuilder();
        userBuilder.withNameCpfBirthDate("Emily", "654.123.897-88", LocalDate.parse("1996-10-20"));
        var user = userBuilder.build();


//        Assertions.assertEquals("Emily", user.getName());

//        user = userBuilder.includeAddress("12345-999", 40, "Apto 401");
//
//        Assertions.assertEquals("Apto 401", user.getAddress().getComplement());

    }
}
