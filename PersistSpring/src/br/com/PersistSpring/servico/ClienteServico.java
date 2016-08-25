package br.com.PersistSpring.servico;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.PersistSpring.dao.ClienteDao;
import br.com.PersistSpring.modelo.Cliente;

@Service
public class ClienteServico {

	@Autowired
	ClienteDao clienteDao; 

	public String salvar(Cliente cliente){
		String msg ="Cadastro Efetuado";
		try {
			clienteDao.salvar(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		}

		return msg;

	}

	public List<Cliente> pesquisarCliente(){
		return clienteDao.buscar();

	}

	
	public List<Cliente> pesquisarClienteNome(Cliente cliente){
		return clienteDao.buscar(cliente);

	}





}
