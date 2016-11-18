
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>InterCity Dashboard</title>

        <jsp:include page="../shared/headDashboard.jsp" flush="true" />

    </head>

    <body>
        <div id="wrapper">
            <div>
                <jsp:include page="../shared/headLeftMenu.jsp" flush="true" />
            </div>
            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Historial de Llamadas</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <!-- CONTENIDO DINAMICO -->
                    <div class="col-lg-12">
                        <div class="col-lg-12">
                            <div class="panel panel-green">
                                <div class="panel-heading">
                                    <i class=""></i> <center><label>FORMULARIO DE BUSQUEDA</label></center>
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="col-lg-8">
                                        <form name="form1" method="GET" action="getRecargas.htm" role="form">
                                            <div class="col-xs-4">
                                                <label>Fecha de inicio</label>
                                                <input type="date" min="2016-10-01" name="startDate" value="${startDate}" placeholder="startDate" required>
                                            </div>
                                            <div class="col-xs-4">
                                                <label>Fecha de fin</label>
                                                <input type="date" name="endDate" min="2016-10-02" value="${endDate}"  placeholder="endDate" required>
                                            </div>            
                                            <div class="col-xs-4">
                                                <select name="max">
                                                    <option selected value="${max}"> ${max} Recargas</option>

                                                    <option value="1">1 Recargas</option> 
                                                    <option value="5">5 Recargas</option> 
                                                    <option value="10">10 Recargas</option> 
                                                    <option value="15">15 Recargas</option> 
                                                    <option value="25">25 Recargas</option> 
                                                    <option value="50">50 Recargas</option> 
                                                    <option value="100">100 Recargas</option> 

                                                </select>
                                            </div>

                                            <div class="col-xs-3">
                                                <label><br></label>
                                                <button type="submit" class="btn btn-success">Ver Historial</button>

                                            </div> 
                                    </div>


                                    <div class="table-striped">
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                    <th>No</th>
                                                    <th>Fecha</th>
                                                    <th>Monto</th>
                                                    <th>Saldo Anterior</th>
                                                    <th>Saldo Posterior</th>
                                                    <th>Descripcion</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${recargas}" var="recarga">
                                                    <tr>
                                                        <td><c:out value="${recarga.getNo()}" /></td>
                                                        <td><c:out value="${recarga.getFecha()}" /></td>
                                                        <td><c:out value="${recarga.getMonto()}" /></td>
                                                        <td><c:out value="${recarga.getSaldoAnterior()}" /></td>
                                                        <td><c:out value="${recarga.getSaldoPosterior() }" /></td>
                                                        <td><c:out value="${recarga.getDescripcion() }" /></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <ul class="pager">

                                            <li class="previous"><a href="getHistorial.htm?page=${pageprevius}&max=${max}&startDate=${startDate}&endDate=${endDate}">&larr; Anterior ${pageprevius}</a></li>
                                            <li class="list-group-item-text">pagina ${page}</li>
                                            <li class="next"><a href="getHistorial.htm?page=${pagenext}&max=${max}&startDate=${startDate}&endDate=${endDate}">Siguiente ${pagenext} &rarr;</a></li>
                                        </ul>
                                        </form>
                                        <div >
                                            <div id="Error">
                                                <Br>
                                                <center>

                                                    <h5>
                                                        ${mensaje}
                                                    </h5>

                                                </center>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <!-- /.panel-body -->
                            </div>
                        </div>
                        <!-- /.panel -->

                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
