package br.com.PersistSpring.servico;

import br.com.PersistSpring.dao.ClienteDao;

public class ClienteServico {
	
	ClienteDao clienteDao = new ClienteDao();
	
	
	public String salvar(String nomeCliente,String cpfCliente,String cnpjCliente,String tipoCliente ){
			
		return clienteDao.salvar(nomeCliente, cpfCliente, cnpjCliente, tipoCliente);
				
	}
	
	

}
