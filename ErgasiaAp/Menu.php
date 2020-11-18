<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/17/2019
 * Time: 2:40 AM
 */
echo "<!DOCTYPE html>
<html lang=\"en\">
<head>
    <meta charset=\"UTF-8\">
    <title>Title</title>
    <link REL=STYLESHEET  HREF=\"theme.css\"
          TYPE=\"text/css\">
</head>
<body>
<img src=\"back.png\"style=\"width:500px;float:left;background-size:cover;\">

<div class=\"navbar\">
    <a href=\"Menu.php\">Αρχική</a>

    
     <a href=\"BuyOrderStatus.php\">Παραγγελίες</a>
     <a href=\"Logout.php\">Αποσύνδεση</a>


</div>
<br>
<br>
<br>
<br>

<div class=\"dropdown\">
    <button class=\"dropbtn\">SmartPhones</button>
    <div class=\"dropdown-content\">
        <a href=\"Samsung.html\">Samsung</a>
        <a href=\"Huawei.html\">Huawei</a>
    </div>
</div>
<br>
<br>
<br>
<br>

<h1>Welcome";
session_start();

print_r($_SESSION['login_user']) ;
echo"
</h1>

</body>
</html>";