package tfgterritorio.modelo;

import java.io.*;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "tipovia")	//Entidad de datos TipoVia.
//Vista modo detalle.
@Views({ @View( members = "descripcion;sigla;siglaCatastro;siglaINE;siglaHacienda")})	// Edicion Registro
//Vista modo lista.
@Tabs({ @Tab( properties = "descripcion,sigla,siglaCatastro,siglaINE,siglaHacienda") })	// Browse

//Clase que implementa el componente de negocio TipoVia.
public class TipoVia extends BaseControl {
	
	// Identificador de TipoVia.	Clave Primaria.	
	@Id
	@GeneratedValue(generator = "idTipoVia", strategy = GenerationType.TABLE)
	@TableGenerator(name = "idTipoVia", pkColumnValue = "idTipoVia", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)
	@ReadOnly
	private Integer idTipoVia;		
	
	@Column(length = 2)
	@DisplaySize(value = 2)
	@Required
	private String sigla;
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	private String siglaCatastro;
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	private String siglaINE;
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	private String siglaHacienda;
	
	@Column(length = 25)
	@DisplaySize(value = 25)
	@Required
	private String descripcion;


	public Integer getIdTipoVia() {
		return idTipoVia;
	}

	public void setIdTipoVia(Integer idTipoVia) {
		this.idTipoVia = idTipoVia;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getSiglaCatastro() {
		return siglaCatastro;
	}

	public void setSiglaCatastro(String siglaCatastro) {
		this.siglaCatastro = siglaCatastro;
	}

	public String getSiglaINE() {
		return siglaINE;
	}

	public void setSiglaINE(String siglaINE) {
		this.siglaINE = siglaINE;
	}

	public String getSiglaHacienda() {
		return siglaHacienda;
	}

	public void setSiglaHacienda(String siglaHacienda) {
		this.siglaHacienda = siglaHacienda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	


}
