package com.poja.prime.endpoint.rest.controller;

import com.poja.prime.service.PrimeService;
import java.math.BigInteger;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Value
public class PrimeController {
  PrimeService primeService;

  @GetMapping("/new-prime")
  public BigInteger newPrime() {
    return primeService.genPrimeNumber(10_000);
  }
}
