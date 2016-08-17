package br.com.PersistSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.PersistSpring.servico.ClienteServico;


@Controller
public class indexController {
	
	ClienteServico clienteServico = new ClienteServico();


	@RequestMapping("/cadastraUsuario")
	public ModelAndView index(Model model,String nomeCliente,String cpfCliente,String cnpjCliente,String tipoCliente) {
		model.addAttribute("mensagem",clienteServico.salvar( nomeCliente, cpfCliente, cnpjCliente, tipoCliente));

		return new ModelAndView("/index");
	}
	
	


	


}
