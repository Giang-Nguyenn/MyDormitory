<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");
//$Id=$_POST['Id'];
$query ="SELECT room.RoomId,Countt FROM room LEFT OUTER JOIN (SELECT RoomId as r, COUNT(RoomId) as Countt FROM user GROUP BY RoomId) as A ON RoomId=r";
$data=mysqli_query($connect,$query);
class Employees{
	function Employees($RoomId,$Countt){
	$this->RoomId=$RoomId;
     $this->Countt=$Countt;

	}
}
$mangData=array();
while($row= mysqli_fetch_assoc($data)){
	array_push($mangData, new Employees($row['RoomId'],$row['Countt']));
}
echo json_encode($mangData); 
 ?>