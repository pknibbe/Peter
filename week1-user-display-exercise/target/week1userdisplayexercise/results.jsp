<%@include file="head.jsp"%>

<html><body>
<link rel="stylesheet" type="text/css" href="myStyle.css">
<div class="container-fluid">
    <h2>Search Results: </h2>
    <table>
        <thead>
            <tr>
                <td>User ID</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Birth Date</td>
                <td>Age</td>
            </tr>
            <c:forEach var="person" items="${users}">
                <tr>
                    <td>${person.userid}</td>
                    <td>${person.firstName}</td>
                    <td>${person.lastName}</td>
                    <td>${person.dateOfBirth}</td>
                    <td>${person.age}</td>
                </tr>
            </c:forEach>
        </thead>
    </table>
</div>

</body>
</html>
