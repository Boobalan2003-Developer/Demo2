-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 02, 2024 at 06:57 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javafullstack830`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `courseid` int(11) NOT NULL,
  `coursename` varchar(15) NOT NULL,
  `coursetype` varchar(20) NOT NULL,
  `coursedegree` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`courseid`, `coursename`, `coursetype`, `coursedegree`) VALUES
(1, 'B.Sc', 'Science', 'UG'),
(2, 'M.Sc', 'Science', 'PG'),
(3, 'BBA', 'BusinessAdmin', 'UG'),
(4, 'MBA', 'BusinessAdmin', 'PG'),
(5, 'B.Com', 'Commerce', 'UG'),
(6, 'B.Com CA', 'Commerce', 'UG'),
(7, 'B.Com PA', 'Commerce', 'UG'),
(8, 'M.Com', 'Commerce', 'PG'),
(9, 'BCA', 'CompApp', 'UG'),
(10, 'MCA', 'CompApp', 'PG');

-- --------------------------------------------------------

--
-- Table structure for table `demo`
--

CREATE TABLE `demo` (
  `idno` int(11) DEFAULT NULL,
  `stuname` varchar(30) DEFAULT NULL,
  `stupass` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `demo`
--

INSERT INTO `demo` (`idno`, `stuname`, `stupass`) VALUES
(101, 'ARUN', '123456'),
(101, 'ARUN', '123456'),
(101, 'ARUN', '123456'),
(101, 'ARUN', '123456'),
(102, 'Boobalan', 'java@123');

-- --------------------------------------------------------

--
-- Table structure for table `departments`
--

CREATE TABLE `departments` (
  `deptid` int(11) NOT NULL,
  `deptname` varchar(100) DEFAULT NULL,
  `deptcode` varchar(15) DEFAULT NULL,
  `depttype` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `departments`
--

INSERT INTO `departments` (`deptid`, `deptname`, `deptcode`, `depttype`) VALUES
(1, 'Computer Science', 'CS', 'Science'),
(2, 'Computer Applications', 'CA', 'CompApp'),
(3, 'Commerce', 'COM', 'Commerce'),
(4, 'Business Administration', 'BA', 'BusinessAdmin'),
(5, 'Tamil', 'TM', 'Arts'),
(6, 'English', 'EN', 'Arts');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `rollno` int(11) DEFAULT NULL,
  `stuid` varchar(10) DEFAULT NULL,
  `stuname` varchar(50) DEFAULT NULL,
  `studept` varchar(25) DEFAULT NULL,
  `stuemailid` varchar(50) DEFAULT NULL,
  `stumobile` varchar(10) DEFAULT NULL,
  `stuadd` varchar(500) NOT NULL,
  `stucity` varchar(100) NOT NULL,
  `stucourse` varchar(15) DEFAULT NULL,
  `studegree` varchar(10) DEFAULT NULL,
  `yoj` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`rollno`, `stuid`, `stuname`, `studept`, `stuemailid`, `stumobile`, `stuadd`, `stucity`, `stucourse`, `studegree`, `yoj`) VALUES
(1001, '24UCS1001', 'Albert Jones A', 'CS', 'albert123@gmail.com', '9090190901', 'Erode	', 'Erode', 'B.Sc', 'UG', '2024'),
(1002, '24UCS1002', 'Divya S', 'CS', 'divya123@gmail.com', '9090290902', 'Perundurai	', 'Erode', 'B.Sc', 'UG', '2024'),
(1003, '24UCS1003', 'Banu A', 'CS', 'banu@gmail.com', '9090390903', 'Perundurai', 'Erode', 'B.Sc', 'UG', '2024');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`courseid`);

--
-- Indexes for table `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`deptid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `courseid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `departments`
--
ALTER TABLE `departments`
  MODIFY `deptid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
