<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Thêm Mới Sản Phẩm</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; background-color: #f8f8f8; display: flex; justify-content: center; align-items: center; flex-direction: column; }
        .container { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); width: 450px; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; font-weight: bold; }
        .form-group input, .form-group textarea, .form-group select { width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        .form-group button { background-color: #4CAF50; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; margin-top: 10px; }
        .form-group button:hover { background-color: #45a049; }
        .error { color: red; font-size: 0.9em; }
        .menu ul { list-style: none; padding: 0; display: flex; justify-content: space-around; width: 500px; }
        .menu a { text-decoration: none; color: #333; padding: 5px 10px; }
    </style>
</head>
<body>
<div style="display: flex; align-items: center; flex-direction: column; width: 100%;">

    <div>
        <img src="${pageContext.request.contextPath}/img/logo.png" width="568" alt="Logo">
    </div>

    <div class="menu">
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

    <div class="container">
        <h1>Thêm Mới Điện Thoại</h1>

        <%--@elvariable id="dienThoai" type="java"--%>
        <form:form action="${pageContext.request.contextPath}/them-moi-dt" method="POST" modelAttribute="dienThoai" enctype="multipart/form-data">

            <div class="form-group">
                <label for="maDT">Mã Điện Thoại:</label>
                <form:input path="maDT" id="maDT" required="true"/>
                <form:errors path="maDT" cssClass="error"/>
            </div>

            <div class="form-group">
                <label for="tenDT">Tên Điện Thoại:</label>
                <form:input path="tenDT" id="tenDT" required="true"/>
                <form:errors path="tenDT" cssClass="error"/>
            </div>

            <div class="form-group">
                <label for="namSanXuat">Năm Sản Xuất (YYYY):</label>
                <form:input path="namSanXuat" id="namSanXuat" type="number" required="true"/>
                <form:errors path="namSanXuat" cssClass="error"/>
            </div>

            <div class="form-group">
                <label for="cauHinh">Thông tin Cấu hình:</label>
                <form:textarea path="cauHinh" id="cauHinh" rows="3" required="true"/>
                <form:errors path="cauHinh" cssClass="error"/>
            </div>

            <div class="form-group">
                <label for="nhaCungCap">Nhà Cung Cấp:</label>
                <form:select path="nhaCungCap.maNCC" id="nhaCungCap">
                    <form:option value="" label="-- Chọn Nhà Cung Cấp --"/>
                    <c:forEach var="ncc" items="${nhaCungCaps}">
                        <form:option value="${ncc.maNCC}">
                            ${ncc.tenNhaCC} - (${ncc.maNCC})
                        </form:option>
                    </c:forEach>
                </form:select>
                <form:errors path="nhaCungCap.maNCC" cssClass="error"/>
            </div>

            <div class="form-group">
                <label for="fileImage">Hình ảnh (PNG/JPG/JPEG):</label>
                <input type="file" name="fileImage" id="fileImage" accept=".png, .jpg, .jpeg" required="required"/>
            </div>

            <div class="form-group">
                <button type="submit">Thêm Sản Phẩm</button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>