<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="prykhodko.learnSpring.util.Mappings" %>

<html>
<head>
    <title>Shopping List Application</title>
</head>

<body>
        <div align="center">
            <c:url var="productsLink" value="${Mappings.ITEMS}" />
            <h2><a href="${productsLink}">Check the Shopping List </h2>
        </div>
</body>
</html>