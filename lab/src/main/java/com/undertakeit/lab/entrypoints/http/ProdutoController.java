package com.undertakeit.lab.entrypoints.http;

import com.undertakeit.lab.entrypoints.http.converter.ProdutoHttpConverter;
import com.undertakeit.lab.entrypoints.http.data.request.ProdutoContractRequest;
import com.undertakeit.lab.entrypoints.http.data.response.ProdutoContractResponse;
import com.undertakeit.lab.usecase.ProdutoUseCase;
import com.undertakeit.lab.usecase.data.input.ProdutoBusinessInput;
import com.undertakeit.lab.usecase.data.output.ProdutoBusinessOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    // O que é D.I? É o processo de prover instâncias de classes que um objeto precisa para funcionar.

//    @Autowired -> Marcando um ponto como injetável no Spring
//    private ProdutoUseCase produtoUseCase;
//
//    @Autowired
//    private ProdutoHttpConverter produtoConverterHttp;

//    Ex. de Construtores p/ darem funcionamento a Injeção de Dependência com .NET
//    private ProdutoUseCase produtoUseCase;
//    private ProdutoHttpConverter produtoConverterHttp;
//
//    É o que @RequiredArgsConstructor faz por baixo dos panos.
//    public ProdutoController(ProdutoUseCase produtoUseCase, ProdutoHttpConverter produtoConverterHttp) {
//        this.produtoUseCase = produtoUseCase;
//        this.produtoConverterHttp = produtoConverterHttp;
//    }

    private final ProdutoUseCase produtoUseCase;
    private final ProdutoHttpConverter produtoHttpConverter;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        String hello = "Hello World";
        return ResponseEntity.ok().body(hello);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoContractResponse>> getAll(){
        List<ProdutoBusinessOutput> produtoBusinessOutputList = produtoUseCase.findAll();
        List<ProdutoContractResponse> produtoContractResponseList = produtoHttpConverter.toHttp(produtoBusinessOutputList);
        return ResponseEntity.ok().body(produtoContractResponseList);
    }

    @PostMapping
    public ResponseEntity<ProdutoContractResponse> post(@RequestBody ProdutoContractRequest produtoContractRequest){

        ProdutoBusinessInput produtoBusinessInput = produtoHttpConverter.toUseCase(produtoContractRequest);
        ProdutoBusinessOutput produtoBusinessOutput = produtoUseCase.save(produtoBusinessInput);
        ProdutoContractResponse produtoContractResponse = produtoHttpConverter.toHttp(produtoBusinessOutput);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoContractResponse.getId())
                .toUri();

        return ResponseEntity.created(uri).body(produtoContractResponse);
    }

}
