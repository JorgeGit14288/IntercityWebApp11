<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="panelAdmin.htm">  <strong>  InterCity WebApp         <small class="text text-primary"> ${sessionScope.usuario}</small> </strong>  </a>
     
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="editarPerfil.htm"><i class="fa fa-user fa-fw"></i>Perfil de Usuario</a>
                </li>
                <li><a href="settings.htm"><i class="fa fa-gear fa-fw"></i> Configuracion</a>
                </li>
                <li class="divider"></li>
                <li><a href="logout.htm"><i class="fa fa-sign-out fa-fw"></i>Salir</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="sidebar-search">
                    <div class="input-group custom-search-form">
                        <input type="text" class="form-control" placeholder="Search...">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button">
                                <i class="fa fa-search"></i>
                            </button>
                        </span>
                    </div>
                    <!-- /input-group -->
                </li>
                <li>
                    <a href="panelAdmin.htm"><i class="fa fa-dashboard fa-fw"></i> ${sessionScope.tipoUsuario} Dashboard</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-phone-square fa-fw"></i> Historial de Llamadas<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="historialAdmin.htm">Historial de Llamadas</a>
                        </li>
                        <li>
                            <a href="recargasAdmin.htm">Hisorial de Recargas</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-user fa-fw"></i> Perfil de Usuario<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="perfilAdmin.htm">Perfil </a>
                        </li>
                        <li>
                            <a href="editarPerfil.htm">Editar Perfil</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-user fa-fw"></i>Gestion de Usuarios<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="listUsuarios.htm">Usuarios Registrados </a>
                        </li>
                        <li>
                            <a href="editUsuarios.htm">Editar Datos</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-phone fa-fw"></i>Gestion de Numeros Tel.<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="listTelefonos.htm">Telefonos Registrados</a>
                        </li>
                        <li>
                            <a href="editTelefonos.htm">Editar Datos</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="logout.htm"><i class="fa fa-sign-out fa-fw"></i> Cerrar Sesion</a>
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>