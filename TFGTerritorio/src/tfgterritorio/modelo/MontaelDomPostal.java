package tfgterritorio.modelo;

import java.util.*;

import org.openxava.actions.*;
import org.openxava.model.*;

/**
 * @author José Antonio Calderón Muñoz
 */

//Clase que implementa el controlador MontaelDomPostal.
//Crea dinamicamente la denominación del domicilio postal.
public class MontaelDomPostal extends OnChangePropertyBaseAction {
	
	public void execute() throws Exception {
		
		ElemTerri elemTerri = (ElemTerri)getView().getEntity();
		
		Map clave = new HashMap(0);
		
		String domPostal = ""; 
		// Evalua la Calle.
		if (elemTerri.getRefCalle().getIdCalle() != null){
			clave.put("idCalle", elemTerri.getRefCalle().getIdCalle());
			Calle calle = (Calle)MapFacade.findEntity("Calle", clave);
			String nombreCalle = calle.getNombreLargo();		
			domPostal = nombreCalle; 
		}
		
		clave.clear();
		// Evalua la Dirección.
		if (elemTerri.getRefDireccion().getIdDireccion() != null){
			clave.put("idDireccion", elemTerri.getRefDireccion().getIdDireccion());
			Direccion direccion = (Direccion)MapFacade.findEntity("Direccion", clave);
			String direcLarga = direccion.getDirecLarga();		
			domPostal = direcLarga; 
		}
		
		clave.clear();
		// Evalua el Domicilio.		
		if (elemTerri.getRefDomicilio().getIdDomicilio() != null){
			clave.put("idDomicilio", elemTerri.getRefDomicilio().getIdDomicilio());
			Domicilio domicilio = (Domicilio)MapFacade.findEntity("Domicilio", clave);
			String domicLargo = domicilio.getDomicLargo();		
			domPostal = domicLargo; 
		}
		
		if (elemTerri.getLocalizacion() != null) {
			domPostal = domPostal + " " + elemTerri.getLocalizacion();
		}
		
		getView().setValue("domicilioPostal", domPostal );

	}

}