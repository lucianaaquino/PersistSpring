package br.com.PersistSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.PersistSpring.modelo.Pedido;
import br.com.PersistSpring.modelo.Pedido;
import br.com.PersistSpring.servico.PedidoServico;
import br.com.PersistSpring.servico.PedidoServico;


@Controller
public class PedidoController {
	
	@Autowired
	PedidoServico pedidoServico;
	

	@RequestMapping("/cadastraPedido")
	public ModelAndView cadastraPedido(Model model,Pedido pedido) {
		model.addAttribute("mensagem",	pedidoServico.salvar(pedido));
		
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
