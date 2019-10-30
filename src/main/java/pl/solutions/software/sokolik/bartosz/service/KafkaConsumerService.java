package pl.solutions.software.sokolik.bartosz.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

  @KafkaListener(topics ="${kafka.topic}", id = "${kafka.consumer-group-id}")
  public void listen(String message) {
    log.info("Consumed message {}", message);
  }


}
