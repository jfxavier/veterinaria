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
@Getter @Setter
@Table(name = "clientes_informacoes")
public class ClienteInformacao extends Informacao{
	
	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public ClienteInformacao(String tipo, String texto, Cliente cliente) {
		super(tipo, texto);
		this.cliente = cliente;
	}
	public ClienteInformacao() {
		super();
	}
	
}
