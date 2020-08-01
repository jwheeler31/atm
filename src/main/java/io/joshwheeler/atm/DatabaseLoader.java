package io.joshwheeler.atm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.joshwheeler.atm.account.AccountRepository;
import io.joshwheeler.atm.teller.TellerRepository;
import io.joshwheeler.atm.util.DBContents;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Utility class to load DB form yaml file; this should not be used in production.
 *
 * @author jwheeler
 */
@Component
public class DatabaseLoader implements CommandLineRunner {
  /**
   * The account repository.
   */
  private final AccountRepository accountRepository;

  /**
   * The teller repository.
   */
  private final TellerRepository tellerRepository;

  /**
   * Constructor.
   *
   * @param accountRepository The account repository.
   * @param tellerRepository The teller repository.
   */
  @Autowired
  public DatabaseLoader(final AccountRepository accountRepository,
      final TellerRepository tellerRepository) {
    this.accountRepository = accountRepository;
    this.tellerRepository = tellerRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    final String testDBFilename = "database.yaml";
    final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    final InputStream inputStream = classLoader.getResourceAsStream(testDBFilename);
    if (inputStream == null) {
      throw new FileNotFoundException(testDBFilename + " file not found");
    }
    final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    final DBContents loader = mapper.readValue(inputStream, DBContents.class);
    accountRepository.saveAll(loader.getAccounts());
    tellerRepository.save(loader.getTeller());
  }
}
