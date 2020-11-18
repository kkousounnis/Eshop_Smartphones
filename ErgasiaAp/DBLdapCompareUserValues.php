<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/8/2019
 * Time: 9:20 PM
 */



$username=($_POST['username']);
$username=ldapspecialchars($username);
$password=($_POST['password']);
$password=ldapspecialchars($password);

function ldapspecialchars($string) {
    $sanitized=array('\\' => '\5c',
        '*' => '\2a',
        '(' => '\28',
        ')' => '\29',
        "\x00" => '\00');

    return str_replace(array_keys($sanitized),array_values($sanitized),$string);
}




$password=md5($password."melenkwsta");

/*
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

    $query = "select username,password from users where username = $1 and Password= $2 ";

    pg_prepare($dbconn, "my_query", $query);

// Execute the prepared query.  Note that it is not necessary to escape
// the string "Joe's Widgets" in any way
    $result = pg_execute($dbconn, "my_query", array($username,$password ));
    if (!$result) {
        echo pg_last_error($db);
        exit;
    }

    if(pg_fetch_row($result)==null){
        echo ("<meta http-equiv=\"refresh\" content=\"0; URL='InvalidMessage.html'\" />");
    }else{
        while ($row = pg_fetch_row($result)) {
            echo "Username = " . $row[0] . "\n";
            echo "Password = " . $row[1] . "\n";




        }
        // echo("<meta http-equiv=\"refresh\" content=\"0; URL='Index.html'\" />");
    }
}
*/

include ("LdapConnection.php");
ldap_set_option($ldapconn, LDAP_OPT_PROTOCOL_VERSION, 3);
$result=ldap_bind($ldapconn, $ldap_dn, $ldap_password);
if($result) {

    $search = ldap_search($ldapconn,$ldaptree, "(cn=$username)") or die ("Error") ;

    $data = ldap_get_entries($ldapconn, $search);
    //print_r($data);

    for ($i=0; $i<$data["count"]; $i++) {
        //echo "dn is: ". $data[$i]["dn"] ."<br />";
        echo "User: ". $data[$i]["cn"][0] ."<br />";
        if(isset($data[$i]["userpassword"][0])) {

            if($data[$i]["userpassword"][0]==$password){

                session_start();

                $_SESSION['login_user'] = $username;
                $_SESSION['login_password']=$password;

                echo("<meta http-equiv=\"refresh\" content=\"0; URL='Menu.php'\" />");
            }else {
                echo("<meta http-equiv=\"refresh\" content=\"0; URL='InvalidMessage.html'\" />");
            }

        }
    }
    echo("<meta http-equiv=\"refresh\" content=\"2; URL='InvalidMessage.html'\" />");
} else
{
    echo "Invalid user/pass or other errors!";
}

