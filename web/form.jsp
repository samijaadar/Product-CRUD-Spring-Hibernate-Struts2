<%-- 
    Document   : form
    Created on : Dec 18, 2021, 12:16:07 AM
    Author     : Sami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="bg-light m-5">
        
        <div class="container bg-white pb-4">
            <h1 class="h1 text-center text-info">Modifier article</h1>
            <div class="row">
                <div class="col">
                <s:form action="saveOrUpdateArticle">
                    <s:textfield name="code" label="Code" />
                    <s:textfield name="designation" label="Designation"/>
                    <s:textfield name="prix" label="Prix"/>
                    <s:submit value="ADD"/>
                </s:form>

                </div>
            </div>
        </div>
    </body>
</html>
