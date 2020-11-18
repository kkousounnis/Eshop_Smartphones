<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/4/2019
 * Time: 5:25 PM
 */
$host        = "host = localhost";
$port        = "port = 5432";
$dbname      = "dbname = dbphonestore";
$credentials = "user = postgres password=pappoulis13";

$username=($_POST['username']);
$username=ldapspecialchars($username);
$password=($_POST['password']);
$password=ldapspecialchars($password);
$password=md5($password."melenkwsta");
$idnumber=($_POST['idnumber']);
$idnumber=ldapspecialchars($idnumber);
$name=($_POST['name']);
$name=ldapspecialchars($name);
$SurName=($_POST['SurName']);
$SurName=ldapspecialchars($SurName);
$PhoneNumber=($_POST['PhoneNumber']);
$PhoneNumber=ldapspecialchars($PhoneNumber);
$Address=($_POST['Address']);
$Address=ldapspecialchars($Address);

function ldapspecialchars($string) {
    $sanitized=array('\\' => '\5c',
        '*' => '\2a',
        '(' => '\28',
        ')' => '\29',
        "\x00" => '\00');

    return str_replace(array_keys($sanitized),array_values($sanitized),$string);
}


//echo($username.$password."kwstasmakis");

$dbconn = pg_connect( "$host $port $dbname $credentials"  );
if(!$dbconn) {
    echo "Error : Unable to open database\n";
} else {
    echo "Opened database successfully\n";
    // Prepare a query for execution

    $query="insert into users VALUES ($1,$2,$3,$4,$5,$6,$7)";

    pg_prepare($dbconn, "my_query", $query);

// Execute the prepared query.  Note that it is not necessary to escape
// the string "Joe's Widgets" in any way
    $check=pg_execute($dbconn, "my_query", array($username,$password,$idnumber,$name,$SurName,$PhoneNumber,$Address));

    if($check)
    echo ("succesfull pass in database");
    else{
        echo ("<meta http-equiv=\"refresh\" content=\"0; URL='InvalidMessage.html'\" />");
    }

}



include ("LdapConnection.php");
$ldaptree = "cn=$username,ou=Members,ou=DepartmentPhoneSales,dc=unipi,dc=gr";

ldap_set_option($ldapconn, LDAP_OPT_PROTOCOL_VERSION, 3);
$result=ldap_bind($ldapconn, $ldap_dn, $ldap_password);
if($result) {

    // prepare data
    $info["cn"] = "$username";
    $info["sn"] = "$SurName";
    $info["Userpassword"] = "$password";
    $info["objectclass"] = "inetOrgPerson";

    $r = ldap_add($ldapconn, $ldaptree, $info);

   if($r) {
       echo("<meta http-equiv=\"refresh\" content=\"0; URL='ValidateMessage.html'\" />");
   }else{
       echo ("<meta http-equiv=\"refresh\" content=\"0; URL='InvalidMessage.html'\" />");
   }
}
else {
    echo "Invalid user/pass or other errors!";

}
