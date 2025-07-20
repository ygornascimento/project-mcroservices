package meu.curso.microservicos.pedido.service;

import meu.curso.microservicos.pedido.model.ItemPedido;
import meu.curso.microservicos.pedido.model.Pedido;
import meu.curso.microservicos.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido salvarPedido(Pedido pedido) {
        if (pedido.getItens() != null) {
            for (ItemPedido item: pedido.getItens()) {
                item.setPedido(pedido);
            }
        }
        return  pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
