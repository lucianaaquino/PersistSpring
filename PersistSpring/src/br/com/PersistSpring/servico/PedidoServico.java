package br.com.PersistSpring.servico;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.PersistSpring.dao.PedidoDao;
import br.com.PersistSpring.modelo.ItemPedido;
import br.com.PersistSpring.modelo.Pedido;
import br.com.PersistSpring.modelo.Produto;

@Service
public class PedidoServico {

	@Autowired
	PedidoDao pedidoDao; 

	public Pedido salvar(Pedido pedido) throws Exception{
		String msg ="Cadastro Efetuado";
		Pedido pe = new Pedido();
		try {
			pe = pedidoDao.salvar(pedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		}
		return pe;
	}
	
	public Pedido salvar(ItemPedido itemPedido) throws Exception{
		String msg ="Cadastro Efetuado";
		
		try {
		 pedidoDao.salvarItem(itemPedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		}
		
		return pesquisarPedidoId(itemPedido.getPk().getPedidoId());
	}

	public List<Pedido> pesquisarPedido(){
		return pedidoDao.buscar();

	}

	
	public Pedido pesquisarPedidoId(int id){
		return pedidoDao.buscarId(id);

	}





}
