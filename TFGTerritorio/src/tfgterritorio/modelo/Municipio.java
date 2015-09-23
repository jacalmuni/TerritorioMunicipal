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

//Clase que implementa el componente de negocio Municipio.
public class Municipio extends BaseControl {
	
	// Identificador de Municipio.	Clave Primaria.
	@Id
	@GeneratedValue(generator = "Municipioid", strategy = GenerationType.TABLE )
	@TableGenerator(name = "Municipioid", pkColumnValue = "idMunicipio", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)	
	@Hidden

	@ReadOnly
	private Integer idMunicipio;
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	@Required
	private Integer codMunicipio;
	
	@Column(length = 25)
	@DisplaySize(value = 25)
	@Required
	private String nombre;

	@Column(length = 60)
	@DisplaySize(value = 60)
	private String nombreLargo;
	
	@Column(length = 60)
	@DisplaySize(value = 60)
	private String provincia;
	
	@Column(length = 10)
	@DisplaySize(value = 10)
	private String telefono;
	
	@Column(length = 30)
	@DisplaySize(value = 30)
	private String domicilio;
	
	@Column(length = 5)
	@DisplaySize(value = 5)
	private Integer codPostal;
	
	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public Integer getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(Integer codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Integer getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(Integer codPostal) {
		this.codPostal = codPostal;
	}

}
