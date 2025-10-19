<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        table {
            border-collapse: collapse;
            margin: 0 auto;
        }

        th, td {
            padding: 5px 15px;
        }

        .serach_btn, .add_btn, input {
            margin: 0 2px;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
        }

        .serach_btn {
            background-color: gray;
            color: white;
        }

        .add_btn {
            background-color: blue;
        }
    </style>
</head>
<body>
<h1 style="text-align: center; margin: 20px 0">EMPLOYEE LIST</h1>
<hr>
<div style="display: flex; justify-content: end; margin: 20px 200px ">
    <form action="${pageContext.request.contextPath}/employees" method="get">
        <label style="margin: 0 2px">
            <input type="text" value="${keyword}" name="keyword" style="padding: 10px 20px; border: none; box-shadow: gray 1px 1px 1px">
        </label>
        <button class="serach_btn" >Search</button>
    </form>
    <button class="add_btn">
        <a href="${pageContext.request.contextPath}/show-add-form"
           style="color: white; text-decoration: none">Add Employee</a>
    </button>
</div>
<table border="1">
    <thead style="background-color: beige">
    <tr>
        <th>First name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>Date of birth</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.gender}</td>
            <td>${employee.dateOfBirth}</td>
            <td>${employee.email}</td>
            <td>${employee.phoneNumber}</td>
            <td>
                <ul style="display: flex; list-style: none; justify-content: space-around">
                    <li style="border-right: black solid 2px; padding-right: 5px">
                        <a href="${pageContext.request.contextPath}/delete?id=${employee.id}"
                            onclick="return confirm('Are you sure about that???')"
                           style="color: red"
                        >
                            Delete</a>
                    </li>
                    <li style="padding-left: 5px"><a href="${pageContext.request.contextPath}/show-update-form?id=${employee.id}">Update</a></li>
                </ul>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>