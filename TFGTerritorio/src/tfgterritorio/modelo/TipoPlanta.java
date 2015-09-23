package tfgterritorio.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "TipoPlanta")	//Entidad de datos TipoPlanta.
//Vista modo detalle.
@Views({ @View( members = "planta;plantaCatastro;plantaINE;plantaHacienda;descripcion;estado")})
//Vista modo lista.
@Tabs({ @Tab( properties = "planta,plantaCatastro,plantaINE,plantaHacienda,descripcion,estado") })

//Clase que implementa el componente de negocio TipoPlanta.
public class TipoPlanta extends BaseControl {
	
	// Identificador de TipoPlanta.	Clave Primaria.
	@Id
	@GeneratedValue(generator = "idPlanta", strategy = GenerationType.TABLE)
	@TableGenerator(name = "idPlanta", pkColumnValue = "idPlanta", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)
	@ReadOnly
	private Integer idPlanta;

	@Column(length = 4)
	@DisplaySize(value = 4)
	private String planta;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String plantaCatastro;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String plantaINE;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	private String plantaHacienda;
	
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
	public Integer getIdPlanta() {
		return idPlanta;
	}
	public void setIdPlanta(Integer idPlanta) {
		this.idPlanta = idPlanta;
	}
	public String getPlanta() {
		return planta;
	}
	public void setPlanta(String planta) {
		this.planta = planta;
	}
	public String getPlantaCatastro() {
		return plantaCatastro;
	}
	public void setPlantaCatastro(String plantaCatastro) {
		this.plantaCatastro = plantaCatastro;
	}
	public String getPlantaINE() {
		return plantaINE;
	}
	public void setPlantaINE(String plantaINE) {
		this.plantaINE = plantaINE;
	}
	public String getPlantaHacienda() {
		return plantaHacienda;
	}
	public void setPlantaHacienda(String plantaHacienda) {
		this.plantaHacienda = plantaHacienda;
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
