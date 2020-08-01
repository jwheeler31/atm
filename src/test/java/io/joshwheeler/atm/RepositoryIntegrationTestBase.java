package io.joshwheeler.atm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.joshwheeler.atm.account.AccountRepository;
import io.joshwheeler.atm.teller.TellerRepository;
import io.joshwheeler.atm.util.DBContents;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO
 *
 * @author jwheeler
 */
public class RepositoryIntegrationTestBase {
  /**
   * Utility class used for parsing yaml.
   */
  protected static DBContents dbContents;

  /**
   * Mock {@link AccountRepository}.
   */
  @Autowired
  protected AccountRepository accountRepository;

  /**
   * Mock {@link TellerRepository}.
   */
  @Autowired
  protected TellerRepository tellerRepository;

  @BeforeAll
  static void beforeAll() throws IOException {
    final String dbYaml = "test-database.yaml";
    final InputStream inputStream = RepositoryIntegrationTestBase.class
        .getClassLoader()
        .getResourceAsStream(dbYaml);
    if (inputStream == null) {
      throw new FileNotFoundException(dbYaml + " file not found");
    }

    final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    dbContents = mapper.readValue(inputStream, DBContents.class);
  }

  /**
   * Populates account repository.
   */
  protected void populateAccounts() {
    accountRepository.saveAll(dbContents.getAccounts());
  }

  /**
   * Populates teller repository.
   */
  protected void populateTeller() {
    tellerRepository.save(dbContents.getTeller());
  }
}
