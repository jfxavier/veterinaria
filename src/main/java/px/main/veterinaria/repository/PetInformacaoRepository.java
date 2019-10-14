package px.main.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import px.main.veterinaria.modelos.PetInformacao;

@Repository
public interface PetInformacaoRepository extends JpaRepository< PetInformacao, Integer> {
	public  PetInformacao findById(int id);
}
