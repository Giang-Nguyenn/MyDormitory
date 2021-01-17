<?php 
// $connect = mysqli_connect("localhost","root","","appmydormitory");
// mysqli_query($connect," SET NAMES 'utf8'");
 function findlv($a){
 	$list=',';
 	if($a=='All'){
 		$connect = mysqli_connect("localhost","root","","appmydormitory");
        mysqli_query($connect," SET NAMES 'utf8'");
 		$query ="SELECT user.UserId FROM `user` ORDER BY UserId ASC";
 		$data=mysqli_query($connect,$query);
 		while($row= mysqli_fetch_assoc($data)){
        $list=$list.$row['UserId'].',';
        }
        return $list;
 	}
 	else{
 		$connect = mysqli_connect("localhost","root","","appmydormitory");
        mysqli_query($connect," SET NAMES 'utf8'");
        $query ="SELECT user.UserId FROM `user` WHERE user.RoomId='$a' ORDER BY UserId ASC";
 		$data=mysqli_query($connect,$query);
 		while($row= mysqli_fetch_assoc($data)){
        $list=$list.$row['UserId'].',';
        }
        return $list;

 	}

 }

 ?>