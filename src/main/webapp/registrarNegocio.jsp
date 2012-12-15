<%--
    Document   : viewPerfil.jsp
    Created on : 16/04/2011, 12:33:56 AM
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns:fb="http://www.facebook.com/2008/fbml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />         <meta http-equiv="X-UA-Compatible" content="IE=7" />
        <title>quienconoce.com</title>
        <link href="<%=request.getContextPath()%>/css/quienconoceform.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery.maskedinput-1.3.min.js" type="text/javascript"></script>
    </head>
    <body>
       
            
            <div class="content" align="center" >
            
            <div class="contenido">
                    <jsp:include page="registrarNegocio.zul?dto_class=mx.test.dr4zkdemo.view.model.RegisterEmpresaMain&action=ADD"/>
            </div>
            </div>
            
        
        </body>
</html>