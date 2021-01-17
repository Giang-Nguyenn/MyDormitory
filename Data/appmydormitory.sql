-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2021 at 03:39 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `appmydormitory`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminId` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Sex` varchar(10) NOT NULL,
  `TitleId` int(10) NOT NULL,
  `Image` varchar(255) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `CreateDate` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminId`, `Name`, `Sex`, `TitleId`, `Image`, `Phone`, `Password`, `CreateDate`) VALUES
(1, 'Admin', 'Nam', 1, 'http://localhost/Images/Image.PNG', '123456789', 'admin', '2020-11-09 21:04:24');

-- --------------------------------------------------------

--
-- Table structure for table `building`
--

CREATE TABLE `building` (
  `BuildingId` varchar(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `AdminId` int(10) NOT NULL,
  `Location` varchar(255) DEFAULT 'Chưa có thông tin ',
  `Information` varchar(255) DEFAULT 'Chưa có thông tin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `building`
--

INSERT INTO `building` (`BuildingId`, `Name`, `AdminId`, `Location`, `Information`) VALUES
('A', 'Tòa nhà A', 1, 'Chưa có thông tin ', 'Chưa có thông tin'),
('B', 'Tòa nhà B', 1, 'Chưa có thông tin ', 'Chưa có thông tin'),
('C', 'Tòa nhà C', 1, 'Chưa có thông tin ', 'Chưa có thông tin'),
('D', 'Tòa nhà D', 1, 'Chưa có thông tin ', 'Chưa có thông tin');

-- --------------------------------------------------------

--
-- Table structure for table `fees_title`
--

CREATE TABLE `fees_title` (
  `Id` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Describe_fee_title` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fees_title`
--

INSERT INTO `fees_title` (`Id`, `Name`, `Describe_fee_title`) VALUES
(1, 'Khoản thu cá nhân ', 'Khoản thu cá nhân '),
(2, 'Khoản thu theo phòng', 'Khoản thu theo phòng'),
(3, 'Khoản thu chung', 'Khoản thu chung');

-- --------------------------------------------------------

--
-- Table structure for table `frees`
--

CREATE TABLE `frees` (
  `Id` int(10) NOT NULL,
  `Id_fees_tittle` int(10) NOT NULL,
  `Id_receive` varchar(10) NOT NULL,
  `Describe_fee` varchar(1000) DEFAULT NULL,
  `Create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `Add_Infor` varchar(1000) DEFAULT NULL,
  `Status` varchar(10) NOT NULL DEFAULT '0',
  `List` mediumtext NOT NULL DEFAULT '-1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `frees`
--

INSERT INTO `frees` (`Id`, `Id_fees_tittle`, `Id_receive`, `Describe_fee`, `Create_time`, `Add_Infor`, `Status`, `List`) VALUES
(1, 2, 'A-101', 'Tiền điện', '2020-12-29 20:41:27', 'Không', '1', '-1'),
(3, 1, 'All', 'Tất cả', '2021-01-04 15:47:56', 'Chung', '0', ',1,2,3,11,111,150,'),
(4, 2, 'A-101', 'Tiền nước', '2021-01-05 19:12:34', 'Tiền nước', '1', '\'-1\''),
(5, 1, 'All', 'Thu tất cả 1', '2021-01-05 23:12:17', 'Thu tất cả 1', '0', ',1,2,3,4,5,6,7,8,9,'),
(6, 1, 'All', 'test1', '2021-01-06 10:50:14', 'test1', '0', ',2,3,'),
(7, 1, 'All', 'test khoản thu cá nhân', '2021-01-06 10:52:11', 'test khoản thu cá nhân', '0', ',2,3,4,5,'),
(8, 2, 'A-101', 'test thu theo phòng', '2021-01-06 10:55:52', 'test thu theo phòng', '1', '-1'),
(9, 3, 'All', 'test thu tất cả', '2021-01-06 10:57:16', 'test thu tất cả', '0', ',2,3,4,5,6,7,8,10,24,30,31,38,39,41,46,47,48,49,50,51,52,55,57,58,59,60,'),
(26, 2, ',A-104,', 'test', '2021-01-08 08:18:05', 'không', '0', '-1'),
(27, 3, 'All', 'test', '2021-01-08 08:19:01', '123', '0', ',1,2,3,4,5,6,7,8,10,24,30,31,38,39,41,46,47,48,49,50,51,52,55,57,58,59,60,'),
(28, 1, 'All', 'test3', '2021-01-08 08:29:01', 'test', '0', ',61,'),
(29, 3, 'All', 'khoản thu ngày 8', '2021-01-08 10:37:48', 'thu tiền điện', '0', ',1,2,3,4,5,6,7,8,10,24,30,31,38,39,41,46,47,48,49,50,51,52,55,57,58,59,60,61,'),
(30, 3, 'All', 'khoản thi 1', '2021-01-08 10:41:41', '1', '0', ',1,2,3,4,5,6,7,8,10,24,30,31,38,39,41,46,47,48,49,50,51,52,55,57,58,59,60,61,62,');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `Id` int(10) NOT NULL,
  `Id_receive` varchar(10) NOT NULL,
  `Describe_notification` varchar(1000) NOT NULL,
  `Content` varchar(1000) NOT NULL,
  `Create_time` datetime NOT NULL DEFAULT current_timestamp(),
  `Add_infor` varchar(1000) NOT NULL,
  `List` mediumtext NOT NULL DEFAULT '-1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`Id`, `Id_receive`, `Describe_notification`, `Content`, `Create_time`, `Add_infor`, `List`) VALUES
