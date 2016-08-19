package br.com.PersistSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.PersistSpring.bean.Cliente;
import br.com.PersistSpring.servico.ClienteServico;


@Controller
public class ClienteController {
	
	ClienteServico clienteServico = new ClienteServico();
	
	@RequestMapping("/cadastraUsuario")
	public ModelAndView telaCliente(Model model) {
		return new ModelAndView("/cliente");
	}
	
	@RequestMapping("/cadastraCliente")
	public ModelAndView cadastraCliente(Model model,Cliente cliente) {
			model.addAttribute("mensagem",	clienteServico.salvar(cliente));
		return new ModelAndView("/cliente");
	}
	
	
	@RequestMapping("/pesquisarCliente")
	public ModelAndView pesquisarCliente(Model model,Cliente cliente) {
			model.addAttribute("listaCliente",	clienteServico.pesquisarCliente(cliente));
		return new ModelAndView("/cliente");
	}
	



	


}
