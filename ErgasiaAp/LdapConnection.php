<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/16/2019
 * Time: 11:19 PM
 */
$ldap_dn = "cn=admin,dc=unipi,dc=gr";
$ldap_password ="123456";
$ldaptree = "ou=Members,ou=DepartmentPhoneSales,dc=unipi,dc=gr";
$ldapconn = ldap_connect("192.168.94.3");