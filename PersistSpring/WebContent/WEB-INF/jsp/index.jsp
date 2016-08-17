<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</body>
</html>