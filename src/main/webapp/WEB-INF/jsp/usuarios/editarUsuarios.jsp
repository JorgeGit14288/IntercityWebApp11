
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
                        <h1 class="page-header">Dashboard</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <jsp:include page="../shared/admin/rowCenter1.jsp" flush="true" />
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
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class=""></i> <center><label>EDITAR PERFIL DE USUARIO</label></center>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">

                                <form class="form-Registro" method="POST" action="setEditarPerfil.htm" >
                                    <Center> <h3 class="form-signin-heading">Ingrese sus datos </h3> </Center>
                                    <div class="form-group">
                                        <label for="idUsuario" >Id Uusario</label>
                                        <input type="text" readonly name="idUsuario" value ="${user.getIdUsuario()}" id="idUsuario" /> 
                                    </div>
                                    <div class="form-group">
                                        <label for="Telefono" >Telefonos:</label><br>
                                    </div>

                                    <c:forEach items="${listTel}" var="tel">
                                        <input type="text"  name="telefono" value ="<c:out value="${tel.getTelefonoArea()}" />" id="telefonos" /> 

                                    </c:forEach>
                                    <div class="form-group">
                                        <label for="nombres" >Nombres</label>
                                        <input type="text"  name="nombres"  id="nombre" required placeholder="first name" /> <br>
                                    </div>
                                    <div class="form-group">
                                        <label for="apellidos" >Apellidos</label>
                                        <input type="text"  name="apellidos"  id="apellidos" required placeholder="last name" /><br>
                                    </div>
                                    <div class="form-group">
                                        <label for="direccion" >Direccion</label>
                                        <input type="text"  name="direccion"  id="direccion" required placeholder="address" /><br>
                                    </div>
                                    <div class="form-group">
                                        <label for="ciudad" >Ciudad</label>
                                        <input type="text"  name="ciudad"  id="city" required placeholder="city" /><br>
                                    </div>
                                    <div class="form-group">
                                        <label for="codigo" >Codigo Postal</label>
                                        <input type="num"  name="codigoPostal"  id="nombre" required placeholder="postal code" /><br>
                                    </div>
                                    <div class="form-group">
                                        <label for="email" >E-mail</label>
                                        <input type="email" name="email"  id="nombre" required placeholder="example@example.com" /><br>
                                    </div>
                                    <div class="form-group">
                                        <label for="languaje"  >Lenguaje para su operador</label>
                                        <select name="languaje"  required  >
                                            <option value="Es">Español</option> 
                                            <option value="En">Ingles</option> 
                                        </select><br>
                                    </div>
                                    <div class="form-group">
                                        <label for="notify Email" >Notificar a e-mail</label>
                                        <input type="checkbox"  name="notifyEmail"  /><br>
                                    </div>
                                    <div class="form-group">
                                        <label for="flag" >Notificar Flag</label>
                                        <input type="checkbox"  name="notifyFlag"  /><br>
                                    </div>
                                    <div class="form-group">
                                        <button  type="submit"class="btn btn-default" >Confirmar</button>
                                        <button type="reset" class="btn btn-default">Reiniciar form</button>
                                    </div>
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
                        <!-- /.panel -->
                        <div class="panel panel-default">
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

                                                    </thead>
                                                    <tbody>

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