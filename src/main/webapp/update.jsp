<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<h2>Update user by id = <%out.println(session.getAttribute("id"));%>:</h2>
<%@ page import="com.example.jenkinsapplication.entity.User" %>
<%User user = (User)session.getAttribute("user");%>
<form method="post">
  <label>Name:
    <input type="text" name="name" minlength="2" maxlength="30" value="<%=user.getName()%>"><br />
  </label>

  <label>Surname:
    <input type="text" name="surname" minlength="2" maxlength="30" value="<%=user.getSurname()%>"><br />
  </label>

  <label>Age:
    <input type="number" name="age" min="0" max="130" value="<%=user.getAge()%>"><br />
  </label>
  <button type="submit">Submit</button>
</form>
</body>
</html>
