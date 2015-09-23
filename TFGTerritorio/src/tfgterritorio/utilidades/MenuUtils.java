package tfgterritorio.utilidades;

import java.util.*;

import javax.persistence.Query;

import tfgterritorio.modelo.*;
import org.hibernate.*;
import org.openxava.jpa.*;

// Clase que implementa la gestión del menu del interfaz de usuario.
public class MenuUtils {

	public static String obtenerMenuOrdenado(Integer id, String sololectura) {

		String salida = "";
		String select = "From Usuario u where u.idUsuario = " + id;
		Query query = XPersistence.getManager().createQuery(select);
		Usuario usuario = (Usuario) query.getSingleResult();
		Menu menu = usuario.getPerfil().getMenu();
		String auxSalida = "";

		try {
			select = "From MenuItem mi where mi.menu=" + menu.getIdMenu()
					+ " and mi.path is null order by mi.orden";
			query = XPersistence.getManager().createQuery(select);
			List<MenuItem> items = query.getResultList();
			Iterator<MenuItem> i = items.iterator();
			while (i.hasNext()) {
				MenuItem mi = i.next();
				auxSalida = obtenerSubMenu("", mi.getIdMenuItem(), menu, sololectura);
				boolean tieneSubmenu = !auxSalida.equals("");
				String url = "#";
				if (!tieneSubmenu){
					url = mi.getUrl() + "' target='ventana'"; 
				}
				salida += "<li>";
				if (tieneSubmenu){
					salida += "<a href='"+url+"' onclick='cambio(\""+mi.getIdMenuItem()+"\")'> " + mi.getEtiqueta() + " </a>";
				} else {
					salida += "<a href='" + url + sololectura + "'  target='ventana'> " + mi.getEtiqueta()
							+ " </a>";					
				}
				salida += "</li>";
				if (tieneSubmenu){
					salida += "<div id='"+mi.getIdMenuItem()+"' style='display:none'>";	
					salida += auxSalida;
					salida += "</div>";
				}
			}
		} catch (ObjectNotFoundException ex) {
			salida = "";
		}
		return salida;
	}

	private static String obtenerSubMenu(String path, Integer idMenuItem,
			Menu menu, String sololectura) {
		String salida = "";
		String select = "From MenuItem mi where mi.menu=" + menu.getIdMenu()
				+ " and mi.path ='" + path + "/" + idMenuItem
				+ "'  order by mi.orden";
		Query query = XPersistence.getManager().createQuery(select);
		try {
			List<MenuItem> items = query.getResultList();
			Iterator<MenuItem> i = items.iterator();
			boolean lista = i.hasNext();
			if (lista){
				salida+="<ul>";
			}
			String auxSalida = "";			
			while (i.hasNext()) {
				MenuItem mi = i.next();
				auxSalida = obtenerSubMenu(mi.getPath(), mi.getIdMenuItem(), menu, sololectura);
				boolean tieneSubmenu = !auxSalida.equals("");
				String url = "#";
				if (!tieneSubmenu){
					url = mi.getUrl() + "' target='ventana'"; 
				}
				salida += "<li>";				
				if (tieneSubmenu){
					salida += "<a href='"+url+"' onclick='cambio(\""+mi.getIdMenuItem()+"\")'> " + mi.getEtiqueta() + " </a>";
				} else {
					salida += "<a href='" + url + sololectura + "'  target='ventana'> " + mi.getEtiqueta()
							+ " </a>";					
				}
				salida += "</li>";
				if (tieneSubmenu){
					salida += "<div id='"+mi.getIdMenuItem()+"' style='display:none'>";	
					salida += auxSalida;
					salida += "</div>";
				}								
			}
			if (lista){
				salida+="</ul>";
			}			
		} catch (ObjectNotFoundException ex) {
			salida = "";
		}
		return salida;
	}
}
