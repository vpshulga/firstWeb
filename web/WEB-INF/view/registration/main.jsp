<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-md-6">
        <fmt:setLocale value="${sessionScope.locale}"/>
        <fmt:setBundle basename="messages" var="i18n"/>
        <c:if test="${not empty requestScope.errorMsg}">
            <h3 class="error"><fmt:message bundle="${i18n}" key="form.input.error"/></h3>
        </c:if>
        <form class="form-horizontal" method="POST" action="frontController?command=registration">
            <h3><fmt:message bundle="${i18n}" key="reg.form"/>:</h3>
            <table>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.name"/>:</td>
                    <td><input type="text" name="firstName" required></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.surname"/>:</td>
                    <td><input type="text" name="lastName" required></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.age"/>:</td>
                    <td><input type="number" name="age"></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.sex"/></td>
                    <td>
                        <select name="sex">
                            <option value="MALE"><fmt:message bundle="${i18n}" key="form.enum.sex.male"/></option>
                            <option value="FEMALE"><fmt:message bundle="${i18n}" key="form.enum.sex.female"/></option>
                            <option selected value="UNDEFINED"><fmt:message bundle="${i18n}" key="form.enum.sex.undefined"/></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.city"/>:</td>
                    <td><input type="text" name="city" required></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.street"/>:</td>
                    <td><input type="text" name="street" required></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.house"/>:</td>
                    <td><input type="number" name="house" required></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.apartament"/>:</td>
                    <td><input type="number" name="apartament" required></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.complaint"/>:</td>
                    <td><input type="text" name="complaint" required></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.doctor"/>:</td>
                    <td>
                        <select name="doctorId">
                            <c:forEach var="doctor" items="${applicationScope.doctors}" varStatus="status">
                                <option value="${doctor.id}">${doctor.firstName} ${doctor.lastName}
                                    <c:choose>
                                        <c:when test="${doctor.spetialty eq 'THERAPIST'}">
                                            <fmt:message bundle="${i18n}" key="doc.enum.therapist"/>
                                        </c:when>
                                        <c:when test="${doctor.spetialty eq 'OPERATOR'}">
                                            <fmt:message bundle="${i18n}" key="doc.enum.operator"/>
                                        </c:when>
                                        <c:when test="${doctor.spetialty eq 'NEUROLOGIST'}">
                                            <fmt:message bundle="${i18n}" key="doc.enum.neurologist"/>
                                        </c:when>
                                        <c:when test="${doctor.spetialty eq 'OPHTHALMOLOGIST'}">
                                            <fmt:message bundle="${i18n}" key="doc.enum.ophtalmologist"/>
                                        </c:when>
                                        <c:when test="${doctor.spetialty eq 'DENTIST'}">
                                            <fmt:message bundle="${i18n}" key="doc.enum.dentist"/>
                                        </c:when>
                                        <c:when test="${doctor.spetialty eq 'OTORHINOLARINGOLOGIST'}">
                                            <fmt:message bundle="${i18n}" key="doc.enum.otorhinoloringologist"/>
                                        </c:when>
                                        <c:when test="${doctor.spetialty eq 'TRAUMATOLOGIST'}">
                                            <fmt:message bundle="${i18n}" key="doc.enum.traumatologyst"/>
                                        </c:when>
                                    </c:choose>
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right" colspan="2"><input type="submit" value="<fmt:message bundle="${i18n}" key="form.submit"/>"></td>
                </tr>
            </table>
        </form>
    </div>
    <div class="col-md-6">
        <div>
            <c:if test="${not empty userName and not empty password}">
                <h3><fmt:message bundle="${i18n}" key="reg.succsessreg"/>, login = ${requestScope.userName}, password = ${requestScope.password}</h3>
            </c:if>

        </div>
    </div>
</div>