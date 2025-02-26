<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL URI -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User Address</title>
</head>
<body>
	<h2>New User Address</h2>
	<form action="saveuseraddress" method="post">
		
		<label for="title">Title</label>
        <select id="title" name="title" required>
            <option value="">Select</option>
            <option value="home">Home</option>
            <option value="office">Office</option>
            <option value="store">Store</option>
        </select>
        <br><br>
        
        <label for="unitName">Unit Name: </label>
        <input type="text" id="unitName" name="unitName">
        <br><br>
        
        <label for="street">Street: </label>
        <input type="text" id="street" name="street">
        <br><br>
        
        <label for="landMark">Land Mark: </label>
        <input type="text" id="landMark" name="landMark">
        <br><br>
        
        <label for="stateName">State: </label>
        <select name="stateId">
			<option>Select State</option>
			<c:forEach items="${allState }" var="s">
				<option value="${s.stateId }">${s.stateName }</option>
			</c:forEach>
		</select>
		<br><br>
		
		<label for="cityName">City: </label>
        <select name="cityId">
			<option>Select City</option>
			<c:forEach items="${allCity }" var="c">
				<option value="${c.cityId }">${c.cityName }</option>
			</c:forEach>
		</select>
		<br><br>
        
        <label for="zipCode">Zip Code: </label>
        <input type="text" id="zipCode" name="zipCode">
        <br><br>
        
        <label for="addressDetail">Address Detail: </label>
        <textarea rows="5" cols="5" id="addressDetail" name="addressDetail"></textarea>
        <br><br>
        
        <input type="submit" value="Save Address">
	</form>
</body>
</html>