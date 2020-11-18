<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/25/2019
 * Time: 5:43 AM
 */

$username=($_POST['username']);
$password=($_POST['password']);
$password=md5($password."hashadmin");
$SurName=($_POST['surname']);

// my first admin password=md5("admin2019"."hashadmin");

include ("LdapConnection.php");
$ldaptree = "cn=$username,ou=Admins,ou=DepartmentPhoneSales,dc=unipi,dc=gr";

ldap_set_option($ldapconn, LDAP_OPT_PROTOCOL_VERSION, 3);
$result=ldap_bind($ldapconn, $ldap_dn, $ldap_password);
if($result) {

    // prepare data
    $info["cn"] = "$username";
   // $info["sn"] = "$SurName";
   // $info["Userpassword"] = "$password";
   // $info["objectclass"] = "inetOrgPerson";

    $r = ldap_delete($ldapconn, $ldaptree);

    if($r) {
        echo("<h2 style=\"color:green\">Επιτυχία</h2>
        <meta http-equiv=\"refresh\" content=\"3; URL='PrivilegeAdminMenu.php'\" />");
    }else{
        echo ("<h2 style=\"color:red\">Aπoτυχία</h2>
         <meta http-equiv=\"refresh\" content=\"3; URL='PrivilegeAdminMenu.php'\" />");
    }
}
else {
    echo "Invalid user/pass or other errors!";

}