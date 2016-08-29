<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tela Cliente</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>


<div class="container">
<br>
<form action="cadastraProduto" class="form-horizontal" method="post">
 <div class="form-group">
  	<label class="col-sm-2 control-label">Produto:</label>
 <div class="col-sm-10">
      <input type="text" name="descricao" required="required" class="form-control" >
  </div>
</div>
 <div class="form-group">
  	<label class="col-sm-2 control-label">Valor R$:</label>
 <div class="col-sm-10">
      <input type="text" name="valor"  class="form-control" >
  </div>
</div>	

 <div class="form-group">
  	<label class="col-sm-2 control-label">Fornecedor do Produto:</label>
 <div class="col-sm-10">
<%-- <input type="hidden" name="fornecedor" value="${listaFornecedor}"> --%>
       <select class="form-control" name="idFornecedor" >
      <c:forEach items="${listaFornecedor}" var="f">
		<option value="${f.id}" >${f.nome}</option>
		<br>
      </c:forEach>
      </select> 
      
  </div>
</div>	
 

	
<div align="center">
<input type="submit" class="btn btn-primary" value="Cadastra"  >
<a href="index" class="btn btn-success" >Voltar </a>
</div>
</form>
	
	
	<c:if test="${mensagem != null}">
<div class="alert alert-warning" role="alert">
  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  ${mensagem}
</div>	 
	</c:if>
	 	

	<form action="pesquisarProdutoNome"   method="post">
	<div class="input-group" align="center">
      <input type="text" class="form-control" name="nome" placeholder="Nome Cliente">
      <div class="input-group-btn">
        <button class="btn btn-default glyphicon glyphicon-search" type="submit"></button> 
      </div>
</div>
	</form>
	
	<br><br>
	
		<c:forEach items="${listaProdutoNome}" var="produto">
		${produto.descricao } - ${produto.valor } 
		<br>
	</c:forEach>
	
	</div> 
</div>
</body>
</html>