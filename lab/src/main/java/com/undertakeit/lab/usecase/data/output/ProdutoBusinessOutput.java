package com.undertakeit.lab.usecase.data.output;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProdutoBusinessOutput {

    private Integer id;
    private String nome;
    private BigDecimal preco;
}
