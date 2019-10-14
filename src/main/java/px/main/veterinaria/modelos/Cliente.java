package px.main.veterinaria.modelos;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	@NotBlank
	private String nome;
	
	private String rg,cpf,endereco,bairro,cidadeUF,telefone,celular,email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
	private List<Pet> pets;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente", orphanRemoval = true)
	private List<ClienteInformacao> informacoes;

	public Cliente(Integer id, String nome, String rg, String cpf, String endereco, String bairro, String cidadeUF,
			String telefone, String celular, String email, Date data, List<Pet> pets,
			List<ClienteInformacao> informacoes) {
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidadeUF = cidadeUF;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.data = data;
		this.pets = pets;
		this.informacoes = informacoes;
	}
	
	

	public Cliente() {
		this.data = new Date();;
		this.pets = new ArrayList<Pet>();
		this.informacoes =  new ArrayList<ClienteInformacao>();
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidadeUF() {
		return cidadeUF;
	}

	public void setCidadeUF(String cidadeUF) {
		this.cidadeUF = cidadeUF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public List<ClienteInformacao> getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(List<ClienteInformacao> informacoes) {
		this.informacoes = informacoes;
	}
	
	
}
