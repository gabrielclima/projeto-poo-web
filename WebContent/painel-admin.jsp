<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="modelo.dominio.Filme"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Filmes</title>
</head>
<body>
	<h3>Cadastro de Filmes</h3>
	Op��es: <a href="abrirCadastro">Incluir</a>
	
	<br>
	<br>
	Lista de Filmes:
	<table cellpadding="5" cellspacing="0" border="1">
		<tr>
			<td>Op��es</td>
			<td>Registro</td>
			<td>Nome Filme</td>
			<td>Descri��o</td>
			<td>Lan�amento</td>
			<td>Categoria</td>
		</tr>
<%
	List<Filme> lista = (List<Filme>) request.getAttribute("lista");
	if (lista != null)
	{
		for (Filme filme: lista)
		{
%>
		<tr>
			<td><a href="alterarCadastro?registro=<%=filme.getNomeFilme()%>">Alterar</a><br>
				<a href="excluirCadastro?registro=<%=filme.getNomeFilme()%>">Excluir</a>
			</td>
			<td><%=filme.getRegistro()%></td>
			<td><%=filme.getNomeFilme()%></td>
			<td><%=filme.getDescricao()%></td>
			<td><%=filme.getDataLancamento()%></td>
			<td><%=filme.getCategoria()%></td>
		</tr>
<%
		}
	}
%>
	</table>
</body>
</html>












	