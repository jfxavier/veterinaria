package px.main.veterinaria.modelos;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Informacao {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	private String tipo,texto;

	public Informacao(String tipo, String texto) {
		this.id=0;
		this.data = new Date();
		this.tipo = tipo;
		this.texto = texto;
	}

	public Informacao() {
		this.id=0;
		this.data = new Date();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
