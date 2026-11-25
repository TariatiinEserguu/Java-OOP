<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product Detail</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
    <h1>Product Detail</h1>
    <table>
        <tr><th scope="row">ID</th><td>${product.id}</td></tr>
        <tr><th scope="row">Name</th><td><c:out value="${product.name}" /></td></tr>
        <tr><th scope="row">Category</th><td><c:out value="${product.categoryName}" /></td></tr>
        <tr><th scope="row">Price</th><td>${product.price}</td></tr>
        <tr><th scope="row">Stock</th><td>${product.stock}</td></tr>
    </table>

    <form action="<c:url value='/productDelete' />" method="post">
        <input type="hidden" name="id" value="${product.id}">
        <button type="submit">Delete</button>
    </form>

    <p><a href="<c:url value='/products' />">Back to List</a></p>
</body>
</html>
