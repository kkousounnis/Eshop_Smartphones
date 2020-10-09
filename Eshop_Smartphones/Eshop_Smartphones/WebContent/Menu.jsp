<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link REL=STYLESHEET  HREF="theme.css"
      TYPE="text/css">
<title>Insert title here</title>


</head>
<body>
<img src="back.png"style="width:500px;float:left;background-size:cover;">    
   
<div class="navbar"> 
  <a href="#index.jsp">Αρχική</a>
  
   <form style="display:inline-block;" method="post" action="UserController">
  <input type="hidden" name="action" value="Status" /> 
  <input class="but button1"  type="submit" value="Παραγγελίες" >
  </form>
  <form style="display:inline-block;" method="post" action="UserController"> 
 <input type="hidden" name="action" value="logout" /> 
  <input class="but button1"  type="submit" value="Αποσύνδεση" >
  </form> 
     
 
 
</div>
<br>
<br>
<br>
<br>

<div class="dropdown">
  <button class="dropbtn">SmartPhones</button>
  <div class="dropdown-content">
    <a href="Samsung.jsp">Samsung</a>
    <a href="Huawei.jsp">Huawei</a>
  </div>
</div>
</body>
</html>