
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


                <div class="row">

                    <!-- CONTENIDO DINAMICO -->
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                DataTables Advanced Tables
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>No. Telefono</th>
                                            <th>Id Usuario</th>
                                            <th>Codigo</th>
                                            <th>Status</th>                                            
                                            <th>Acciones</th>


                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listaTelefonos}" var="telefono">
                                            <tr>
                                                <td><c:out value="${telefono.getTelefonoArea()}" /></td>
                                                <td><c:out value="${telefono.getUsuarios().getIdUsuario()}" /></td>
                                                <td><c:out value="${telefono.getCodigoConfirm()}" /></td>
                                                
                                                <td><c:out value="${telefono.getStatus()}" /></td>
                                              
                                                <td><a href="editarTelefonos.htm?idTelefono=${telefono.getTelefonoArea()}">editar</a></td>         
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                                <!-- /.table-responsive -->
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
                    <!-- /.col-lg-8 -->

                    <!-- CONTENIDO DINAMICO -->

                </div>
            </div>
            <script>
                $(document).ready(function () {
                    $('#dataTables-example').DataTable({
                        responsive: true
                    });
                });
            </script>


        </div>

    </body>

</html>
