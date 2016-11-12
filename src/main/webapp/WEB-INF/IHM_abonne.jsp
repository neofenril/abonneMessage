<%-- 
    Document   : index
    Created on : 9 nov. 2016, 14:17:22
    Author     : Yohann
--%>

<%@page import="objets_metiers.Abonne"%>
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
    <%
       if(request.getAttribute("abonne")!=null){
            session.setAttribute("abonne", request.getAttribute("abonne"));
            response.sendRedirect("./message");
       }
    %>
    <body>
        <div class="login-page">
            <div class="form">
                <form class="register-form" action="<c:url value="/abonne"/>" method="POST">
                    Particulier <input class="typeAbonne" type="radio" name="typeAbonne" value="particulier" checked/>
                    Entreprise <input class="typeAbonne" type="radio" name="typeAbonne" value="entreprise" />
                    <input class="inputForm" id="nom" type="text" name="nom" placeholder="nom"/>
                    <input class="inputForm" id="prenom" type="text" name="prenom" placeholder="prenom"/>
                    <input class="inputForm" id="raison_sociale" style="display:none" type="text" name="raison_sociale" placeholder="raison sociale"/>
                    <input class="inputForm" type="text" name="login" placeholder="login"/>
                    <input class="inputForm" type="password" name="mdp" placeholder="password"/>
                    <input type="hidden" name="gestion_abonne" value="ajout"/>
                    <button type="submit">Créer</button>
                    <p class="message">Déjà Inscrit? <a href="#">Se Connecter</a></p>
                </form>
                <form class="login-form" action="<c:url value="/abonne"/>" method="POST">
                    <input class="inputForm" type="text" name="login" placeholder="login"/>
                    <input class="inputForm" type="password" name="mdp" placeholder="password"/>
                    <input type="hidden" name="gestion_abonne" value="connection"/>
                    <button type="submit">Se Connecter</button>
                    <p class="message">Non Inscrit? <a href="#">Créer un Compte</a></p>
                </form>
            </div>
        </div>
        <script>
            $('.message a').click(function () {
                $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
            });
            $('.typeAbonne').change(function () {
                if($('.typeAbonne:checked').val()=="entreprise"){     
                    $('#raison_sociale').show();
                    $('#nom').hide();
                    $('#prenom').hide();
                }else{
                    $('#raison_sociale').hide();
                    $('#nom').show();
                    $('#prenom').show();
                }
            });
        </script>
    </body>
</html>
