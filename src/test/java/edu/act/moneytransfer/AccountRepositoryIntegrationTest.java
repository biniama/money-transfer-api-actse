package edu.act.moneytransfer;

import edu.act.moneytransfer.domains.Account;
import edu.act.moneytransfer.repositories.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class AccountRepositoryIntegrationTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void shouldCreateAnAccountInDB() {

        // Without using Builder pattern
//        Account account = new Account();
//        account.setFirstName("Biniam");
//        account.setMiddleName("Asnake");
//        account.setLastName("Kefale");

        // Builder pattern (@Builder)
        // GIVEN
        Account account = Account.builder()
                .firstName("John")
                .middleName("Doe")
                .lastName("Smith")
                .dateOfBirth(LocalDate.of(2000, 01, 01))
                .phoneNumber("12345555")
                .email("john@doe.com")
                .pin(1234)
                .build();

        // WHEN
        Account savedAccount = accountRepository.save(account);

        // THEN
        assertThat(savedAccount).isNotNull();
        assertThat(savedAccount.getId()).isEqualTo(1);

        assertThat(savedAccount.getFirstName()).isEqualTo("John");
        assertThat(savedAccount.getFirstName()).isEqualTo(account.getFirstName());
    }
}