(1, 'All', 'Thông báo tháng 1', 'Thông báo chung 1', '2021-01-04 16:17:34', 'không', ',1,2,3,4,5,6,7,8,9,'),
(2, 'Room', 'Thông báo phòng A-101', 'Thông báo theo phòng', '2021-01-04 16:18:02', 'không', ',A-101,A-102,A-103,'),
(3, 'All', 'Thông báo chung', 'Thông báo chung', '2021-01-04 16:18:25', 'không', ',1,2,3,'),
(4, 'All', 'Thông  báo tháng 1', 'Thông báo 1', '2021-01-06 17:41:30', 'Không', ',1,'),
(5, 'Room', 'Thông báo tháng 3', 'Thông báo 2', '2021-01-06 17:42:07', 'Không', ',A-101,A-102,A-103,'),
(6, 'All', 'Thông báo tháng 4', 'Thông báo 3', '2021-01-06 17:42:31', 'Không', ',1,2,3,4,5,6,7,8,10,24,30,31,38,39,41,46,47,48,49,50,51,52,55,57,58,59,60,'),
(7, 'All', 'test tb', 'test tb', '2021-01-08 08:19:29', 'Không', ',1,2,3,4,5,6,7,8,10,24,30,31,38,39,41,46,47,48,49,50,51,52,55,57,58,59,60,61,'),
(8, 'All', 'test 2', 'test', '2021-01-08 08:24:58', 'Không', ',1,2,3,4,5,6,7,8,10,24,30,31,38,39,41,46,47,48,49,50,51,52,55,57,58,59,60,61,'),
(9, 'All', 'thông báo ngày 8 ', 'thoing báo ngày 8', '2021-01-08 10:38:21', 'Không', ',1,2,3,4,5,6,7,8,10,24,30,31,38,39,41,46,47,48,49,50,51,52,55,57,58,59,60,61,62,'),
(10, 'All', 'thông báo 1', 'thông bao1', '2021-01-08 10:42:59', 'Không', ',1,2,3,4,5,6,7,8,10,24,30,31,38,39,41,46,47,48,49,50,51,52,55,57,58,59,60,61,62,');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `RoomId` varchar(10) NOT NULL,
  `BuildingId` varchar(10) NOT NULL,
  `Location` varchar(255) NOT NULL DEFAULT 'Chưa có thông tin',
  `Intrastructure` varchar(255) NOT NULL DEFAULT 'Chưa có thông tin ',
  `Information` varchar(255) NOT NULL DEFAULT 'Chưa có thông tin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`RoomId`, `BuildingId`, `Location`, `Intrastructure`, `Information`) VALUES
('A-101', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-102', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-103', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-104', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-105', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-201', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-202', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-203', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-204', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-205', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-301', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-302', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-303', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-304', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-305', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-401', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-402', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-403', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-404', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-405', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-501', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-502', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-503', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-504', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('A-505', 'A', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-101', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-102', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-103', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-104', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-105', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-201', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-202', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-203', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-204', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-205', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-301', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-302', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-303', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-304', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-305', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-401', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-402', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-403', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-404', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-405', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-501', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-502', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-503', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-504', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin'),
('B-505', 'B', 'Chưa có thông tin', 'Chưa có thông tin ', 'Chưa có thông tin');

-- --------------------------------------------------------

--
-- Table structure for table `title`
--

