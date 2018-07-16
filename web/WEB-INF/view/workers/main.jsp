<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="personalTables">
        <h3>Доктора:</h3>
        <table border="1" align="center">
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Специализация</th>
            </tr>
        <c:forEach var="doctor" items="${doctors}" varStatus="status">
                <tr>
                    <td>${doctor.firstName}</td>
                    <td>${doctor.lastName}</td>
                    <td>${doctor.spetialty}</td>
                </tr>
        </c:forEach>
        </table>
        <table border="1" align="center">
            <h3>Медсестры:</h3>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
            </tr>
            <c:forEach var="nurse" items="${nurses}" varStatus="status">
                <tr>
                    <td>${nurse.firstName}</td>
                    <td>${nurse.lastName}</td>
                </tr>
            </c:forEach>
        </table>

        <table border="1" align="center">
            <h3>Работники регистратуры:</h3>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
            </tr>
            <c:forEach var="reg" items="${regWorkers}" varStatus="status">
                <tr>
                    <td>${reg.firstName}</td>
                    <td>${reg.lastName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
