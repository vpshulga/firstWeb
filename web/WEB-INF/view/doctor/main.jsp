<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">

    <div class="col-md-4">
        <div class="table-responsive">
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Жалоба</th>
                </tr>
                <c:forEach var="patient" items="${patients}" varStatus="status">
                    <tr>
                        <td>${patient.id}</td>
                        <td>${patient.firstName}</td>
                        <td>${patient.lastName}</td>
                        <div class="form-group">
                            <td><textarea class="form-control" cols="15" readonly>${patient.complaint}</textarea></td>
                        </div>
                    </tr>
                </c:forEach>


            </table>
        </div>
    </div>


    <div class="col-md-4">
        <form method="POST" action="frontController?command=doctor">
            <div class="form-group">
                <label for="patId">Выберите пациента</label>
                <select class="form-control" name="patientId" id="patId">
                    <c:forEach var="patient" items="${patients}" varStatus="status">
                        <option value="${patient.id}">${patient.id} ${patient.firstName} ${patient.lastName}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="appointment">Выписать назначение</label>
                <input type="text" class="form-control" name="appointment" id="appointment">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>




    <div class="col-md-4">
        <form method="POST" action="frontController?command=doctor">
            <div class="form-group">
                <label for="patientId">Выберите пациента</label>
                <select class="form-control" name="patientId" id="patientId">
                    <c:forEach var="patient" items="${patients}" varStatus="status">
                        <option value="${patient.id}">${patient.id} ${patient.firstName} ${patient.lastName}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="diagnosys">Поставить диагноз</label>
                <input type="text" class="form-control" name="diagnosys" id="diagnosys">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
</div>

