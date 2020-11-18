<?php
/**
 * Created by PhpStorm.
 * User: kwnstantinos
 * Date: 1/17/2019
 * Time: 8:03 PM
 */
session_start();
session_unset();

// destroy the session
session_destroy();
echo("<meta http-equiv=\"refresh\" content=\"0; URL='Index.html'\" />");