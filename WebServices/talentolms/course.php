<?php 

	include_once("TalentLMS.php");


TalentLMS::setApiKey('w6UzjEh4Jk6hRzABKU34aJD5K2BkFU');
TalentLMS::setDomain('https://ubycall-dynamicall.talentlms.com/');

if ($_SERVER['REQUEST_METHOD'] == 'GET')
{
	if(isset($_GET['id']))
	{
		$id=$_GET['id'];

		echo json_encode(TalentLMS_Course::retrieve($id));


	}
	else
	{
		echo json_encode(TalentLMS_Course::all());
        exit();
	}
	
      
	
}



	






 ?>