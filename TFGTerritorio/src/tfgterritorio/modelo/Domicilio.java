package tfgterritorio.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "domicilio")	//Entidad de datos Domicilio.
//Vista modo detalle.
@Views({ @View( members = "refDireccion; domicLargo;refPortal;refEscalera;refPlanta; refPuerta; refLocal; numGaraje; numTrastero; estado")})	// Edicion Registro
//Vista modo lista.
@Tabs({ @Tab( properties = "domicLargo,refPortal.portal,refEscalera.escalera,refPlanta.planta, refPuerta.puerta, refLocal.local, numGaraje, numTrastero, estado") })	// Browse

//Clase que implementa el componente de negocio Domicilio.
public class Domicilio extends BaseControl {

	// Identificador de Domicilio. Clave Primaria.
	@Id
	@GeneratedValue(generator = "idDomicilio", strategy = GenerationType.TABLE)
	@TableGenerator(name = "idDomicilio", pkColumnValue = "idDomicilio", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)
	@ReadOnly
	private Integer idDomicilio;	

	// Referencia a Portal.
	@ManyToOne
	@JoinColumn(name = "refPortal", referencedColumnName = "idPortal")
	@OnChange(MontaelDomicilio.class)	// Crea la denominación textual del Domicilio en una cadena de caracteres.
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="portal")
	private TipoPortal refPortal;	
	
	// Referencia a Escalera.
	@ManyToOne
	@JoinColumn(name = "refEscalera", referencedColumnName = "idEscalera")
	@OnChange(MontaelDomicilio.class)	// Crea la denominación textual del Domicilio en una cadena de caracteres.
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="escalera")
	private TipoEscalera refEscalera;	
			
	// Referencia a Planta.
	@ManyToOne
	@JoinColumn(name = "refPlanta", referencedColumnName = "idPlanta")
	@OnChange(MontaelDomicilio.class)	// Crea la denominación textual del Domicilio en una cadena de caracteres.
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="planta")
	private TipoPlanta refPlanta;	
			
	// Referencia a Puerta.
	@ManyToOne
	@JoinColumn(name = "refPuerta", referencedColumnName = "idPuerta")
	@OnChange(MontaelDomicilio.class)
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="puerta")
	private TipoPuerta refPuerta;	
	
	// Referencia a Local.
	@ManyToOne
	@JoinColumn(name = "refLocal", referencedColumnName = "idLocal")
	@OnChange(MontaelDomicilio.class)
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="local")
	private TipoLocal refLocal;	
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	@OnChange(MontaelDomicilio.class)
	private Integer numGaraje;
	
	@Column(length = 4)
	@DisplaySize(value = 4)
	@OnChange(MontaelDomicilio.class)
	private Integer numTrastero;
	
	@Column(length = 200)
	@ReadOnly
	private String domicLargo;	
	
	// Propiedad Estado con editor RadioButtom
	@DefaultValueCalculator(value=org.openxava.calculators.LongCalculator.class,
			properties={ @PropertyValue(name="value", value="0") 
			})
	@Editor("ValidValuesVerticalRadioButton")
	@Required
	private Estado estado;
	public enum Estado {ALTA, BAJA}

	@Column(length = 8)
	@Hidden
	private Integer refCalle;

	// Referencia a Direccion.
	@ManyToOne
	@JoinColumn(name = "refDireccion", referencedColumnName = "idDireccion")
	@OnChange(MontaelDomicilio.class)
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="direcLarga")
	@Required
	private Direccion refDireccion;

	public Integer getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(Integer idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public TipoPortal getRefPortal() {
		return refPortal;
	}

	public void setRefPortal(TipoPortal refPortal) {
		this.refPortal = refPortal;
	}

	public TipoEscalera getRefEscalera() {
		return refEscalera;
	}

	public void setRefEscalera(TipoEscalera refEscalera) {
		this.refEscalera = refEscalera;
	}

	public TipoPlanta getRefPlanta() {
		return refPlanta;
	}

	public void setRefPlanta(TipoPlanta refPlanta) {
		this.refPlanta = refPlanta;
	}

	public TipoPuerta getRefPuerta() {
		return refPuerta;
	}

	public void setRefPuerta(TipoPuerta refPuerta) {
		this.refPuerta = refPuerta;
	}

	public TipoLocal getRefLocal() {
		return refLocal;
	}

	public void setRefLocal(TipoLocal refLocal) {
		this.refLocal = refLocal;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getNumGaraje() {
		return numGaraje;
	}

	public void setNumGaraje(Integer numGaraje) {
		this.numGaraje = numGaraje;
	}

	public Integer getNumTrastero() {
		return numTrastero;
	}

	public void setNumTrastero(Integer numTrastero) {
		this.numTrastero = numTrastero;
	}

	public Integer getRefCalle() {
		return refCalle;
	}

	public void setRefCalle(Integer refCalle) {
		this.refCalle = refCalle;
	}

	public Direccion getRefDireccion() {
		return refDireccion;
	}

	public void setRefDireccion(Direccion refDireccion) {
		this.refDireccion = refDireccion;
	}

	public String getDomicLargo() {
		return domicLargo;
	}

	public void setDomicLargo(String domicLargo) {
		this.domicLargo = domicLargo;
	}
	

	

}
