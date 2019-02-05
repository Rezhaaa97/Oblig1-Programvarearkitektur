<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rejwanraouf
  Date: 03/02/2019
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>

</body>

<div class="container">
    <div class="row my-5">
        <div class="col-sm-8 mx-auto">
            <h4 class="text-primary text-center">Books List</h4>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ISBN</th>
                    <th scope="col">Title</th>
                    <th scope="col">Release Year</th>
                    <th scope="col">Author</th>


                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${books}">

                    <tr>
                        <th> ${book.ISBN} </th>
                        <td>${book.title}</td>
                        <td>${book.releaseYear}</td>
                        <td>${book.author.firstName} ${book.author.lastName}</td>
                        <td>
                            <a href="/edit/${book.ISBN}" class="btn btn-white btn-lg text-warning"><i class="fas fa-edit"></i> </a>

                        </td>

                        <td>
                            <a href="/delete/${book.ISBN}" class="btn btn-white btn-lg text-danger"> <i class="fas fa-trash-alt"></i>  </a>

                        </td>

                    </tr>

                </c:forEach>


                </tbody>
            </table>

            <a href="/formBook" class="btn btn-primary btn-lg btn-block active" role="button" aria-pressed="true">Add a book</a>


        </div>
    </div>
</div>


</html>
