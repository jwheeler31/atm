package io.joshwheeler.atm;

import static org.assertj.core.api.Assertions.*;

import io.joshwheeler.atm.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO
 */
@SpringBootTest
class AtmApplicationTests {
  /**
   * TODO
   */
  @Autowired
  private HomeController controller;

  /**
   * TODO
   */
  @Test
  void contextLoads() {
    assertThat(this.controller).isNotNull();
  }

}
