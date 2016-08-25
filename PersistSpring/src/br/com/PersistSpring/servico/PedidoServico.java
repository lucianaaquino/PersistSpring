package br.com.PersistSpring.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.PersistSpring.dao.PedidoDao;
import br.com.PersistSpring.modelo.Cliente;
import br.com.PersistSpring.modelo.Pedido;

@Service
public class PedidoServico {

	@Autowired
	PedidoDao pedidoDao; 

	public String salvar(Pedido pedido){
		String msg ="Cadastro Efetuado";
		try {
			pedidoDao.salvar(pedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		}

		return msg;

	}

	public List<Pedido> pesquisarPedido(){
		return pedidoDao.buscar();

	}

	
	/*public List<Pedido> pesquisarPedidoNome(Pedido pedido){
		return pedidoDao.buscar(pedido);

	}*/





}
