<?php
$connect = mysqli_connect("localhost","root","","appmydormitory");
mysqli_query($connect," SET NAMES 'utf8'");
$a=$_POST['Img'];
$RoomId=$_POST["RoomId"];
$Name=$_POST["Name"];
$Sex=$_POST["Sex"];
$Phone=$_POST["Phone"];
$BirthDay=$_POST["BirthDay"];
$Address=$_POST["Address"];
$Password=$_POST["Password"];
$Gmail=$_POST["Gmail"];
$Exp=$_POST["Exp"];
$AddInfor=$_POST["AddInfor"];
$Number=$_POST["Number"];
$NameImage="http://localhost/API/Images/".$RoomId."_".$Name."_".$Number.".png";
$decodeImage=base64_decode("$a");
$name="../Images/".$RoomId."_".$Name."_".$Number.".png";
file_put_contents($name, $decodeImage);
$query ="INSERT INTO `user` (`UserId`, `Name`, `Sex`, `RoomId`, `Image`, `Phone`, `Birthday`, `Address`, `Password`, `Email`, `CreateTime`, `Exp`, `AddInfor`) VALUES (NULL, '$Name', '$Sex', '$RoomId', '$NameImage', '$Phone', '$BirthDay', '$Address', '$Password', '$Gmail', current_timestamp(), '$Exp', '$AddInfor')";
//$data=mysqli_query($connect,$query);
if(mysqli_query($connect,$query)){
	echo "Ok";
}
else{
	echo "No".mysql_error(connect);
}
 ?>
