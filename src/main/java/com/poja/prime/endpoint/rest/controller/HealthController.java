package com.poja.prime.endpoint.rest.controller;

import static java.util.UUID.randomUUID;

import com.poja.prime.PojaGenerated;
import com.poja.prime.endpoint.event.EventProducer;
import com.poja.prime.endpoint.event.gen.UuidCreated;
import com.poja.prime.repository.DummyRepository;
import com.poja.prime.repository.DummyUuidRepository;
import com.poja.prime.repository.model.Dummy;
import com.poja.prime.repository.model.DummyUuid;
import com.poja.prime.util.Prime;
import java.util.List;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@PojaGenerated
@RestController
@Value
public class HealthController {

  DummyRepository dummyRepository;
  DummyUuidRepository dummyUuidRepository;
  EventProducer eventProducer;
  Prime prime;

  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  @GetMapping("/new-prime")
  public int newPrime() {
    return prime.genPrimeNumber();
  }

  @GetMapping("/dummy-table")
  public List<Dummy> dummyTable() {
    return dummyRepository.findAll();
  }

  @GetMapping(value = "/uuid-created")
  public String uuidCreated() throws InterruptedException {
    var randomUuid = randomUUID().toString();
    var event = new UuidCreated().toBuilder().uuid(randomUuid).build();

    eventProducer.accept(List.of(event));

    Thread.sleep(20_000);
    return dummyUuidRepository.findById(randomUuid).map(DummyUuid::getId).orElseThrow();
  }
}
