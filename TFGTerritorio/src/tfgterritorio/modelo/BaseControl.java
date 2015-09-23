/**
 * 
 */
package tfgterritorio.modelo;

import java.lang.reflect.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

// Clase Base de la que heredan todas las clases de Negocio.

@MappedSuperclass
public abstract class BaseControl {


	@Column(length = 20)
	@Hidden
	private String uControl;	//Identificador de Usuario que modifica la fila.

	@Column
	@Hidden
	@Stereotype("FECHAHORA")
	private Date fechaModificacion;	// Fecha y hora en que se modifica la fila.

	@Column
	@Hidden
	private Integer numMunicipio; // Identificador de Municipio gestionado.
	
	@PrePersist
	@PreUpdate
	private void setControl() {
		
		
		String usu = Users.getCurrent();	// Lee el usuario que graba.

		Date fecha = new Date(System.currentTimeMillis());	// Lee fecha y hora en que se graba.
		
		Integer idMuni = Integer.parseInt(UsuariosMunicipio.getMunicipioUsuario()); //Lee Municipio gestionado.
		
		uControl = usu;
		fechaModificacion = fecha;
		numMunicipio = idMuni;
	}

	public String getuControl() {
		return uControl;
	}

	public void setuControl(String uControl) {
		this.uControl = uControl;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Integer getNumMunicipio() {
		return numMunicipio;
	}

	public void setNumMunicipio(Integer numMunicipio) {
		this.numMunicipio = numMunicipio;
	}



}