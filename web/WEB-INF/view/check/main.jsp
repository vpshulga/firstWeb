<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <c:if test="${not empty user and user.role eq 'DOCTOR'}">
        <h1>Нет доступа, вы волши как DOCTOR</h1>
    </c:if>
</div>