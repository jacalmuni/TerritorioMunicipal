
package tfgterritorio.acciones;

import java.awt.image.*;
import java.text.*;
import java.util.*;

import javax.persistence.*;
import javax.servlet.*;

import org.openxava.actions.*;
import org.openxava.jpa.*;

import tfgterritorio.modelo.*;
import tfgterritorio.modelo.Domicilio.Estado;

/**
 * @author  José Antonio Calderón Muñoz
 */

//Clase que implementa el controlador GenerarDomiciliosTrastero.
//Crea un conjunto de domicilios de tipo trastero.
public class GenerarDomiciliosTrastero extends ViewBaseAction implements IForwardAction {

	private String url = null;

	public void execute() throws Exception {
		
		Direccion direccion = (Direccion) getView().getEntity();

		Integer ginicio = direccion.getTrasteroIni().intValue();
		Integer gfinal = direccion.getTrasteroFin().intValue();
		if ((ginicio > gfinal) || (ginicio == null) || (gfinal == null)) {
			addError("El rango no es correcto.");
			return;
			}
		
		String msg;
		Integer cuentaDomicilios=0;
		
		if (direccion.getIdDireccion() == null){
			msg = "Debe seleccionar una Dirección";
			addError(msg);
			return;
			} else {
				String consulta = "select domic FROM Domicilio domic where domic.refDireccion = " + direccion.getIdDireccion();
				Query query = XPersistence.getManager().createQuery(consulta);
				List<Domicilio> listaDomicilios = query.getResultList();
				Integer numeroDomicilios = 0;
				Iterator<Domicilio> ldomi = listaDomicilios.iterator();
				while (ldomi.hasNext()) {
					Domicilio rdomicilio = ldomi.next();
					if (rdomicilio.getNumTrastero() == null){
						continue;
					}
					if ((rdomicilio.getNumTrastero() >= direccion.getTrasteroIni()) && (rdomicilio.getNumTrastero() <= direccion.getTrasteroFin())) 
						numeroDomicilios++;
					}
				if (numeroDomicilios > 0){
					msg = "Ya existen Domicilios Trastero en este rango.";
					addError(msg);
					return;
					}
			}
		
		Calle calle;
		String qSelect1 = "select c FROM Calle c where c.idCalle = " + direccion.getRefCalle().getIdCalle();
		Query query1 = XPersistence.getManager().createQuery(qSelect1);
		calle = (Calle)query1.getSingleResult();
		String nombreCalle = calle.getNombreLargo();
		
		String dirCompleta = ""; 

		if (( (direccion.getNumero() == null) || (direccion.getNumero() == 0) ) && ( (direccion.getPuntokm() == null) || (direccion.getPuntokm() == 0) )){

			dirCompleta = "S/N";
			
			} else {
				
				if ((direccion.getNumero() != null) && (!direccion.getNumero().equals(0))){

					if ((direccion.getLetra() != null) && (!direccion.getLetra().equals(""))){

						dirCompleta = dirCompleta+" "+direccion.getNumero()+" "+direccion.getLetra();

						} else{
							
							dirCompleta = dirCompleta+" "+direccion.getNumero();
							
						}
					
					if ((direccion.getBloque() != null) && (!direccion.getBloque().equals(""))){
							dirCompleta = dirCompleta + " Blq " + direccion.getBloque();
						}
					if ((direccion.getPuntokm() != null) && (!direccion.getPuntokm().equals(0))){
							dirCompleta = dirCompleta + " Km " + direccion.getPuntokm();
						}
					
					}

			}	
		// Graba los domicilios.		
		for (int i = direccion.getTrasteroIni(); i <= direccion.getTrasteroFin(); i++) {
			Domicilio domi = new Domicilio();
			domi.setRefCalle(direccion.getRefCalle().getIdCalle());
			domi.setRefDireccion(direccion);
			domi.setEstado(Estado.ALTA);
			domi.setNumTrastero(i);
			String dirCompleta1 = dirCompleta + " Trastero " + i;
			dirCompleta1 = nombreCalle + " " + dirCompleta1;
			domi.setDomicLargo(dirCompleta1);
			XPersistence.getManager().persist(domi);
			new MontaelDomicilio();
			cuentaDomicilios++;
			}		

		msg = "Se han creado " + cuentaDomicilios + " Domicilios Trastero en esta Dirección.";
		this.addMessage(msg);
			
		}
	
	public String getForwardURI() {
		return url;
	}

	public boolean inNewWindow() {
		// TODO Auto-generated method stub
		return true;
	}


}
