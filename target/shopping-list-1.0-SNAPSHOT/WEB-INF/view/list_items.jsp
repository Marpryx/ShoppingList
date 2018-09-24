<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping List</title>
</head>

<body>
        <div align="center">
            <table border="1" cellpadding="5">

                <caption><h2>Shopping List</h2></caption>

                <tr>
                    <th>Item</th>
                    <th>Details</th>
                    <th>Amount</th>
                    <th>Price</th>
                </tr>

                <c:forEach var="item" items="${shoppingData.items}">

                    <tr>
                        <td><c:out value="${item.item}"/></td>
                        <td><c:out value="${item.details}"/></td>
                        <td><c:out value="${item.amount}"/></td>
                        <td><c:out value="${item.price}"/></td>
                    </tr>

                </c:forEach>

            </table>
        </div>
</body>
</html>