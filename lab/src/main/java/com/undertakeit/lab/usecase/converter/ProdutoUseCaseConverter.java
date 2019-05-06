package com.undertakeit.lab.usecase.converter;

import com.undertakeit.lab.gateway.data.ProdutoEntity;
import com.undertakeit.lab.usecase.data.input.ProdutoBusinessInput;
import com.undertakeit.lab.usecase.data.output.ProdutoBusinessOutput;

public interface ProdutoUseCaseConverter {

    ProdutoEntity toGateway(ProdutoBusinessInput input);

    ProdutoBusinessOutput toUseCase(ProdutoEntity produtoEntity);

}
