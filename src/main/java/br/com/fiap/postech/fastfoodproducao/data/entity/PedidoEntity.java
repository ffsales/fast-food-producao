package br.com.fiap.postech.fastfoodproducao.data.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("pedido")
@Data
@Builder
public class PedidoEntity {

    @Id
    private String id;

    private List<ItemPedidoEntity> itens;

    private LocalDateTime data;

    private String status;
}
