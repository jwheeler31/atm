package io.joshwheeler.atm;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * TODO
 *
 * @author jwheeler
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
  /**
   * TODO
   */
  @LocalServerPort
  private int port;

  /**
   * TODO
   */
  @Autowired
  private TestRestTemplate restTemplate;

  /**
   * TODO
   */
  @Test
  public void greetingShouldReturnDefaultMessage() {
    Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
        .contains("Hello, World");
  }
}
