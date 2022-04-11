package com.diego.estoquepreco.controller;

import com.diego.estoquepreco.contantes.RabbitmqContantes;
import com.diego.estoquepreco.dto.EstoqueDTO;
import com.diego.estoquepreco.service.RabbitmqService;
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
    RabbitmqService rabbitmqService;

    @PutMapping
    private ResponseEntity alteraEstoque(@RequestBody EstoqueDTO estoqueDTO){
        log.info("Estoque recebido: "+estoqueDTO.toString());
        this.rabbitmqService.enviaMensagem(RabbitmqContantes.FILA_ESTOQUE, estoqueDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

}
