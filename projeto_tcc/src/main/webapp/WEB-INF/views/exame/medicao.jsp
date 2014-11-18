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
						<div class="panel-heading">Medições</div>
						<div class="panel-body">
							<div class="row">
								<div class="panel panel panel-green">
									<div class="panel-heading">Paciente</div>
									<div class="panel-body">
										<div class="form-group">
											<br><label>Nome Paciente</label>
											<br><p>${exame.paciente.nome}</p>
											<br><label>Sexo</label>
											<br><p>${exame.paciente.sexo}</p>
											<br><label>Data de Nascimento</label>
											<br><p>${exame.paciente.data_nascimento}</p>
											<br><label>Telefone</label>
											<br><p>${exame.paciente.telefone}</p>
											<br><label><span style="color: green">Nome Medico</span></label>
											<br><p><span style="color: green">${exame.medico.nome}</span></p>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="panel panel panel-green">
									<div class="panel-heading">Tabela de Medições</div>
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
							                    	<c:forEach var="medicoes" items="${exame.medicoes}">
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
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6">
								<div class="panel panel panel-green">
									<div class="panel-heading"></div>
										<div class="panel-body">
											<script type="text/javascript">
													$(function () {
													    $('#pressao_'+${exame.id}).highcharts({
													        chart: {
													            type: 'area'
													        },
													        title: {
													            text: 'Gráfico das Medições'
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
													            	dataLabels: {
													                    enabled: true
													                },
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
			                                <div id="pressao_${exame.id}" style="min-width: 800px; height: 400px; margin: 0 auto"></div>
		                                </div>
	                                </div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6">
									<div class="panel panel panel-green">
									<div class="panel-heading"></div>
										<div class="panel-body">
											<script type="text/javascript">
												$(function () {
												    $('#batimento_'+${exame.id}).highcharts({
												        title: {
												            text: 'Gráfico batimentos cardíacos por minuto'
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
												                text: 'Batimentos cardíaco por minuto'
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
												            line: {
												                dataLabels: {
												                    enabled: true
												                },
												                enableMouseTracking: false
												            }
												        },
												        
												        ${exame.medicoesBatimento}
												        
												    });
												});
											</script>
		                               		<div id="batimento_${exame.id}" style="min-width: 800px; height: 400px; margin: 0 auto"></div>
		                               </div>
		                           </div>
								</div>
							</div>
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
