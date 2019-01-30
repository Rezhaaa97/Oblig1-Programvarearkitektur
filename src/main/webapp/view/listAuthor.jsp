<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rejwanraouf
  Date: 22/01/2019
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>

</body>
<div class="container">
    <div class="row my-5">
        <div class="col-sm-10 mx-auto">
            <h4 class="text-primary text-center">Authors</h4>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Nasjonalitet</th>


                </tr>
                </thead>
                <tbody>
                <c:forEach var="author" items="${authors}">

                    <tr>
                        <th> ${author.id} </th>
                        <td>${author.firstName}</td>
                        <td>${author.lastName}</td>
                        <td>${author.nasjonalitet}</td>


                    </tr>

                </c:forEach>




                </tbody>
            </table>
            <div align="middle">
                <a href="/authorForm">
                    <button type="button" class="btn btn-primary btn-lg" align="right">+ Add new Author</button>
                </a>

            </div>


        </div>
    </div>
</div>
</html>
