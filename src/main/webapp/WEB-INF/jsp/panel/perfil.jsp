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
                        <h1 class="page-header">Perfil de Usuario</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <div class="row">

                    <!-- CONTENIDO DINAMICO -->


                    <div class="col-lg-8">

                        <!-- /.panel -->
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> DATOS DE USUARIO
                                <div class="pull-right">

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
                                                        <td>Nombres:  </td>
                                                        <td>${account.getFirst_name()}</td>

                                                    </tr>
                                                    <tr>
                                                        <td>Apellidos: </td>
                                                        <td>${account.getLast_name()}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Direccion: </td>
                                                        <td>${account.getAddress1()}</td>

                                                    </tr>
                                                    <tr>
                                                        <td>Ciudad: </td>
                                                        <td>${account.getCity()}</td>

                                                    </tr>
                                                    <tr>
                                                        <td>Codigo Postal: </td>
                                                        <td>${account.getPostal_code()}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Email: </td>
                                                        <td>${account.getEmail()}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Lenguaje</td>
                                                        <td>${account.getLanguaje_id()}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Notificar Emai: </td>
                                                        <td>${account.getNotify_email()}</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Notificar Flag: </td>
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
        </div>
    </body>
</html>
