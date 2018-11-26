<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="prykhodko.learnSpring.util.Mappings" %>

<html>
<head>
    <title>View Single Products in the List</title>
</head>

<body>
    <div align="center">
    <h2>View Single Product</h2>

        <table border="1" cellpadding="2">
            <tr>
                <td><label>ID</label></td>
                <td>
                    <c:out value="${shoppingItem.id}" />
                </td>
            </tr>

             <tr>
                <td><label>Item</label></td>
                <td>
                    <c:out value="${shoppingItem.item}"/>
                </td>
             </tr>

             <tr>
                <td><label>Details</label></td>
                <td><c:out value="${shoppingItem.details}"/></td>
             </tr>

              <tr>
                <td><label>Amount</label></td>
                <td><c:out value="${shoppingItem.amount}"/></td>
              </tr>
               <tr>
                   <td><label>Price</label></td>
                   <td><c:out value="${shoppingItem.price}"/></td>
                </tr>

            </table>

            <br/>
            <c:url var="tableUrl" value="${Mappings.ITEMS}" />
            <a href="${tableUrl}"> Return to the List of Products</a>


        </div>
</body>
</html>