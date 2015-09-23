package tfgterritorio.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "TipoPortal")	//Entidad de datos TipoPlanta.
//Vista modo detalle.
@Views({ @View( members = "portal;portalCatastro;portalINE;portalHacienda;descripcion;estado")})
//Vista modo lista
@Tabs({ @Tab( properties = "portal,portalCatastro,portalINE,portalHacienda,descripcion,estado") })

//Clase que implementa el componente de negocio TipoPortal.
public class TipoPortal extends BaseControl {
	
	// Identificador de TipoPortal.	Clave Primaria.
	@Id
	@GeneratedValue(generator = "idPortal", strategy = GenerationType.TABLE)
	@TableGenerator(name = "idPortal", pkColumnValue = "idPortal", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)
	@ReadOnly
	private Integer idPortal;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String portal;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String portalCatastro;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String portalINE;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String portalHacienda;
	
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
	
	public Integer getIdPortal() {
		return idPortal;
	}
	public void setIdPortal(Integer idPortal) {
		this.idPortal = idPortal;
	}
	public String getPortal() {
		return portal;
	}
	public void setPortal(String portal) {
		this.portal = portal;
	}
	public String getPortalCatastro() {
		return portalCatastro;
	}
	public void setPortalCatastro(String portalCatastro) {
		this.portalCatastro = portalCatastro;
	}
	public String getPortalINE() {
		return portalINE;
	}
	public void setPortalINE(String portalINE) {
		this.portalINE = portalINE;
	}
	public String getPortalHacienda() {
		return portalHacienda;
	}
	public void setPortalHacienda(String portalHacienda) {
		this.portalHacienda = portalHacienda;
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
	}; 


}
