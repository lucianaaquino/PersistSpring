package br.com.PersistSpring.servico;

import java.util.LinkedList;

import br.com.PersistSpring.bean.Cliente;
import br.com.PersistSpring.dao.ClienteDao;

public class ClienteServico {
	
	ClienteDao clienteDao = new ClienteDao();
		
	public String salvar(Cliente cliente){
				return clienteDao.salvar(cliente);
				
	}
	
	public LinkedList<Cliente> pesquisarCliente(Cliente cliente){
		return clienteDao.pesquisarCliente(cliente);
				
	}
	
	
	
	
	

}
