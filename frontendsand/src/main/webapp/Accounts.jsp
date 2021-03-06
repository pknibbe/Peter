<%@include file="taglib.jsp"%>
<c:set var="title" value="Account Management" />
<%@include file="head.jsp"%>
<html>
<body>
<h2>${SessionMessage}</h2><br/><br/>

<div>
    <h2>Manage Accounts</h2>
    <form action="UpdateAccounts" method="POST">
        <table>
            <thead><tr><th>Select</th><th>ID</th><th>Name</th><th>Username</th><th>Password</th><th>Role</th></tr></thead>
            <tbody>
                <c:forEach var="person" items="${users}">
                    <tr>
                        <td><input type="radio" name="userID" value=${person.id} /></td>
                        <td>${person.id}</td>
                        <td><input type="text" name="Name" value=${person.name} /></td>
                        <td><input type="text" name="Username" value=${person.username} /></td>
                        <td><input type="text" name="Password" value=${person.pw} /></td>
                        <td><select name="Role">
                            <option value=${person.role}>${person.role}</option>
                            <option value="admin">Admin</option>
                            <option value="edit">Editor</option>
                            <option value="readOnly">Listener</option>
                        </select></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><input type="radio" name="userID" value="0" /></td>
                    <td>New User</td>
                    <td><input type="text" name="Name" value="" /></td>
                    <td><input type="text" name="Username" value="" /></td>
                    <td><input type="text" name="Password" value="" /></td>
                    <td><select name="Role">
                        <option value="admin">Admin</option>
                        <option value="edit">Editor</option>
                        <option value="readOnly">Listener</option>
                    </select></td>
                </tr>
            </tbody>
        </table><br/><br/>
        <input type="submit" name="Update" value="Update" />
        <input type="submit" name="Delete" value="Delete" />
    </form>
</div>

<div>
    <h4>MessageCenter</h4>

    <form action="MessageCenter" method="POST">
        <input type="submit" value="Submit" name="Enter" />
    </form>
</div>

<br /><br />

<div>

    <h4>Account Center</h4>

    <form action="AccountCenter" method="POST">
        <input type="submit" value="Submit" name="Enter" />
    </form></div>

</body>

</html>