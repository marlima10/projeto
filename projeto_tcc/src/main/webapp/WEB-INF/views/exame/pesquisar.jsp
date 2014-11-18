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
    <link href="<c:url value="/resources/font-awesome-4.2.0/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
     
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
										action="${pageContext.request.contextPath}/exame/pesquisar"
										method="post">
										<div class="form-group">
											<label>Paciente</label> 
											<select name="txt_paciente" id="txt_paciente" class="form-control">
												<option value="" selected="selected">-</option>
												<c:forEach var="paciente" items="${listaPacientes}">
												 	<option value="${paciente.id}">${paciente.nome}</option>
												</c:forEach>
											</select>
											<label>Médico</label> 
											<select name="txt_medico" id="txt_medico" class="form-control">
												<option value="" selected="selected">-</option>
												<c:forEach var="medico" items="${listaMedicos}">
												 	<option value="${medico.id}">${medico.nome}</option>
												</c:forEach>
											</select>  
										</div>
										<button type="submit" class="btn btn-primary">Pesquisar</button>
										<a href="${pageContext.request.contextPath}/exame/adicionar"><input type="button" class="btn btn-primary" alt="Adicionar Paciente" value="Adicionar"/></a>
									</form>
								</div>
							</div>
							<div class="row">
								<c:if test="${listaExames != null}">
									<table class="table table-striped table-bordered table-hover" id="dataTables-example">
										<thead>
											<tr>
												<th>ID</th>
												<th>Nome Paciente</th>
												<th>Nome Medico</th>
												<th>Ultimas Medições</th>
												<th>Exibir Resultados</th>
												<th>Editar</th>
											</tr>
										</thead>
										<tbody>
											
											<c:forEach var="exame" items="${listaExames}">
												<tr class="odd gradeX">
													<td>${exame.id}</td>
													<td>${exame.paciente.nome}</td>
													<td>${exame.medico.nome}</td>
													<td class="center">
														<!-- Modal Paciente -->
														<button type="button" class="btn btn-primary btn-circle" data-toggle="modal" data-target="#myModalPaciente${exame.id}">
														  <i class="fa fa-info"></i>
														</button>
														
														<!-- Modal -->
														<div class="modal fade" id="myModalPaciente${exame.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
														  <div class="modal-dialog modal-lg">
														    <div class="modal-content">
														      <div class="modal-header">
														        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
														        <h4 class="modal-title" id="myModalLabel">Ultimas Medições</h4>
														      </div>
														      <div class="modal-body">
														      	<div class="form-group">
																	<br><label>Nome Paciente</label>
																	<br><p>${exame.paciente.nome}</p>
																	<br><label>Nome Medico</label>
																	<br><p>${exame.medico.nome}</p>
																	<div class="panel panel-primary">
												                        <div class="panel-heading">
												                            Ultimas Três Medições
												                        </div>
												                        
												                        <!-- /.Panel Medições -->
												                        <div class="panel-body">
												                            <div class="table-responsive table-bordered">
												                                <table class="table">
												                                    <thead>
												                                        <tr>
												                                            <th>id</th>
												                                            <th>Sistole</th>
												                                            <th>Diastole</th>
												                                            <th>Batimentos Cadíacos</th>
												                                        </tr>
												                                    </thead>
												                                    <tbody>
												                                    	<c:forEach var="medicoes" items="${exame.medicoesUltimas}">
													                                    	<tr>
													                                            <td>${medicoes.id}</td>
													                                            <td>${medicoes.pressao_sistolica}</td>
													                                            <td>${medicoes.pressao_diastolica}</td>
													                                            <td>${medicoes.batimento}</td>
													                                        </tr>
												                                    	</c:forEach>
												                                    </tbody>
												                                </table>
												                            </div>
												                            <!-- /.table-responsive -->
												                        </div>
												                        <!-- /.Panel Medições -->
												                        
												                         <!-- /.Panel Medições -->
												                        <div class="panel-body">
												                            <div class="table-responsive table-bordered">
												                            	    <script type="text/javascript">
																						$(function () {
																						    $('#container_'+${exame.id}).highcharts({
																						        chart: {
																						            type: 'area'
																						        },
																						        title: {
																						            text: 'Ultimos Resultados'
																						        },
																						        xAxis: {
																						            allowDecimals: false,
																						            labels: {
																						                formatter: function () {
																						                    return this.value; // clean, unformatted number for year
																						                }
																						            }
																						        },
																						        yAxis: {
																						            title: {
																						                text: 'Pressão arterial ml/Hg'
																						            },
																						            labels: {
																						                formatter: function () {
																						                    return this.value;
																						                }
																						            }
																						        },
																						        tooltip: {
																						            pointFormat: '{series.name}:<b>{point.y:,.0f}</b>'
																						        },
																						        plotOptions: {
																						            area: {
																						                pointStart: 1,
																						                marker: {
																						                    enabled: false,
																						                    symbol: 'circle',
																						                    radius: 2,
																						                    states: {
																						                        hover: {
																						                            enabled: true
																						                        }
																						                    }
																						                }
																						            }
																						        },
																						        
																						        ${exame.medicoesData}
																						        
																						    });
																						});
																					</script>
												                                <div id="container_${exame.id}" style="min-width: 800px; height: 400px; margin: 0 auto"></div>
												                            </div>
												                            <!-- /.table-responsive -->
												                        </div>
												                        <!-- /.Panel Medições -->									                        												                        
												                    </div>
																</div>
														      </div>
														    </div>
														  </div>
														</div>	
													</td>
													<td class="center"><a href="${pageContext.request.contextPath}/exame/medicao/${exame.id}" title="Ver Resumo"><button class="btn btn-danger btn-circle" type="button" ><i class="fa fa-area-chart"></i></button></a></td>
													<td class="center"><a href="${pageContext.request.contextPath}/exame/editar/${exame.id}" title="Ver Resultados"><button class="btn btn-primary btn-circle" type="button"><i class="fa fa-pencil-square-o"></i></button></a></td>
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
    
    <script src="<c:url value="/resources/chart/js/highcharts.js"/>"></script>
</body>

</html>
