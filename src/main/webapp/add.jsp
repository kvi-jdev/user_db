
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user page</title>
</head>
<body>
<form method="post">
    <label>Name:
        <input type="text" name="name" minlength="2" maxlength="30"><br />
    </label>

    <label>Surname:
        <input type="text" name="surname" minlength="2" maxlength="30"><br />
    </label>

    <label>Age:
        <input type="number" name="age" min="0" max="130"><br />
    </label>
    <button type="submit">Submit</button>
</form>
</body>
</html>
