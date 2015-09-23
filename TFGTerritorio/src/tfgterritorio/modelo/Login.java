
package tfgterritorio.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;

//Vista modo detalle.
@Views({ @View(members = "login; password"),
		@View(name = "login", members = "login; password") })

//Clase que implementa el componente de negocio Login.
public class Login extends BaseControl {

	private String login;

	@Stereotype("PASSWORD")
	private String password;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
