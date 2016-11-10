<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Mensaje de Confirmacion</title>

        <jsp:include page="../shared/headLogin.jsp" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <center>  <h3 class="panel-title">Codigo de Confirmacion</h3></center> 
                        </div>
                        <div class="panel-body">
                            <center>
                                <form class="form-Registro"  method="POST" action="validarRecuperarPhone.htm">
                                    <label>Ingrese el codigo enviado a su telefono <c:out value="${codigo}" /></label><br>
                                    <input type="number" class="form-control" name="codigo" placeholder="Codigo" required="" >
                                    <br>
                                    <button class="btn btn-lg btn-primary btn-block" type="submit"  >Envar Codigo</button>
                                </form>
                            </center>
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