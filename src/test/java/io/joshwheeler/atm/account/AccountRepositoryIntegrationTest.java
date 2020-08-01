package io.joshwheeler.atm.account;

import static org.assertj.core.api.Assertions.*;

import io.joshwheeler.atm.RepositoryIntegrationTestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Account repository integration test.
 *
 * @author jwheeler
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class AccountRepositoryIntegrationTest extends RepositoryIntegrationTestBase {
  /**
   * Populates the account repository. Optimize when approaching production.
   */
  @Test
  void testAccountPopulation() {
    assertThat(this.accountRepository).isNotNull();
    this.populateAccounts();

    final Account account1 = accountRepository.findById("2859459814").orElse(null);
    assertThat(account1).isNotNull();
    assertThat(account1.getPin()).isEqualTo("7386");
    assertThat(account1.getBalance()).isEqualTo(10.24);

    final Account account2 = accountRepository.findById("1434597300").orElse(null);
    assertThat(account2).isNotNull();
    assertThat(account2.getPin()).isEqualTo("4557");
    assertThat(account2.getBalance()).isEqualTo(90000.55);

    final Account account3 = accountRepository.findById("7089382418").orElse(null);
    assertThat(account3).isNotNull();
    assertThat(account3.getPin()).isEqualTo("0075");
    assertThat(account3.getBalance()).isEqualTo(0);

    final Account account4 = accountRepository.findById("2001377812").orElse(null);
    assertThat(account4).isNotNull();
    assertThat(account4.getPin()).isEqualTo("5950");
    assertThat(account4.getBalance()).isEqualTo(60);
  }
}
