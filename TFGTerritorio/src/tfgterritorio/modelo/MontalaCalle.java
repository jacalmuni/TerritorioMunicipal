package tfgterritorio.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.actions.*;
//import org.openxava.jpa.*;
import org.openxava.model.*;

/**
 * @author José Antonio Calderón Muñoz
 */

//Clase que implementa el controlador MontalaCalle.
//Crea dinamicamente la denominación de la calle.
public class MontalaCalle extends OnChangePropertyBaseAction {
		
	public void execute() throws Exception {
		
		TipoVia tipoVia = new TipoVia();
		
		Calle calle = (Calle)getView().getEntity();
		// Verifica que exista una vía seleccionada.
		if (calle.getRefTipoVia().getIdTipoVia() == null)
			return;
		
		Integer idTipovia = calle.getRefTipoVia().getIdTipoVia();
				
		Map clave = new HashMap(0);

		clave.put("idTipoVia", idTipovia);
		// Lee la entidad TipoVia
		tipoVia = (TipoVia)MapFacade.findEntity("TipoVia", clave);
		
		String siglaCalle = tipoVia.getSigla();
	
		String calleCompleta = ""; 
		
		if ((getView().getValue("particula") != null) && (getView().getValue("nombre") != null)){
			calleCompleta = siglaCalle+" "+getView().getValue("particula")+" "+getView().getValue("nombre");
			
			} else {
				
				if ((getView().getValue("particula") == null) && (getView().getValue("nombre") != null)){
					calleCompleta = siglaCalle+" "+getView().getValue("refTipoVia.sigla")+" "+getView().getValue("nombre");
					} else {
						
						if ((getView().getValue("particula") != null) && (getView().getValue("nombre") == null)){
							calleCompleta = siglaCalle+" "+getView().getValue("refTipoVia.sigla")+" "+getView().getValue("particula");
							} else {
						
								if ((getView().getValue("particula") == null) && (getView().getValue("nombre") == null)){
									getView().setValue("nombreLargo", "");
									}

							}

					}

			}
		getView().setValue("nombreLargo", calleCompleta );
		
	}

}