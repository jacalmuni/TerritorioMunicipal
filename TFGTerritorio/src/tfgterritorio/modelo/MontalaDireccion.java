package tfgterritorio.modelo;

import java.util.*;

import org.openxava.actions.*;
import org.openxava.model.*;

/**
 * @author José Antonio Calderón Muñoz
 */

//Clase que implementa el controlador MontalaDireccion.
//Crea dinamicamente la denominación de la dirección.
public class MontalaDireccion extends OnChangePropertyBaseAction {
	Calle calle;
	
	public void execute() throws Exception {
		
		Direccion direccion = (Direccion)getView().getEntity();
		// Debe existir una dirección seleccionada.
		if (direccion.getRefCalle().getIdCalle() == null)
			return;
		
		Map clave = new HashMap(0);
		clave.put("idCalle", direccion.getRefCalle().getIdCalle());
		calle = (Calle)MapFacade.findEntity("Calle", clave);	// Lee la entidad calle.
		String nombreCalle = calle.getNombreLargo();

		String dirCompleta = ""; 
		
		if (( ((Integer)getView().getValue("numero") == null) || ((Integer)getView().getValue("numero") == 0) ) && ( ((Integer)getView().getValue("puntokm") == null) || ((Integer)getView().getValue("puntokm") == 0) )){

			dirCompleta = "S/N";
			
			} else {

				if (((Integer)getView().getValue("numero") != null) && ((Integer)getView().getValue("numero") != 0)){

					if ((getView().getValue("letra") != null) && (getView().getValue("letra") != " ")){

						dirCompleta = dirCompleta+" "+getView().getValue("numero")+" "+getView().getValue("letra");

						} else{
							
							dirCompleta = dirCompleta+" "+getView().getValue("numero");
							
						}
					}

			}
		if ((getView().getValue("bloque") != null) && (!getView().getValue("bloque").equals(""))){
			dirCompleta = dirCompleta + " Blq " + (String)getView().getValue("bloque");
			}
		if ((getView().getValue("puntokm") != null) && (!getView().getValue("puntokm").equals(0))){
			dirCompleta = dirCompleta + " Km " + getView().getValue("puntokm");
			}
	
		
		dirCompleta = nombreCalle + " " + dirCompleta;
		
		getView().setValue("direcLarga", dirCompleta );

	}

}