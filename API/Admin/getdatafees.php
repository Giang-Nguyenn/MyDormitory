<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");
$Status=$_POST['Status'];
// $Status='RoomA-101';

class Fees{
	function Fees($Id,$Describe,$Create,$Status,$Add_Infor,$List){
	 $this->Id=$Id;
	 $this->Describe=$Describe;
     $this->Create=$Create;
     $this->Status=$Status;
     $this->Add_Infor=$Add_Infor;
     $this->List=$List;
	}
}
if(substr($Status, 0, 5) === 'Admin'){
	$Id=substr($Status,5);
	$query ="SELECT Id,Describe_fee,Create_time,Add_Infor,Status,List FROM `frees` WHERE Id_receive='All'";
}
else if(substr($Status, 0, 4) === 'Room'){
	$Id=substr($Status,4);
	$query ="SELECT Id,Describe_fee,Create_time,Add_Infor,Status,List FROM `frees` WHERE Id_receive='$Id'";
}
else{
	$Id=substr($Status,4);
	$query ="SELECT Id,Describe_fee,Create_time,Add_Infor,Status,List FROM `frees` WHERE (Id_receive='All') AND List LIKE '%,$Id,%'";
}
$data=mysqli_query($connect,$query);
$mangData=array();
while($row= mysqli_fetch_assoc($data)){
	array_push($mangData, new Fees($row['Id'],$row['Describe_fee'],$row['Create_time'],$row['Status'],$row['Add_Infor'],$row['List']));
}
echo json_encode($mangData); 
 ?>