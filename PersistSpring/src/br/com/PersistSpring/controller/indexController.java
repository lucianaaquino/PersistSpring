package br.com.PersistSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.PersistSpring.servico.ClienteServico;
import br.com.PersistSpring.servico.FornecedorServico;


@Controller
public class indexController {
	
	@Autowired
	FornecedorServico fornecedorServico;
	
	@Autowired
	ClienteServico clienteServico;
	
	@RequestMapping("/index")
	public ModelAndView index(Model model) {
		return new ModelAndView("/index");
	}

	@RequestMapping("/telaCliente")
	public ModelAndView telaCliente(Model model) {
		return new ModelAndView("/cliente");
	}
	
	@RequestMapping("/telaFornecedor")
	public ModelAndView telaFornecedor(Model model) {
		return new ModelAndView("/fornecedor");
	}
	
	@RequestMapping("/telaProduto")
	public ModelAndView telaProduto(Model model) {
		model.addAttribute("listaFornecedor",	fornecedorServico.pesquisarFornecedor());
		return new ModelAndView("/produto");
	}
	@RequestMapping("/telaPedido")
	public ModelAndView telaPedido(Model model) {
		model.addAttribute("listaCliente",	clienteServico.pesquisarCliente());
		return new ModelAndView("/pedido");
	}
	
	
	



	


}
