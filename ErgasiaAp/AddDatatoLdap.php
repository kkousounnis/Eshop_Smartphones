<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/4/2019
 * Time: 3:41 PM
 */
$ldap_dn = "cn=admin,dc=unipi,dc=gr";
$ldap_password ="123456";


$ldaptree = "cn=John Jones,dc=unipi,dc=gr";
$ldapconn = ldap_connect("192.168.94.3");
ldap_set_option($ldapconn, LDAP_OPT_PROTOCOL_VERSION, 3);
$result=ldap_bind($ldapconn, $ldap_dn, $ldap_password);
if($result) {

    // prepare data
    $info["cn"] = "John Jones";
    $info["sn"] = "Jones";
    $info["objectclass"] = "inetOrgPerson";

    $r = ldap_add($ldapconn, $ldaptree, $info);



} else {echo "Invalid user/pass or other errors!";}



