<%-- 
    Document   : newjsp
    Created on : Oct 8, 2021, 9:54:51 AM
    Author     : Sami
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="bg-light m-4">
        <div class="container bg-white pb-3">
            <h1 class="h1 text-center text-info mt-4">Gestion des articles</h1>
            <div class="row justify-content-center">
                <div class="col-md-8 offset-md-3">
                <s:form action="saveOrUpdateArticle">
                    <s:textfield name="code" label="Code" />
                    <s:textfield name="designation" label="Designation"/>
                    <s:textfield name="prix" label="Prix"/>
                    <s:submit value="ADD"/>
                </s:form>
                </div>
            </div>
            
            
            <div class="row">
                <div class="col">
                    <table class="table" border="1" style="margin: auto; width:50%;">
                        <thead class="thead-dark">
                            <tr>
                                <th>Code</th>
                                <th>Designiation</th>
                                <th>Prix</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            
                            <s:iterator value="articleList">
                            <tr>    
                                <td><s:property value="code" /></td>
                                 <td><s:property value="designation" /></td>
                                <td><s:property value="prix" /></td>
                                <td>
                                  <s:url id="editURL" action="editArticle">
                                    <s:param name="code" value="%{code}"></s:param>
                                  </s:url> 
                                  <s:a href="%{editURL}">Update</s:a>
                                </td>
                          
                                <td>
                                    <s:url id="deleteURL" action="deleteArticle">
                                        <s:param name="code" value="%{code}"></s:param>
                                    </s:url> 
                                    <s:a href="%{deleteURL}">Delete</s:a>
                                </td>
                                
                            </tr>
                            </s:iterator>
                          
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>