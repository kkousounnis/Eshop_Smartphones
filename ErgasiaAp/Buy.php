<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/18/2019
 * Time: 1:06 AM
 */


$model=($_POST['model']);
$price=($_POST['price']);
echo "<!DOCTYPE html>
<html lang=\"en\">
<head>
    <meta charset=\"UTF-8\">
    <title>Title</title>
    <link REL=STYLESHEET  HREF=\"theme.css\"
          TYPE=\"text/css\">
</head>
<body>
<img src=\"back.png\"style=\"width:500px;float:left;background-size:cover;\">

<div class=\"navbar\">
    <a href=\"Menu.php\">Αρχική</a>

    
     <a href=\"BuyOrderStatus.php\">Παραγγελίες</a>
     <a href=\"Logout.php\">Αποσύνδεση</a>


</div>
<br>
<br>
<br>
<br>
<fieldset style=\"position:absolute\">  				
<form method=\"post\" action=\"TakeCredentials.php\"> 	
To μοντέλο που θέλετε να αγοράσετε είναι : <input type=\"hidden\" style=\"border:white;font-size:20px;\" type=\"text\" name=\"model\" value=\"".$model."\"required> ".$model."  <br></br>  
Τα χρήματα που θα δώσετε είναι τα εξής:<input type=\"hidden\" style=\"border:white;font-size:20px\" type=\"text\" name=\"price\" value=\"".$price."\"required> ".$price."  <br></br>  
Για να προχωρήσετε στην συναλλαγή θα πρέπει να πατήσετε συνέχεια:
<br></br>
<input type=\"submit\" value=\"Συνέχεια\" >  
				    		 						 	 
</form> 
</fieldset>

";