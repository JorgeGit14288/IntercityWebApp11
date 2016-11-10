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

        <title>Perfil de Usuario</title>

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
                        <h1 class="page-header">Dashboard</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <jsp:include page="../shared/rowCenter1.jsp" flush="true" />
                <div class="row">

                    <!-- CONTENIDO DINAMICO -->

                   
                    <div class="col-lg-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Area Chart Example
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
                               INFORMACION
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> DATOS DE USUARIO
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
                                    <div class="col-lg-10">
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-hover table-striped">
                                                   <tbody>
                                                <tr>
                                                    <td>First Name:  </td>
                                                    <td>${account.getFirst_name()}</td>

                                                </tr>
                                                <tr>
                                                    <td>Last Name: </td>
                                                    <td>${account.getLast_name()}</td>
                                                </tr>
                                                <tr>
                                                    <td>Address: </td>
                                                    <td>${account.getLast_name()}</td>

                                                </tr>
                                                <tr>
                                                    <td>City: </td>
                                                    <td>${account.getCity()}</td>

                                                </tr>
                                                <tr>
                                                    <td>Postal Code: </td>
                                                    <td>${account.getPostal_code()}</td>
                                                </tr>
                                                <tr>
                                                    <td>Email: </td>
                                                    <td>${account.getEmail()}</td>
                                                </tr>
                                                <tr>
                                                    <td>Languaje</td>
                                                    <td>${account.getLanguaje_id()}</td>
                                                </tr>
                                                <tr>
                                                    <td>Notify Email: </td>
                                                    <td>${account.getNotify_email()}</td>
                                                </tr>
                                                <tr>
                                                    <td>Notity Flag: </td>
                                                    <td>${account.getNotify_flag()}</td>
                                                </tr>
                                            </tbody>
                                            </table>
                                        </div>
                                        <!-- /.table-responsive -->
                                        <div>
                                            
                                        </div>
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
                        <jsp:include page="../shared/rightPanel.jsp" flush="true" />
                    </div>
                </div>
            </div>
            <!-- /#page-wrapper -->
        </div>

    </body>

</html>