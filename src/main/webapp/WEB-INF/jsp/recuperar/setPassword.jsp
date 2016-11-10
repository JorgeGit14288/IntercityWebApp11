<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Cambiar Password</title>
        <jsp:include page="../shared/headLogin.jsp" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <center><h3 class="panel-title">Ingrese el nuevo Password</h3></center> 
                        </div>
                        <div class="panel-body">
                            <form name="f1" class="form-Registro" method="POST" action="validarNewPassword.htm" >

                                <label for="Telefono" class="sr-only">Telefono</label>
                                <input type="tel" value="${sessionScope.usuario}" readonly  name="telefono" id="telefono" class="form-control" placeholder="Numero de telefono" required autofocus>
                                <label for="inputPassword" class="sr-only">Password</label>
                                <input type="password" name="password"  id="inputPassword" class="form-control" placeholder="Password" required >
                                <label for="confirmPassword" class="sr-only">Confiramar Password</label>
                                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                                <button class="btn btn-lg btn-primary btn-block" type="submit"  >Set Password</button>
                            </form>
                        </div> <!-- /container -->
                        <div id="Error">
                            <Br>
                            <center>
                                <h5>
                                    ${mensaje}
                                </h5>
                            </center>
                        </div>
                        <div>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
