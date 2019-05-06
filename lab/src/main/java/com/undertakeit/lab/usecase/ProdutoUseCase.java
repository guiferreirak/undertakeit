package com.undertakeit.lab.usecase;

import com.undertakeit.lab.usecase.data.input.ProdutoBusinessInput;
import com.undertakeit.lab.usecase.data.output.ProdutoBusinessOutput;

import java.util.List;

public interface ProdutoUseCase {

    List<ProdutoBusinessOutput> findAll();
    ProdutoBusinessOutput findOne();
    ProdutoBusinessOutput save(ProdutoBusinessInput produtoBusinessInput);
}
