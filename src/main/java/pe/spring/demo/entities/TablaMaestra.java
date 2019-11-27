package pe.spring.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabla_maestra") 
public class TablaMaestra {
	
	@Id
	@Column(name = "cod_tabla")
    private String codTabla;
	
	@Column(name = "cod_grupo")
	private String codGrupo;
	
	@Column(name = "valor")
	private String valor;

	public String getCodTabla() {
		return codTabla;
	}

	public void setCodTabla(String codTabla) {
		this.codTabla = codTabla;
	}

	public String getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
