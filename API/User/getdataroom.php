<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");
$Id=$_POST['Id'];
$query ="SELECT user.Name,user.Image,user.Birthday,user.UserId FROM user WHERE user.RoomId=(SELECT user.RoomId FROM user WHERE user.UserId='$Id')";
$data=mysqli_query($connect,$query);
class Employees{
	function Employees($Name,$Image,$Birthday,$UserId){
	 $this->Name=$Name;
     $this->Image=$Image;
     $this->Birthday=$Birthday;
     $this->UserId=$UserId;
	}
}
$mangData=array();
while($row= mysqli_fetch_assoc($data)){
	array_push($mangData, new Employees($row['Name'],$row['Image'],$row['Birthday'],$row['UserId']));
}
echo json_encode($mangData); 
 ?>