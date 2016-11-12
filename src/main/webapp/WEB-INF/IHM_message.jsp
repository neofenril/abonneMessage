<%-- 
    Document   : IHM_message.jsp
    Created on : 10 nov. 2016, 13:04:07
    Author     : Yohann
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="objets_metiers.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Connection</title>
    </head>
    <body>
        <div class="message-page">
            <div class="list-group">
                <li class="list-group-item list-group-item-action">
                    <h4 class="list-group-item-heading">Poster un Message</h4>
                    <form action="<c:url value="/message"/>" method="POST">
                        <input type="text" class="form-control" style="margin-bottom:1%" name="objet" required="required" placeholder="objet">
                        <textarea id="message" name="message" class="form-control" placeholder="message" rows="4" required="required" data-error="Please,leave us a message."></textarea>
                        <div class="help-block with-errors"></div>
                        <input type="hidden" name="abonne" value="<%=session.getAttribute("abonne")%>">
                        <input type="submit" class="btn btn-success btn-send" value="Envoyer">
                    </form>
                </li>
                <%
                    List<HashMap> messages = (List<HashMap>) request.getAttribute("messages");
                    if (messages != null) {
                        for (HashMap h : messages) {
                            String objet = (String)h.get("objet");
                            String corps = (String)h.get("corps");
                            String login = (String)h.get("login");
                %>
                <li class="list-group-item list-group-item-action">
                    <h4 class="list-group-item-heading"><%=objet%><i style="font-size:12px;"><%=" posté par "+login%></i></h4>
                    <p class="list-group-item-text"><%=corps%></p>
                </li>
                <%
                        }
                    }
                %>
            </div>
        </div>
    </body>
</html>
