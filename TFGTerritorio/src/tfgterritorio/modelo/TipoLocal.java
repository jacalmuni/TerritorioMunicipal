package tfgterritorio.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "TipoLocal")	//Entidad de datos TipoLocal.
//Vista modo detalle.
@Views({ @View( members = "local;localCatastro;localINE;localHacienda;descripcion; estado")})	// Edicion Registro
//Vista modo lista.
@Tabs({ @Tab( properties = "local,localCatastro,localINE,localHacienda,descripcion,estado") })	// Browse

//Clase que implementa el componente de negocio TipoLocal.
public class TipoLocal extends BaseControl {
	
	// Identificador de TipoLocal.	Clave Primaria.
	@Id
	@GeneratedValue(generator = "TipoLocalid", strategy = GenerationType.TABLE )
	@TableGenerator(name = "TipoLocalid", pkColumnValue = "idLocal", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)	
	@Hidden
	@ReadOnly
	private Integer idLocal;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	@Required
	private String local;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String localCatastro;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String localINE;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String localHacienda;
	
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
	
	public Integer getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getLocalCatastro() {
		return localCatastro;
	}
	public void setLocalCatastro(String localCatastro) {
		this.localCatastro = localCatastro;
	}
	public String getLocalINE() {
		return localINE;
	}
	public void setLocalINE(String localINE) {
		this.localINE = localINE;
	}
	public String getLocalHacienda() {
		return localHacienda;
	}
	public void setLocalHacienda(String localHacienda) {
		this.localHacienda = localHacienda;
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
