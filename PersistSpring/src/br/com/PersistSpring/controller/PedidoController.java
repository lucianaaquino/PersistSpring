package br.com.PersistSpring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.PersistSpring.modelo.ItemPedido;
import br.com.PersistSpring.modelo.Pedido;
import br.com.PersistSpring.servico.PedidoServico;
import br.com.PersistSpring.servico.ProdutoServico;


@Controller
public class PedidoController {
	
	@Autowired
	PedidoServico pedidoServico;
	
	@Autowired
	ProdutoServico produtoServico;

	@RequestMapping("/cadastraPedido")
	public ModelAndView cadastraPedido(Model model,Pedido pedido) throws Exception {
		model.addAttribute("pedido",	pedidoServico.salvar(pedido));
		
		model.addAttribute("listaProduto",	produtoServico.pesquisarProduto());
		
		return new ModelAndView("/pedido");
	}
	

	@RequestMapping("/adicionaItemPedido")
	public ModelAndView adicionaItemPedido(Model model,ItemPedido itemPedido ) throws Exception {
		model.addAttribute("pedido",	pedidoServico.salvar(itemPedido));
		model.addAttribute("listaProduto",	produtoServico.pesquisarProduto());
		return new ModelAndView("/pedido");
	}
	
	@RequestMapping("/adicionaPedidoGeral")
	public ModelAndView adicionaPedidoGeral(Model model,Pedido pedido) throws Exception {
		model.addAttribute("pedido",	pedidoServico.salvarPedidoGeral(pedido));
		model.addAttribute("listaProduto",	produtoServico.pesquisarProduto());
		return new ModelAndView("/pedido");
	}
	
	
	@RequestMapping("/pesquisarPedido")
	public ModelAndView pesquisarPedido(Model model) {
			model.addAttribute("listaPedido",	pedidoServico.pesquisarPedido());
		return new ModelAndView("/pedido");
	}
	
	/*@RequestMapping("/pesquisarPedidoNome")
	public ModelAndView pesquisarPedido(Model model,Pedido pedido) {
			model.addAttribute("listaPedidoNome",	pedidoServico.pesquisarPedidoNome(pedido));
		return new ModelAndView("/pedido");
	}
	*/



	


}
