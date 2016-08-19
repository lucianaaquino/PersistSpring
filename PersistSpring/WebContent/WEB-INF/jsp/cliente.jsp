<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tela Cliente</title>
</head>
<body>
<form action="cadastraCliente" method="post">
		Nome:<input type="text" required="required" name="nome" >
		<br>
		CPF:<input type="text" name="refix="c" cpf" >
		<br>
		CNPJ:<input type="text" name="cnpj" >
		<br>
		Tipo Cliente:<input type="text" name="tipoCliente" >
		<br>
		<br>
		<input type="submit" value="Cadastra Usuario "  >
	
	<a href="index"><input type="button" value="Voltar" ></a>
		<br>
	 ${mensagem}
	</form> 
	
		<br>
		<br>
	<form action="pesquisarCliente" method="post">
		Nome:<input type="text" required="required" name="nome" >
			<input type="submit" value="Pesquisar"  >
			
	</form> 

<c:forEach items="${listaCliente}" var="cliente">
${cliente.nome } - ${cliente.cpf } 
<br>

</c:forEach>
	
	
	
	

</body>
</html>