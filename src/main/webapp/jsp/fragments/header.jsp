<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="app.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.1.1/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <%--<sec:authorize access="!isAuthenticated()">--%>
        <%--<p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Войти</a></p>--%>
    <%--</sec:authorize>--%>
    <sec:authorize access="isAuthenticated()">
        <p>Ваш логин: <sec:authentication property="principal.username" /></p>
        <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>
    </sec:authorize>

</div>
<hr>

