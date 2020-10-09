<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link REL=STYLESHEET  HREF="theme.css"
      TYPE="text/css">
<title>Insert title here</title>
</head>
<body>
    
   
<div class="navbar"> 
   
  
    
  <form style="display:inline-block;" method="post" action="UserController"> 
 <input type="hidden" name="action" value="logout" /> 
  <input class="but button1"  type="submit" value="Αποσύνδεση" >
  </form> 
  
 </div>
 <br>
 <br>
 <br> 
  <table border=1>
        <thead>
            <tr>
                
                <th>Name</th>
                <th>SurName</th>
                <th>Phonenumber</th>
                <th>Address</th>                 
                <th>Model</th> 
                <th>Date</th>
                <th>Price</th> 
                <th>Status</th>           
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.Buyers}" var="Buyer">
                <tr>
                    <td><c:out value="${Buyer.name}" /></td>
                    <td><c:out value="${Buyer.phonenumber}" /></td>
                   	<td><c:out value="${Buyer.surname}" /></td> 
                   	<td><c:out value="${Buyer.address}" /></td>                       
                    <td><c:out value="${Buyer.model}" /></td>
                    <td><c:out value="${Buyer.date}" /></td> 
                    <td><c:out value="${Buyer.price}" /></td> 
                    <td><c:out value="${Buyer.status}" /></td>
                    <td><a href="UserController?action=Acceptupdate=<c:out value="${Buyer.status}"/>">Accept</a></td>
                     <td><a href="UserController?action=Declineupdate=<c:out value="${Buyer.status}"/>">Decline</a></td>
              
                </tr>
            </c:forEach>
        </tbody>
    </table>  
 
 


<img src="Admin_icon.jpg"style="position:absolute; right:0;">
<br>
<br>
<br>
<br>

 
</body>
</html>