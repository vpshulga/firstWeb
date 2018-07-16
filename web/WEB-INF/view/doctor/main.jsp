<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="POST" action="frontController?command=doctor">
    <table>
        <tr>
            <td>Имя:</td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td>Фамилия:</td>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td>Возраст:</td>
            <td><input type="number" name="age"></td>
        </tr>
        <tr>
            <td>Пол</td>
            <td>
                <select name="sex">
                    <option value="MALE">Муж.</option>
                    <option value="FEMALE">Жен.</option>
                    <option selected value="UNDEFINED">Неопр.</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Город:</td>
            <td><input type="text" name="city"></td>
        </tr>
        <tr>
            <td>Улица:</td>
            <td><input type="text" name="street"></td>
        </tr>
        <tr>
            <td>Дом:</td>
            <td><input type="number" name="house"></td>
        </tr>
        <tr>
            <td>Кваритра:</td>
            <td><input type="number" name="apartament"></td>
        </tr>
        <tr>
            <td>Жалоба:</td>
            <td><input type="text" name="complaint"></td>
        </tr>
        <tr>
            <td>Доктор:</td>
            <td>
                <select name="doctorId">
                    <c:forEach var="doctor" items="${doctors}" varStatus="status">
                        <option value="${doctor.id}">${doctor.firstName} ${doctor.lastName} ${doctor.spetialty}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" colspan="2"><input type="submit" value="Отправить"></td>
        </tr>
    </table>
</form>

