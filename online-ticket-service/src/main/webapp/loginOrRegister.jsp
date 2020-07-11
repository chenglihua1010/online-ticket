<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
</head>
<body>
<h3>用户注册</h3>
<form method="post" action="/userInfor/addUser">
    <table>
        <tr>
            <td><label>账号(手机号)：</label></td>
            <td><input type="text" name="user_phone_num"></td>
        </tr>
        <tr>
            <td><label>密码：</label></td>
            <td><input type="password" name="user_password"></td>
        </tr>
        <tr>
            <td><label>真实姓名：</label></td>
            <td><input type="text" name="user_real_name"></td>
        </tr>
        <tr>
            <td><label>身份证号：</label></td>
            <td><input type="text" name="userIdNumber"></td>
        </tr>

        <tr>
            <td><input type="submit" value="注册"/>

        </tr>
    </table>
</form>
</body>
</html>