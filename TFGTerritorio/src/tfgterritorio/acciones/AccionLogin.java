
package tfgterritorio.acciones;

import java.util.*;

import javax.persistence.*;


import tfgterritorio.modelo.*;
import org.openxava.actions.*;
import org.openxava.jpa.*;
import org.openxava.util.*;

// Clase que implementa el contgrolador AccionLogin.
public class AccionLogin extends ViewBaseAction implements IForwardAction {
	public static String ATRIBUTO_USUARIO = "usuarioaplicacion";
	public static String ATRIBUTO_MUNICIPIO = "municipioaplicacion";
	private String urlInicio;
	
	public AccionLogin() {
		super();
		ResourceBundle config = ResourceBundle.getBundle(this.getClass()
				.getName().toString());

		urlInicio = config.getString("urlInicio");
		
		}

	public void execute() throws Exception {
		// Verifica el acceso usuario y contraseña.
		Map valores = this.getView().getValues();
		String login = (String) valores.get("login");
		String pass = (String) valores.get("password");
		Query query = XPersistence.getManager().createQuery(
				"select u from Usuario u where u.codUsuario = '" + login
						+ "' and u.clave = '" + pass + "'");
		try {
			Usuario usuario = (Usuario) query.getSingleResult();
			// hay que ponerlo en el contexto para poder recuperarlo en los
			// filtros.
			getView().getRequest().getSession().setAttribute(ATRIBUTO_USUARIO, usuario);
			getView().getRequest().getSession().setAttribute(ATRIBUTO_MUNICIPIO, usuario.getMunicipio().getIdMunicipio());
			
		} catch (NoResultException ex1) {

			addError("usuario_desconocido");
		}

	}	

	private void limpiarLogin() throws Exception{
		Login login = (Login)getView().getEntity();
		login.setPassword("");
		getView().setModel(login);
	}
	
	public String getForwardURI() {
		// TODO Auto-generated method stub
		return urlInicio;
	}

	public String getUrlInicio() {
		return urlInicio;
	}

	public void setUrlInicio(String urlInicio) {
		this.urlInicio = urlInicio;
	}

	public boolean inNewWindow() {
		// TODO Auto-generated method stub
		return false;
	}

}
