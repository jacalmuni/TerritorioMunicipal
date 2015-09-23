package tfgterritorio.modelo;

import java.io.*;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "usuario")	//Entidad de datos usuario.
//Vista modo detalle.
@Views({ @View( members = "codUsuario;clave;apellido1;apellido2;nombre; perfil; municipio")})	// Edicion Registro
//Vista modo lista.
@Tabs({ @Tab( properties = "codUsuario,clave,apellido1,apellido2,nombre, perfil.descripcion, municipio.nombre") })	// Browse

//Clase que implementa el componente de negocio Usuario.
public class Usuario extends BaseControl {
	
	// Identificador de usuario. Clave Primaria.	
	@Id
	@GeneratedValue(generator = "Usuarioid", strategy = GenerationType.TABLE )
	@TableGenerator(name = "Usuarioid", pkColumnValue = "idUsuario", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)	
	@Hidden
	@ReadOnly
	private Integer idUsuario;
	
	@Column(length = 9)
	@DisplaySize(value = 9)
	@Required
	private String codUsuario;
	
	@Column(length = 20)
	@DisplaySize(value = 20)
	@Required
	private String nombre;

	@Column(length = 20)
	@DisplaySize(value = 20)
	@Required
	private String apellido1;

	@Column(length = 20)
	@DisplaySize(value = 20)
	private String apellido2;
	
	@Column(length = 100)
	@DisplaySize(value = 50)
	@Required
	private String clave;

	// Referencia a Perfil de opciones.
	@ManyToOne
	@JoinColumn(name="idPerfil", referencedColumnName="idPerfil")
	@DescriptionsList
	private Perfil perfil;
	
	// Referencia a Municipios.
	@ManyToOne
	@JoinColumn(name = "refMunicipio", referencedColumnName = "idMunicipio")
	@DescriptionsList(descriptionProperties="nombre")	
	@Required
	private Municipio municipio;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
}
