<%@page import="modelo.dominio.Usuario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.dominio.Filme"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirma��o de Registro</title>

<style type="text/css">
.tituloCampo {
	text-align: right;
	color: blue;
}
</style>
<%
	// Candidato candidato = (Candidato) request.getAttribute("candidato");
	// if (candidato == null)
	// 	candidato = new Candidato();
%>
</head>
<body>
<jsp:useBean id="usuario" class="modelo.dominio.Usuario" scope="request"></jsp:useBean>
	<table>
		<tr>
			<td class="tituloCampo">Nome:</td>
			<td><%=usuario.getNome()%></td>
		</tr>
	</table>
	<p class="tituloCampo">Ol�, <%=usuario.getNome()%>. Seu registro foi confirmado.</p>
</body>
</html>








