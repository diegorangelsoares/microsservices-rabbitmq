package com.microservico.estoquepreco.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitmqService {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  public void enviaMensagem(String nomeFila, Object mensagem){
    try {
      String mensagemJson = this.objectMapper.writeValueAsString(mensagem);
      this.rabbitTemplate.convertAndSend(nomeFila, mensagemJson);
    } catch (Exception e){
      log.error("Erro ao enviar mensagem. Erro: "+e.getMessage());
      e.printStackTrace();
    }
  }
}
