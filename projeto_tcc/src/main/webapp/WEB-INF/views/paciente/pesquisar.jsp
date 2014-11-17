<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sistema</title>
    
    <!-- Bootstrap Core CSS -->    
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="<c:url value="/resources/css/plugins/metisMenu/metisMenu.min.css"/>" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/sb-admin-2.css"/>" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/font-awesome-4.2.0/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Sistema</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Editar Perfil</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                        <li>
                            <a href="${pageContext.request.contextPath}/sistema/principal"><i class="fa fa-home"></i> Principal</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-user-md"></i> Médico<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/medico/adicionar/">Cadastrar</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/medico/pesquisar">Pesquisar</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-male"></i> Paciente<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/paciente/adicionar/">Cadastrar</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/paciente/pesquisar">Pesquisar</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-area-chart"></i> Exame<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/exame/adicionar/">Cadastrar</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/exame/pesquisar">Pesquisar</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>


		<div id="page-wrapper">
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
				<p style="color: blue;">${mensagem}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<br>
					<div class="panel panel-primary">
						<div class="panel-heading">Pesquisar Pacientes</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<form role="form"
										action="${pageContext.request.contextPath}/paciente/pesquisar"
										method="post">
										<div class="form-group">
											<label>Nome</label> <input type="text" name="txt_nome"
												id="txt_nome" class="form-control"
												placeholder="Digete o nome ou deixe em branco para filtrar todos os pacientes">
										</div>
										<button type="submit" class="btn btn-primary">Pesquisar</button>
										<a href="${pageContext.request.contextPath}/paciente/adicionar"><input type="button" class="btn btn-primary" alt="Adicionar Paciente" value="Adicionar"/></a>
									</form>
								</div>
							</div>
							<div class="row">
								<c:if test="${listaPacientes != null}">
									<table class="table table-striped table-bordered table-hover" id="dataTables-example">
										<thead>
											<tr>
												<th>ID</th>
												<th>Nome</th>
												<th>Sexo</th>
												<th>RG</th>
												<th>Editar</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="paciente" items="${listaPacientes}">
												<tr class="odd gradeX">
													<td>${paciente.id}</td>
													<td>${paciente.nome}</td>
													<td>${paciente.sexo}</td>
													<td class="center">${paciente.rg}</td>
													<td class="center"><a href="${pageContext.request.contextPath}/paciente/editar/${paciente.id}"><button class="btn btn-primary btn-circle" type="button"><i class="fa fa-pencil-square-o"></i></button></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</c:if>
							</div>
							<!-- /.row (nested) -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.col-lg-12 -->
				</div>

				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->


    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery.js"/>"> </script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value="/resources/js/plugins/metisMenu/metisMenu.min.js"/>"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/resources/js/sb-admin-2.js"/>"></script>

</body>

</html>
