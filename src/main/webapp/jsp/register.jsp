<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="fragments/header.jsp"/>

<div class="container">
    <a href="login" class="btn btn-primary">
        Back
    </a>
    <form method="post" action="register">

        <input type="hidden" id="id" name="id" value="${user.id}">
        <div class="form-group">
            <label for="name" class="control-label col-xs-3">User name</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="name" name="name" value="${user.name}">
            </div>
            <label for="email" class="control-label col-xs-3">User email</label>
            <div class="col-xs-9">
                <input type="email" class="form-control" id="email" name="email" value="${user.email}">
            </div>
            <label for="age" class="control-label col-xs-3">User age</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="age" name="age" value="${user.age}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
                <input class="btn btn-primary" type="submit" value="save">
            </div>
        </div>
    </form>
</div>
<jsp:include page="fragments/footer.jsp"/>
