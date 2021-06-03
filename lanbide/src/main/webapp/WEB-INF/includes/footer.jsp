<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
<p>Prueba para Lanbide / jgarai</br>
IPARTEK: DESARROLLO DE APLICACIONES JAVA: COMPONENTES WEB Y APLICACIONES DE BASE DE DATOS (JSP Y JPA)</p>
</div>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="//cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap5.min.js"></script>

<script>
	$(document).ready(function() {
		$('table').DataTable({
	        language: {
	            url: 'https://cdn.datatables.net/plug-ins/1.10.24/i18n/Spanish.json'
	        }
	    } );
	});
	
</script>
</body>
</html>