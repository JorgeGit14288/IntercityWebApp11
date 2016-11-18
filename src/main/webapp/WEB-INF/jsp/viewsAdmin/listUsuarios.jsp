
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').DataTable({
                    responsive: true
                });
            });
        </script>

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
                        <h1 class="page-header">Admin Dashboard</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>

                <jsp:include page="../shared/admin/rowCenter1.jsp" flush="true" />
                <div class="row">

                    <!-- CONTENIDO DINAMICO -->
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> Formulario de Busqueda
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
                                <div class="col-lg-4">
                                    <form role="form" method="POST" action="buscarUsuarios.htm">
                                        <fieldset>
                                            <label for="parametro" >Busqueda por</label>
                                            <select name="parametro"  required  ><br>
                                                <option value="idUsuario">idUsuario</option> 
                                                <option value="nombres">Nombres</option> 
                                                <option value="apellidos">Apellidos</option> 
                                                <option value="idAccount">IdAccount</option> 
                                                <option value="telefono">Telefono</option>
                                            </select>
                                            <div class="form-group">
                                                <input class="form-control" placeholder="Datos a buscar" name="datoBuscar" required type="text" autofocus >
                                            </div>                                           
                                            <!-- Change this to a button or input when using this as a form -->
                                            <button class="btn btn-lg btn-primary btn-block" type="submit">Buscar</button>
                                        </fieldset>
                                    </form>
                                </div>
                                <!-- /.panel-body -->
                            </div>
                            <!-- /.panel -->

                            <!-- /.row -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            USUARIOS REGISTRADOS
                                        </div>
                                        <!-- /.panel-heading -->
                                        <div class="panel-body">
                                            <div class="table-responsive">  
                                                <display:table name="listaUsuarios" id="usuarios" pagesize="10" requestURI="listaUsuarios.htm" >
                                                    <display:setProperty name="export.excel.filename" value="ListadoClientes.xls" />
                                                    <display:setProperty name="export.xml.filename" value="ListadoClientes.xml" />
                                                    <display:setProperty name="export.csv.filename" value="ListadoClientes.csv" />
                                                    <display:caption title="Listado de Usuarios"/>
                                                    <display:column  title="idUsuario" property="idUsuario"  style="width:80px" />  
                                                    <display:column  title="Nombres" property="nombres" sortable="true" sortName="nombres" style="width:100px" />  
                                                    <display:column  title="Apellidos" property="apellidos" style="width:130px"/>  
                                                    <display:column  title="Pais" property="pais"style="width:120px"/>  
                                                    <display:column  title="Email" property="email"style="width:220px"/>  
                                                    <display:column  title="Status" property="status" sortable="true" sortName="status"style="width:100px"/>  
                                                    <display:column  title="Tipo" property="tipoUsuario" sortable="true" sortName="tipoUsuario" style="width:100px" />   
                                                    <display:column  title="Tipo" property="tipoUsuario" sortable="true" sortName="idAccount" style="width:100px" />


                                                </display:table> 

                                            </div>
                                            <!-- /.table-responsive -->
                                            <div class="well">
                                                <h4>DataTables Usage Information</h4>
                                                <p>DataTables is a very flexible, advanced tables plugin for jQuery. In SB Admin, we are using a specialized version of DataTables built for Bootstrap 3. We have also customized the table headings to use Font Awesome icons in place of images. For complete documentation on DataTables, visit their website at <a target="_blank" href="https://datatables.net/">https://datatables.net/</a>.</p>
                                                <a class="btn btn-default btn-lg btn-block" target="_blank" href="https://datatables.net/">View DataTables Documentation</a>
                                            </div>
                                        </div>
                                        <!-- /.panel-body -->
                                    </div>
                                    <!-- /.panel -->
                                </div>
                                <!-- /.col-lg-12 -->
                            </div>
                            <!-- /.row -->

                        </div>

                    </div>
                    <!-- /.col-lg-8 -->

                    <!-- CONTENIDO DINAMICO -->

                </div>
            </div>

        </div>

    </body>

</html>
