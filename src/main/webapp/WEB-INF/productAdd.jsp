<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Product</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
    <h1>Add Product</h1>

    <c:forEach var="error" items="${errors}">
        <p class="error"><c:out value="${error}" /></p>
    </c:forEach>

    <form action="<c:url value='/productAdd' />" method="post">
        <label>Name
            <input type="text" name="name" value="<c:out value='${name}' />">
        </label>

        <label>Category
            <select name="categoryId">
                <c:forEach var="category" items="${categoryList}">
                    <option value="${category.id}"<c:if test="${not empty categoryId and category.id eq categoryId}"> selected</c:if>><c:out value="${category.name}" /></option>
                </c:forEach>
            </select>
        </label>

        <label>Price
            <input type="text" name="price" value="<c:out value='${price}' />">
        </label>

        <label>Stock
            <input type="text" name="stock" value="<c:out value='${stock}' />">
        </label>

        <button type="submit">Add</button>
    </form>

    <p><a href="<c:url value='/products' />">Back to List</a></p>
</body>
</html>
