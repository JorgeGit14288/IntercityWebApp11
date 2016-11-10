

<script>
function comprobarClave(){
	clave1 = document.f1.password.value
	clave2 = document.f1.confirmPassword.value
	
	if (clave1 == clave2)
		alert("Las dos claves son iguales...\nRealizaríamos las acciones del caso positivo")
	else
		alert("Las dos claves son distintas...\nRealizaríamos las acciones del caso negativo")
            document.f1.submit()
}
</script>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                            <h3 class="panel-title">Please Sign In</h3>
                        </div>
                        <div class="panel-body">
                            <form name="f1" class="form-Registro" method="POST" action="validarRegistro.htm" >
                                <h2 class="form-signin-heading">INGRESE SUS DATOS </h2>                
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
                                <label for="inputPassword" class="sr-only">Password</label>
                                <input type="password" name="password"  id="inputPassword" class="form-control" placeholder="Password" required >
                                <label for="confirmPassword" class="sr-only">Confiramar Password</label>
                                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>



                                <div class="checkbox">

                                    <label>
                                        <input type="checkbox" value="remember-me"> Remember me
                                    </label>
                                </div>
                                <button class="btn btn-lg btn-primary btn-block" type="submit" onClick="comprobarClave()"   >Sign in</button>
                            </form>
                            <div>
                                <center>
                                    
                                    <br>
                                    <a href="recuperar.htm">Recuperar una cueta existente</a>
                                   
                                    <br>
                                    <a href="registrar.htm">Registrarse como nuevo usuario</a>
                                </center>
                            </div>
                            <div id="Error">
                                <Br>
                                <center>
                                    <h3>
                                        ${mensaje}
                                    </h3>

                                </center>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



    </body>

</html>
