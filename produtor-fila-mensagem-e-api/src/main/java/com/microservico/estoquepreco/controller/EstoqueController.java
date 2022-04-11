package com.microservico.estoquepreco.controller;

import com.microservico.estoquepreco.service.RabbitmqService;
import dto.EstoqueDto;
import constantes.RabbitmqConstantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "estoque")
@Slf4j
public class EstoqueController {

  @Autowired
  private RabbitmqService rabbitmqService;

  @PutMapping
  private ResponseEntity alteraEstoque(@RequestBody EstoqueDto estoqueDto){
    System.out.println(estoqueDto.codigoproduto);
    log.info("Enviando para a fila alternação de estoque do produto: "+estoqueDto.codigoproduto+" Novo estoque: "+estoqueDto.quantidade);

    this.rabbitmqService.enviaMensagem(RabbitmqConstantes.FILA_ESTOQUE, estoqueDto);
    return new ResponseEntity(HttpStatus.OK);
  }
}
