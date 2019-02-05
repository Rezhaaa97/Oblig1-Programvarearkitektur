<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rejwanraouf
  Date: 03/02/2019
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>

</body>

<div class="container">
    <div class="row my-5">
        <div class="col-sm-6 mx-auto">
            <h4 class="text-primary text-center">Add new Book</h4>

            <form:form method="POST" action="/save" modelAttribute="book">
            <div class="form-group">
                <form:input type="text" class="form-control" placeholder="ISBN" name="ISBN" path="ISBN"/>
            </div>

            <div class="form-group">
                <form:input type="text" class="form-control" placeholder="title" name="title" path="title"/>
            </div>

            <div class="form-group">
                <form:input type="text" class="form-control" placeholder="releaseYear" name="releaseYear" path="releaseYear"/>
            </div>

            <div class="form-group">
                <select class="custom-select" id="inputGroupSelect01"  name="author" >
                    <c:forEach var="auth" items="${authors}">
                        <option  value=${auth.id}>${auth.firstName}   ${auth.lastName} </option>
                    </c:forEach>

                </select>
            </div>


            <button type="submit" class="btn btn-primary">Save</button>

        </div>
    </div>
</div>

</form:form>
</html>
