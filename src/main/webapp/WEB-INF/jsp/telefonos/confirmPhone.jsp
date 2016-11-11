

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

        <title>LOGIN</title>

        <jsp:include page="../shared/headLogin.jsp" />

    </head>

    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <center>    <h3 class="panel-title">Confirmar Numero Telefonico</h3></center>
                        </div>
                        <div class="panel-body">
                            <form method="POST" action="validarPhone.htm">
                                <center> 
                                    <label>Ingrese el codigo enviado a su telefono <br> <c:out value="${codigo}" /></label>
                                    </center>
                                    <input class="form-control" type="number" name="codigo" placeholder="codigo de confirmacion" required="" >
                                <br>
                               <button class="btn btn-lg btn-primary btn-block" type="submit">Confirmar</button>
                            </form>

                            <div id="Error">
                                <Br>
                                <center>
                                    <h4>
                                        ${mensaje}
                                    </h4>
                                    <br>
                                </center>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



    </body>

</html>
l>