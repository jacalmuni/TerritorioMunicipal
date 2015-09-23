package tfgterritorio.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "direccion")	//Entidad de datos Direccion.
//Vista modo detalle.
@Views({ 
	@View(name = "vistaDireccion", members = "refCalle; numero, letra; direcLarga; numAnterior, letraAnterior; bloque, puntokm; codPostal; estado; fAltaSistema;GeneraDomiciliosTrastero[trasteroIni, trasteroFin];GeneraDomiciliosGaraje[garajeIni, garajeFin]"),
	@View(name = "vistaTrastero", members = "direcLarga; trasteroIni; trasteroFin")
})	
//Vista modo lista.
@Tabs({ @Tab( properties = "direcLarga, codPostal, estado, fAltaSistema, numero, letra, numAnterior,letraAnterior, bloque, puntokm") })	// Browse

//Clase que implementa el componente de negocio Direccion.
public class Direccion extends BaseControl {
	
	// Identificador de Direccion. Clave Primaria.
	@Id
	@GeneratedValue(generator = "idDireccion", strategy = GenerationType.TABLE)
	@TableGenerator(name = "idDireccion", pkColumnValue = "idDireccion", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)
	@ReadOnly
	private Integer idDireccion;	
	
	// Referencia a Calle.
	@ManyToOne
	@JoinColumn(name = "refCalle", referencedColumnName = "idCalle")
	@OnChange(MontalaDireccion.class)	// Crea el denominación textual de la Direccion en una cadena de caracteres.
	@DescriptionsList(condition = "estado = 0 ", descriptionProperties="nombreLargo")
	@Required
	private Calle refCalle;

	@Column(length = 5)
	@DisplaySize(value = 5)
	@OnChange(MontalaDireccion.class)	// Crea el denominación textual de la Direccion en una cadena de caracteres.
	private Integer numero;
	
	@Column(length = 3)
	@DisplaySize(value = 3)
	@OnChange(MontalaDireccion.class)
	private String letra;
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	private Integer numAnterior;
	
	@Column(length = 3)
	@DisplaySize(value = 3)
	private String letraAnterior;
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	@OnChange(MontalaDireccion.class)
	private String bloque;
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	@OnChange(MontalaDireccion.class)
	private Integer puntokm;
	
	@Column(length = 90)
	@ReadOnly
	private String direcLarga;	
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	@Required
	private String codPostal;

	// Propiedad Estado con editor RadioButtom
	@DefaultValueCalculator(value=org.openxava.calculators.LongCalculator.class,
			properties={ @PropertyValue(name="value", value="0") 
			})
	@Editor("ValidValuesVerticalRadioButton")
	@Required
	private Estado estado;
	public enum Estado {ALTA, BAJA}; 

	@Column
	@Required
	private Date fAltaSistema;
	
	@Transient
	@DisplaySize(value = 4)
	private Integer trasteroIni;

	@Transient
	@DisplaySize(value = 4)
	private Integer trasteroFin;

	@Transient
	@DisplaySize(value = 4)
	private Integer garajeIni;

	@Transient
	@DisplaySize(value = 4)
	private Integer garajeFin;
	
	
	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public Calle getRefCalle() {
		return refCalle;
	}

	public void setRefCalle(Calle refCalle) {
		this.refCalle = refCalle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public Integer getNumAnterior() {
		return numAnterior;
	}

	public void setNumAnterior(Integer numAnterior) {
		this.numAnterior = numAnterior;
	}

	public String getLetraAnterior() {
		return letraAnterior;
	}

	public void setLetraAnterior(String letraAnterior) {
		this.letraAnterior = letraAnterior;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public Integer getPuntokm() {
		return puntokm;
	}

	public void setPuntokm(Integer puntokm) {
		this.puntokm = puntokm;
	}

	public String getDirecLarga() {
		return direcLarga;
	}

	public void setDirecLarga(String direcLarga) {
		this.direcLarga = direcLarga;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getfAltaSistema() {
		return fAltaSistema;
	}

	public void setfAltaSistema(Date fAltaSistema) {
		this.fAltaSistema = fAltaSistema;
	}

	public Integer getTrasteroIni() {
		return trasteroIni;
	}

	public void setTrasteroIni(Integer trasteroIni) {
		this.trasteroIni = trasteroIni;
	}

	public Integer getTrasteroFin() {
		return trasteroFin;
	}

	public void setTrasteroFin(Integer trasteroFin) {
		this.trasteroFin = trasteroFin;
	}

	public Integer getGarajeIni() {
		return garajeIni;
	}

	public void setGarajeIni(Integer garajeIni) {
		this.garajeIni = garajeIni;
	}

	public Integer getGarajeFin() {
		return garajeFin;
	}

	public void setGarajeFin(Integer garajeFin) {
		this.garajeFin = garajeFin;
	}



}
