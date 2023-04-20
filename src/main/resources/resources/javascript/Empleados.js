$(document).ready(function(){ // Esta parte es para realizar la carga de la pagina DESDE EL INICIO
		
alert("Holaa");//imprimir un mensaje en un modal o ventana
console.log("holaaa desde consola"); // imprime el mensaje desde la consola del navegador

llenarTablaEmpleados();
//dataTable();
	 
});  // Termina  - $(document).ready /HibernateIntegrado/src/main/resources/resources/JavaScript/Empleados.js

//Para pruebas
//function dataTable(){
	//var table = $('#tbl_empleados').DataTable();

//}

///Esta funcion es para el llenado de la tabla

function llenarTablaEmpleados(){

	var table = $('#tbl_empleados').DataTable();
	table.destroy(); // Destruir la informacion
	$.ajax({
		type: "get",
		url: '/SistemaWeb/DatosEmpleados/consultarDatosEmpleados',
		dataType: "json",
		success: function(response){  // response =  listadeRamos
			$("#tbl_empleados").DataTable({
				data: response,
				resposive: true,
				columns:[
					{
						data: "idDatosEmpleados",
						"searchable" : false, //no deja buscar algo por este campo		
						"visible": false,	// aparece invisible en la vista					
					},
					{
						data: "nombreCompleto",
					},
					{
						data: "rfc",
					},
					{
						data: "edad",
					},
					{
						data: "sexo",
					},
					{
						data: "direccion",
					},
					{
						data: "telefono",
					},
					{
						data: "activo",
						"orderable" : false,
					},
					{
						className: "text-center",
						"orderable" : false,
						data: function(row, type, set){
							var a;
							a = `<a href="#" id="eliminar_empleado" class="btn btn-danger btn-remove" value="${row.idDatosEmpleados}"><i class="fas fa-trash-alt"></i></a>`;
							
							return a;
						}						
					},
					{
						className: "text-center",
						"orderable" : false,
						data: function(row, type, set){			// fa-2x
							var a;
							a = `<a href="#" id="editar_empleado" class="btn btn-success" value="${row.idDatosEmpleados}"><i class="fa fa-edit"></i></a>`;
							
							return a;
						}						
					}
					],
					"language" : configuracionLenguaje_es
					 
				});
			},					
		});
}

//Al momento de dar click sobre el icono se ejecuta esta funcion para ejecitar la peticion y se elimne el registro.

$(document).on("click","#eliminar_empleado",function(e){
	e.preventDefault();
	var idTraidoDesdeElBotonEliminar = $(this).attr("value"); // Asignado el id a la variable -> idTraidoDesdeElBotonEliminar 
	$.ajax({												 // Todo esto contiene el valor del id desde la tabla -> $(this).attr("value");
		type: "post",
		url: "/SistemaWeb/DatosEmpleados/eliminarEmpleados",
		data: {
			idDatosEmpleados: idTraidoDesdeElBotonEliminar,  //idDatosEmpleados -> el valor de la izq hace referencia a mi modelo o clase RamoDTO *DEBE ESTAR TAL CUAL
		}, 				    
		dataType: "json",
		success: function(respuestadelcontrolador){
			if (respuestadelcontrolador==1){  // En caso de que si se elimino el registro (CONDICION)
				alert("El catalogo juzgado fue eliminado"); // Mensaje a mostrar
				llenarTablaJuzgados();  // Aki se llama la funcion para poder recargar nuevamente los registros nuevos o los que se hayan eliminado
				
			}
			else{
				alert("No se pudo eliminar el registro.!");
			}
		}
	});

});



var configuracionLenguaje_es = {
		sLoadingRecords : "Cargando...",
		sProcessing : "Procesando...",
		sInfoEmpty : "Registros: 0",
		sZeroRecords : "Ningún dato disponible en esta tabla",
		sEmptyTable : "Ningún dato disponible en esta tabla",
		sInfo : " Registros: TOTAL ",
		sSearch : "Filtrar por: ",
		sInfoFiltered : "filtrados",
		sUrl : "",
		sInfoThousands : ",",
		oPaginate : {
			sFirst : "Primero",
			sLast : "Último",
			sNext : "Siguiente",
			sPrevious : "Anterior"
		}
	};