package tfgterritorio.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

/**
 * @author José Antonio Calderón Muñoz
 *
 */

//Clase de persistencia.
@Entity
@Table(name = "seg_menuitem")	//Entidad de datos seg_menu.
//Vista modo detalle.
@Views({ @View( members = "etiqueta;orden;path;url; menu")})
//Vista modo lista.
@Tabs({ @Tab( properties = "etiqueta, orden, path, url, menu.descripcion") })

//Clase que implementa el componente de negocio MenuItem.
public class MenuItem  extends BaseControl {

	// Identificador de MenuItem.	Clave Primaria.
	@Id
	@GeneratedValue(generator = "MenuItemid", strategy = GenerationType.TABLE )
	@TableGenerator(name = "MenuItemid", pkColumnValue = "idMenuItem", table = "secuencias", pkColumnName = "secuencia", valueColumnName = "valor", initialValue = 1, allocationSize = 1)	
	@Hidden
	@ReadOnly
	private Integer idMenuItem;	
	
	@Required
	private String etiqueta;
	
	private String url;
	
	// Referencia a Menu.
	@ManyToOne
	@JoinColumn(name = "idMenu", referencedColumnName = "idMenu")	
	@DescriptionsList
	private Menu menu;
	
	private Integer orden;
	
	private String path=null;

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getIdMenuItem() {
		return idMenuItem;
	}

	public void setIdMenuItem(Integer idMenuItem) {
		this.idMenuItem = idMenuItem;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	

}
