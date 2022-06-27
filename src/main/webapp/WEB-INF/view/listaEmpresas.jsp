<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List,br.com.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- Importando a biblioteca -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	Usuario Logado: ${usuarioLogado.login }
	
	<br>
	<br>
	<br>

	<c:if test="${not empty empresa}">
		Empresa ${ empresa } cadastrada com sucesso
	</c:if>
	<br>
	<br>
	Lista de Empresas:
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			
			<li>
				${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy	"/>
				<a href="/gerenciador/entrada?acao=MostraEmpresas&id=${empresa.id }">Editar</a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}"> remover</a> 
			</li>
		</c:forEach>
	</ul>
</body>
</html>