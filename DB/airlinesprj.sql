-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2024 at 06:58 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airlinesprj`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `sno` int(11) NOT NULL,
  `empID` varchar(15) DEFAULT NULL,
  `empname` varchar(50) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `empDOB` varchar(12) DEFAULT NULL,
  `designation` varchar(40) NOT NULL,
  `empmail` varchar(100) DEFAULT NULL,
  `empmob` varchar(10) DEFAULT NULL,
  `empadd` varchar(500) DEFAULT NULL,
  `aadhar` varchar(12) DEFAULT NULL,
  `yoj` varchar(4) DEFAULT NULL,
  `photo` varchar(700) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`sno`, `empID`, `empname`, `gender`, `empDOB`, `designation`, `empmail`, `empmob`, `empadd`, `aadhar`, `yoj`, `photo`) VALUES
(1, '123ANAL321', 'Alan B', 'M', '02/01/2003', 'Cheif-Executive', 'boobalanvellingiri@gmail.com', '9500546209', 'Erode', '123412341234', '2024', 'Alan.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `adminlogin`
--

CREATE TABLE `adminlogin` (
  `sno` int(11) NOT NULL,
  `empID` varchar(15) DEFAULT NULL,
  `empUsername` varchar(15) DEFAULT NULL,
  `designation` varchar(40) NOT NULL,
  `empmail` varchar(50) DEFAULT NULL,
  `empPW` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `adminlogin`
--

INSERT INTO `adminlogin` (`sno`, `empID`, `empUsername`, `designation`, `empmail`, `empPW`) VALUES
(1, '123NALA321', 'alan_08', 'Cheif-Executive', 'boobalanvellingiri@gmial.com', 'Alan');

-- --------------------------------------------------------

--
-- Table structure for table `arrivaldetails`
--

CREATE TABLE `arrivaldetails` (
  `sno` int(11) NOT NULL,
  `departure` varchar(50) DEFAULT NULL,
  `arrival` varchar(50) DEFAULT NULL,
  `departureTime` varchar(5) DEFAULT NULL,
  `arrivalime` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `arrivaldetails`
--

INSERT INTO `arrivaldetails` (`sno`, `departure`, `arrival`, `departureTime`, `arrivalime`) VALUES
(1, 'Chennai-MAA', 'Bangalore-BLR', '10', '10.45');

-- --------------------------------------------------------

--
-- Table structure for table `departuredetails`
--

CREATE TABLE `departuredetails` (
  `sno` int(11) NOT NULL,
  `planeRegno` varchar(20) NOT NULL,
  `departure` varchar(50) DEFAULT NULL,
  `destination` varchar(50) DEFAULT NULL,
  `departureTime` varchar(5) DEFAULT NULL,
  `reachTime` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `departuredetails`
--

INSERT INTO `departuredetails` (`sno`, `planeRegno`, `departure`, `destination`, `departureTime`, `reachTime`) VALUES
(1, 'VT-JGA', 'Bangalore-BLR', 'Chennai', '20', '21');

-- --------------------------------------------------------

--
-- Table structure for table `pilot`
--

CREATE TABLE `pilot` (
  `sno` int(11) NOT NULL,
  `pilID` varchar(15) DEFAULT NULL,
  `pilname` varchar(100) DEFAULT NULL,
  `designation` varchar(40) NOT NULL,
  `pilmail` varchar(100) DEFAULT NULL,
  `pilRegNo` varchar(15) DEFAULT NULL,
  `photo` varchar(500) DEFAULT NULL,
  `yoj` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pilot`
--

INSERT INTO `pilot` (`sno`, `pilID`, `pilname`, `designation`, `pilmail`, `pilRegNo`, `photo`, `yoj`) VALUES
(1, '010203', 'Alan B', 'Cheif-pilot', 'boobalanvellingiri@gmial.com', '2123AL12', 'Alan.jpeg', '2023');

-- --------------------------------------------------------

--
-- Table structure for table `planedetails`
--

CREATE TABLE `planedetails` (
  `sno` int(11) NOT NULL,
  `planeModel` varchar(50) DEFAULT NULL,
  `planeregno` varchar(20) DEFAULT NULL,
  `planeSerialno` varchar(15) DEFAULT NULL,
  `countryofReg` varchar(50) DEFAULT NULL,
  `planetype` varchar(50) DEFAULT NULL,
  `route` varchar(30) NOT NULL,
  `seatcap` varchar(4) NOT NULL,
  `config` varchar(30) NOT NULL,
  `frq` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `planedetails`
--

INSERT INTO `planedetails` (`sno`, `planeModel`, `planeregno`, `planeSerialno`, `countryofReg`, `planetype`, `route`, `seatcap`, `config`, `frq`) VALUES
(1, 'Boeing 737-800', 'VT-JGA ', '39043', 'India', 'Narrow-body, twin-en', 'Domestic', '300', 'economy, 1st class, ', 'weekly');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `adminlogin`
--
ALTER TABLE `adminlogin`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `arrivaldetails`
--
ALTER TABLE `arrivaldetails`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `departuredetails`
--
ALTER TABLE `departuredetails`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `pilot`
--
ALTER TABLE `pilot`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `planedetails`
--
ALTER TABLE `planedetails`
  ADD PRIMARY KEY (`sno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `sno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `adminlogin`
--
ALTER TABLE `adminlogin`
  MODIFY `sno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `arrivaldetails`
--
ALTER TABLE `arrivaldetails`
  MODIFY `sno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `departuredetails`
--
ALTER TABLE `departuredetails`
  MODIFY `sno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `pilot`
--
ALTER TABLE `pilot`
  MODIFY `sno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `planedetails`
--
ALTER TABLE `planedetails`
  MODIFY `sno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
