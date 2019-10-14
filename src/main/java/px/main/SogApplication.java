package px.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import px.main.seguranca.modelos.Usuario;
import px.main.seguranca.repository.UsuarioRepository;
import px.main.veterinaria.modelos.Cliente;
import px.main.veterinaria.modelos.ClienteInformacao;
import px.main.veterinaria.modelos.Pet;
import px.main.veterinaria.modelos.PetInformacao;
import px.main.veterinaria.repository.ClienteRepository;
import px.main.veterinaria.repository.PetRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses={UsuarioRepository.class,ClienteRepository.class,PetRepository.class})
@EntityScan(basePackageClasses={Usuario.class,Cliente.class,Pet.class,PetInformacao.class,ClienteInformacao.class})
public class SogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SogApplication.class, args);
	}
}
