package io.joshwheeler.atm.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * TODO
 *
 * @author jwheeler
 */
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
public class Account {
  /**
   * The account number.
   */
  @Id
  @NonNull
  private String number;

  /**
   * The account personal identification number.
   */
  @NonNull
  private String pin;

  /**
   * The account balance.
   */
  private double balance;
}
