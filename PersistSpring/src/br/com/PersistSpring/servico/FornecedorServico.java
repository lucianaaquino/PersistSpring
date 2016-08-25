package br.com.PersistSpring.servico;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.PersistSpring.dao.ClienteDao;
import br.com.PersistSpring.dao.FornecedorDao;
import br.com.PersistSpring.modelo.Cliente;
import br.com.PersistSpring.modelo.Fornecedor;

@Service
public class FornecedorServico {

	@Autowired
	FornecedorDao fornecedorDao; 

	public String salvar(Fornecedor fornecedor){
		String msg ="Cadastro Efetuado";
		try {
			fornecedorDao.salvar(fornecedor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		}

		return msg;

	}

	public List<Fornecedor> pesquisarFornecedor(){
		return fornecedorDao.buscar();

	}

	
	public List<Fornecedor> pesquisarFornecedorNome(Fornecedor fornecedor){
		return fornecedorDao.buscar(fornecedor);

	}





}
