package pl.solutions.software.sokolik.bartosz.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducerService {

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final String topic;

  public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, @Value("${kafka.topic}") String topic) {
    this.kafkaTemplate = kafkaTemplate;
    this.topic = topic;
  }

  public void sendMessage(String message) {
    log.info("Sending message: {} to consumer", message);
    kafkaTemplate.send(topic, message);
  }
}
