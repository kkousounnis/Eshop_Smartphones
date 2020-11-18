<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/25/2019
 * Time: 3:51 AM
 */
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
<img src=\"back.png\"style=\"width:500px;float:left;background-size:cover;\">

<div class=\"navbar\">
    <a href=\"PrivilegeAdminMenu.php\">Αρχική</a>
    <a href=\"login.html\">Αποσύνδεση</a> 

</div>
<br>
<br>
<br>
<br>
<fieldset style=\"position:absolute\">
    <form autocomplete=\"off\" method=\"post\" action=\"PrivilegeAdminInsertUsers.php\">

        Ονομα Χρήστη:<input type=\"text\" name=\"username\"required><br></br>
        Κωδικός:<input type=\"password\" name=\"password\"required><br></br>         
        Επιθετο:<input type=\"text\" name=\"SurName\"required><br></br>         
        <input type=\"submit\" value=\"Εγγραφή\" >

    </form>
</fieldset>";

echo ( " <br><br><br><br><br><br><br><br><br><br>

 <table style='...'>
  <tr>
    <th>Username</th>
    <th>Surname</th>
    <th>AdminPassword</th>
  </tr>
  <tr>
  ");
include ("LdapConnection.php");
$ldaptree = "ou=Admins,ou=DepartmentPhoneSales,dc=unipi,dc=gr";
ldap_set_option($ldapconn, LDAP_OPT_PROTOCOL_VERSION, 3);
$result=ldap_bind($ldapconn, $ldap_dn, $ldap_password);

if($result) {

    $search = ldap_search($ldapconn,$ldaptree, "(cn=*)") or die ("Error");
    $data = ldap_get_entries($ldapconn, $search);
    //print_r($data);

    for ($i=0; $i<$data["count"]; $i++) {
        //echo "dn is: ". $data[$i]["dn"] ."<br />";
        //echo "User: ". $data[$i]["cn"][0] ."<br />";
        //echo $data[$i]["userpassword"][0];
        //echo $password;
        //echo strcmp($data[$i]["userpassword"][0],$password);

        echo("
    <form  method=\"post\" action=\"DeleteAdminUsers.php\"> 
     
    <td> <input type=\"hidden\" name=\"username\" value=\"" . $data[$i]["cn"][0] . "\">" . $data[$i]["cn"][0] . " </td>
    <td> <input type=\"hidden\" name=\"surname\" value=\"" . $data[$i]["sn"][0] . "\">" . $data[$i]["sn"][0] . " </td>
    <td> <input type=\"hidden\" name=\"password\" value=\"" . $data[$i]["userpassword"][0] . "\">" . $data[$i]["userpassword"][0] . " </td>
    <td><input type=\"submit\" value=\"Delete\" ></td> 
  </tr>
  

    </form>");

    }
} else
{
    echo "Invalid user/pass or other errors!";
}


echo "  
</body>
</html>";
