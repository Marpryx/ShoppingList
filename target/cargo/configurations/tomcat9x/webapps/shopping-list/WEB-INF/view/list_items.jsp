<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="prykhodko.learnSpring.util.Mappings" %>

<html>
<head>
    <title>Shopping List</title>
</head>

<body>
        <div align="center">
        <c:url var="addUrl" value="${Mappings.ADD_PRODUCT}" />
        <a href="${addUrl}">New Item</a>

            <table border="1" cellpadding="6">

                <caption><h2>Shopping List</h2></caption>

                <tr>
                    <th>Item</th>
                    <th>Details</th>
                    <th>Amount</th>
                    <th>Price</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>

                <c:forEach var="item" items="${shoppingData.items}">

                    <c:url var="editUrl" value="${Mappings.ADD_PRODUCT}">
                        <c:param name="id" value="${item.id}" />
                    </c:url>

                    <c:url var="deleteUrl" value="${Mappings.DELETE_PRODUCT}">
                        <c:param name="id" value="${item.id}" />
                    </c:url>

                    <tr>
                        <td><c:out value="${item.item}"/></td>
                        <td><c:out value="${item.details}"/></td>
                        <td><c:out value="${item.amount}"/></td>
                        <td><c:out value="${item.price}"/></td>
                        <td><a href="${editUrl}">Edit</a></td>
                        <td><a href="${deleteUrl}">Delete</a></td>

                    </tr>

                </c:forEach>

            </table>
        </div>
</body>
</html>