<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Recuperar Cuenta</title>
        <jsp:include page="../shared/headLogin.jsp" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                          <center>  <h3 class="panel-title">Recuperar Cuenta</h3> </center>
                        </div>
                        <div class="panel-body">
                            <form class="form-Registro" method="POST" action="validarRecuperar.htm" >
                                <center>   <label>Ingrese la informacion requerida</label><br> </center>
                                <br>
                                <label for="codigoArea"  class="sr-only">Codigo de Area</label>
                                <select name="codigo"  required  >
                                    <option value="1">+1 Estados Unidos </option> 
                                    <option value="1">+1 Canada</option> 
                                    <option value="1">+1 Puerto Rico</option> 
                                    <option value="1">+1 Republica Dominicana</option> 
                                    <option value="51">+51 Peru</option>
                                    <option value="52">+52 Mexico</option>
                                    <option value="53">+53 Cuba</option>
                                    <option value="56">+56 Chile</option>
                                    <option value="502">+502 Guatemala</option>
                                    <option value="503">+503 El Salvador</option>
                                    <option value="504">+504 Honduras</option>
                                    <option value="505">+505 Nicaragua</option>
                                    <option value="506">+506 Costa Rica</option>
                                    <option value="507">+507 Panama</option>
                                </select>
                                <label for="Telefono" class="sr-only">Telefono</label>
                                <input type="tel" name="telefono" id="telefono" class="form-control" placeholder="Numero de telefono" required autofocus>
                                <button class="btn btn-lg btn-primary btn-block" type="submit">Recuperar</button>
                            </form>
                        </div> <!-- /container -->
                        <div id="Error">
                            <Br>
                            <center>
                                <h4>
                                    ${mensaje}
                                </h4>
                            </center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
