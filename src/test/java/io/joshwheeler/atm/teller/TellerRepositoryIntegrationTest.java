package io.joshwheeler.atm.teller;

import static org.assertj.core.api.Assertions.*;

import io.joshwheeler.atm.RepositoryIntegrationTestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Teller repository integration test.
 *
 * @author jwheeler
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class TellerRepositoryIntegrationTest extends RepositoryIntegrationTestBase {
  /**
   * Populates the teller repository.
   */
  @Test
  void testTellerPopulation() {
    assertThat(this.tellerRepository).isNotNull();
    this.populateTeller();

    final Iterable<Teller> iterable = tellerRepository.findAll();
    assertThat(iterable).isNotEmpty();
    final Teller teller = iterable.iterator().next();
    assertThat(teller.getId()).isNotNull();
    assertThat(teller.getBalance()).isEqualTo(10000);
  }
}
