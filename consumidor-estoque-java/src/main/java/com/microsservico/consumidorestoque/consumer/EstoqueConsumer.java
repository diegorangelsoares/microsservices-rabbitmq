package com.microsservico.consumidorestoque.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constantes.RabbitmqConstantes;
import dto.EstoqueDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EstoqueConsumer {

  @RabbitListener(queues = RabbitmqConstantes.FILA_ESTOQUE)
  private void consumidor(String mensagem) throws JsonProcessingException, InterruptedException {
    EstoqueDto estoqueDto = new ObjectMapper().readValue(mensagem, EstoqueDto.class);

    log.info("Chegou uma nova atualização de estoque...");
    log.info("Código do produto: "+estoqueDto.codigoproduto);
    log.info("Estoque do produto: "+estoqueDto.quantidade);
    log.info("------------------------------------------------");

    //throw new IllegalArgumentException("Argumento inválido!");
  }
}
