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
@Table(name = "seg_menu")	//Entidad de datos seg_menu.
//Vista modo detalle.
@Views({ @View(members = "descripcion; items"), 
	 @View(name = "sinDetalle", members = "descripcion")})
//Vista modo lista.
@Tabs({ @Tab(properties = "descripcion") })

//Clase que implementa el componente de negocio Menu.
public class Menu extends BaseControl {

	// Identificador de Menu. Clave Primaria.
	@Id
	@GeneratedValue(generator = "Menuid", strategy = GenerationType.TABLE )
	@TableGenerator(name = "Menuid", pkColumnValue = "idMenu", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)	
	@Hidden
	@ReadOnly
	private Integer idMenu;	

	@Required
	private String descripcion;
	
	// Referencia a MenuItem.
	@OneToMany(mappedBy="menu", cascade = CascadeType.REMOVE)
	@Editor(value="TreeView") // Editor TreeView.
	@ListProperties("etiqueta") // 2
	@OrderBy("path, orden") // 3
	@Tree(pathProperty="path") // 4
	private List<MenuItem> items;

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<MenuItem> getItems() {
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}

	
}
