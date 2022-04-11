package com.diego.estoquepreco.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EstoqueDTO implements Serializable {

    public String codigoproduto;
    public int quantidade;

}
