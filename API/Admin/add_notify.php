<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");
include("../model.php");
if(isset($_POST['Describe']) and isset($_POST['Content']) and isset($_POST['Option']) and isset($_POST['ListId'])){
	$Describe=$_POST['Describe'];
	$Content=$_POST['Content'];
	$Option=$_POST['Option'];
	$ListId=$_POST['ListId'];
	if($Option=='1'){
		$query ="INSERT INTO `notification` (`Id`, `Id_receive`, `Describe_notification`, `Content`, `Create_time`, `Add_infor`, `List`) VALUES (NULL, 'All', '$Describe', '$Content', current_timestamp(), 'Không', '$ListId')";
	}
	else if($Option=='2'){
		$query ="INSERT INTO `notification` (`Id`, `Id_receive`, `Describe_notification`, `Content`, `Create_time`, `Add_infor`, `List`) VALUES (NULL, 'Room', '$Describe', '$Content', current_timestamp(), 'Không', '$ListId')";
	}
	else{
		$List=findlv("All");
		$query ="INSERT INTO `notification` (`Id`, `Id_receive`, `Describe_notification`, `Content`, `Create_time`, `Add_infor`, `List`) VALUES (NULL, 'All', '$Describe', '$Content', current_timestamp(), 'Không', '$List')";
	};
	$data=mysqli_query($connect,$query);
	if($data){
		echo "Success";
	}
	else{
		echo "Error";
	}

}
 ?>