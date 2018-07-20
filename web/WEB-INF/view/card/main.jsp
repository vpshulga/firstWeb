<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">

    <div class="col-md-12">
        <div class="table-responsive">
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Жалоба</th>
                    <th>Назначения</th>
                    <th>Диагноз</th>
                </tr>

                <tr>
                    <td>${requestScope.patient.id}</td>
                    <td>${requestScope.patient.firstName}</td>
                    <td>${requestScope.patient.lastName}</td>
                    <td>${requestScope.patient.complaint}</td>
                    <td>
                        <c:forEach var="app" items="${requestScope.appointments}">
                            ${app.text}(${app.type})<br/>
                        </c:forEach>
                    </td>
                    <td>${requestScope.diagnosys.text}</td>
                </tr>

            </table>
        </div>
    </div>

</div>

