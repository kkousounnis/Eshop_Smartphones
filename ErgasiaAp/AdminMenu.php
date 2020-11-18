<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/22/2019
 * Time: 2:06 AM
 */
$host        = "host = localhost";
$port        = "port = 5432";
$dbname      = "dbname = dbphonestore";
$credentials = "user = postgres password=pappoulis13";

$dbconn = pg_connect( "$host $port $dbname $credentials"  );



if(!$dbconn) {
    echo "Error : Unable to open database\n";
} else {
    echo "Opened database successfully\n <br> </br>";
    // Prepare a query for execution

    $query = "select * from statusbuy natural join users ";

    pg_prepare($dbconn, "my_query", $query);

// Execute the prepared query.  Note that it is not necessary to escape
// the string "Joe's Widgets" in any way
    $result = pg_execute($dbconn, "my_query", array());
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
    <a href=\"AdminMenu.php\">Αρχική</a>

    
      
     <a href=\"Logout.php\">Αποσύνδεση</a>


</div>
<br>
<br>
<br>
<br>";

    echo ( " 

 <table style='position: absolute'>
  <tr>
    <th>Idnumber</th>
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Phonenumber</th>
    <th>Address</th>
    <th>Status</th> 
    <th colspan=\"1\">Model</th>
    <th colspan=\"1\">Price</th>
    <th>Date-Time</th>
  </tr>
  <tr>
  ");

    while ($row = pg_fetch_row($result)) {
        if(strcmp("Pending",$row[2])==0) {
            echo("
    <form method=\"post\" action=\"AdminAcceptBuy.php\"> 
    <td >" . $row[6] . " </td>
    <td> <input type=\"hidden\" name=\"Firstname\" value=\"" . $row[7] . "\">" . $row[7] . " </td>
    <td> <input type=\"hidden\" name=\"Lastname\" value=\"" . $row[8] . "\">" . $row[8] . " </td>
    <td> <input type=\"hidden\" name=\"Phonenumber\" value=\"" . $row[9] . "\">" . $row[9] . " </td>
    <td> <input type=\"hidden\" name=\"Address\" value=\"" . $row[10] . "\">" . $row[10] . " </td>
    <td> <input type=\"hidden\" name=\"Status\" value=\"" . $row[2] . "\">" . $row[2] . " </td>
    <td> <input type=\"hidden\" name=\"Model\" value=\"" . $row[3] . "\">" . $row[3] . " </td>
    <td> <input type=\"hidden\" name=\"Price\" value=\"" . $row[4] . "\">" . $row[4] . " </td>
    <td> <input type=\"hidden\" name=\"DateTime\" value=\"" . $row[5] . "\">" . $row[5] . " </td>
    <td><input type=\"submit\" value=\"Accept\" ></td> 
  </tr>
  

    </form>");

        }


    }
    echo(" 
     
   
</table>

 

</body>
</html>");

}