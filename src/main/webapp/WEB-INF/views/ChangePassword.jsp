<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>
	<h2>Change Password</h2>
	
	<form action="updatepassword" method="post">
		
		<label for="email">Email</label>
        <input type="email" id="email" name="email" required>
        
        <br><br>
        
        <label for="otp">OTP:</label>
        <input type="text" name="otp"/>
        
        <br><br>
        
        <label for="password">New Password</label>
        <input type="password" name="password">
        
        <br><br>
        
        <label for="confirmpassword">Confirm Password</label>
        <input type="password" name="confirmpassword">
        
        <br><br>
        
        <input type="submit" value="Update Password">
	</form>
</body>
</html>