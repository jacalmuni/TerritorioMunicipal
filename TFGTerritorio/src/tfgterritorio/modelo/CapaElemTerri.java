package tfgterritorio.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

@Entity // Clase de persistencia
@Table(name = "CapaElemTerri")	//Entidad de datos CapaElemTerri.
//Vista modo detalle.
@Views({ @View( members = "descripcion; nivel; estado")})	
//Vista modo lista.
@Tabs({ @Tab( properties = "descripcion, nivel, estado") })	

//Clase que implementa el componente de negocio Capa de Elementos del Territorio.
public class CapaElemTerri extends BaseControl {

	// Identificador de CapaElemTerri. Clave primaria.
	@Id
	@GeneratedValue(generator = "idCapa", strategy = GenerationType.TABLE)
	@TableGenerator(name = "idCapa", pkColumnValue = "idCapa", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)
	@ReadOnly
	private Integer idCapa;
	
	@Column(length = 80)
	@DisplaySize(value = 30)
	private String descripcion;
	
	@Column(length = 1)
	@DisplaySize(value = 1)
	private Integer nivel;

// Propiedad Estado con editor RadioButtom
	@DefaultValueCalculator(value=org.openxava.calculators.LongCalculator.class,
			properties={ @PropertyValue(name="value", value="0") 
			})
	@Editor("ValidValuesVerticalRadioButton")
	@Required
	private Estado estado;
	public enum Estado {ALTA, BAJA}
	
	public Integer getIdCapa() {
		return idCapa;
	}
	public void setIdCapa(Integer idCapa) {
		this.idCapa = idCapa;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}; 
	

	
}
