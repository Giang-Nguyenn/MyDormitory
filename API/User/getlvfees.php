<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");
$Id=$_POST['Id'];
$query ="SELECT frees.Id,frees.Describe_fee,frees.Status,frees.Add_infor,frees.Create_time FROM `frees`,`user`WHERE
(frees.Id_receive='$Id' 
OR(frees.Id_receive IN (SELECT RoomId FROM user WHERE UserId='$Id') AND Status='0') 
OR (frees.Id_receive='All' AND frees.List LIKE '%,$Id,%'))
AND user.UserId='$Id'";
// $query ="SELECT frees.Id,frees.Describe_fee,frees.Status,frees.Add_infor,frees.Create_time FROM `frees`,`user`WHERE(frees.Id_receive='$Id' OR frees.Id_receive IN (SELECT RoomId FROM user WHERE UserId='$Id') OR frees.Id_receive='All') AND user.UserId='$Id'";
$data=mysqli_query($connect,$query);
class Employees{
	function Employees($Id,$Describe,$Create,$Status,$Add_infor){
	 $this->Id=$Id;
     $this->Describe=$Describe;
     $this->Create=$Create;
     $this->Status=$Status;
     $this->Add_infor=$Add_infor;
	}
}
$mangData=array();
while($row= mysqli_fetch_assoc($data)){
	array_push($mangData, new Employees($row['Id'],$row['Describe_fee'],$row['Create_time'],$row['Status'],$row['Add_infor']));
}
echo json_encode($mangData); 
 ?>