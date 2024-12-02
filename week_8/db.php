<!-- Database creation -->
<?php
$host = 'localhost';
$user = 'root';
$pass = '';
$db = 'csec';
// create connection
$conn = mysqli_connect($host, $user, $pass, $db);

if (!$conn) {
	// die('Could not connect:' . mysqli_error($conn));
	die('Could not connect:' . mysqli_connect_error());
}else{
	echo 'DB Connection Established successfully….';
}

// sql to create table
$sql="CREATE TABLE `faculty` (`id` INT(4) NOT NULL AUTO_INCREMENT , `name` INT NOT NULL , `phone no` INT NOT NULL , `marks` INT NOT NULL , PRIMARY KEY (`id`))";
if(mysqli_query($conn,$sql)){
    echo "Table faculty created sucessfully";
}else{
    // echo "Error,creating table: ". $conn->error;
    echo "Error,creating table: ". mysqli_error($conn);
}



if($_SERVER['REQUEST_METHOD']==='POST'){
	$names = $_POST['name'];
	$phoness = $_POST['phone'];
	$marksss = $_POST['marks'];
	// INSERT INTO `phpstudents` (`name`, `phone no`, `marks`) VALUES ('$names', '$phoness', '$marksss');
	$q = "INSERT into faculty(`name`, `phone no`, `marks`) VALUES ('$names', '$phoness', '$marksss')";
}

if (mysqli_query($conn, $q))
	echo "registration success.......";
else
	echo "registration Failed......." . mysqli_error($conn);

// mysqli_close($conn);
// $conn->close();
?>