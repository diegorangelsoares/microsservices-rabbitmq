package com.diego.estoquepreco.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PrecoDTO implements Serializable {

    public String codigoproduto;
    public Double preco;

}
