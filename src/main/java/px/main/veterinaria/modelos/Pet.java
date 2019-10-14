package px.main.veterinaria.modelos;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "pets")
public class Pet {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@NotBlank
	private String nome;
	
	private String especie,raca,pelagem,obs;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name = "cliente_id")
    private Cliente proprietario;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pet", orphanRemoval = true)
	private List<PetInformacao> informacoes;

	public Pet(Integer id, String nome, String especie, String raca, String pelagem, String obs, Cliente proprietario,
			List<PetInformacao> informacoes) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.pelagem = pelagem;
		this.obs = obs;
		this.proprietario = proprietario;
		this.informacoes = informacoes;
	}
	

	public Pet() {
		this.informacoes = new ArrayList<PetInformacao>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getPelagem() {
		return pelagem;
	}

	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Cliente getProprietario() {
		return proprietario;
	}

	public void setProprietario(Cliente proprietario) {
		this.proprietario = proprietario;
	}

	public List<PetInformacao> getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(List<PetInformacao> informacoes) {
		this.informacoes = informacoes;
	}
	
	

}
