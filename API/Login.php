<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");
$user=$_POST['user'];
$password=$_POST['password'];
if($user=="admin"){
	$query ="SELECT Name,AdminId FROM `admin` WHERE Password='$password'";
	$data=mysqli_query($connect,$query);
	if($data->num_rows>0){
		$row = mysqli_fetch_assoc($data);
	//echo $row["Success"];
		echo "Admin".$row["AdminId"];
	}
	else{echo "No";}
}
else{
	$query ="SELECT UserId FROM `user` WHERE user.Phone='$user' and user.Password='$password'";
	$data=mysqli_query($connect,$query);
	if($data->num_rows>0){
		$row = mysqli_fetch_assoc($data);
	//echo $row["Success"];
		echo "Ok".$row["UserId"];
	}
	else{echo "No";}

}
?>

