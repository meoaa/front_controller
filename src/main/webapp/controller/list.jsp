<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>list page</title>
</head>
<body>
    <h1>list</h1>
    <c:if test="${empty todo}">
        <p>할 일이 존재하지 않습니다.</p>
    </c:if>

    <c:if test="${not empty todo}">
        <ul>
            <c:forEach var="todo" items="${todo}">
                <li>${todo.title} / ${todo.completed}</li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>