package tfgterritorio.filtros;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import tfgterritorio.acciones.*;
import tfgterritorio.modelo.*;

import org.apache.commons.logging.*;

/**
 * @author  José Antonio Calderón Muñoz
 */

//Clase que implementa el filtro AccesoFilter.
//Establece las variables que se presentan en la cabecera del interfaz de usuario.
public class AccesoFilter implements Filter {
	public static String NOMBRE_APLICACION_WEB = "TFGTerritorio";

	private Usuario usuario;
	private FilterConfig filterConfig = null;
	private Log LOG = LogFactory.getLog(getClass());

	public void destroy() {
		this.setFilterConfig(null);
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		usuario = (Usuario) ((HttpServletRequest) request).getSession().getAttribute(AccionLogin.ATRIBUTO_USUARIO);
		String url = ((HttpServletRequest) request).getRequestURI();

		if (usuario != null) LOG.debug("url: " + url + "--- usuario " + usuario.getCodUsuario());

		if (puedePasar(url)) {
			chain.doFilter(request, response);
			return;
		} else {
			if (usuario == null) {
				Integer cont = (Integer) ((HttpServletRequest) request)
						.getSession().getAttribute("cont");
				if (cont == null) {
					cont = 0;
				}
				if (cont < 3) {
					((HttpServletRequest) request).getSession().setAttribute(
							"cont", ++cont);
					((HttpServletResponse) response).sendRedirect("/"
							+ AccesoFilter.NOMBRE_APLICACION_WEB
							+ "/modules/Login");
				} else
					((HttpServletResponse) response).sendRedirect("/"
							+ AccesoFilter.NOMBRE_APLICACION_WEB
							+ "/error.html");
			} else {
				chain.doFilter(request, response);
				return;
			}
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.setFilterConfig(filterConfig);
	}

	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public boolean puedePasar(String url) {
		return url.equals("/" + AccesoFilter.NOMBRE_APLICACION_WEB
				+ "/modules/Login");

	}
}
