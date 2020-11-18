<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/19/2019
 * Time: 8:48 PM
 */
$host        = "host = localhost";
$port        = "port = 5432";
$dbname      = "dbname = dbphonestore";
$credentials = "user = postgres password=pappoulis13";


$model=($_POST['model']);
$price=($_POST['price']);
$status=("Pending");
$date=date("Y/m/d h:i:sa");


session_start();

$username=$_SESSION['login_user'];
$password=$_SESSION['login_password'];

$dbconn = pg_connect( "$host $port $dbname $credentials"  );

if(!$dbconn) {
    echo "Error : Unable to open database\n";
} else {
    echo "Opened database successfully\n";
    // Prepare a query for execution

    $query = "insert into statusbuy VALUES ($1,$2,$3,$4,$5,$6)";

    pg_prepare($dbconn, "my_query", $query);

// Execute the prepared query.  Note that it is not necessary to escape
// the string "Joe's Widgets" in any way
    $check = pg_execute($dbconn, "my_query", array($status, $username, $password, $model, $price,$date));
    if ($check) {
        echo("<html> 
		    					<head>
		    					<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">
		    					<link REL=STYLESHEET  HREF=\"theme.css\" 
		    					      TYPE=\"text/css\">
		    					<title>Insert title here</title> 
		    					</head>
		    					<body>
		    					<img src=\"pictures\back.png\"style=\"width:500px;float:left;background-size:cover;\">     
		    					   
		    					<div class=\"navbar\">
                                    <a href=\"Menu.php\">Αρχική</a>

    
                                    <a href=\"BuyOrderStatus.php\">Παραγγελίες</a>
                                    <a href=\"Logout.php\">Αποσύνδεση</a>


                                </div>
		    					<br> 
		    					<br> 
		    					<br>
		    					<br>
		    				
		    					<h2 style=\"color:green\">Η παραγγελία έχει πραγματοποιηθεί  μπορείτε να πάτε στις παραγγελίες σας για να δείτε την αγορά σας</h2>
		    					<meta http-equiv=\"refresh\" content=\"2; URL='Menu.php'\" />
		    					</body> 
		    					</html>");


    }else{
        echo"<head>
		    					<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">
		    					<link REL=STYLESHEET  HREF=\"theme.css\" 
		    					      TYPE=\"text/css\">
		    					<title>Insert title here</title> 
		    					</head>
		    					<body>
		    					<img src=\"pictures\back.png\"style=\"width:500px;float:left;background-size:cover;\">     
		    					   
		    					<div class=\"navbar\">
                                    <a href=\"#index.html\">Αρχική</a>

    
                                     <a href=\"Logout.php\">Παραγγελίες</a>
                                     <a href=\"Logout.php\">Αποσύνδεση</a>


                                </div>
		    					<br> 
		    					<br> 
		    					<br>
		    					<br>
		    				
		    					<h2 style=\"color:red\">Δεν μπορείτε να αγορασετε το ίδιο προιόν δύο φορές</h2>
		    					<meta http-equiv=\"refresh\" content=\"2; URL='Menu.php'\" />
		    					</body> 
		    					</html>";
    }
}