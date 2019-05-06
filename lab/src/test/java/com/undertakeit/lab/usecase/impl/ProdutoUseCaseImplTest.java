package com.undertakeit.lab.usecase.impl;

import com.undertakeit.lab.gateway.ProdutoGateway;
import com.undertakeit.lab.gateway.data.ProdutoEntity;
import com.undertakeit.lab.usecase.converter.ProdutoUseCaseConverter;
import com.undertakeit.lab.usecase.data.input.ProdutoBusinessInput;
import com.undertakeit.lab.usecase.data.output.ProdutoBusinessOutput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoUseCaseImplTest {

    @Mock
    ProdutoUseCaseConverter produtoUseCaseConverter;

    @Mock
    ProdutoGateway produtoGateway;

    @InjectMocks
    ProdutoUseCaseImpl produtoUseCaseImpl;

    @Test
    public void deveListarTodosProdutos() {

        // Arrange
        List<ProdutoBusinessOutput> expected = getListProdutoBusinessOutput();

        // Act
        List<ProdutoBusinessOutput> actual = produtoUseCaseImpl.findAll();

        // Assert
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void deveListarUmProduto() {

        // Arrange
        ProdutoBusinessOutput expected = getProdutoBusinessOutput();

        // Act
        ProdutoBusinessOutput actual = produtoUseCaseImpl.findOne();

        // Assert
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void deveSalvarUmProduto() {

        // Arrange
        ProdutoBusinessOutput expected = getProdutoBusinessOutputEmpty();
        ProdutoEntity entityEmpty = getProdutoEntityEmpty();
        ProdutoBusinessInput param = getProdutoBusinessInput();

        // Act
        when(produtoUseCaseConverter.toGateway(param)).thenReturn(entityEmpty);
        when(produtoGateway.save(entityEmpty)).thenReturn(entityEmpty);
        when(produtoUseCaseConverter.toUseCase(entityEmpty)).thenReturn(expected);
        ProdutoBusinessOutput actual = produtoUseCaseImpl.save(param);

        // Assert
        assertNotNull(actual);
        assertEquals(expected, actual);
        verify(produtoUseCaseConverter, times(1)).toGateway(param);
        verify(produtoGateway, times(1)).save(entityEmpty);
        verify(produtoUseCaseConverter, times(1)).toUseCase(entityEmpty);
    }

    private List<ProdutoBusinessOutput> getListProdutoBusinessOutput() {
        ProdutoBusinessOutput produtoBusinessOutput1 = ProdutoBusinessOutput.builder().id(1).nome("Notebook").preco(new BigDecimal("2.000")).build();
        ProdutoBusinessOutput produtoBusinessOutput2 = ProdutoBusinessOutput.builder().id(2).nome("Iphone").preco(new BigDecimal("3.000")).build();
        return Arrays.asList(produtoBusinessOutput1, produtoBusinessOutput2);
    }

    private ProdutoBusinessOutput getProdutoBusinessOutput() {
        return ProdutoBusinessOutput.builder().id(1).nome("Notebook").preco(new BigDecimal("2.000")).build();
    }

    private ProdutoBusinessOutput getProdutoBusinessOutputEmpty() {
        return ProdutoBusinessOutput.builder().build();
    }

    private ProdutoEntity getProdutoEntityEmpty() {
        return ProdutoEntity.builder().build();
    }

    private ProdutoBusinessInput getProdutoBusinessInput() {
        return ProdutoBusinessInput.builder().id(1).nome("Notebook").preco(new BigDecimal("2.000")).build();
    }
}
