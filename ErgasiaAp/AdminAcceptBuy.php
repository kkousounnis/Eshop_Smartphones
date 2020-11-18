<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/22/2019
 * Time: 10:44 PM
 */
$Firstname=($_POST['Firstname']);
$Lastname=($_POST['Lastname']);
$Phonenumber=($_POST['Phonenumber']);
$Address=($_POST['Address']);
$Status=($_POST['Status']);
$Model=($_POST['Model']);
$Price=($_POST['Price']);
$DateTime=($_POST['DateTime']);



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

    $query="select * from statusbuy 
            natural join users 
            where name = $1 and surname = $2 and phonenumber=$3 and address=$4 and model=$5 and price=$6 and date=$7";

    pg_prepare($dbconn, "my_query", $query);

// Execute the prepared query.  Note that it is not necessary to escape

    $result=pg_execute($dbconn, "my_query", array($Firstname, $Lastname , $Phonenumber , $Address , $Model ,$Price ,$DateTime));
    if(!$result) {
        echo pg_last_error($db);
        exit;
    }
    while($row = pg_fetch_row($result)) {
        //echo "Username = ". $row[0] . "\n";
        $username=$row[0];
        //echo "Password = ". $row[1] . "\n";
        $password=$row[1];
    }
    echo ("succesful");

}

if(!$dbconn) {
    echo "Error : Unable to open database\n";
} else {
    echo "Opened database successfully\n";
    // Prepare a query for execution

    $query="update statusbuy 
            set status = 'accepted'
            where username = $1 and password = $2 and model=$3 and price=$4 and date=$5";

    pg_prepare($dbconn, "my_query1", $query);

// Execute the prepared query.  Note that it is not necessary to escape

    $result=pg_execute($dbconn, "my_query1", array($username, $password , $Model , $Price , $DateTime));

    echo("<meta http-equiv=\"refresh\" content=\"0; URL='AdminMenu.php'\" />");

}