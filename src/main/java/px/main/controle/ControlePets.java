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

import px.main.veterinaria.modelos.Pet;
import px.main.veterinaria.modelos.PetInformacao;
import px.main.veterinaria.repository.ClienteRepository;
import px.main.veterinaria.repository.PetRepository;

@Controller
@RequestMapping("/pet")
public class ControlePets {

	@Autowired
	PetRepository petRepository;
	@Autowired
	ClienteRepository clienteRepository;

	@RequestMapping(value = "/lista")
	public ModelAndView lista() {
		ModelAndView model = new ModelAndView("pet/lista");
		model.addObject("lista", petRepository.findAll());
		return model;
	}

	@RequestMapping("")
	public ModelAndView novo(Pet pet) {
		System.out.print(pet);
		ModelAndView model = new ModelAndView("pet/formulario");
		model.addObject("pet", pet);
		model.addObject("listaclientes", clienteRepository.findAll());
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView cliente(@PathVariable Integer id) {
		Pet pet = petRepository.findOne(id);
		return novo(pet);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Pet pet, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(pet);
		}
		if(pet.getId()!=0)pet.setInformacoes(petRepository.findById(pet.getId()).getInformacoes());
		pet.getInformacoes().add(new PetInformacao("Salvo", "Salvamento pelo usuário", pet));
		petRepository.save(pet);
		ModelAndView model = new ModelAndView("redirect:lista");
		attributes.addFlashAttribute("mensagem", "Pet salvo com sucesso.");
		return model;
	}

}
