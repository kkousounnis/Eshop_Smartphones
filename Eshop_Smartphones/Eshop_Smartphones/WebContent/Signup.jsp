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
<input type="hidden" name="action" value="insert" /> 
Ονομα Χρήστη:<input type="text" name="username"required><br></br>
Κωδικός:<input type="password" name="password"required><br></br> 
Αριθμος Ταυτότητας:<input type="text" maxlength="7" placeholder="XX-XXXX" style="text-transform:uppercase" name="idnumber"required><br></br> 
Ονομα:<input type="text" name="name"required><br></br> 
Επιθετο:<input type="text" name="SurName"required><br></br>
Αριθμός Τηλεφώνου:<input type="number" name="PhoneNumber"required><br></br> 
Διεύθυνση:<input type="text" name="Address"required><br></br>
<input type="submit" value="Εγγραφή" > 
				 	
</form>
</fieldset>


</body>
</html>