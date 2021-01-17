<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");
$RoomId=$_POST['RoomId'];
$query ="SELECT user.Name,user.Image,user.Address,user.UserId FROM user WHERE user.RoomId='$RoomId'";
$data=mysqli_query($connect,$query);
class Employees{
	function Employees($Name,$Image,$Address,$UserId){
	 $this->Name=$Name;
     $this->Image=$Image;
     $this->Address=$Address;
     $this->UserId=$UserId;
	}
}
$mangData=array();
while($row= mysqli_fetch_assoc($data)){
	array_push($mangData, new Employees($row['Name'],$row['Image'],$row['Address'],$row['UserId']));
}
echo json_encode($mangData); 
 ?>