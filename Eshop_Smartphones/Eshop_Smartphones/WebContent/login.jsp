<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link REL=STYLESHEET  HREF="theme.css"
      TYPE="text/css">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
 <img src="back.png"style="width:500px;float:left;background-size:cover;">     
   
<div class="navbar"> 
  <a href="index.jsp">Αρχική</a>
  <a href="login.jsp">Είσοδος χρήστη</a>
  <a href="Signup.jsp">Εγγραφή</a>
</div>
<br>
<br>
<br>
<br>
<fieldset style="position:absolute"> 
 <form method="post" action="UserController">
 <input type="hidden" name="action" value="login" />
 	Όνομα Χρήστη:<input type="text" name="username"><br></br>
 	Κωδικός:<input type="password" name="password"><br></br>
 	<input type="submit" value="Login" >
 	
 </form>
 </fieldset>
  <h8 style="position:absolute;left:0;bottom:0;" >Είσοδος ως Διαχειριστής:<a style="overflow:hidden" href="Login_Admin.jsp"><b>Admin_Login</b></a></h8>
</body>
</html>