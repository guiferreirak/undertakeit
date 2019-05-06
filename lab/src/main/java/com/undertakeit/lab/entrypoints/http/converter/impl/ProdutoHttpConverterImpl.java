package com.undertakeit.lab.entrypoints.http.converter.impl;

import com.undertakeit.lab.entrypoints.http.converter.ProdutoHttpConverter;
import com.undertakeit.lab.entrypoints.http.data.request.ProdutoContractRequest;
import com.undertakeit.lab.entrypoints.http.data.response.ProdutoContractResponse;
import com.undertakeit.lab.usecase.data.input.ProdutoBusinessInput;
import com.undertakeit.lab.usecase.data.output.ProdutoBusinessOutput;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoHttpConverterImpl implements ProdutoHttpConverter {

    @Override
    public List<ProdutoContractResponse> toHttp(List<ProdutoBusinessOutput> outputs) {

        List<ProdutoContractResponse> ProdutoContractResponseList = new ArrayList<>();

        outputs.forEach(x -> {
            ProdutoContractResponse produtoContractResponse = ProdutoContractResponse.builder().id(x.getId()).nome(x.getNome()).preco(x.getPreco()).build();
            ProdutoContractResponseList.add(produtoContractResponse);
        });

        return ProdutoContractResponseList;
    }

    @Override
    public ProdutoContractResponse toHttp(ProdutoBusinessOutput output) {
        return ProdutoContractResponse.builder()
                .id(output.getId())
                .nome(output.getNome())
                .preco(output.getPreco())
                .build();
    }

    @Override
    public ProdutoBusinessInput toUseCase(ProdutoContractRequest request) {
        return ProdutoBusinessInput.builder()
                .nome(request.getNome())
                .preco(request.getPreco())
                .build();
    }
}
