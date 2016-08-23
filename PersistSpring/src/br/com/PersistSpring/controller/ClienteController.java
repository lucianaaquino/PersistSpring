package br.com.PersistSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.PersistSpring.modelo.Cliente;
import br.com.PersistSpring.servico.ClienteServico;


@Controller
public class ClienteController {
	
	@Autowired
	ClienteServico clienteServico;
	

	@RequestMapping("/cadastraCliente")
	public ModelAndView cadastraCliente(Model model,Cliente cliente) {
			model.addAttribute("mensagem",	clienteServico.salvar(cliente));
		return new ModelAndView("/cliente");
	}
	
	
	@RequestMapping("/pesquisarCliente")
	public ModelAndView pesquisarCliente(Model model) {
			model.addAttribute("listaCliente",	clienteServico.pesquisarCliente());
		return new ModelAndView("/cliente");
	}
	
	@RequestMapping("/pesquisarClienteNome")
	public ModelAndView pesquisarCliente(Model model,Cliente cliente) {
			model.addAttribute("listaClienteNome",	clienteServico.pesquisarClienteNome(cliente));
		return new ModelAndView("/cliente");
	}
	



	


}
