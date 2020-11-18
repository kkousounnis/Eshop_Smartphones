<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/20/2019
 * Time: 12:00 AM
 */
$host        = "host = localhost";
$port        = "port = 5432";
$dbname      = "dbname = dbphonestore";
$credentials = "user = postgres password=pappoulis13";

$dbconn = pg_connect( "$host $port $dbname $credentials"  );

session_start();
$username=$_SESSION['login_user'];
$password=$_SESSION['login_password'];

if(!$dbconn) {
    echo "Error : Unable to open database\n";
} else {
    echo "Opened database successfully\n <br> </br>";
    // Prepare a query for execution

    $query = "select * from statusbuy where username = $1 and password = $2";

    pg_prepare($dbconn, "my_query", $query);

// Execute the prepared query.  Note that it is not necessary to escape
// the string "Joe's Widgets" in any way
    $result = pg_execute($dbconn, "my_query", array($username, $password));
    if (!$result) {
        echo pg_last_error($db);
        exit;
    }
    echo "<!DOCTYPE html>
<html lang=\"en\">
<head>
    <meta charset=\"UTF-8\">
    <title>Title</title>
    <link REL=STYLESHEET  HREF=\"theme.css\"
          TYPE=\"text/css\">
   <style>
table, th, td {
  border: 1px solid black;
}
</style>  
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
<br>";

    echo ( " 

 <table style='position: absolute'>
  <tr>
    <th>Status</th>
    <th colspan=\"1\">Model</th>
    <th colspan=\"1\">Price</th>
    <th colspan=\"1\">Date-time</th>
  </tr>
  <tr>
  ");

    while ($row = pg_fetch_row($result)) {
        echo(" 
    <td>". $row[0]." </td>
    <td>".$row[3]." </td>
    <td>".$row[4]." </td>
    <td>".$row[5]." </td>
  </tr>");




    }
   echo(" 
     
   
</table>

 

</body>
</html>");

}


