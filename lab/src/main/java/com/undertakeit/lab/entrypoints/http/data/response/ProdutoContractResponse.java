package com.undertakeit.lab.entrypoints.http.data.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProdutoContractResponse {

    private Integer id;

    private String nome;

    private BigDecimal preco;

}
