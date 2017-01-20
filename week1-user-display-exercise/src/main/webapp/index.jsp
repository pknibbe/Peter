<%@include file="head.jsp"%>
<html>
<body>
<h2>User Display Exercise - Week 1</h2>
<br /><br />
<br /><br />

<h4>Search for users</h4>
<br /><br />
<form action="searchUser" method="GET">
    Criterion:
    <select name="criterion">
        <option value=""></option>
        <option value="id">ID</option>
        <option value="first_name">First Name</option>
        <option value="last_name">Last Name</option>
        <option value="date_of_birth">Birth Date</option>
    </select>
        <br /><br />
    Search value:
    <input type="text" name="value" /><br /><br />
    <input type="submit" name="" value="Enter" />
</form>

</body>
</html>