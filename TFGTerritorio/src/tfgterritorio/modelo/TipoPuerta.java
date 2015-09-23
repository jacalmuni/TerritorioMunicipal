package tfgterritorio.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "TipoPuerta")	//Entidad de datos TipoPuerta.
//Vista modo detalle.
@Views({ @View( members = "puerta;puertaCatastro;puertaINE;puertaHacienda;descripcion;estado")})	// Edicion Registro
//Vista modo lista.
@Tabs({ @Tab( properties = "puerta,puertaCatastro,puertaINE,puertaHacienda,descripcion,estado") })	// Browse

//Clase que implementa el componente de negocio TipoPuerta.
public class TipoPuerta extends BaseControl {
	
	// Identificador de TipoPuerta.	Clave Primaria.
	@Id
	@GeneratedValue(generator = "idPuerta", strategy = GenerationType.TABLE)
	@TableGenerator(name = "idPuerta", pkColumnValue = "idPuerta", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)
	@ReadOnly
	private Integer idPuerta;

	@Column(length = 4)
	@DisplaySize(value = 4)
	private String puerta;

	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String puertaCatastro;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String puertaINE;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String puertaHacienda;
	
	@Column(length = 60)
	@DisplaySize(value = 30)
	@Required
	private String descripcion;

	// Propiedad Estado con editor RadioButtom
	@DefaultValueCalculator(value=org.openxava.calculators.LongCalculator.class,
			properties={ @PropertyValue(name="value", value="0") 
			})
	@Editor("ValidValuesVerticalRadioButton")
	@Required
	private Estado estado;
	public enum Estado {ALTA, BAJA}
	public Integer getIdPuerta() {
		return idPuerta;
	}
	public void setIdPuerta(Integer idPuerta) {
		this.idPuerta = idPuerta;
	}
	public String getPuerta() {
		return puerta;
	}
	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	public String getPuertaCatastro() {
		return puertaCatastro;
	}
	public void setPuertaCatastro(String puertaCatastro) {
		this.puertaCatastro = puertaCatastro;
	}
	public String getPuertaINE() {
		return puertaINE;
	}
	public void setPuertaINE(String puertaINE) {
		this.puertaINE = puertaINE;
	}
	public String getPuertaHacienda() {
		return puertaHacienda;
	}
	public void setPuertaHacienda(String puertaHacienda) {
		this.puertaHacienda = puertaHacienda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	
}
