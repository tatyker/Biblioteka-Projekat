-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2019 at 05:44 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--
CREATE DATABASE IF NOT EXISTS `library` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `library`;

-- --------------------------------------------------------

--
-- Table structure for table `bibliotekar`
--

CREATE TABLE `bibliotekar` (
  `id` int(11) NOT NULL,
  `korisnicko_ime` varchar(48) NOT NULL,
  `sifra` varchar(48) NOT NULL,
  `ime` varchar(48) DEFAULT NULL,
  `prezime` varchar(48) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bibliotekar`
--

INSERT INTO `bibliotekar` (`id`, `korisnicko_ime`, `sifra`, `ime`, `prezime`) VALUES
(1, 'a', 'a', 'Tanja', 'Ker'),
(2, 'b', 'b', 'Bosa', ''),
(4, 'admin', '1', 'Administrator', NULL),
(6, 'c', 'c', 'Cica', 'C'),
(7, 'mona', 'm', 'Simona', 'Simic');

-- --------------------------------------------------------

--
-- Table structure for table `clanovi`
--

CREATE TABLE `clanovi` (
  `id` int(11) NOT NULL,
  `ime` varchar(48) NOT NULL,
  `prezime` varchar(48) NOT NULL,
  `br_dokumenta` varchar(48) NOT NULL,
  `adresa` varchar(48) NOT NULL,
  `grad` varchar(48) NOT NULL,
  `godina_rodj` int(4) NOT NULL,
  `pol` varchar(8) NOT NULL,
  `br_clanske` varchar(48) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clanovi`
--

INSERT INTO `clanovi` (`id`, `ime`, `prezime`, `br_dokumenta`, `adresa`, `grad`, `godina_rodj`, `pol`, `br_clanske`) VALUES
(1, 'Pera', 'Peric', '141411212', 'Sarajevska 22', 'Beograd', 1955, 'muski', '1/2018'),
(2, 'Mika', 'Mikic', '525235743', 'Beogradska 12', 'Beograd', 1967, 'muski', '2/2018'),
(3, 'Ana', 'Maric', '414142142', 'Ruzveltova 5', 'Beograd', 1987, 'zenski', '3/2018'),
(4, 'Maja', 'Simic', '243143181', 'Ivana Milutinovica 2', 'Beograd', 1991, 'zenski', '4/2018'),
(5, 'Jelena', 'Tosic', '439414153', 'Glavna 33', 'Novi Sad', 1988, 'zenski', '5/2018'),
(6, 'Tosa', 'Tosic', '1041049104', 'Zahumska 4', 'Beograd', 1977, 'muski', '1/2019'),
(7, 'Misa', 'Misic', '2423423423', 'Niska 33', 'Beograd', 1977, 'muski', '2/2019'),
(8, 'Marko', 'Ilic', '234141112', 'Zahumska 3', 'Beograd', 1921, 'muski', '3/2019'),
(9, 'Tina', 'Tinic', '234234241', 'Igmanska 22', 'Beograd', 1988, 'zenski', '4/2019'),
(10, 'Mirko', 'Mirkovic', '23-491-491', 'Ulica lipa 11', 'Subotica', 2000, 'ostalo', '5/2019'),
(11, 'Bosiljka', 'Popovic', '264637268', '27. marta 145', 'Beograd', 1949, 'zenski', '6/2019');

-- --------------------------------------------------------

--
-- Table structure for table `izdavanje`
--

CREATE TABLE `izdavanje` (
  `id` int(11) NOT NULL,
  `id_clan` int(11) NOT NULL,
  `id_knjiga` int(11) NOT NULL,
  `datum_izdavanja` date DEFAULT NULL,
  `datum_vracanja` date DEFAULT NULL,
  `id_status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `izdavanje`
--

INSERT INTO `izdavanje` (`id`, `id_clan`, `id_knjiga`, `datum_izdavanja`, `datum_vracanja`, `id_status`) VALUES
(1, 2, 1, '2018-12-13', '2019-01-11', 2),
(2, 1, 3, '2018-12-13', '2018-12-19', 2),
(3, 2, 4, '2018-12-14', '2018-12-27', 2),
(4, 2, 2, '2018-12-19', '2018-12-27', 2),
(5, 3, 3, '2018-12-27', '2018-12-27', 2),
(6, 4, 1, '2018-12-27', '2019-01-08', 2),
(7, 1, 2, '2018-12-27', '2019-01-09', 2),
(8, 4, 3, '2018-12-27', '2018-12-27', 2),
(9, 3, 5, '2018-12-27', '2019-01-14', 2),
(10, 4, 4, '2018-12-27', '2019-01-14', 2),
(11, 2, 6, '2018-12-27', '2019-01-14', 2),
(12, 5, 3, '2018-12-27', '2019-01-14', 2),
(13, 7, 1, '2019-01-08', '2019-01-14', 2),
(14, 6, 8, '2019-01-09', '2019-01-11', 2),
(15, 1, 1, '2019-01-09', '2019-01-14', 2),
(16, 8, 2, '2019-01-09', '2019-01-14', 2),
(17, 6, 9, '2019-01-11', '2019-01-14', 2),
(18, 7, 3, '2019-01-11', '2019-01-14', 2),
(19, 4, 5, '2019-01-11', NULL, 1),
(20, 11, 12, '2019-01-11', NULL, 1),
(21, 3, 6, '2019-01-11', '2019-01-14', 2),
(22, 4, 14, '2019-01-13', NULL, 1),
(23, 7, 16, '2019-01-14', NULL, 1),
(24, 3, 7, '2019-01-14', NULL, 1),
(25, 2, 11, '2019-01-14', NULL, 1),
(26, 1, 2, '2019-01-14', NULL, 1),
(27, 5, 10, '2019-01-14', NULL, 1),
(28, 8, 1, '2019-01-14', NULL, 1),
(29, 6, 8, '2019-01-14', NULL, 1),
(30, 10, 13, '2019-01-14', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `knjige`
--

CREATE TABLE `knjige` (
  `id` int(11) NOT NULL,
  `naziv` varchar(255) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `isbn` varchar(48) NOT NULL,
  `godina_izdanja` int(4) NOT NULL,
  `izdavac` varchar(100) NOT NULL,
  `zanr` varchar(48) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `knjige`
--

INSERT INTO `knjige` (`id`, `naziv`, `autor`, `isbn`, `godina_izdanja`, `izdavac`, `zanr`) VALUES
(1, 'Ubistvo je lako', 'Agata Kristi', '86-311-1995-1', 2005, 'Narodna knjiga', 'krimi'),
(2, 'Lovac na zmajeve', 'Haled Hoseini', '978-86-7436-502-1', 2009, 'Laguna', 'drama'),
(3, 'Herkulovi zadaci', 'Agata Kristi', '86-311-2175-1 (NK)', 2005, 'Narodna knjiga', 'krimi'),
(4, 'Utkani svet', 'Klajv Barker', '978-86-5567-444-3', 1989, 'Autorsko izdanje', 'fantastika'),
(5, 'Bogovi licno', 'Isak Asimov', '978-86-7702-149-8', 2010, 'Carobna knjiga', 'SF'),
(6, 'Nikadodjija', 'Nil Gejmen', '978-86-521-1327-9', 2013, 'Laguna', 'fantastika'),
(7, 'Vitez sedam kraljevstava', 'Dzordz R. R. Martin', '978-86-521-1708-6', 2014, 'Laguna', 'fantastika'),
(8, 'Nordijska mitologija', 'Nil Gejman', '978-86-521-2828-0', 2017, 'Laguna', 'mitologija'),
(9, 'Hobit', 'Dz.R.R. Tolkin', '86-7560-003-8', 2001, 'Solaris', 'fantastika'),
(10, 'Mandolina kapetana Korelija', 'Luj de Bernije', '978-86-521-5548-9', 2001, 'Plato', 'drama'),
(11, 'Dragulj Medine', 'Dzons Sheri', '978-86-87027-09-1', 2008, 'BeoBook', 'drama'),
(12, 'Zla kuca', 'Agata Kristi', '820-31', 1997, 'Narodna knjiga', 'krimi'),
(13, 'Arhangelsk', 'Robert Heris', '978-86-7436-653-0', 2007, 'Laguna', 'triler'),
(14, 'Ubiti pticu rugalicu', 'Harper Li', '820(73)-31', 2000, 'Plato', 'drama'),
(15, 'Bela tvrdjava', 'Orhan Pamuk', '86-83053-83-0', 2002, 'Geopoetika', 'drama'),
(16, 'Gordijev cvor', 'Berndhard Slink', '978-86-447-0473-7', 2009, 'Plato', 'drama'),
(17, 'Gospodin pogresni', 'Mirjana Bobic Mojsilovic', '978-86-7558-770-5', 2010, 'Autor / Cigoja / Ganesa klub', 'drama');

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id`, `status`) VALUES
(1, 'izdata'),
(2, 'vracena');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bibliotekar`
--
ALTER TABLE `bibliotekar`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UC_bibliotekar` (`korisnicko_ime`);

--
-- Indexes for table `clanovi`
--
ALTER TABLE `clanovi`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `izdavanje`
--
ALTER TABLE `izdavanje`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_clan` (`id_clan`),
  ADD KEY `id_knjiga` (`id_knjiga`),
  ADD KEY `id_status` (`id_status`);

--
-- Indexes for table `knjige`
--
ALTER TABLE `knjige`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bibliotekar`
--
ALTER TABLE `bibliotekar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `clanovi`
--
ALTER TABLE `clanovi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `izdavanje`
--
ALTER TABLE `izdavanje`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `knjige`
--
ALTER TABLE `knjige`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `izdavanje`
--
ALTER TABLE `izdavanje`
  ADD CONSTRAINT `izdavanje_ibfk_1` FOREIGN KEY (`id_clan`) REFERENCES `clanovi` (`id`),
  ADD CONSTRAINT `izdavanje_ibfk_2` FOREIGN KEY (`id_knjiga`) REFERENCES `knjige` (`id`),
  ADD CONSTRAINT `izdavanje_ibfk_3` FOREIGN KEY (`id_status`) REFERENCES `status` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
