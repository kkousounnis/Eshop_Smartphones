<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/19/2019
 * Time: 3:30 AM
 */
$host        = "host = localhost";
$port        = "port = 5432";
$dbname      = "dbname = dbphonestore";
$credentials = "user = postgres password=pappoulis13";
$dbconn = pg_connect( "$host $port $dbname $credentials"  );