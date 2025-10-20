<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Danh Sách Điện Thoại</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background-color: #f8f8f8;
        }
        table {
            width: 90%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            background-color: white;
        }
        th, td {
            padding: 12px 15px;
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
    </style>
</head>
<body>
<div style="display: flex; align-items: center; flex-direction: column">

    <div>
        <img src="${pageContext.request.contextPath}/src/main/webapp/img/logo.png" width="568" alt="Logo">
    </div>

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

    <div>
        <h1>Danh Sách Điện Thoại Theo Nhà Cung Cấp</h1>
    </div>

    <div>
        <table>
            <thead>
            <tr>
                <th>Mã ĐT</th>
                <th>Tên ĐT</th>
                <th>Năm SX</th>
                <th>Cấu hình</th>
                <th>Hình ảnh</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="dt" items="${dienThoaiList}">
                <tr>
                    <td>${dt.maDT}</td>
                    <td>${dt.tenDT}</td>
                    <td>${dt.namSanXuat}</td>
                    <td>${dt.cauHinh}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/img/uploads/${dt.hinhAnh}"
                             alt="${dt.tenDT}"
                             style="width: 100px; height: auto; border-radius: 5px;"/>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${empty dienThoaiList}">
                <tr>
                    <td colspan="5" style="background-color: #ffe0e0; color: #cc0000; font-style: italic;">Không tìm thấy sản phẩm nào từ nhà cung cấp này.</td>
                </tr>
            </c:if>
            </tbody>
        </table>
        <p>
            <a href="${pageContext.request.contextPath}/danh-sach-ncc">← Quay lại danh sách Nhà Cung Cấp</a>
        </p>
    </div>
</div>

</body>
</html>