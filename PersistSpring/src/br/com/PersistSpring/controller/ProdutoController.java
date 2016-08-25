package br.com.PersistSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.PersistSpring.modelo.Fornecedor;
import br.com.PersistSpring.modelo.Produto;
import br.com.PersistSpring.servico.FornecedorServico;
import br.com.PersistSpring.servico.ProdutoServico;


@Controller
public class ProdutoController {
	
	@Autowired
	ProdutoServico produtoServico;
	
	@Autowired
	FornecedorServico fornecedorServico;
	
	@RequestMapping("/cadastraProduto")
	public ModelAndView cadastraProduto(Model model,Produto produto,Fornecedor fornecedor) {
			model.addAttribute("mensagem",	produtoServico.salvar(produto,fornecedor));
			model.addAttribute("listaFornecedor",	fornecedorServico.pesquisarFornecedor());
		return new ModelAndView("/produto");
	}
	
	
	@RequestMapping("/pesquisarProduto")
	public ModelAndView pesquisarProduto(Model model) {
			model.addAttribute("listaProduto",	produtoServico.pesquisarProduto());
			model.addAttribute("listaFornecedor",	fornecedorServico.pesquisarFornecedor());
		return new ModelAndView("/produto");
	}
	
	@RequestMapping("/pesquisarProdutoNome")
	public ModelAndView pesquisarProduto(Model model,Produto produto) {
			model.addAttribute("listaProdutoNome",	produtoServico.pesquisarProdutoNome(produto));
			model.addAttribute("listaFornecedor",	fornecedorServico.pesquisarFornecedor());
		return new ModelAndView("/produto");
	}
	



	


}
