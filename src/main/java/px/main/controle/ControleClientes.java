package px.main.controle;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import px.main.veterinaria.modelos.Cliente;
import px.main.veterinaria.modelos.ClienteInformacao;
import px.main.veterinaria.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ControleClientes {

	@Autowired
	ClienteRepository clienteRepository;

	@RequestMapping(value = "/lista")
	public ModelAndView lista() {
		ModelAndView model = new ModelAndView("cliente/lista");
		model.addObject("lista", clienteRepository.findAll());
		return model;
	}

	@RequestMapping("")
	public ModelAndView novo(Cliente cliente) {
		System.out.print(cliente);
		ModelAndView model = new ModelAndView("cliente/formulario");
		model.addObject("cliente", cliente);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView cliente(@PathVariable Integer id) {
		Cliente cliente = clienteRepository.findOne(id);
		return novo(cliente);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cliente);
		}
		if(cliente.getId()!=0)cliente.setInformacoes(clienteRepository.findById(cliente.getId()).getInformacoes());
		cliente.getInformacoes().add(new ClienteInformacao("Salve", "Salvamento pelo usuário", cliente));
		clienteRepository.save(cliente);

		ModelAndView model = new ModelAndView("redirect:lista");
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso.");
		return model;
	}

}
