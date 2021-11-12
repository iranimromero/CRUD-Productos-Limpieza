<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Listar Producto</title>
</head>
<body>

   <!-- <//%
    InscripcionDAO inscripcionDAO = new InscripcionDAO();
    List<InscripcionDTO> lista = inscripcionDAO.obtieneInscritos();
    request.setAttribute("lista", lista);
    System.out.println(lista);
    %>-->
 
    <table>
 
        <tr>
            <th>Id Producto</th>
            <th>Nombre Producto</th>
            <th>Precio Producto</th>
            <th>Descripcion Producto</th>
            <th>Categoria</th>
        </tr>
        <c:forEach items="${listaProdCat}" var="listaTemp">
        <tr>
        <td>${listaTemp.getProducto().getIdProducto()}</td>
        <td>${listaTemp.getProducto().getNombreProducto()}</td>
        <td>${listaTemp.getProducto().getPrecioProducto()}</td>
        <td>${listaTemp.getProducto().getDescripcionProducto()}</td>
        <td>${listaTemp.getCategoria().getNombreCategoria()}</td>
       
      
        </tr>
        </c:forEach>
        </table>

	<br><a href="PaginaInicio">Volver al Inicio</a>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>

</body>
</html>