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
       
   
<div class="navbar"> 
  <a href="Menu.jsp">Αρχική</a>
  <form action="logout">
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
<div class="card">
<form method="post" action="UserController"> 
  <input type="hidden" name="action" value="Buy" />
  <img src="S9.jpg" alt="Denim Jeans" style="width:100%"> 
  <h1 ><input style="font-size:20px;border:white;" type="text" name="model"required value="Samsung Galaxy S9"> </h1>
  <input style="color:grey;font-size:22px;border:white;text-align:center;" type="text" name="price"required value="799euro"> </h1>
  
  
  
 	<p>Έκδοση Λειτουργικού: Android 8.0 (Oreo)</p>
	<p>	Επεξεργαστής: Octa Core (4x 2.7GHx & 4x 1.7GHz)</p>
	<p>Μνήμη (Ram): 6 GB</p>
	<p>	Μέγεθος Οθόνης: 6,2"</p>
	<p>	Βασική Κάμερα: Dual 12 Mp</p>
  
   
  <p>
  <input type="submit" value="Buy" > 
   </p>
  </form>
</div> 
<div class="card">
<form method="post" action="UserController"> 
  <input type="hidden" name="action" value="Buy" />
  <img src="Note.jpeg" alt="Denim Jeans" style="width:100%"> 
  <h1 ><input style="font-size:20px;border:white;" type="text" name="model"required value="Samsung Galaxy Note9"> </h1>
  <input style="color:grey;font-size:22px;border:white;text-align:center;" type="text" name="price"required value="699euro"> </h1>
   
 
  <p>RAM: 6GB</p>
  <p>Μνήμη: 128GB</p>
  <p>	Βασική Κάμερα: Dual 12 Mp</p>	
  <p>
	<input type="submit" value="Buy" >
</p>
</div> 
 
</body>
</html>