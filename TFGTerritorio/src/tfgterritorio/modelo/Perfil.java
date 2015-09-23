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
@Table(name = "seg_perfil")	//Entidad de datos seg_perfil.
//Vista modo detalle.
@Views({ @View(members = "descripcion; menu; usuarios"), })
//Vista modo lista.
@Tabs({ @Tab(properties = "descripcion, menu.descripcion") })

//Clase que implementa el componente de negocio Perfil.
public class Perfil extends BaseControl {

	// Identificador de Perfil.	Clave Primaria.
	@Id
	@GeneratedValue(generator = "Perfilid", strategy = GenerationType.TABLE )
	@TableGenerator(name = "Perfilid", pkColumnValue = "idPerfil", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)	
	@Hidden
	@ReadOnly
	private Integer idPerfil;	
	
	@Required
	private String descripcion;
	
	// Referencia a Menu. Clave Foránea.
	@ManyToOne
	@JoinColumn(name="idMenu", referencedColumnName="idMenu")
	@DescriptionsList
	private Menu menu;
	
	// Referencia a Usuarios. Clave Foránea.
	@OneToMany(mappedBy="perfil")
	@ReadOnly
	private List<Usuario> usuarios;

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}
