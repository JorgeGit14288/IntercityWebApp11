
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
                        <h1 class="page-header">Editar datos de usuario</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <!-- CONTENIDO DINAMICO -->
                    <div class="col-lg-8">
                        <div class="col-lg-12">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <i class=""></i> <center><label>EDITAR PERFIL DE USUARIO</label></center>
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <table>

                                        <form class="form-Registro" method="POST" action="validarEditarPerfil.htm" >
                                            <Center> <h4 class="form-signin-heading">Ingrese sus datos </h4> </Center>
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
                                                <input class="form-control-feedbackl" type="text"  name="nombres"  id="nombre" required placeholder="first name" value="${account.getFirst_name()}" /> <br>
                                            </div>
                                            <div class="form-group">
                                                <label for="apellidos" >Apellidos</label>
                                                <input class="form-control-feedbackl" type="text"  name="apellidos"  id="apellidos" required placeholder="last name" value="${account.getLast_name()}" /><br>
                                            </div>
                                            <div class="form-group">
                                                <label for="direccion" >Direccion</label>
                                                <input class="form-control-feedbackl" type="text"  name="direccion"  id="direccion" required placeholder="address" value="${account.getAddress1()}" /><br>
                                            </div>
                                            <div class="form-group">
                                                <label for="ciudad" >Ciudad</label>
                                                <input class="form-control-feedbackl" type="text"  name="ciudad"  id="city" required placeholder="city" value="${account.getCity()}" /><br>
                                            </div>
                                            <div class="form-group">
                                                <label for="codigo" >Codigo Postal</label>
                                                <input type="num" class="form-control-feedbackl"  name="codigoPostal"  id="nombre" required placeholder="postal code" value="${account.getPostal_code()}" /><br>
                                            </div>
                                            <div class="form-group">
                                                <label for="email" >E-mail</label>
                                                <input type="email" class="form-control-feedbackl" name="email"  id="nombre" required placeholder="example@example.com" value="${account.getEmail()}" /><br>
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
                                                <button  type="submit"class="btn btn-primary" >Confirmar</button>
                                                <button type="reset" class="btn btn-danger">Reiniciar form</button>
                                            </div>
                                        </form>
                                    </table>

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
            <!-- /#page-wrapper -->
        </div>

    </body>

</html>
