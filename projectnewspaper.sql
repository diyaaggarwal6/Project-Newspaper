-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 12, 2022 at 11:21 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projectnewspaper`
--

-- --------------------------------------------------------

--
-- Table structure for table `areas`
--

CREATE TABLE `areas` (
  `area` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `areas`
--

INSERT INTO `areas` (`area`) VALUES
('Model Town Phase-1'),
('Model Town Phase-2'),
('Model Town Phase-3'),
('Ajit Road'),
('Ganpati Enclave'),
('Sheesh Mahal'),
('Housefed Enclave'),
('Homeland Enclave'),
('Namdev Road'),
('NFL Colony'),
('Thermal Colony'),
('BSNL Colony'),
('Bank Colony'),
('Jujhaar Nagar'),
('Barnala Bypass Road'),
('G.T. Road'),
('Bhatti Road'),
('Power House Road'),
('Mall Road'),
('Railway Station Road'),
('Bank Bazaar'),
('Post Office Bazaar'),
('Sirki Bazaar'),
('Kikkar Bazaar'),
('Civil Lines Area'),
('Nirvana Colony'),
('Bibi Wala Road'),
('100ft-Road'),
('60ft-Road'),
('40ft-Road'),
('Veer Colony'),
('Panchvati Nagar'),
('Shakti Nagar'),
('Amrik Singh Road'),
('D.A.V. College Road'),
('Maheshwari Chowk'),
('Bharat Nagar'),
('Ganesha Basti'),
('Model Town Phase-1');

-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

CREATE TABLE `bills` (
  `mobile` varchar(12) DEFAULT NULL,
  `dos` date DEFAULT NULL,
  `dupto` date DEFAULT NULL,
  `bill` float DEFAULT NULL,
  `STATUS` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bills`
--

INSERT INTO `bills` (`mobile`, `dos`, `dupto`, `bill`, `STATUS`) VALUES
('7087309381', '2021-07-11', '2021-07-31', 348, 1),
('9041986147', '2021-07-01', '2021-07-31', 432, 1),
('7087309381', '2021-07-31', '2021-08-25', 502.5, 0),
('9041986147', '2021-07-31', '2021-08-24', 345.6, 0);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `cname` varchar(20) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `area` varchar(120) DEFAULT NULL,
  `hawkers` varchar(20) DEFAULT NULL,
  `mobile` varchar(12) NOT NULL,
  `sel_papers` varchar(300) DEFAULT NULL,
  `sel_price` varchar(50) DEFAULT NULL,
  `dos` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`cname`, `address`, `area`, `hawkers`, `mobile`, `sel_papers`, `sel_price`, `dos`) VALUES
('Lovish Jindal', '#786,Street no.7,Ganpati Enclave,Bathinda', 'Ganpati Enclave', 'Gurpreet Singh', '7087309381', 'Dainik Bhaskar,Punjabi Tribune,The Economic Times,The Hindu,Punjab Kesari,', '1.9,5.1,3.0,7.4,2.7,', '2021-08-25'),
('Manish Jindal', '#456,Street No.-4,Homeland Enclave,BTI', 'Homeland Enclave', 'Ram Babu', '9041986147', 'Dainik Bhaskar,Hindustan,Punjabi Jagran,Punjabi Tribune,', '1.9,3.2,4.2,5.1,', '2021-08-24'),
('Kavya', '#43,Street no.5,Homeland Enclave,Bathinda', 'Homeland Enclave', 'Ram Babu', '9501141536', 'Hindustan Times,Punjabi Tribune,The Statesman,', '4.6,5.1,8.6,', '2021-08-26'),
('Nikhil', '#32,Street No.-1,Model Town Phase-1,Bathinda', 'Model Town Phase-1', 'Sham Lal', '9814256201', 'Dainik Bhaskar,Punjab Kesari,The Hindu,', '1.9,2.7,7.4,', '2021-07-31');

-- --------------------------------------------------------

--
-- Table structure for table `hawkers`
--

CREATE TABLE `hawkers` (
  `name` varchar(20) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `Aadhar` varchar(12) DEFAULT NULL,
  `contact` varchar(12) DEFAULT NULL,
  `selected` varchar(100) DEFAULT NULL,
  `pic` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hawkers`
--

INSERT INTO `hawkers` (`name`, `address`, `Aadhar`, `contact`, `selected`, `pic`) VALUES
('Akshay', '#83,Gali no.-1,Near Railway Station,Bti', '560116334582', '9417689158', 'Mall Road,Ganesha Basti,Namdev Road,', 'C:\\Users\\lavish jindal\\Downloads\\images.png'),
('Gurmail Singh', 'Village Mehma Sarja,Gonian Mandi,Bti', '985665474123', '98700002590', 'Kikkar Bazar,Sirki Bazar,', 'C:\\Users\\lavish jindal\\Downloads\\gurmail.jfif'),
('Gurpreet Singh', '#8,Gali No.-1,Adarsh nagar,Bathinda', '987458975236', '7845129639', 'Ganpati Enclave,', 'C:\\Users\\lavish jindal\\Downloads\\images (1).png'),
('Neelam Rani', 'Near Power House Road,Model town Phase-2,Bti', '812500364596', '7852946130', 'Bhatti Road,Power House Road,', 'null'),
('Playboy', '12,Near SBI ATM,BallaRam Nagar,Bti', '120356987430', '9988202910', 'Ajit Road,', 'C:\\Users\\lavish jindal\\Downloads\\images (1).jfif'),
('Raju', '#106,Gali no. 9,Paras Ram Nagar,Bti', '874500213601', '9815200631', 'Model Town Phase-2,', 'C:\\Users\\lavish jindal\\Downloads\\download.png'),
('Ram Babu', '#2,Gali no.-15,Thermal Colony,Bti', '987456032100', '7087569842', 'Homeland Enclave,Barnala Bypass Road,', 'C:\\Users\\lavish jindal\\Downloads\\images (2).jfif'),
('Sham Lal', '#56,Gali no. 5,Paras Ram Nagar,Bti', '894500125236', '9745681230', 'Model Town Phase-1,Model Town Phase-3,', 'C:\\Users\\lavish jindal\\Downloads\\download.jfif');

-- --------------------------------------------------------

--
-- Table structure for table `papers`
--

CREATE TABLE `papers` (
  `paper` varchar(20) NOT NULL,
  `rate` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `papers`
--

INSERT INTO `papers` (`paper`, `rate`) VALUES
('Ajit', 2.75),
('Dainik Bhaskar', 1.9),
('Dainik Jagran', 1.5),
('Hindustan', 3.2),
('Hindustan Times', 4.6),
('Jagbani', 1.9),
('Punjab Kesari', 2.7),
('Punjabi Jagran', 4.2),
('Punjabi Tribune', 5.1),
('The Economic Times', 3),
('The Hindu', 10),
('The Indian Express', 6.4),
('The Statesman', 8.6);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `DOB` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `Phone`, `DOB`) VALUES
('Karanveer Singh', 'Karan@123', '4545574865', '2021-10-05'),
('Lovish', 'Lovish@1', '7087309381', '2021-08-31'),
('Lovish Jindal', 'Lovish@1', '7087309381', '2021-08-30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`mobile`);

--
-- Indexes for table `hawkers`
--
ALTER TABLE `hawkers`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `papers`
--
ALTER TABLE `papers`
  ADD PRIMARY KEY (`paper`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
