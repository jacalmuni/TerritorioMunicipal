package tfgterritorio.modelo;

import java.util.*;

import org.openxava.actions.*;
import org.openxava.model.*;

/**
 * @author  José Antonio Calderón Muñoz
 */

//Clase que implementa el controlador MontaelDomicilio.
//Crea dinamicamente la denominación del domicilio.
public class MontaelDomicilio extends OnChangePropertyBaseAction {
	Direccion direccion;
	
	public void execute() throws Exception {
		
		Domicilio domicilio = (Domicilio)getView().getEntity();
		// Debe existir un domicilio seleccionado.
		if (domicilio.getRefDireccion().getIdDireccion() == null)
			return;
		
		Map clave = new HashMap(0);
		
		String domCompleto = ""; 
		// Lee la entidad dirección del domicilio.
		clave.put("idDireccion", domicilio.getRefDireccion().getIdDireccion());
		direccion = (Direccion)MapFacade.findEntity("Direccion", clave);
		String direcLarga = direccion.getDirecLarga();

		// Evalua el Portal.
		if (domicilio.getRefPortal().getIdPortal() != null){
			clave.put("idPortal", domicilio.getRefPortal().getIdPortal());
			TipoPortal portal = (TipoPortal)MapFacade.findEntity("TipoPortal", clave);
			String codPortal = portal.getPortal();		
			domCompleto = domCompleto + " Portal: " + codPortal; 
		}
		
		clave.clear();
		// Evalua el Escalera.
		if (domicilio.getRefEscalera().getIdEscalera() != null) {
			clave.put("idEscalera", domicilio.getRefEscalera().getIdEscalera());
			TipoEscalera escalera = (TipoEscalera)MapFacade.findEntity("TipoEscalera", clave);
			String codEscalera = escalera.getEscalera();		

			domCompleto = domCompleto + " Escalera: " + codEscalera; 
		}
		
		clave.clear();
		// Evalua el Planta.		
		if (domicilio.getRefPlanta().getIdPlanta() != null) {
			clave.put("idPlanta", domicilio.getRefPlanta().getIdPlanta());
			TipoPlanta planta = (TipoPlanta)MapFacade.findEntity("TipoPlanta", clave);
			String codPlanta = planta.getPlanta();		
			
			domCompleto = domCompleto + " Planta: " + codPlanta; 
		}
		
		clave.clear();
		// Evalua el Puerta.
		if (domicilio.getRefPuerta().getIdPuerta() != null) {
			clave.put("idPuerta", domicilio.getRefPuerta().getIdPuerta());
			TipoPuerta puerta = (TipoPuerta)MapFacade.findEntity("TipoPuerta", clave);
			String codPuerta = puerta.getPuerta();		

			domCompleto = domCompleto + " Puerta: " + codPuerta; 
		}
		
		clave.clear();
		// Evalua el Local.
		if (domicilio.getRefLocal().getIdLocal() != null) {
			clave.put("idLocal", domicilio.getRefLocal().getIdLocal());
			TipoLocal local = (TipoLocal)MapFacade.findEntity("TipoLocal", clave);
			String codLocal = local.getLocal();		

			domCompleto = domCompleto + " Local: " + codLocal; 
		}
		// Evalua el Garaje.
		if  (((Integer)getView().getValue("numGaraje") != null) && ((Integer)getView().getValue("numGaraje") != 0)) {
			domCompleto = domCompleto + " Garaje: " + ((Integer)getView().getValue("numGaraje"));
		}
		// Evalua el Trastero.
		if  (((Integer)getView().getValue("numTrastero") != null) && ((Integer)getView().getValue("numTrastero") != 0)) {
			domCompleto = domCompleto + " Trastero: " + ((Integer)getView().getValue("numTrastero"));
		}
		
		domCompleto = direcLarga + " " + domCompleto;
		
		getView().setValue("domicLargo", domCompleto );

	}

}