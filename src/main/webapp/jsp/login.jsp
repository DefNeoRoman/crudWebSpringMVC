<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="fragments/header.jsp"/>
<div class="container">
    <h1>Login page</h1>
    <h2>login or register</h2>
    <form action="/j_spring_security_check" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value=" ">
        <input type="password" class="form-control" name="j_password" placeholder="Password" required value=" ">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</div>
<jsp:include page="fragments/footer.jsp"/>
