package px.main.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import px.main.veterinaria.modelos.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
	public Pet findById(int id);
}
