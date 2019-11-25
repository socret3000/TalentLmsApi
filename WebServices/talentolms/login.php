<?php


	include_once("TalentLMS.php");


TalentLMS::setApiKey('w6UzjEh4Jk6hRzABKU34aJD5K2BkFU');
TalentLMS::setDomain('https://ubycall-dynamicall.talentlms.com/');

if ($_SERVER['REQUEST_METHOD'] == 'POST')
{

	$user=$_POST['userName'];
	$password=$_POST['password'];

	if(isset($user) && isset($password))
	{


		echo json_encode(TalentLMS_User::login(array('login' => $user, 'password' => $password)));
	    
		
	}




}







?>