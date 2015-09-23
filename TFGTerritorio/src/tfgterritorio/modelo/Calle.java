package tfgterritorio.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

@Entity	// Clase de persistencia.
@Table(name = "calle")	//Entidad de datos Calle.
//Vista modo detalle.
@Views({ @View(name="vistaCalle", members = "refTipoVia;particula,nombre;nombreLargo;codCatastro;codHacienda;codINE; estado; fAltaSistema; fAprobacion")})	
//Vista modo lista.
@Tabs({ @Tab( properties = "nombreLargo, particula, nombre, codCatastro, codHacienda, codINE, estado, fAltaSistema, fAprobacion") })	


//Clase que implementa el componente de negocio Calle.
public class Calle extends BaseControl {	
	
	// Identificador de Calle. Clave Primaria.
	@Id
	@GeneratedValue(generator = "idCalle", strategy = GenerationType.TABLE)
	@TableGenerator(name = "idCalle", pkColumnValue = "idCalle", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)
	@ReadOnly
	@Hidden
	private Integer idCalle;	
	
	
	@Column(length = 25)
	@DisplaySize(value = 25)
	@OnChange(MontalaCalle.class)
	@Required
	private String nombre;
	
	@Column(length = 6)
	@DisplaySize(value = 6)
	@OnChange(MontalaCalle.class)
	private String particula;
	
	@Column(length = 30)
	@ReadOnly
	private String nombreLargo;	
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	private Integer codCatastro;
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	private Integer codINE;
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	private Integer codHacienda;
	
	@Column
	private Date fAprobacion;
	
	@Column
	@Required
	private Date fAltaSistema;
	
// Propiedad Estado con editor RadioButtom
	@DefaultValueCalculator(value=org.openxava.calculators.LongCalculator.class,
			properties={ @PropertyValue(name="value", value="0") 
			})
	@Editor("ValidValuesVerticalRadioButton")
	@Required
	private Estado estado;
	public enum Estado {ALTA, BAJA}; 

// Referencia a Tipo de Vía.
	@ManyToOne  
	@DescriptionsList(descriptionProperties="descripcion")
	@NoModify
	@NoCreate
	@JoinColumn(name = "refTipoVia", referencedColumnName = "idTipoVia")
	@OnChange(MontalaCalle.class)	// Crea el nombre de calle largo en una cadena de caracteres.
	@Required
	private TipoVia refTipoVia;


	public Integer getIdCalle() {
		return idCalle;
	}

	public void setIdCalle(Integer idCalle) {
		this.idCalle = idCalle;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getParticula() {
		return particula;
	}

	public void setParticula(String particula) {
		this.particula = particula;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public Integer getCodCatastro() {
		return codCatastro;
	}

	public void setCodCatastro(Integer codCatastro) {
		this.codCatastro = codCatastro;
	}

	public Integer getCodINE() {
		return codINE;
	}

	public void setCodINE(Integer codINE) {
		this.codINE = codINE;
	}

	public Integer getCodHacienda() {
		return codHacienda;
	}

	public void setCodHacienda(Integer codHacienda) {
		this.codHacienda = codHacienda;
	}

	public Date getfAprobacion() {
		return fAprobacion;
	}

	public void setfAprobacion(Date fAprobacion) {
		this.fAprobacion = fAprobacion;
	}

	public Date getfAltaSistema() {
		return fAltaSistema;
	}

	public void setfAltaSistema(Date fAltaSistema) {
		this.fAltaSistema = fAltaSistema;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public TipoVia getRefTipoVia() {
		return refTipoVia;
	}

	public void setRefTipoVia(TipoVia refTipoVia) {
		this.refTipoVia = refTipoVia;
	}



}
