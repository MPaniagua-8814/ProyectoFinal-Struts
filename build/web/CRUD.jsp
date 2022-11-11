<%-- 
    Document   : CRUD
    Created on : Nov 9, 2022, 10:19:36 PM
    Author     : Anderson
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
        <title>CRUD STRUTS2</title>
    </head>
    <body>
        <h1>Administrar Usuario</h1>
        <s:form action="SaveOrUpdate">
            <s:push value="usuario">
                <s:hidden name="id_usuario"></s:hidden>
                <s:label for="form-control">
                    <s:textfield cssClass="form-control" name="nombre" label="NOMBRE"/>
                </s:label>
                <s:label for="form-control">
                    <s:textfield cssClass="form-control" name="login" label="LOGIN"/>
                </s:label>
                <s:label for="form-control">
                    <s:textfield cssClass="form-control" name="correo" label="CORREO"/>
                </s:label>
                <s:label for="form-control">
                    <s:submit cssClass="btn btn-primary" value="ENVIAR"></s:submit>
                </s:label>
            </s:push>
        </s:form>
        <div class="d-flex">
            <div class="col-sm-12" id="hijo">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Login</th>
                            <th>Correo</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <s:iterator value="list">
                        <tr>
                            <td><s:property value="id_usuario"/> </td>
                            <td><s:property value="nombre"/></td>
                            <td><s:property value="login"/></td>
                            <td><s:property value="correo"/></td>
                            <td><s:url id="editUrl" action="editusuario">
                                    <s:param name="id_usuario" value="%{id_usuario}"></s:param>
                                </s:url><s:a href="%{editUrl}">Editar</s:a>  
                                <s:url id="deleteUrl" action="deleteusuario">
                                    <s:param name="id_usuario" value="%{id_usuario}"></s:param>
                                </s:url><s:a href="%{deleteUrl}">Eliminar</s:a>

                                </td>
                            </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

    </body>
</html>
