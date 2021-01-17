<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");
$Id=$_POST['Id'];
$query ="SELECT * FROM `user` WHERE UserId='$Id'";
$data=mysqli_query($connect,$query);
class Employees{
	function Employees($Name,$Image,$Room,$Sex,$Phone,$Birthday,$Address,$Email,$CreateTime,$Exp,$AddInfor){
	 $this->Name=$Name;
     $this->Image=$Image;
     $this->Room=$Room;
     $this->Sex=$Sex;
     $this->Phone=$Phone;
     $this->Birthday=$Birthday;
     $this->Address=$Address;
     $this->Email=$Email;
     $this->CreateTime=$CreateTime;
     $this->Exp=$Exp;
     $this->AddInfor=$AddInfor;

	}
}
$mangData=array();
while($row= mysqli_fetch_assoc($data)){
	array_push($mangData, new Employees($row['Name'],$row['Image'],$row['RoomId'],$row['Sex'],$row['Phone'],$row['Birthday'],$row['Address'],$row['Email'],$row['CreateTime'],$row['Exp'],$row['AddInfor']));
}
echo json_encode($mangData); 
 ?>