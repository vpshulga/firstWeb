<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container text-center">
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="messages" var="i18n"/>
    <div class="error">
        <c:if test="${not empty requestScope.errorMsg}">
            <fmt:message bundle="${i18n}" key="login.error.msg"/>
        </c:if>
    </div>

    <form action="frontController?command=login" method="post">
        <b><fmt:message bundle="${i18n}" key="login.login"/></b><input type="text" name="login" maxlength="30"/>
        <b><fmt:message bundle="${i18n}" key="login.password"/></b><input type="password" name="password"
                                                                          maxlength="20"/><br/>
        <input type="submit" value="<fmt:message bundle="${i18n}" key="login.submit"/>">
    </form>
</div>
