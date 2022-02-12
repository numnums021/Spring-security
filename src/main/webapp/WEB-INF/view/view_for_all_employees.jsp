<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang = "en">
<head>
    <title>Information about all employees</title>
    <meta content="text/html; charset=utf-8" />
</head>

<body>

    <h3></h3>

    <br>Information about all employees<br>

    <security:authorize access = "hasRole('HR')">
        <input type="button" value="Salary" onclick="window.location.href = 'hr_info'">
        Only for HR workers
    </security:authorize>


    <br><br>
    <security:authorize access = "hasRole('MANAGER')">
        <input type="button" value="Performance" onclick="window.location.href = 'manager_info'">
        Only for MANAGER employees
    </security:authorize>

</body>

</html>