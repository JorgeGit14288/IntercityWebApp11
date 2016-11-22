
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
        <title>DashBoard</title>
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
                        <h1 class="page-header">InterCity DashBoard</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <jsp:include page="../shared/admin/rowCenter1.jsp" flush="true" />
                <div class="row">
                    <!-- CONTENIDO DINAMICO -->
                    <div class="col-lg-8">
                        <!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Cuotas InterCity
                                <div class="pull-right">
                                    <div class="btn-group">

                                    </div>
                                </div>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <form name="form" method="POST" action="postCuotas.htm" role="form">
                                            <div class="col-xs-4">
                                                <label>Pais</label>
                                                <select name="country"  required  ><br>
                                                    <option value="${country}">Pais Actual ${country}  </option> 
                                                    <option value="Estados Unidos">Estados Unidos </option> 
                                                    <option value="Canada">Canada</option> 
                                                    <option value="Puesto Rico">Puerto Rico</option> 
                                                    <option value="Republica Dominicana">Republica Dominicana</option> 
                                                    <option value="Peru">Peru</option>
                                                    <option value="Mexico">Mexico</option>
                                                    <option value="Cuba">Cuba</option>
                                                    <option value="Chile">Chile</option>
                                                    <option value="Guatemala">Guatemala</option>
                                                    <option value="El Salvador">El Salvador</option>
                                                    <option value="Honduras">Honduras</option>
                                                    <option value="Nicaragua">Nicaragua</option>
                                                    <option value="Costa Rica">Costa Rica</option>
                                                    <option value="Panama">Panama</option>
                                                </select>
                                            </div>

                                            <div class="col-xs-4">
                                                <label>Monto de la recarga</label>

                                                <select name="amount" id="amount">
                                                    <option selected value="5">  Recarga de 5</option>
                                                    <option value="5">5 Recargas</option> 
                                                    <option value="10">10 Recargas</option> 
                                                    <option value="15">15 Recargas</option> 
                                                    <option value="25">25 Recargas</option> 
                                                    <option value="50">50 Recargas</option> 
                                                    <option value="100">100 Recargas</option> 

                                                </select>
                                            </div>
                                            <div class="col-xs-2">
                                                <label></label>
                                                <button  type="submit" id = "btncuotas" name="btncuotas" onclick="" class="btn btn-success">Ver Cuotas </button>

                                            </div> 
                                        </form>
                                        <!-- /.consulta retornada por post -->
                                    </div>
                                    <div id="result">

                                        ${resultado}

                                    </div>
                                </div>
                                <!-- /.row -->
                            </div>
                            <!-- /.panel-body -->
                        </div>

                    </div>
                    <!-- /.col-lg-8 -->
                    <!-- CONTENIDO DINAMICO -->
                    <div class="col-lg-4">
                        <jsp:include page="../shared/admin/rightPanel.jsp" flush="true" />
                    </div>
                </div>
            </div>
            <!-- /#page-wrapper -->
        </div>

    </body>

</html>
