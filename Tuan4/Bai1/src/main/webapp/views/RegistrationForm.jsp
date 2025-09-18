<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 9/18/2025
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>User Registration Form</h1>
    <form method="post" action="${pageContext.request.contextPath}/registrationform">
        <div>
            <input type="text" name="firstName" placeholder="First name">
            <input type="text" name="lastName" placeholder="Last name">
        </div>
        <input type="text" name="email" placeholder="Your email">
        <input type="text" name="re-enter-email" placeholder="Re-enter email">
        <input type="password" name="password" placeholder="New password">
        <p>Birthday</p>
        <input type="date" name="birthDay">
        <div>
            <input type="radio" name="gender">
            <span>Female</span>
            <input type="radio" name="gender">
            <span>Male</span>
        </div>
    </form>
</head>
<body>

</body>
</html>
