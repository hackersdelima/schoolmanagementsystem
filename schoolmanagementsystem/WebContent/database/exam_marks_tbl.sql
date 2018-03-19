-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 19, 2018 at 11:29 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `aranikodb`
--

-- --------------------------------------------------------

--
-- Table structure for table `exam_marks_tbl`
--

CREATE TABLE IF NOT EXISTS `exam_marks_tbl` (
  `exammarksid` bigint(20) NOT NULL,
  `studentid` bigint(20) DEFAULT NULL,
  `examtype` varchar(50) DEFAULT NULL,
  `subjectid` bigint(20) DEFAULT NULL,
  `pmarks` varchar(10) DEFAULT NULL,
  `thmarks` varchar(10) DEFAULT NULL,
  `totalmarks` varchar(10) DEFAULT NULL,
  `totalgrade` varchar(10) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `reserved1` varchar(10) DEFAULT NULL,
  `reserved2` varchar(10) DEFAULT NULL,
  `reserved3` varchar(10) DEFAULT NULL,
  `reserved4` varchar(10) DEFAULT NULL,
  `reserved5` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `exam_marks_tbl`
--
ALTER TABLE `exam_marks_tbl`
  ADD PRIMARY KEY (`exammarksid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `exam_marks_tbl`
--
ALTER TABLE `exam_marks_tbl`
  MODIFY `exammarksid` bigint(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
