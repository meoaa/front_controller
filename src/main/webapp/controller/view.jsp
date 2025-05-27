<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>view</h1>
    <ul>
        <li>title : ${todo.title} </li>
        <li>createdAt : ${todo.createdAt} </li>
        <li>completed : ${todo.completed} </li>
    </ul>
</body>
</html>