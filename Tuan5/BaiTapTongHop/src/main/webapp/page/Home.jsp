<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 9/26/2025
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
      .container{
        width: 1260px;
        border: 2px black  solid;
        margin: 0 auto;
        padding: 0;
        box-sizing: border-box;
      }
      .banner{
        width: 100%;
      }
      a{
        padding-left: 10px;
        padding-right: 10px;
        color: blue;
        text-decoration: underline;

      }
    </style>
</head>
<body>
  <div class="container">
    <div>
      <img src="${pageContext.request.contextPath}/img/banner.png" class="banner" >
    </div>
    <div style="display: flex; justify-content: center; border-top: 1px black solid; border-bottom: 1px black solid" >
      <a>Danh sach san pham</a>
      <a style="border-left: black 2px solid; border-right:black 2px solid">Them moi san pham</a>
      <a>Chuc nang quan ly</a>
    </div>
    <div style="height: 500px">
        <table border="1">
            <thead>
                <tr>
                    <th>MaDT</th>
                    <th>Ten DT</th>
                    <th>NSX</th>
                    <th>Cau hinh</th>
                    <th>Ma NCC</th>
                    <th>Hinh anh</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="dt" items="${listDienThoai}">
                <tr>
                    <td>${dt.maDT}</td>
                    <td>${dt.tenDT}</td>
                    <td>${dt.namSanXuat}</td>
                    <td>${dt.cauHinh}</td>
                    <td>${dt.maNCC}</td>
                    <td>
                        <img src="${pageContext.request.contextPath}/img/${dt.hinhAnh}" alt="${dt.tenDT}" width="50">

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <footer style="text-align: center; border-top: black 1px solid">Pham Dac Thinh - 22691361 - DHKTPM18CTT</footer>
  </div>
</body>
</html>
