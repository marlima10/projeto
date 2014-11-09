<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Acessar o Sistema</title>

    <!-- Bootstrap Core CSS -->    
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="<c:url value="/resources/css/plugins/metisMenu/metisMenu.min.css"/>" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/sb-admin-2.css"/>" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/font-awesome-4.1.0/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Acessar o Sistema</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="Post" action="${pageContext.request.contextPath}/sistema/logar">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Senha" name="senha" type="password" value="">
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit" class="btn btn-lg btn-success btn-block"  title="Acessar"/>
                                <p style="color:red;font-family:verdana;font-size:80%;">${message}</p>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div> 
    
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
