<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.dominio.Filme"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirma��o de Cadastro de Filme</title>

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
<a href="exibirCandidatos">CADASTRO DE CANDIDATOS</a>
<jsp:useBean id="filme" class="modelo.dominio.Filme" scope="request"></jsp:useBean>
	<table>
		<tr>
			<td class="tituloCampo">Nome:</td>
			<td><%=filme.getNomeFilme() %></td>
		</tr>
		<tr>
			<td class="tituloCampo">Descricao:</td>
			<td><%=filme.getDescricao()%></td>
		</tr>
		<tr>
			<td class="tituloCampo">Data Lan�amento:</td>
			<td><%=filme.getDataLancamento()%></td>
		</tr>
		<tr>
			<td class="tituloCampo">Categoria:</td>
			<td><%=filme.getCategoria()%></td>
		</tr>
	</table>
</body>
</html>








