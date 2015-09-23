
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page import="tfgterritorio.modelo.Usuario"%>
<%@page import="tfgterritorio.acciones.AccionLogin" %> 
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="java.util.*"%>
<%@page import="org.openxava.util.Users"%>

 <!-- HACER ACTIVA LA SESION -->
<%@page session="true"%>
<!-- DEVUELVE LA SESION DEL USUARIO ok-->
<!-- identificador único asociado a una sesión:  -->
<!--<%HttpSession sesion=request.getSession(true);%>-->
<!--<%="Nº SESION: " + sesion.getId()%>-->
<%
	Date momento=new Date(sesion.getCreationTime());
%>
<!--<%="CREACION SESION: " + momento%>-->
<%
	Date acceso=new Date(sesion.getLastAccessedTime());
%>
<!--<%="ULTIMO ACCESO" + acceso%>-->
<%

	Usuario usuario = ((Usuario)request.getSession().getAttribute(AccionLogin.ATRIBUTO_USUARIO));
	String nombreApellidos = usuario.getNombre() + " " + usuario.getApellido1() + " " + usuario.getApellido2();

%>


<script type="text/javascript">
function irAgenda() {
	var auxEl=urlAgenda+"login.do?ticket=" + tick.obtenerTicket(usuariotrewa);
	alert(auxEl);
	window.open(auxEl,"_blank");
}

function ver(n) {
	var auxEl=document.getElementById("submenu"); // Cada sumenú: sub1, sub2...	

   		auxEl.className="tabla_m2_1";

       }
	         
function ocultar(n) {
			var auxEl=document.getElementById("submenu"); // Cada sumenú: sub1, sub2...
			auxEl.className="tabla_m2";
	         }
	         
function mouseOverTabla(id)
{
	var table = document.getElementById('submenu');
	
	if(table!=undefined)
    {
        var rows = table.getElementsByTagName("tr");
		
		var celda = rows[0].getElementsByTagName("A");

		for (var i=0; i < celda.length; i++) {
			
				if(id==i+1) {
					celda[i].className='celda_blanca' 
				}
				else{
					celda[i].className='celda_defecto' 
				}
			
        }
    }
	
}	
</script>

<html>
  <head>
    <meta content="text/html;" http-equiv="content-type" charset="ISO-8859-1"/>
    <link href="../css/styleTerri.css" rel="stylesheet" type="text/css"/>
    <title>TFGTerritorio</title>
  </head>
 
 <body>
	<div id="capa_fondo"> </div> 
			<div id="usuario_fecha" style="display: block;">
				<TABLE border=0 cellSpacing=0 cellPadding=0 width="100%" align=center>
					<TBODY>
						<TD vAlign=top>
							<TABLE  width="100%" class="usuario_fecha">
								<TBODY>
								<TR>	
									
									<TD> <img src="../imagenes/logo.png"/> </TD>
									<TD>
											<SPAN  style= "font-size: 16px; ">TFG Territorio Municipal</SPAN>
									</TD>
									<TD align=left>
									<TABLE class="usuario_fecha">
										<TBODY>
											<TD rowSpan="2"> <img src="../imagenes/usuario.png" alt="usuario"> </TD>
											<TD> <%="USUARIO: " + nombreApellidos%></TD>
								</TR>
										<TR>
											<TD> <%="SESION: " + momento%> </TD>
											
										</TR>
										<TR>
												<td></td>
												<TD><a href="/TFGTerritorio/logout" font="18px"  target="_top">Desconectar</a></TD>
										</TR>
										</TBODY>
									</TABLE>	
								</TBODY>
							</TABLE>	
						</TD>
					</TBODY>
				</TABLE>	
			</div>	
	</body>
</html>