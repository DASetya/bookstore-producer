-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 14, 2021 at 03:02 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `enigma_book_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `mst_book`
--

CREATE TABLE `mst_book` (
  `id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `year` int(4) NOT NULL,
  `page` int(4) NOT NULL,
  `language` varchar(20) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mst_book`
--

INSERT INTO `mst_book` (`id`, `title`, `description`, `publisher`, `year`, `page`, `language`, `stock`, `price`) VALUES
(1, 'Pemrograman Berorientasi Object Bagian 2', 'PBO adalah salah satu prinsip dalam bahasa pemrograman', 'PT Enigma Cipta Humanika', 2021, 150, 'Indonesia', 95, 50000),
(2, 'Pemrograman Berorientasi Object Bagian 3', 'PBO adalah salah satu prinsip dalam bahasa pemrograman', 'PT Enigma Cipta Humanika', 2021, 90, 'Indonesia', 100, 50000),
(3, 'Book A', 'Book A is', 'Publisher A', 2018, 250, 'English', 3, 1125000),
(4, 'Book B ', 'Book B is', 'Publisher B', 2020, 90, 'Indonesia', 4, 155000),
(5, 'Book C ', 'Book C is', 'Publisher A', 2019, 890, 'Indonesia', 4, 155000),
(6, 'Book D ', 'Book D is', 'Publisher B', 2018, 190, 'English', 4, 255000),
(7, 'Book E ', 'Book E is', 'Publisher C', 2021, 220, 'Indonesia', 4, 55000),
(8, 'F', 'book F is', 'Enigma', 2021, 75, '', 100, 50000),
(10, 'Rembulan terapung', 'apa aja', 'Erlangga', 2002, 200, 'Indonesia', 5, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `mst_member`
--

CREATE TABLE `mst_member` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mst_member`
--

INSERT INTO `mst_member` (`id`, `first_name`, `last_name`, `email`, `username`, `password`) VALUES
(1, 'Jane', 'Jane', 'janejane@gmail.com', 'janejane', 'password'),
(2, 'Luke', 'Aiden', 'luke.aiden@gmail.com', 'luke123', 'aa30a972-1375-11ec-ba29-8030497dcb18'),
(3, 'Inez', 'Amanda', 'inez.amanda16@gmail.com', 'bni_intern_inez', 'password'),
(4, 'Aithra', 'Bouty', 'aithrabouty@gmail.com', 'bni_intern_aithra', 'password'),
(5, 'Alfian', 'Hidayat', 'hidayatullohalfian@gmail.com', 'bni_intern_alfian', 'password'),
(6, 'Dimas', 'Arif', '18081010093@student.upnjatim.ac.id', 'bni_intern_dimas', 'password'),
(7, 'Haura', 'Salka', 'haura.athaya@gmail.com', 'bni_intern_haura', 'password'),
(8, 'Tes', 'Update', 'tesupdate@gmail.com', 'tes', 'default'),
(10, 'Tes', 'Insert', 'tesinsert@gmail.com', 'tesinsert', 'default');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `date`, `member_id`, `book_id`, `qty`, `total`) VALUES
(1, '2021-09-08', 1, 2, 5, 250000),
(2, '2021-09-08', 1, 1, 4, 200000),
(8, '2021-09-06', 4, 4, 2, 110000),
(9, '2021-09-06', 4, 4, 1, 55000),
(10, '2021-09-07', 4, 4, 1, 155000),
(11, '2021-09-07', 4, 6, 3, 465000),
(12, '2021-09-08', 4, 7, 3, 765000),
(14, '2021-09-12', 7, 1, 5, 250000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mst_book`
--
ALTER TABLE `mst_book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mst_member`
--
ALTER TABLE `mst_member`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `member_id` (`member_id`),
  ADD KEY `book_id` (`book_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mst_book`
--
ALTER TABLE `mst_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `mst_member`
--
ALTER TABLE `mst_member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `mst_member` (`id`),
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `mst_book` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
