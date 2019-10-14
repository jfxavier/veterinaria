package px.main.veterinaria.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Setter @Getter
@Table(name = "pets_informacoes")
public class PetInformacao extends Informacao{


	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name = "pet_id")
	private Pet pet;
	
	public PetInformacao(String tipo, String texto,Pet pet) {
		super(tipo, texto);
		this.pet=pet;
		}
	public PetInformacao() {
		super();
		}
	
	}
