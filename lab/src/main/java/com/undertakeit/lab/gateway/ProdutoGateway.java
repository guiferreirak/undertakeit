package com.undertakeit.lab.gateway;

import com.undertakeit.lab.gateway.data.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoGateway extends JpaRepository<ProdutoEntity, Integer> {

}
