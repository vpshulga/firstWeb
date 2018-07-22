<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="messages" var="i18n"/>
    <div class="col-md-4">
        <form class="form-horizontal" method="POST" action="frontController?command=admin">
            <h3><fmt:message bundle="${i18n}" key="admin.adddoc"/>:</h3>
            <table>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.name"/>:</td>
                    <td><input type="text" name="firstName"></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.surname"/>:</td>
                    <td><input type="text" name="lastName"></td>
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
                    <td><fmt:message bundle="${i18n}" key="admin.form.education"/></td>
                    <td>
                        <select name="education">
                            <option value="HIGH"><fmt:message bundle="${i18n}" key="admin.form.enum.education.high"/></option>
                            <option value="MIDDLE"><fmt:message bundle="${i18n}" key="admin.form.enum.education.middle"/></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="admin.exp"/></td>
                    <td><input type="number" name="experience"></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.speciality"/>:</td>
                    <td>
                    <select name="spetiality">
                        <option value="THERAPIST"><fmt:message bundle="${i18n}" key="doc.enum.therapist"/></option>
                        <option value="OPERATOR"><fmt:message bundle="${i18n}" key="doc.enum.operator"/></option>
                        <option value="NEUROLOGIST"><fmt:message bundle="${i18n}" key="doc.enum.neurologist"/></option>
                        <option value="OPHTHALMOLOGIST"><fmt:message bundle="${i18n}" key="doc.enum.ophtalmologist"/></option>
                        <option value="DENTIST"><fmt:message bundle="${i18n}" key="doc.enum.dentist"/></option>
                        <option value="OTORHINOLARINGOLOGIST"><fmt:message bundle="${i18n}" key="doc.enum.otorhinoloringologist"/></option>
                        <option value="TRAUMATOLOGIST"><fmt:message bundle="${i18n}" key="doc.enum.traumatologyst"/></option>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="login.login"/></td>
                    <td><input type="text" name="login"></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="login.password"/>:</td>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td align="right" colspan="2"><input type="submit" value="<fmt:message bundle="${i18n}" key="login.submit"/>"></td>
                </tr>
            </table>
            <c:if test="${not empty requestScope.repDoc}">
                <h3><fmt:message bundle="${i18n}" key="admin.repeateduser"/></h3>
            </c:if>
        </form>
    </div>

    <div class="col-md-4">
        <form class="form-horizontal" method="POST" action="frontController?command=admin">
            <h3><fmt:message bundle="${i18n}" key="admin.addreg"/>:</h3>
            <table>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.name"/>:</td>
                    <td><input type="text" name="firstNameReg"></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.surname"/>:</td>
                    <td><input type="text" name="lastNameReg"></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.age"/>:</td>
                    <td><input type="number" name="ageReg"></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="form.sex"/>:</td>
                    <td>
                        <select name="sexReg">
                            <option value="MALE"><fmt:message bundle="${i18n}" key="form.enum.sex.male"/></option>
                            <option value="FEMALE"><fmt:message bundle="${i18n}" key="form.enum.sex.female"/></option>
                            <option selected value="UNDEFINED"><fmt:message bundle="${i18n}" key="form.enum.sex.undefined"/></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="admin.form.education"/>:</td>
                    <td>
                        <select name="educationReg">
                            <option value="HIGH"><fmt:message bundle="${i18n}" key="admin.form.enum.education.high"/></option>
                            <option value="MIDDLE"><fmt:message bundle="${i18n}" key="admin.form.enum.education.middle"/></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="admin.exp"/>:</td>
                    <td><input type="number" name="experienceReg"></td>
                </tr>

                <tr>
                    <td><fmt:message bundle="${i18n}" key="login.login"/>:</td>
                    <td><input type="text" name="loginReg"></td>
                </tr>
                <tr>
                    <td><fmt:message bundle="${i18n}" key="login.password"/>:</td>
                    <td><input type="text" name="passwordReg"></td>
                </tr>
                <tr>
                    <td align="right" colspan="2"><input type="submit" value="<fmt:message bundle="${i18n}" key="login.submit"/>"></td>
                </tr>
            </table>
            <c:if test="${not empty requestScope.repReg}">
                <h3>Exists!</h3>
            </c:if>
        </form>
    </div>

    <div class="col-md-4">
        <form method="POST" action="frontController?command=admin">
            <div class="form-group">
                <h4><fmt:message bundle="${i18n}" key="admin.delete.doc"/></h4>
                <label for="delDoc"><fmt:message bundle="${i18n}" key="form.choosedoc"/></label>
                <select class="form-control" name="delDocId" id="delDoc">
                    <c:forEach var="doctor" items="${requestScope.doctors}" varStatus="status">
                        <option value="${doctor.id}">${status.index + 1} ${doctor.firstName} ${doctor.lastName}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
        <c:if test="${not empty isDocDeleted}">
            <h3>Доктор удален</h3>
        </c:if>

        <form method="POST" action="frontController?command=admin">
            <div class="form-group">
                <h4><fmt:message bundle="${i18n}" key="admin.delete.reg"/></h4>
                <label for="delReg"><fmt:message bundle="${i18n}" key="form.choosereg"/></label>
                <select class="form-control" name="delRegId" id="delReg">
                    <c:forEach var="reg" items="${requestScope.registryWorkers}" varStatus="status">
                        <option value="${reg.id}">${status.index + 1} ${reg.firstName} ${reg.lastName}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
        <c:if test="${not empty isRegDeleted}">
            <h3>Работник регистратуры удален</h3>
        </c:if>
    </div>
</div>

