<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><!-- LIGAS PARA FUNCIONALIDAD DE LOS DataTables  -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
	<script type="text/javascript" lenguaje="javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" lenguaje="javascript" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	
	<script lenguaje="javascript" type="text/javascript" src="<c:url value="/resources/javascript/Empleados.js"/>"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

<meta charset="ISO-8859-1">	
	<title>Pantalla de empleados</title>
</head>
<body>
<h1>Vista Empleados</h1>
<br>
<br>

<div class="container">
<div width="80%">
	<table class="table table-striped table-hover" id="tbl_empleados">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">NOMBRE COMPLETO</th>
				<th style="width: 15%">RFC</th>
				<th style="width: 15%">EDAD</th>
				<th style="width: 15%">SEXO</th>
				<th scope="col">DIRECCION</th>
				<th style="width: 15%">TELEFONO</th>
				<th style="width: 15%">ACTIVO</th>
				<th style="width: 15%">ELIMINAR</th>
				<th style="width: 15%">EDITAR</th>
			</tr>
		</thead>
	</table>
</div>
</div>

</body>
</html>