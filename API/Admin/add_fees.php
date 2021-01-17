<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");

include("../model.php");
if(isset($_POST["Status"]) and isset($_POST["Option"]) and isset($_POST["Describe"]) and isset($_POST["Add_Infor"])and isset($_POST["ListId"])){	
	$Status=$_POST['Status'];
	$Option=$_POST['Option'];
	$Describe=$_POST['Describe'];
	$Add_Infor=$_POST['Add_Infor'];
	$ListId=$_POST['ListId'];

	if($Option=='1'){
		$query ="INSERT INTO `frees` (`Id`, `Id_fees_tittle`, `Id_receive`, `Describe_fee`, `Create_time`, `Add_Infor`, `Status`, `List`) VALUES (NULL, '1', 'All', '$Describe', current_timestamp(), '$Add_Infor', '0', '$ListId')";
	}
	else if($Option=='2'){
		$query ="INSERT INTO `frees` (`Id`, `Id_fees_tittle`, `Id_receive`, `Describe_fee`, `Create_time`, `Add_Infor`, `Status`, `List`) VALUES (NULL, '2', '$ListId', '$Describe', current_timestamp(), '$Add_Infor', '0', '-1')";
	}
	else{
		$List=findlv("All");
		$query ="INSERT INTO `frees` (`Id`, `Id_fees_tittle`, `Id_receive`, `Describe_fee`, `Create_time`, `Add_Infor`, `Status`, `List`) VALUES (NULL, '3', 'All', '$Describe', current_timestamp(), '$Add_Infor', '0', '$List')";
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