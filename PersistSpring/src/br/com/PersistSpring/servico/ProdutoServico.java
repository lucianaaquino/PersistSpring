package br.com.PersistSpring.servico;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.PersistSpring.dao.ProdutoDao;
import br.com.PersistSpring.modelo.Fornecedor;
import br.com.PersistSpring.modelo.Produto;

@Service
public class ProdutoServico {

	@Autowired
	ProdutoDao produtoDao; 
	

	
	public String salvar(Produto produto,Fornecedor fornecedor){
		LinkedList<Fornecedor> lista = new LinkedList<Fornecedor>();
		lista.add(fornecedor);
		produto.setFornecedor(lista);
		
		String msg ="Cadastro Efetuado";
		try {
			produtoDao.salvar(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		}

		return msg;

	}

	public List<Produto> pesquisarProduto(){
		return produtoDao.buscar();

	}

	
	public List<Produto> pesquisarProdutoNome(Produto produto){
		return produtoDao.buscar(produto);

	}





}
