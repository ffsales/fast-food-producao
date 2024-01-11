package br.com.fiap.postech.fastfoodproducao.presentation.controller;

import br.com.fiap.postech.fastfoodproducao.application.service.PedidoService;
import br.com.fiap.postech.fastfoodproducao.dto.PedidoRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @GetMapping
    public List<PedidoRecord> getAll() {

        var pedidos = pedidoService.listaPedidos();

        return pedidos;
    }

    @GetMapping("/{id}")
    public PedidoRecord getPedido(@PathVariable UUID id) {

        var pedido = pedidoService.consultaPedido(id);
        return pedido;
    }

    @GetMapping("/status/{status}")
    public List<PedidoRecord> getPedidosByStatus(@PathVariable String status) {

        var pedidos = pedidoService.listaPedidosPorStatus(status);

        return pedidos;
    }

    @PatchMapping("/{id}/status/{status}")
    public PedidoRecord atualizaStatusPedido(@PathVariable UUID id, @PathVariable String status) throws JsonProcessingException {

        //consulta pedido
        var pedido = this.getPedido(id);
        //valida status
        //atualiza pedido
        var pedidoResult = pedidoService.atualizaStatusPedido(pedido, status);
        //envia mensagemp com atualizacao do pedido

        return pedidoResult;
    }
}
