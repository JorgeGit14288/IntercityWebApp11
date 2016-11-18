
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

        <jsp:include page="../shared/admin/headDashboard.jsp" flush="true" />

    </head>

    <body>
        <div id="wrapper">
            <div>
                <jsp:include page="../shared/admin/headLeftMenu.jsp" flush="true" />
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
                                        <form name="form1" method="GET" action="getHistorial.htm" role="form">
                                            <div class="col-xs-4">
                                                <label>Fecha de inicio</label>
                                                <input type="date" min="2016-10-01" name="startDate" value="${startDate}" placeholder="startDate" required>
                                            </div>
                                            <div class="col-xs-4">
                                                <label>Fecha de fin</label>
                                                <input type="date" name="endDate" min="2016-10-02" value="${endDate}"  placeholder="endDate" required>
                                            </div>
                                            <div class="col-xs-4">
                                                <label>Numero de destino</label>
                                                <input type="number" name="destination" min="1" value="${destination}" class="form-control" placeholder="code and number">
                                            </div> 
                                            <div class="col-xs-4">

                                                <select name="max">
                                                    <option selected value="${max}">Mostrar ${max}</option>

                                                    <option value="1">1 llamada</option> 
                                                    <option value="5">5 llamadas</option> 
                                                    <option value="10">10 llamadas</option> 
                                                    <option value="15">15 llamadas</option> 
                                                    <option value="25">25 llamadas</option> 
                                                    <option value="50">50 llamadas</option> 
                                                    <option value="100">100 llamadas</option> 

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
                                                    <th>Fecha/Hora</th>
                                                    <th>Destino</th>
                                                    <th>Pais-Operador</th>
                                                    
                                                    <th>Minutos</th>
                                                    <th>Costo-minuto</th>
                                                    <th>Costo-Total</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${llamadas}" var="llamada">
                                                    <tr class="odd gradeX">
                                                        <td><c:out value="${llamada.getNo()}" /></td>
                                                        <td><c:out value="${llamada.getInicioLLamada()}" /></td>
                                                        <td><c:out value="${llamada.getNumero()}" /></td>
                                                        <td><c:out value="${llamada.getPais_operador()}" /></td>
                                                        <td><c:out value="${llamada.getDuracionMinutos() }" /></td>
                                                        <td><c:out value="${llamada.getCostoMinuto()}" /></td>
                                                        <td><c:out value="${llamada.getCostoTotal()}" /></td>

                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <ul class="pager">

                                            <li class="previous"><a href="getHistorial.htm?page=${pageprevius}&max=${max}&startDate=${startDate}&endDate=${endDate}&destination=${destination}">&larr; Anterior ${pageprevius}</a></li>
                                            <li class="list-group-item-text">pagina ${page}</li>
                                            <li class="next"><a href="getHistorial.htm?page=${pagenext}&max=${max}&startDate=${startDate}&endDate=${endDate}&destination=${destination}"">Siguiente ${pagenext} &rarr;</a></li>
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
