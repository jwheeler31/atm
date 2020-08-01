package io.joshwheeler.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 *
 * @author jwheeler
 */
@Controller
public class HomeController {
  /**
   * TODO
   *
   * @return
   */
  @RequestMapping("/")
  @ResponseBody
  public String greeting() {
    return "Hello, World!";
  }
}
