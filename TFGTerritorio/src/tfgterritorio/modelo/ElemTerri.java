package tfgterritorio.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "ElemTerri")	//Entidad de datos ElemTerri.
//Vista modo detalle.
@Views({ @View( members = "refTipoElemTerri;descripcion;localizacion;refCalle;refDireccion;refDomicilio;domicilioPostal;refElemenComun;refElemenPadre;inscripRegistral;observaciones;coordenadax;coordenaday; estado;")})
//Vista modo lista.
@Tabs({ @Tab( properties = " domicilioPostal,refTipoElemTerri.descripcion, descripcion, localizacion, refElemenComun.domicilioPostal,refElemenPadre.domicilioPostal,coordenadax, coordenaday, estado") })

//Clase que implementa el componente de negocio ElemTerri.
public class ElemTerri extends BaseControl {

	// Identificador de ElemTerri.	Clave Primaria.
	@Id
	@GeneratedValue(generator = "idElemterri", strategy = GenerationType.TABLE)
	@TableGenerator(name = "idElemterri", pkColumnValue = "idElemterri", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)
	@ReadOnly
	private Integer idElemterri;	

	// Referencia a Tipo Elemento del Territorio. Clave Foránea.
	@ManyToOne
	@JoinColumn(name = "refTipoElemTerri", referencedColumnName = "idTipoElemTerri")
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="descripcion")
	@Required
	private TipoElemTerri refTipoElemTerri;
		
	@Column(length = 100)
	@DisplaySize(value = 60)
	private String descripcion;
	
	@Column(length = 100)
	@DisplaySize(value = 60)
	@OnChange(MontaelDomPostal.class)
	private String localizacion;
	
	// Referencia a Calle. Clave Foránea.
	@ManyToOne
	@JoinColumn(name = "refCalle", referencedColumnName = "idCalle")
	@OnChange(MontaelDomPostal.class)	// Crea la denominación textual de domicilio postal en una cadena de caracteres.
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="nombreLargo")
	private Calle refCalle;

	// Referencia a Dirección. Clave Foránea.
	@ManyToOne
	@JoinColumn(name = "refDireccion", referencedColumnName = "idDireccion")
	@OnChange(MontaelDomPostal.class)	// Crea la denominación textual de domicilio postal en una cadena de caracteres.
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="direcLarga")
	private Direccion refDireccion;

	// Referencia a Domicilio. Clave Foránea.
	@ManyToOne
	@JoinColumn(name = "refDomicilio", referencedColumnName = "idDomicilio")
	@OnChange(MontaelDomPostal.class)	// Crea la denominación textual de domicilio postal en una cadena de caracteres.
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="domicLargo")
	private Domicilio refDomicilio;
		
	@Column(length = 300)
	@DisplaySize(value = 60)
	private String domicilioPostal;
	
	@ManyToOne
	@JoinColumn(name = "refElemenComun", referencedColumnName = "idElemTerri")
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="domicilioPostal")
	private ElemTerri refElemenComun;	
	
	@ManyToOne
	@JoinColumn(name = "refElemenPadre", referencedColumnName = "idElemTerri")
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="domicilioPostal")
	private ElemTerri refElemenPadre;		

	// Propiedad Estado con editor RadioButtom
	@DefaultValueCalculator(value=org.openxava.calculators.LongCalculator.class,
			properties={ @PropertyValue(name="value", value="0") })
	@Editor("ValidValuesVerticalRadioButton")
	@Required
	private Estado estado;
	public enum Estado {ALTA, BAJA}
	
	@Column(length = 80)
	@DisplaySize(value = 30)
	private String inscripRegistral;
	
	@Column(length = 255)
	@DisplaySize(value = 30)
	private String observaciones;
	
	@Column(length = 16)
	@DisplaySize(value = 16)
	private Long coordenadax;
	
	@Column(length = 16)
	@DisplaySize(value = 16)
	private Long coordenaday;

	public Integer getIdElemterri() {
		return idElemterri;
	}

	public void setIdElemterri(Integer idElemterri) {
		this.idElemterri = idElemterri;
	}

	public TipoElemTerri getRefTipoElemTerri() {
		return refTipoElemTerri;
	}

	public void setRefTipoElemTerri(TipoElemTerri refTipoElemTerri) {
		this.refTipoElemTerri = refTipoElemTerri;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public Calle getRefCalle() {
		return refCalle;
	}

	public void setRefCalle(Calle refCalle) {
		this.refCalle = refCalle;
	}

	public Direccion getRefDireccion() {
		return refDireccion;
	}

	public void setRefDireccion(Direccion refDireccion) {
		this.refDireccion = refDireccion;
	}

	public Domicilio getRefDomicilio() {
		return refDomicilio;
	}

	public void setRefDomicilio(Domicilio refDomicilio) {
		this.refDomicilio = refDomicilio;
	}

	public String getDomicilioPostal() {
		return domicilioPostal;
	}

	public void setDomicilioPostal(String domicilioPostal) {
		this.domicilioPostal = domicilioPostal;
	}

	public ElemTerri getRefElemenComun() {
		return refElemenComun;
	}

	public void setRefElemenComun(ElemTerri refElemenComun) {
		this.refElemenComun = refElemenComun;
	}

	public ElemTerri getRefElemenPadre() {
		return refElemenPadre;
	}

	public void setRefElemenPadre(ElemTerri refElemenPadre) {
		this.refElemenPadre = refElemenPadre;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getInscripRegistral() {
		return inscripRegistral;
	}

	public void setInscripRegistral(String inscripRegistral) {
		this.inscripRegistral = inscripRegistral;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Long getCoordenadax() {
		return coordenadax;
	}

	public void setCoordenadax(Long coordenadax) {
		this.coordenadax = coordenadax;
	}

	public Long getCoordenaday() {
		return coordenaday;
	}

	public void setCoordenaday(Long coordenaday) {
		this.coordenaday = coordenaday;
	}

	

}
