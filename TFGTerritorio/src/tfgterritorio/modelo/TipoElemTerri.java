package tfgterritorio.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "TipoElemTerri")	//Entidad de datos TipoElemTerri.
//Vista modo detalle.
@Views({ @View( members = "refCapaElemTerri;descripcion;observaciones; estado")})
//Vista modo lista.
@Tabs({ @Tab( properties = "refCapaElemTerri.descripcion,descripcion,observaciones, estado") })	

//Clase que implementa el componente de negocio TipoElemTerri.
public class TipoElemTerri extends BaseControl {

	// Identificador de TipoElemTerri.	Clave Primaria.
	@Id
	@GeneratedValue(generator = "idTipoElemTerri", strategy = GenerationType.TABLE)
	@TableGenerator(name = "idTipoElemTerri", pkColumnValue = "idTipoElemTerri", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)
	@ReadOnly
	private Integer idTipoElemTerri;	
	
	
	@Column(length = 50)
	@DisplaySize(value = 30)
	private String descripcion;
	
	@Column(length = 80)
	@DisplaySize(value = 30)
	private String observaciones;

	// Propiedad Estado con editor RadioButtom
	@DefaultValueCalculator(value=org.openxava.calculators.LongCalculator.class,
			properties={ @PropertyValue(name="value", value="0") 
			})
	@Editor("ValidValuesVerticalRadioButton")
	@Required
	private Estado estado;
	public enum Estado {ALTA, BAJA}; 
	
	// Referencia a CapaElemTerri. Clave Foránea.
	@ManyToOne
	@JoinColumn(name = "refCapaElemTerri", referencedColumnName = "idCapa")
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="descripcion")
	@Required
	private CapaElemTerri refCapaElemTerri;

	public Integer getIdTipoElemTerri() {
		return idTipoElemTerri;
	}

	public void setIdTipoElemTerri(Integer idTipoElemTerri) {
		this.idTipoElemTerri = idTipoElemTerri;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public CapaElemTerri getRefCapaElemTerri() {
		return refCapaElemTerri;
	}

	public void setRefCapaElemTerri(CapaElemTerri refCapaElemTerri) {
		this.refCapaElemTerri = refCapaElemTerri;
	}
	



}
