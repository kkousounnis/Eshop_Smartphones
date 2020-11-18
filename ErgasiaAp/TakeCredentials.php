<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/19/2019
 * Time: 3:21 AM
 */
session_start();
$model=($_POST['model']);
$price=($_POST['price']);

$username=$_SESSION['login_user'];
$password=$_SESSION['login_password'];
echo $username.$password."sddsoi";

$host        = "host = localhost";
$port        = "port = 5432";
$dbname      = "dbname = dbphonestore";
$credentials = "user = postgres password=pappoulis13";

$dbconn = pg_connect( "$host $port $dbname $credentials"  );
if(!$dbconn) {
    echo "Error : Unable to open database\n";
} else {
    echo "Opened database successfully\n";
    // Prepare a query for execution

    $query="select username,password,idnumber,name,surname,phonenumber,address from users where username = $1 and password = $2";

    pg_prepare($dbconn, "my_query", $query);

// Execute the prepared query.  Note that it is not necessary to escape
// the string "Joe's Widgets" in any way
    $result=pg_execute($dbconn, "my_query", array($username,$password));
    if(!$result) {
        echo pg_last_error($db);
        exit;
    }




    while($row = pg_fetch_row($result)) {
        //echo "Username = ". $row[0] . "\n";

       // echo "Password = ". $row[1] . "\n";
        //echo "idnumber = ". $row[2] . "\n";
        $idnumber=$row[2];
       // echo "name = ". $row[3] . "\n";
        $Firstname=$row[3];
       // echo "surname = ". $row[4] . "\n";
        $Surname=$row[4];
       // echo "phonenumber = ". $row[5] . "\n";
        $phonenumber=$row[5];
       // echo "address = ". $row[6] . "\n";
        $Addres=$row[6];


    }


    echo("<!DOCTYPE html>
<html lang=\"en\">
<head>
    <meta charset=\"UTF-8\">
    <title>Title</title>
    <link REL=STYLESHEET  HREF=\"theme.css\"
          TYPE=\"text/css\">
</head>
<body>
<img src=\"pictures\back.png\"style=\"width:500px;float:left;background-size:cover;\">

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
<form style=\"border:white;font-size:20px;\" method=\"post\" action=\"AddPurchase.php\">  
To μοντέλο που θέλετε να αγοράσετε είναι :<input type=\"hidden\" style=\"border:white;font-size:20px;\" type=\"text\" name=\"model\" value=\"".$model."\"required> " .$model. "  <br></br>  
Τα χρήματα που θα δώσετε είναι τα εξής:<input type=\"hidden\" style=\"border:white;font-size:20px\" type=\"text\" name=\"price\" value=\"".$price."\"required>  ".$price."    <br></br>  	
				    		 		 
Αριθμος Ταυτότητας:<input type=\"hidden\" type=\"text\" maxlength=\"7\" placeholder=\"XX-XXXX\" style=\"text-transform:uppercase\" name=\"idnumber\" value=\"".$idnumber."\"required> ".$idnumber."  <br></br> 
				    		 		 
Όνομα :<input type=\"hidden\" style=\"border:white;font-size:20px;\" type=\"text\" name=\"Firstname\" value=\"".$Firstname."\"required> ".$Firstname."   <br></br>  
				    		 		 
Επίθετο :<input type=\"hidden\" style=\"border:white;font-size:20px;\" type=\"text\" name=\"SurName\" value=\"".$Surname."\"required> ".$Surname." <br> </br> 
				    		 		 
Αριθμός Τηλεφώνου :<input type=\"hidden\" style=\"border:white;font-size:20px;\" type=\"text\" name=\"PhoneNumber\" value=\"".$phonenumber."\"required> ".$phonenumber." <br> </br> 
				    		 	 
Διεύθυνση :<input type=\"hidden\" style=\"border:white;font-size:20px;\" type=\"text\" name=\"Address\" value=\"".$Addres."\"required> ".$Addres." <br> </br>  
 
<input type=\"submit\" value=\"Επιβεβαίωση Αγοράς\" >  
</form> 
</fieldset>");


}