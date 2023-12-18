package springdatademo.demo;

import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    void crud(){
        QAccount account = QAccount.account;
        Predicate predicate = account
                .firstName.containsIgnoreCase("jeeun")
                .and(account.lastName.startsWith("kim"));

        Optional<Account> one = accountRepository.findOne(predicate);
        assertThat(one).isEmpty();
    }
}