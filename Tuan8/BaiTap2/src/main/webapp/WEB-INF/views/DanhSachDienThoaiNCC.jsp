<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Danh Sách Nhà Cung Cấp</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background-color: #f8f8f8;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            background-color: white;
        }
        th, td {
            padding: 12px 30px;
            text-align: center;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        a {
            text-decoration: none;
            color: #1a0dab;
        }
        .menu a {
            padding: 5px 10px;
            color: #333;
            transition: color 0.3s;
        }
        .menu a:hover {
            color: #007bff;
        }
        form button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        form button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div style="display: flex; align-items: center; flex-direction: column">
    <div style="width: 50%" class="menu">
        <ul style="display: flex; justify-content: space-around; list-style: none; padding: 0;">
            <li>
                <a href="${pageContext.request.contextPath}/danh-sach-ncc">Danh sách nhà cung cấp</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/them-moi-dt">Thêm mới sản phẩm</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/quan-ly">Chức năng quản lý</a>
            </li>
        </ul>
    </div>

    <div style="margin: 20px">
        <form action="${pageContext.request.contextPath}/danh-sach-ncc" method="get">
            <input type="text" name="keyword" placeholder="Tìm NCC theo mã/tên/địa chỉ..."
                   style="padding: 5px 10px; border-radius: 5px; border-style: solid; box-shadow: gray 1px 1px 0px"/>
            <button type="submit" style="padding: 5px 15px; border-radius: 5px;">Search</button>
        </form>
    </div>

    <div>
        <h1>Danh Sách Nhà Cung Cấp</h1>
        <table>
            <thead>
            <tr>
                <th>Mã NCC</th>
                <th>Tên NCC</th>
                <th>Địa chỉ</th>
                <th>Số Điện Thoại</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="ncc" items="${nhacungcap}">
                <tr>
                    <td>${ncc.maNCC}</td>
                    <td>${ncc.tenNhaCC}</td>
                    <td>${ncc.diaChi}</td>
                    <td>${ncc.soDienThoai}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/danh-sach-dt?maNCC=${ncc.maNCC}">Xem sản phẩm</a>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty nhacungcap}">
                <tr>
                    <td colspan="5" style="background-color: #ffe0e0; color: #cc0000; font-style: italic;">Không tìm thấy nhà cung cấp nào.</td>
                </tr>
            </c:if>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>