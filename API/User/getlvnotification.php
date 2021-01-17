<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");
$Id=$_POST['Id'];
$query ="SELECT notification.Id,notification.Describe_notification,notification.Content,notification.Create_time,notification.Add_infor FROM `notification`,`user` WHERE (notification.Id_receive='$Id' 
OR (notification.Id_receive='All' AND notification.List LIKE '%,$Id,%'))
AND user.UserId='$Id'";
$data=mysqli_query($connect,$query);
class Employees{
	function Employees($Id,$Describe,$Content,$Create,$Add_Infor){
	 $this->Id=$Id;
     $this->Describe=$Describe;
     $this->Content=$Content;
     $this->Create=$Create;
     $this->Add_Infor=$Add_Infor;
	}
}
$mangData=array();
while($row= mysqli_fetch_assoc($data)){
	array_push($mangData, new Employees($row['Id'],$row['Describe_notification'],$row['Content'],$row['Create_time'],$row['Add_infor']));
}
echo json_encode($mangData); 
 ?>