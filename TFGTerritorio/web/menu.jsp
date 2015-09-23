<html xmlns="http://www.w3.org/1999/xhtml">
<%@page import="tfgterritorio.acciones.*"%>

<%@page import="tfgterritorio.modelo.Usuario"%>
<%@page import="tfgterritorio.modelo.MenuItem"%>
<%@page import="tfgterritorio.modelo.Menu"%>
<%@page import="tfgterritorio.utilidades.MenuUtils"%>


<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="java.util.*"%>

<%@page import="org.openxava.util.Users"%>
<%@page session="true"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="xava/style/liferay43/css/everything_unpacked.css"
	rel="stylesheet" type="text/css" />

<title>Menú</title>
</head>

<body>
	<script>

		function cambio(abc) {

			if (document.getElementById(abc).style.display == 'none')
				document.getElementById(abc).style.display = 'block'
			else
				document.getElementById(abc).style.display = 'none'

		}
	</script>

	<%
		String sololectura = "";
			Usuario usuario = (Usuario) request.getSession().getAttribute(AccionLogin.ATRIBUTO_USUARIO);
			String menu = MenuUtils.obtenerMenuOrdenado(usuario.getIdUsuario(), sololectura);
	%>
	<%=menu%>

</body>
</html>