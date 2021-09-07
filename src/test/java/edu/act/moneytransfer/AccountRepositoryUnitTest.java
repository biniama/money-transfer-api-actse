package edu.act.moneytransfer;

import edu.act.moneytransfer.repositories.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class AccountRepositoryUnitTest {

    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setup() {
        given(accountRepository.count())
                .willReturn(3L);
    }

    @Test
    public void shouldReturnTheCountOfAccountsInTheDatabase() {
        long count = accountRepository.count();
        assertThat(count).isEqualTo(3L);
    }
}
