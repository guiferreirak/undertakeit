package com.undertakeit.lab.entrypoints.http.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoContractRequest {

    private String nome;

    private BigDecimal preco;
}
