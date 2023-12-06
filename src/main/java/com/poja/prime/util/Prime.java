package com.poja.prime.util;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class Prime {

  public boolean isPrime(int nbr) {
    if (nbr <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(nbr); i++) {
      if (nbr % i == 0) {
        return false;
      }
    }
    return true;
  }

  public int genPrimeNumber() {
    Random random = new Random();
    int primeNumber = random.nextInt(Integer.MAX_VALUE) + 1;
    while (!isPrime(primeNumber)) {
      primeNumber = random.nextInt(Integer.MAX_VALUE) + 1;
    }
    return primeNumber;
  }
}
