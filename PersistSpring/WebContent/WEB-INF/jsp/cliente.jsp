<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tela Cliente</title>
</head>
<body>
<form action="cadastraUsuario">
		
		Nome:<input type="text" required="required" name="nomeCliente " >
		<br>
		CPF:<input type="text" name="cpfCliente" >
		<br>
		CNPJ:<input type="text" name="cnpjCliente" >
		<br>
		Tipo Cliente:<input type="text" name="tipoCliente" >
		<br>
		<br>
		<input type="submit" value="Cadastra Usuario "  >
		<br>
	 ${mensagem}
	</form> 
	
	<a href="index"><input type="button" value="Voltar" ></a>
</body>
</html>