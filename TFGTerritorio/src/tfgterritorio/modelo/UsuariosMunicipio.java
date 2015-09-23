package tfgterritorio.modelo;

import java.util.prefs.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.*;
import org.openxava.util.*;
import org.openxava.util.impl.*;

//Clase UsuariosMunicipio
//Lee el usuario.
public class UsuariosMunicipio {
	
	private static Log log = LogFactory.getLog(UsuariosMunicipio.class);
	final private static ThreadLocal municipioUsuario = new ThreadLocal(); 
	final private static ThreadLocal municipioUsuarioInfo = new ThreadLocal();
		

	public static String getMunicipioUsuario() {
		return (String) municipioUsuario.get();
	}
	
	public static UserInfo getMunicipioUsuarioInfo() {
		UserInfo userInfo = (UserInfo) municipioUsuarioInfo.get();
		if (userInfo == null) userInfo = new UserInfo();
		userInfo.setId(getMunicipioUsuario());
		return userInfo;
	}	

	public static void setMunicipioUsuario(String userName) {
		municipioUsuario.set(userName);
		municipioUsuarioInfo.set(null); 
	}
	
	public static void setCurrentUserInfo(UserInfo userInfo) { 
		municipioUsuario.set(userInfo.getId());
		municipioUsuarioInfo.set(userInfo); 
	}
	
	public static void setCurrent(HttpServletRequest request) {		
        Object rundata = request.getAttribute("rundata");
        String portalUser = (String) request.getSession().getAttribute("xava.portal.user"); 
        String webUser = (String) request.getSession().getAttribute("xava.user"); 
        String user = portalUser == null?webUser:portalUser;
        if (Is.emptyString(user) && rundata != null) {
			PropertiesManager pmRundata = new PropertiesManager(rundata);
			try {
				Object jetspeedUser = pmRundata.executeGet("user");
				PropertiesManager pmUser = new PropertiesManager(jetspeedUser);
				user = (String) pmUser.executeGet("userName");
			}
			catch (Exception ex) {				
				log.warn(XavaResources.getString("warning_get_user"),ex);
				user = null;
			}			
		}		
        municipioUsuario.set(user);
		request.getSession().setAttribute("xava.user", user); 
				
		municipioUsuarioInfo.set(request.getSession().getAttribute("xava.portal.userinfo")); 
	}

} 