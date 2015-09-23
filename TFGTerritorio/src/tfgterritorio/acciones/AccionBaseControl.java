/**
 * 
 */
package tfgterritorio.acciones;

import org.openxava.actions.*;
import org.openxava.util.*;

import tfgterritorio.modelo.*;
import tfgterritorio.servlet.*;

//Clase que implementa el controlador Acción Base Control.
// Lo utiliza todos los componentes de negocio.
public class AccionBaseControl extends ViewBaseAction {

	public void execute() throws Exception {
		
		Usuario usuarioObjeto = ((Usuario)this.getRequest().getSession().getAttribute(AccionLogin.ATRIBUTO_USUARIO));
		String usuario = usuarioObjeto.getCodUsuario();
		Users.setCurrent(usuario); //Usuario actual
		String usuario2 = Integer.toString(usuarioObjeto.getMunicipio().getIdMunicipio());
		UsuariosMunicipio.setMunicipioUsuario(usuario2);
		
		
	}

}
