<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="prykhodko.learnSpring.util.AttributeNames" %>

    <html>
    <head>
        <title>Add Products to List</title>
    </head>

    <body>
        <div align="center">

                <form:form method="POST" modelAttribute="${AttributeNames.SHOPPING_ITEM}">
                    <table border="1" cellpadding="2">
                        <tr>
                            <td><label>ID</label></td>
                            <td>
                                <form:input path="id" disabled="true" />
                            </td>
                        </tr>

                         <tr>
                            <td><label>Item</label></td>
                            <td><form:input path="item"/></td>
                         </tr>

                         <tr>
                            <td><label>Details</label></td>
                            <td><form:textarea path="details"/></td>
                         </tr>

                          <tr>
                            <td><label>Amount</label></td>
                            <td><form:input path="amount"/></td>
                                             </tr>
                                             <tr>
                                                 <td><label>Price</label></td>
                                                 <td><form:input path="price"/></td>
                                    </tr>
                                    <tr>
                                        <td><input type="submit" value="Submit"/></td>
                                    </tr>

                                </table>

                        </form:form>


            </div>
    </body>
    </html>