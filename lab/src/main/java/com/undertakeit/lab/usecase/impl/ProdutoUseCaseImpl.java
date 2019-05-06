package com.undertakeit.lab.usecase.impl;

import com.undertakeit.lab.gateway.ProdutoGateway;
import com.undertakeit.lab.gateway.data.ProdutoEntity;
import com.undertakeit.lab.usecase.ProdutoUseCase;
import com.undertakeit.lab.usecase.converter.ProdutoUseCaseConverter;
import com.undertakeit.lab.usecase.data.input.ProdutoBusinessInput;
import com.undertakeit.lab.usecase.data.output.ProdutoBusinessOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component // Classe elegível de ser injetada
@RequiredArgsConstructor
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoUseCaseConverter produtoUseCaseConverter;
    private final ProdutoGateway produtoGateway;

    @Override
    public List<ProdutoBusinessOutput> findAll() {

        ProdutoBusinessOutput produtoBusinessOutput1 = ProdutoBusinessOutput.builder().id(1).nome("Notebook").preco(new BigDecimal("2.000")).build();
        ProdutoBusinessOutput produtoBusinessOutput2 = ProdutoBusinessOutput.builder().id(2).nome("Iphone").preco(new BigDecimal("3.000")).build();

        return Arrays.asList(produtoBusinessOutput1, produtoBusinessOutput2);

//        List<ProdutoBusinessOutput> produtoBusinessOutputList = new ArrayList<>();
//        produtoBusinessOutputList.add(produtoBusinessOutput1);
//        produtoBusinessOutputList.add(produtoBusinessOutput2);
//
//        return produtoBusinessOutputList;
    }

    @Override
    public ProdutoBusinessOutput findOne() {
        return ProdutoBusinessOutput.builder().id(1).nome("Notebook").preco(new BigDecimal("2.000")).build();
    }

    @Override
    public ProdutoBusinessOutput save(ProdutoBusinessInput produtoBusinessInput) {
        ProdutoEntity produtoEntity = produtoUseCaseConverter.toGateway(produtoBusinessInput);
        ProdutoEntity entity = produtoGateway.save(produtoEntity);
        ProdutoBusinessOutput produtoBusinessOutput = produtoUseCaseConverter.toUseCase(entity);
         return produtoBusinessOutput;
    }

}


