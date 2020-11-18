<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/22/2019
 * Time: 2:08 AM
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




//$username="Admin1";
//$password="admin2019"."hashadmin";
$password=md5($password."hashadmin");

include ("LdapConnection.php");
$ldaptree = "ou=Admins,ou=DepartmentPhoneSales,dc=unipi,dc=gr";
ldap_set_option($ldapconn, LDAP_OPT_PROTOCOL_VERSION, 3);
$result=ldap_bind($ldapconn, $ldap_dn, $ldap_password);
if($result) {
$x=0;
    $search = ldap_search($ldapconn,$ldaptree, "(cn=$username)") or die ("Error") ;

    $data = ldap_get_entries($ldapconn, $search);
    //print_r($data);

    for ($i=0; $i<$data["count"]; $i++) {
        //echo "dn is: ". $data[$i]["dn"] ."<br />";
        //echo "User: ". $data[$i]["cn"][0] ."<br />";
        if(isset($data[$i]["userpassword"][0])) {

            if($data[$i]["userpassword"][0]==$password){

                session_start();

                $_SESSION['login_user'] = $username;
                $_SESSION['login_password']=$password;
                $x=1;
                echo("<meta http-equiv=\"refresh\" content=\"0; URL='AdminMenu.php'\" />");
            }else {
                echo("<meta http-equiv=\"refresh\" content=\"0; URL='Login_Admin.html'\" />");
            }
        }
    }
    if($x==0){
        echo("<meta http-equiv=\"refresh\" content=\"0; URL='Login_Admin.html'\" />");
    }
} else
{
    echo "Invalid user/pass or other errors!";
}