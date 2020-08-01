package io.joshwheeler.atm.util;

import io.joshwheeler.atm.account.Account;
import io.joshwheeler.atm.teller.Teller;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

/**
 * Wrapper class used by {@link io.joshwheeler.atm.DatabaseLoader} to simplify
 * loading the database. Not used in a production environment.
 *
 * @author jwheeler
 */
@Getter
@ToString
public class DBContents {
  /**
   * List of accounts.
   */
  private List<Account> accounts;

  /**
   * The teller.
   */
  private Teller teller;
}
