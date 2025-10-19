<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        .form-container {
            width: 450px;
            padding: 40px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        }

        h1 {
            color: #000;
            text-align: center;
            margin-bottom: 30px;
            font-size: 24px;
            font-weight: bold;
            line-height: 1.2;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 10px 0;
            vertical-align: middle;
        }

        td:first-child {
            font-weight: normal;
            width: 35%;
            padding-right: 15px;
        }

        form\:input, input[type="date"] {
            width: 95%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .button-group {
            /* SỬA: Căn giữa các nút */
            text-align: center;
            padding-top: 20px;
        }

        .button-group button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin: 0 5px; /* Giảm khoảng cách giữa các nút */
            width: 120px;
        }

        .back-btn {
            background-color: #9e9e9e;
            color: white;
        }

        .register-btn {
            background-color: #007bff;
            color: white;
        }

        .register-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body contenteditable="false" >
<div class="form-container">

    <h1>${pageTitle}</h1>

    <%--@elvariable id="employee" type="java"--%>
    <form:form action="${pageContext.request.contextPath}/${formAction}"
               method="post"
               modelAttribute="employee">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td>First Name</td>
                <td><form:input path="firstName" placeholder="First Name"/></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><form:input path="lastName" placeholder="Last Name"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><form:input path="email" placeholder="Email"/></td>
            </tr>
            <tr>
                <td>Date of Birth</td>
                <td>
                    <form:input path="dateOfBirth" type="date"/>
                </td>
            </tr>
            <tr>
                <td>Phone number</td>
                <td><form:input path="phoneNumber" placeholder="Phone number"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>
                    <label>Male <form:radiobutton path="gender" value="MALE"/></label>
                    <label>Female <form:radiobutton path="gender" value="FEMALE"/></label>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="button-group">
                    <button type="button" class="back-btn"
                            onclick="window.location.href='${pageContext.request.contextPath}/employees'">Back
                    </button>

                    <button type="submit" class="register-btn">${submitButtonText}</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>