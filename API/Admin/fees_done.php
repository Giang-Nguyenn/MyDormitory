<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");
$Status=$_POST['Status'];
$Id=$_POST['Id'];
if(substr($Status, 0, 5) === 'Admin'){
	$Id=substr($Status,5);
	$query ="SELECT Describe_fee,Create_time,Add_Infor,Status,List FROM `frees` WHERE Id_receive='All'";
}
else if(substr($Status, 0, 4) === 'Room'){
	//echo $Id;
	$query ="UPDATE `frees` SET `Status` = '1' WHERE `frees`.`Id` = $Id";
}
else{
	$UserId=substr($Status,4);
	//echo $Id;
	$query ="UPDATE frees SET List=REPLACE(List,',$UserId,',',') WHERE Id='$Id'";
}
$data=mysqli_query($connect,$query);
 ?>