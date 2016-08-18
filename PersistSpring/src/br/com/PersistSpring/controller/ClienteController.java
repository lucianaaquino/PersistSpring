package br.com.PersistSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.PersistSpring.servico.ClienteServico;


@Controller
public class ClienteController {
	
	
	@RequestMapping("/cadastraUsuario")
	public ModelAndView telaCliente(Model model) {
		return new ModelAndView("/cliente");
	}
	



	


}
