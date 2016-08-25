<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tela Cliente</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>


<script type="text/javascript">
            $(function () {
     
                $('#datepicker').datepicker();
            });
        </script>
</head>

<body>


<div class="container">
<br>
<form action="cadastraPedido" class="form-horizontal" method="post">
 <div class="form-group">
  	<label class="col-sm-2 control-label">Cliente:</label>
 <div class="col-sm-10">
            <select class="form-control" name="pk.clienteIdCliente" >
      <c:forEach items="${listaCliente}" var="c">
		<option value="${c.idCliente}" >${c.nome}</option>
		<br>
      </c:forEach>
      </select> 
  </div>
</div>
 <div class="form-group">
  	<label class="col-sm-2 control-label">Data:</label>
 
 <div class="col-sm-10">
 
                    <input type="date" name="data" id="datepicker" class="form-control" />
                    
     
  </div>
</div>	
 
	
<div align="center">
<input type="submit" class="btn btn-primary" value="Cadastra Pedido "  >
<a href="index" class="btn btn-success" >Voltar </a>
</div>
</form>
	
	
	<c:if test="${mensagem != null}">
<div class="alert alert-warning" role="alert">
  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  ${mensagem}
</div>	 
	</c:if>
	 	
	<!-- <form action="pesquisarCliente" method="post">
			<input type="submit" value="Pesquisar Geral"  >
			
	</form>  -->
	
	<!-- <form action="pesquisarClienteNome" method="post">
		Nome:<input type="text" required="required" name="nome" >
			<input type="submit" value="Pesquisar"  >
			
	</form>  -->
	<form action="pesquisarClienteNome"   method="post">
	<div class="input-group" align="center">
      <input type="text" class="form-control" name="nome" placeholder="Nome Cliente">
      <div class="input-group-btn">
        <button class="btn btn-default glyphicon glyphicon-search" type="submit"></button> 
      </div>
</div>
	</form>
	
	<br><br>
	
		<c:forEach items="${listaClienteNome}" var="cliente">
		${cliente.nome } - ${cliente.cpf } 
		<br>
	</c:forEach>
	
	</div> 

</body>
</html>