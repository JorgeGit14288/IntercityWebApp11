
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
                        <h1 class="page-header">Historial de Recargas</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">

                    <!-- CONTENIDO DINAMICO -->

                    <div class="col-lg-8">
                        <div class="col-lg-8">
                            <div class="panel panel-green">
                                <div class="panel-heading">
                                    <i class=""></i> <center><label>FORMULARIO DE BUSQUEDA</label></center>
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <center><label>Ingrese los parametros a buscar en el historial</label></center> 
                                    <form name="form1" method="POST" action="getRecargas.htm" role="form">
                                        <div class="form-group">
                                            <label>Fecha de inicio</label>
                                            <input type="date" name="startDate" class="form-control" placeholder="startDate" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Fecha de fin</label>
                                            <input type="date" name="endDate" class="form-control" placeholder="endDate" required>
                                        </div>
                                        <button type="submit" class="btn btn-success">Ver Historial</button>
                                        <button type="reset" class="btn btn-danger">Reiniciar form</button>
                                    </form>

                                    <div id="Error">
                                        <Br>
                                        <center>

                                            <h5>
                                                ${mensaje}
                                            </h5>

                                        </center>

                                    </div>
                                </div>
                                <!-- /.panel-body -->
                            </div>
                        </div>
                        <!-- /.panel -->
                        <div class="col-lg-12">
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <i class=""></i> <center><label>RESULTADO DE LA BUSQUEDA</label></center>
                                    <div class="pull-right">
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                                Actions
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu pull-right" role="menu">
                                                <li><a href="#">Action</a>
                                                </li>
                                                <li><a href="#">Another action</a>
                                                </li>
                                                <li><a href="#">Something else here</a>
                                                </li>
                                                <li class="divider"></li>
                                                <li><a href="#">Separated link</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="table-responsive">
                                                <form action="editar.htm" method="GET" name="formLista" >
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
                                                </form>
                                            </div>
                                            <!-- /.table-responsive -->
                                        </div>

                                    </div>
                                    <!-- /.row -->
                                </div>
                                <!-- /.panel-body -->
                            </div>

                        </div>
                    </div>
                    <div class="col-lg-4">

                        <jsp:include page="../shared/admin/rightPanel.jsp" flush="true" />
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <i class="fa fa-info-circle fa-fw"></i> Informacion
                            </div>
                            <div class="panel-body">
                                <p>Bienvenido a InterCity, en esta aplicacion web usted podra gestionar su cuenta de usuario </p>
                            </div>
                            <div class="panel-footer">
                                InterCity WebApp
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /#page-wrapper -->
        </div>

    </body>

</html>
