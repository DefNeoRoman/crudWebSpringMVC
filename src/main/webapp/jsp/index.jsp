<%@ page import="app.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="fragments/header.jsp"/>
<div class="container">

        <form method="get" action="user/create">
            <input class="btn btn-primary" type="submit" value="Add">
        </form>
        <table id="userDataTable" class="display" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
                <th>Register Date</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody id="arrayTable">

            <c:forEach items="${users}" var="user">
                <jsp:useBean id="user" class="app.model.User"/>
                <tr id = "${user.id}">
                    <td name="id"><c:out value="${user.id}"/></td>
                    <td name="name"><c:out value="${user.name}"/></td>
                    <td name="email"><c:out value="${user.email}"/></td>
                    <td name="age"><c:out value="${user.age}"/></td>
                    <td name="createdDate"><c:out value="${user.createdDate}"/></td>
                    <td name="role"><c:out value="${user.role}"/></td>
                    <td name="id">
                        <a class ="btn btn-primary" href="user/edit?id=${user.id}">Edit</a>
                    </td>
                    <td name="id">
                        <a class ="btn btn-primary" href="user/delete?id=${user.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

            <tfoot>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
                <th>Register Date</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </tfoot>
        </table>


</div>
<jsp:include page="fragments/footer.jsp"/>