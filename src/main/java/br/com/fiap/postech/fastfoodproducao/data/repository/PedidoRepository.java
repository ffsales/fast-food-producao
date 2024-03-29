package br.com.fiap.postech.fastfoodproducao.data.repository;

import br.com.fiap.postech.fastfoodproducao.data.entity.PedidoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends MongoRepository<PedidoEntity, UUID> {

    List<PedidoEntity> findAll();

    @Query("{id:'?0'}")
    PedidoEntity findByIdPedido(UUID id);

    @Query("{status:'?0'}")
    Page<PedidoEntity> findByStatus(String status, Pageable pageable);
}