CREATE TABLE `title` (
  `TitleId` int(10) NOT NULL,
  `TitleName` varchar(100) NOT NULL,
  `DescribeTitle` varchar(255) NOT NULL DEFAULT 'Chưa có thông tin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `title`
--

INSERT INTO `title` (`TitleId`, `TitleName`, `DescribeTitle`) VALUES
(1, 'Quản lý tòa nhà', 'Chưa có thông tin');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserId` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Sex` varchar(10) NOT NULL,
  `RoomId` varchar(10) NOT NULL,
  `Image` varchar(255) NOT NULL,
  `Phone` varchar(10) NOT NULL,
  `Birthday` varchar(50) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `CreateTime` datetime NOT NULL DEFAULT current_timestamp(),
  `Exp` varchar(255) NOT NULL,
  `AddInfor` varchar(255) NOT NULL DEFAULT 'Chưa có thông tin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserId`, `Name`, `Sex`, `RoomId`, `Image`, `Phone`, `Birthday`, `Address`, `Password`, `Email`, `CreateTime`, `Exp`, `AddInfor`) VALUES
(1, 'Nguyễn Văn Anh', 'Nam', 'A-101', 'http://localhost/API/Images/Image.PNG', '123456789', '01-01-2002', 'Hà Nội', '123456789', '@gmail.com', '2020-11-09 21:21:45', '01/01/2021', 'Chưa có thông tin'),
(2, 'Nguyễn Văn Bình', 'Nam', 'A-101', 'http://localhost/API/Images/Image.PNG', '123456781', '01-01-2002', 'Hà Nội', 'binh123456789', 'binh@gmail.com', '2020-11-09 21:24:00', '01/01/2021', 'Chưa có thông tin thêm'),
(3, 'Nguyễn Văn Công', 'Nam', 'A-101', 'http://localhost/API/Images/Image.PNG', '123456782', '01-01-2002', 'Hà Nội', 'cong123456789', 'cong@gmail.com', '2020-11-09 21:24:57', '01/01/2021', 'Chưa có thông tin'),
(4, 'Nguyễn Văn Đức', 'Nam', 'A-101', 'http://localhost/API/Images/Image.PNG', '123456783', '01-01-2002', 'Hà Nội', 'duc123456789', 'duc@gmail.com', '2020-11-09 21:24:57', '01/01/2021', 'Chưa có thông tin'),
(5, 'Nguyễn Văn Giang', 'Nam', 'A-101', 'http://localhost/API/Images/Image.PNG', '123456784', '01-01-2002', 'Hà Nội', 'giang123456789', 'giang@gmail.com', '2020-11-09 21:24:57', '01/01/2021', 'Chưa có thông tin'),
(6, 'Nguyễn Văn Hào', 'Nam', 'A-101', 'http://localhost/API/Images/Image.PNG', '123456785', '01-01-2002', 'Hà Nội', 'hao123456789', 'hao@gmail.com', '2020-11-09 21:24:57', '01/01/2021', 'Chưa có thông tin'),
(7, 'Nguyễn Văn Long', 'Nam', 'A-101', 'http://localhost/API/Images/Image.PNG', '123456786', '01-01-2002', 'Hà Nội', 'long123456789', 'long@gmail.com', '2020-11-09 21:24:57', '01/01/2021', 'Chưa có thông tin'),
(8, 'Nguyễn Văn Minh', 'Nam', 'A-101', 'http://localhost/API/Images/Image.PNG', '123456787', '01-01-2002', 'Hà Nội', 'minh123456789', 'minh@gmail.com', '2020-11-09 21:24:57', '01/01/2021', 'Chưa có thông tin'),
(10, 'Nguyễn Văn Anhh', 'Nam', 'A-102', 'http://localhost/API/Images/Image.PNG', '123456780', '01-02-2002', 'Hà Nội', 'anh123456791', 'anh@gmail.com', '2020-11-13 21:51:54', 'null', 'Chưa có thông tin'),
(24, 'Name', 'Nam', 'A-102', 'http://localhost/API/Images/Image.PNG', '012345999', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-22 21:59:44', '2021', 'Chưa có thông tin thêm'),
(30, 'NameA', 'Nam', 'A-102', 'http://localhost/API/Images/Image.PNG', '002345678', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-22 22:08:38', '2021', 'Chưa có thông tin thêm'),
(31, 'NameA1', 'Nam', 'A-102', 'http://localhost/API/Images/Image.PNG', '012245678', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-22 22:09:39', '2021', 'Chưa có thông tin thêm'),
(38, 'test', 'Nam', 'A-102', 'http://localhost/API/Images/A-102_test_6.png', '082345678', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-23 16:51:17', '2021', 'Chưa có thông tin thêm'),
(39, '103', 'Nam', 'A-103', 'http://localhost/API/Images/A-103_103_1.png', '112345671', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-23 16:56:30', '2021', 'Chưa có thông tin thêm'),
(41, 'Namehiiii', 'Nam', 'A-102', 'http://localhost/API/Images/A-102_Namehiiii_6.png', '123415678', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-23 17:00:02', '2021', 'Chưa có thông tin thêm'),
(46, 'Namehi', 'Nam', 'A-103', 'http://localhost/API/Images/A-103_Namehi_2.png', '012344568', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-23 17:02:42', '2021', 'Chưa có thông tin thêm'),
(47, 'Aaa', 'Nam', 'A-103', 'http://localhost/API/Images/A-103_Aaa_3.png', '0123456781', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-25 10:53:09', '2021', 'Chưa có thông tin thêm'),
(48, 'Nameâ', 'Nam', 'A-103', 'http://localhost/API/Images/Image.PNG', '012345678', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-25 11:04:17', '2021', 'Chưa có thông tin thêm'),
(49, 'Name', 'Nam', 'A-103', 'http://localhost/API/Images/Image.PNG', '121345678', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-27 09:28:18', '2021', 'Chưa có thông tin thêm'),
(50, 'Name aaaa', 'Nam', 'A-103', 'http://localhost/API/Images/Image.PNG', '012344567', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-27 09:29:50', '2021', 'Chưa có thông tin thêm'),
(51, 'Name12345', 'Nam', 'A-102', 'http://localhost/API/Images/Image.PNG', '01234556', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-11-27 09:45:01', '2021', 'Chưa có thông tin thêm'),
(52, 'Name104', 'Nam', 'A-104', 'http://localhost/API/Images/A-104_Name104_1.png', '012845678', '1-1-2000', 'Hà Nội', '123456782', 'hia@gmail.com', '2020-12-28 21:24:04', '2021', 'Chưa có thông tin thêm'),
(55, 'Name test1', 'Nam', 'A-104', 'http://localhost/API/Images/A-104_Name test1_3.png', '123456123', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-12-28 21:57:09', '2021', 'Chưa có thông tin thêm'),
(57, 'Name test11', 'Nam', 'A-104', 'http://localhost/API/Images/A-104_Name test11_3.png', '023456123', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-12-28 21:58:57', '2021', 'Chưa có thông tin thêm'),
(58, 'Nametestt', 'Nam', 'A-104', 'http://localhost/API/Images/A-104_Nametestt_4.png', '0123451238', '1-1-2000', 'Hà Nội', '123456782', 'hei@gmail.com', '2020-12-28 22:27:55', '2021', 'Chưa có thông tin thêm'),
(59, 'Name test', 'Nam', 'A-105', 'http://localhost/API/Images/A-105_Name test_1.png', '012341238', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-12-28 22:44:10', '2021', 'Chưa có thông tin thêm'),
(60, 'Name1', 'Nam', 'A-105', 'http://localhost/API/Images/A-105_Name1_2.png', '0123123478', '1-1-2000', 'Hà Nội', '123456782', 'hi@gmail.com', '2020-12-28 22:53:31', '2021', 'Chưa có thông tin thêm'),
(61, 'Nguyễn Nguyên', 'Nam', 'A-104', 'http://localhost/API/Images/A-104_Nguyễn Nguyên_5.png', '0861234567', '1-1-2000', 'Hà Nội', '08612345678', 'hi@gmail.com', '2021-01-08 08:15:57', '2021', 'test'),
(62, 'Nguyên1', 'Nam', 'A-104', 'http://localhost/API/Images/A-104_Nguyên1_6.png', '0688438320', '1-1-2000', 'Hà Nội', '0868438320', 'hi@gmail.com', '2021-01-08 10:35:56', '2021', 'Chưa có thông tin thêm');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminId`),
  ADD KEY `FK-admin-title` (`TitleId`);

--
-- Indexes for table `building`
--
ALTER TABLE `building`
  ADD PRIMARY KEY (`BuildingId`),
  ADD KEY `FK-building-admin` (`AdminId`);

--
-- Indexes for table `fees_title`
--
ALTER TABLE `fees_title`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `frees`
--
ALTER TABLE `frees`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK-fees-title` (`Id_fees_tittle`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`RoomId`),
  ADD KEY `FK-room-building` (`BuildingId`);

--
-- Indexes for table `title`
--
ALTER TABLE `title`
  ADD PRIMARY KEY (`TitleId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserId`),
  ADD UNIQUE KEY `Phone` (`Phone`),
  ADD KEY `Fk-user-room` (`RoomId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AdminId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `fees_title`
--
ALTER TABLE `fees_title`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `frees`
--
ALTER TABLE `frees`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `title`
--
ALTER TABLE `title`
  MODIFY `TitleId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UserId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FK-admin-title` FOREIGN KEY (`TitleId`) REFERENCES `title` (`TitleId`);

--
-- Constraints for table `building`
--
ALTER TABLE `building`
  ADD CONSTRAINT `FK-building-admin` FOREIGN KEY (`AdminId`) REFERENCES `admin` (`AdminId`);

--
-- Constraints for table `frees`
--
ALTER TABLE `frees`
  ADD CONSTRAINT `FK-fees-title` FOREIGN KEY (`Id_fees_tittle`) REFERENCES `fees_title` (`Id`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `FK-room-building` FOREIGN KEY (`BuildingId`) REFERENCES `building` (`BuildingId`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `Fk-user-room` FOREIGN KEY (`RoomId`) REFERENCES `room` (`RoomId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
