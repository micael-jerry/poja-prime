package com.poja.prime.service;

import java.math.BigInteger;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class PrimeService {

  public BigInteger genPrimeNumber(int nBits) {
    return BigInteger.probablePrime(nBits, new Random());
  }
}
