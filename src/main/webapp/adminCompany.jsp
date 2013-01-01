

<%@page import="java.util.Collection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns:fb="http://www.facebook.com/2008/fbml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />         <meta http-equiv="X-UA-Compatible" content="IE=7" />
        <title>quienconoce.com</title>
        <link href="<%=request.getContextPath()%>/css/quienconoceform.css" rel="stylesheet" type="text/css" />
        <script src="<%=request.getContextPath()%>/js/myslidemenu2.js" type="text/javascript"></script>
        <link href="<%=request.getContextPath()%>/css/slidemenu.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/css/slidemenu2.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/css/slidemenu3.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/css/slidemenu4.css" rel="stylesheet" type="text/css" />




        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/jquery.maskedinput-1.3.min.js" type="text/javascript"></script>
    </head>
    <%
                String ua = request.getHeader("User-Agent");
                boolean isFirefox = (ua != null && ua.indexOf("Firefox/") != -1);
                Collection<DRMenu> menu = (Collection<DRMenu>) session.getAttribute(DRConstants.SESSION_CURRENT_MENU);

                System.out.println("in map: " + session.getAttributeNames());
    %>
    <body onload="<% if (menu != null) {
                    for (int i = 1; i <= menu.size(); i++) {%>initSlideDownMenu2('dhtmlgoodies_slidedown_menu<%=i%>');<% }
                                }%>">

            <jsp:include page ="../../pages/template/header.zul"/>
            <div class="content" align="center" >




            <div class="contenido">
            <table width="100%" cellspacing="10" height="100%">
            <tr>
                <td  width="170px" id="leftMenu2" valign="top">


                    <%if (menu != null) {
                                    int i = 1;
                                    for (DRMenu princ : menu) {
                    %>
                    <div class="menutitles"><%=princ.getLabel()%></div>
                    <div id="dhtmlgoodies_slidedown_menu<%=i%>">
                        <ul>
                            <% for (DRMenu sub : princ.getSubmenu()) {%>
                            <li><a href="#"><%=sub.getLabel()%></a>
                                <ul>
                                    <%for (DRMenu subsub : sub.getSubmenu()) {%>
                                    <li><a href="<%=request.getContextPath()%>/pages/<%=subsub.getRutas()[0]%>"><%=subsub.getLabel()%></a></li>
                                    <%}%>
                                </ul>
                            </li>
                            <%}%>
                        </ul>
                    </div>
                    <%i++;
                        }
                    }%>


                </td>
                <td>
                     <jsp:include page="/pages/admin/buscarGeneral.zul?dto_class=mx.dr.ml.view.dto.empresa.SearchEmpresaMain&action=SEARCH"/>


                </td>
            </tr>

            </table>

            </div>
            </div>
            <jsp:include page ="../../pages/template/footer.zul"/>

        </body>
</html>

      