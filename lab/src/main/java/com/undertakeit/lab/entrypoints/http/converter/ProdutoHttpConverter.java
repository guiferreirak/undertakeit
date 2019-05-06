package com.undertakeit.lab.entrypoints.http.converter;

import com.undertakeit.lab.entrypoints.http.data.request.ProdutoContractRequest;
import com.undertakeit.lab.entrypoints.http.data.response.ProdutoContractResponse;
import com.undertakeit.lab.usecase.data.input.ProdutoBusinessInput;
import com.undertakeit.lab.usecase.data.output.ProdutoBusinessOutput;

import java.util.List;

public interface ProdutoHttpConverter {

    List<ProdutoContractResponse> toHttp(List<ProdutoBusinessOutput>  outputs);

    ProdutoContractResponse toHttp(ProdutoBusinessOutput output);

    ProdutoBusinessInput toUseCase(ProdutoContractRequest request);
}
