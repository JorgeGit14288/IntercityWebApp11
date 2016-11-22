 <%-- 
    Document   : headDashboard
    Created on : 7/11/2016, 10:22:26 AM
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/theme1/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/resources/theme1/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/theme1/dist/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/theme1/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
      <!-- DataTables CSS -->
    <link href="${pageContext.request.contextPath}/resources/theme1/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
    <!-- DataTables Responsive CSS -->
    <link href="${pageContext.request.contextPath}/resources/theme1/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
    <!-- morris -->
    <link href="${pageContext.request.contextPath}/resources/theme1/vendor/morrisjs/morris.css" rel="stylesheet">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
     </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/theme1/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/theme1/vendor/jquery/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/theme1/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/theme1/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/theme1/dist/js/sb-admin-2.js"></script>
    
     <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/theme1/vendor/raphael/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/theme1/vendor/morrisjs/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/theme1/data/morris-data.js"></script>
    
     <!-- DataTables JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/theme1/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/theme1/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/theme1/vendor/datatables-responsive/dataTables.responsive.js"></script>
    
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
    </head>
    
</html>
