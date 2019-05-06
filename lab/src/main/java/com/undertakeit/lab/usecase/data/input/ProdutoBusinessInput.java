package com.undertakeit.lab.usecase.data.input;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProdutoBusinessInput {

    private Integer id;

    private String nome;

    private BigDecimal preco;

}
