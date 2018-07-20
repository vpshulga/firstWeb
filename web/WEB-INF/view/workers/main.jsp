<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-5">
        <div class="table-responsive">
            <h3>Доктора:</h3>
            <table class="table">
                <tr>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Специализация</th>
                </tr>
                <c:forEach var="doctor" items="${applicationScope.doctors}" varStatus="status">
                    <tr>
                        <td>${doctor.firstName}</td>
                        <td>${doctor.lastName}</td>
                        <td>${doctor.spetialty}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="col-md-4">
        <div class="table-responsive">
            <h3>Медсестры:</h3>
            <table class="table">
                <tr>
                    <th>Имя</th>
                    <th>Фамилия</th>
                </tr>
                <c:forEach var="nurse" items="${applicationScope.nurses}" varStatus="status">
                    <tr>
                        <td>${nurse.firstName}</td>
                        <td>${nurse.lastName}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <div class="col-md-3">
        <div class="table-responsive">
            <h3>Работники регистратуры::</h3>
            <table class="table">
                <tr>
                    <th>Имя</th>
                    <th>Фамилия</th>
                </tr>
                <c:forEach var="reg" items="${applicationScope.regWorkers}" varStatus="status">
                    <tr>
                        <td>${reg.firstName}</td>
                        <td>${reg.lastName}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
