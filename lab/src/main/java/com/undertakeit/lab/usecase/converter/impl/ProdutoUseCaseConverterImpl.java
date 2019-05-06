package com.undertakeit.lab.usecase.converter.impl;

import com.undertakeit.lab.gateway.data.ProdutoEntity;
import com.undertakeit.lab.usecase.converter.ProdutoUseCaseConverter;
import com.undertakeit.lab.usecase.data.input.ProdutoBusinessInput;
import com.undertakeit.lab.usecase.data.output.ProdutoBusinessOutput;
import org.springframework.stereotype.Component;

@Component
public class ProdutoUseCaseConverterImpl implements ProdutoUseCaseConverter {

    @Override
    public ProdutoEntity toGateway(ProdutoBusinessInput input) {
        return ProdutoEntity.builder()
                .nome(input.getNome())
                .preco(input.getPreco())
                .build();
    }

    @Override
    public ProdutoBusinessOutput toUseCase(ProdutoEntity produtoEntity) {
        return ProdutoBusinessOutput.builder()
                .id(produtoEntity.getId())
                .nome(produtoEntity.getNome())
                .preco(produtoEntity.getPreco())
                .build();
    }
}
