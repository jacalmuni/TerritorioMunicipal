/**
 * 
 */
package tfgterritorio.servlet;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;


import tfgterritorio.acciones.*;
import tfgterritorio.filtros.*;
import org.openxava.jpa.*;

public class ServletLogout extends HttpServlet {

	
	public ServletLogout() {
		super();
	}

	protected void doGet(final HttpServletRequest req,
			final HttpServletResponse resp) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@SuppressWarnings({ "static-access", "unused" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute(AccionLogin.ATRIBUTO_USUARIO,
				null);

		response.sendRedirect("/" + AccesoFilter.NOMBRE_APLICACION_WEB
						+ "/modules/Login");

	}

	protected static int unsignedByteToInt(byte b) {
		return (int) b & 0xFF;
	}
}
