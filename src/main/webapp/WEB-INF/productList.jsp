<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product List</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
    <h1>Product List</h1>
    <p><a href="<c:url value='/productAdd' />">Add Product</a></p>

    <table>
        <thead>
            <tr><th scope="col">ID</th><th scope="col">Name</th><th scope="col">Category</th><th scope="col">Price</th><th scope="col">Stock</th></tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${productList}">
                <c:url var="detailUrl" value="/productDetail">
                    <c:param name="id" value="${product.id}" />
                </c:url>
                <tr>
                    <td>${product.id}</td>
                    <td><a href="${detailUrl}"><c:out value="${product.name}" /></a></td>
                    <td><c:out value="${product.categoryName}" /></td>
                    <td>${product.price}</td>
                    <td>${product.stock}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
