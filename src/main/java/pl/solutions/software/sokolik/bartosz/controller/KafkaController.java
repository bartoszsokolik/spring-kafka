package pl.solutions.software.sokolik.bartosz.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.solutions.software.sokolik.bartosz.service.KafkaProducerService;

@RestController
@RequestMapping("/api/message")
public class KafkaController {

  private final KafkaProducerService kafkaProducerService;

  public KafkaController(KafkaProducerService kafkaProducerService) {
    this.kafkaProducerService = kafkaProducerService;
  }

  @ResponseStatus(OK)
  @PostMapping("/{message}")
  public void produce(@PathVariable String message) {
    kafkaProducerService.sendMessage(message);
  }
}
