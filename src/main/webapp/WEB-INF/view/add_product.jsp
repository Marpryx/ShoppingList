<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% page import="prykhodko.learnSpring.util.AttributeNames" %>

<html>
<head>
    <title>Add Products to List</title>
</head>

<body>
        <div align="center">
            <form:form method="POST" modelAttribute="$AttributeNames.SHOPPING_ITEM">

            </form:form>

        </div>
</body>
</html>