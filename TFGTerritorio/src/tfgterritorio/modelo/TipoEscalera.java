package tfgterritorio.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "TipoEscalera")	//Entidad de datos TipoEscalera.
//Vista modo detalle.
@Views({ @View( members = "escalera;escaleraCatastro;escaleraINE;escaleraHacienda;descripcion;estado")})	// Edicion Registro
//Vista modo lista.
@Tabs({ @Tab( properties = "escalera,escaleraCatastro,escaleraINE,escaleraHacienda,descripcion,estado") })	// Browse

//Clase que implementa el componente de negocio TipoEscalera.
public class TipoEscalera extends BaseControl {
	
	// Identificador de TipoEscalera.	Clave Primaria.
	@Id
	@GeneratedValue(generator = "idEscalera", strategy = GenerationType.TABLE)
	@TableGenerator(name = "idEscalera", pkColumnValue = "idEscalera", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)
	@ReadOnly
	private Integer idEscalera;

	@Column(length = 4)
	@DisplaySize(value = 4)
	private String escalera;
		
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String escaleraCatastro;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String escaleraINE;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String escaleraHacienda;
	
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
	
	public Integer getIdEscalera() {
		return idEscalera;
	}
	public void setIdEscalera(Integer idEscalera) {
		this.idEscalera = idEscalera;
	}
	
	public String getEscalera() {
		return escalera;
	}
	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}
	public String getEscaleraCatastro() {
		return escaleraCatastro;
	}
	public void setEscaleraCatastro(String escaleraCatastro) {
		this.escaleraCatastro = escaleraCatastro;
	}
	public String getEscaleraINE() {
		return escaleraINE;
	}
	public void setEscaleraINE(String escaleraINE) {
		this.escaleraINE = escaleraINE;
	}
	public String getEscaleraHacienda() {
		return escaleraHacienda;
	}
	public void setEscaleraHacienda(String escaleraHacienda) {
		this.escaleraHacienda = escaleraHacienda;
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