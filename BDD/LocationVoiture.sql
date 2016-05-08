-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 08, 2016 at 12:54 AM
-- Server version: 5.7.9
-- PHP Version: 5.5.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `LocationVoiture`
--

-- --------------------------------------------------------

--
-- Table structure for table `Emprunteur`
--

CREATE TABLE `Emprunteur` (
  `ID` int(11) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `Adresse` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Emprunteur`
--

INSERT INTO `Emprunteur` (`ID`, `Nom`, `Prenom`, `Adresse`) VALUES
(1, 'Soares', 'Edouard', '1 villas de l''Ermitage, Bois d''Arcy, FRANCE'),
(2, 'Rouanet', 'Ronan', '4 allée des platanes, Lyon, FRANCE'),
(3, 'Garnier', 'Florian', '3 rue des pétunias, Sartrouville, France'),
(4, 'Hache', 'Sylvain', '43 Avenue de la république, Paris, France'),
(5, 'Duval', 'Franklin', '56 rue de la paroisse, Levallois-Perret, France'),
(6, 'Benelli', 'Mario', '29, via santa caterina, San Vincenzo, Italia'),
(7, 'Parker', 'Peter', '25 bis, 5th Avenue, New York City, USA'),
(8, 'Fox', 'Adelaide', '67 Franklin street, Boulder, USA'),
(9, 'Marquez', 'Marc', '45 calle de los Hermanos, Nerja, Espana'),
(10, 'Dupont', 'Jean', '57 allée du mystère, Paris, France'),
(11, 'Dupont', 'Albert', '57 allée du mystère, Montpellier, France'),
(12, 'Holmes', 'Sherlock', '22 baker''s street, London, UK'),
(13, 'Jaques', 'Michelle', '65 rue de la paix, Baden, France'),
(14, 'Roels', 'Clément', '7 rue d''Alesia, Paris, France'),
(15, 'Petit', 'Mehdi', '59 rue du général De Gaulle, Bordeaux, France '),
(16, 'Cathala', 'Théophile', '59 boulevard des militaires, Bordeaux, France'),
(17, 'Nitrosso', 'Joachim', 'Quelque part perdu dans la campagne, Uruguay'),
(18, 'Nairi', 'Loic', '85 avenue de Rouen, Paris, France'),
(19, 'Bourgeaux', 'Benjamin', 'Allée des bouquetins, Mont-Saxonnex, France'),
(20, 'Carpuat', 'Guillaume', '3 allée des sardines, Marseille, France'),
(21, 'Carbonnel', 'Guillaume', '52 rue du jambon, Pau, France'),
(22, 'De Champs', 'Thomas', '59 rue de la buse, Limoges, France'),
(23, 'Boitel-Denyset', 'Valentin', '79 boulevard des réfugiés, Paris, France'),
(24, 'Lesnar', 'Brock', '79 Rockhead street, Los Angeles, USA'),
(25, 'St-Pierre', 'Georges', '94 Avenue de la paix, Montréal, Canada'),
(26, 'Lacroix', 'Mathilde', '29 rue des tilleuls, Sceaux, France'),
(27, 'Grant', 'Hugh', '79 rollover street, London, UK'),
(28, 'Depré', 'Julien', '4 avenue Victor Hugo, PAris, France'),
(29, 'Stark', 'Tony', 'Stark building, Los Angeles, USA'),
(33, 'InShape', 'Tibo', '4 rue de la veine du bibi, Toulouse, France'),
(34, 'Barbot', 'Hervé', '1 rue de la danse, Paris, France'),
(35, 'Man', 'Béatrice', '5 avenue de la paix, Paris, France');

-- --------------------------------------------------------

--
-- Table structure for table `Exemplaires`
--

CREATE TABLE `Exemplaires` (
  `ID` int(11) NOT NULL,
  `Immatriculation` varchar(10) NOT NULL,
  `Marque` varchar(20) NOT NULL,
  `Type` varchar(10) NOT NULL,
  `Cylindree` int(11) DEFAULT NULL,
  `Modele` varchar(20) DEFAULT NULL,
  `Kilometrage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Exemplaires`
--

INSERT INTO `Exemplaires` (`ID`, `Immatriculation`, `Marque`, `Type`, `Cylindree`, `Modele`, `Kilometrage`) VALUES
(1, 'AS-033-GT', 'Peugeot', 'Auto', NULL, '206', 88000),
(2, 'DF-675-FF', 'Peugeot', 'Auto', NULL, '206', 125000),
(4, 'SX-546-GT', 'Peugeot', 'Auto', NULL, '308', 55000),
(7, 'GT-875-KL', 'Peugeot', 'Auto', NULL, '508', 99000),
(8, 'GG-984-IO', 'Peugeot', 'Auto', NULL, '508', 17000),
(9, 'FR-762-JH', 'Peugeot', 'Auto', NULL, '508', 177000),
(10, 'KJ-096-LK', 'Peugeot', 'Auto', NULL, '807', 97000),
(11, 'HJ-983-JN', 'Peugeot', 'Auto', NULL, '807', 175000),
(12, 'HG-966-LM', 'Peugeot', 'Auto', NULL, '807', 13000),
(13, 'KI-099-NJ', 'Renault', 'Auto', NULL, 'Clio', 56000),
(15, 'HH-645-YY', 'Renault', 'Auto', NULL, 'Clio', 140000),
(16, 'FR-563-TG', 'Renault', 'Auto', NULL, 'Twingo', 87000),
(17, 'GT-785-DX', 'Renault', 'Auto', NULL, 'Twingo', 134000),
(18, 'SE-896-JU', 'Renault', 'Auto', NULL, 'Twingo', 10000),
(19, 'FR-762-RD', 'Renault', 'Auto', NULL, 'Koleos', 86000),
(20, 'TT-907-OI', 'Renault', 'Auto', NULL, 'Koleos', 9000),
(22, 'QZ-341-CF', 'Renault', 'Auto', NULL, 'Laguna', 76000),
(23, 'SQ-451-GT', 'Renault', 'Auto', NULL, 'Laguna', 19000),
(24, 'DH-671-ND', 'Renault', 'Auto', NULL, 'Laguna', 145000),
(25, 'GG-769-FL', 'BMW', 'Auto', NULL, '535i', 96000),
(27, 'BB-769-HT', 'BMW', 'Auto', NULL, '535i', 1000),
(28, 'FF-769-GG', 'BMW', 'Auto', NULL, '320d', 46000),
(31, 'GY-863-NN', 'BMW', 'Auto', NULL, 'M5', 6000),
(32, 'GG-983-KK', 'BMW', 'Auto', NULL, 'M5', 9000),
(36, 'GB-730-LM', 'Mercedes-Benz', 'Auto', NULL, 'SLS-AMG', 7000),
(37, 'MA-619-UJ', 'Mercedes-Benz', 'Auto', NULL, 'Classe C', 56000),
(38, 'LU-382-GF', 'Mercedes-Benz', 'Auto', NULL, 'Classe C', 149000),
(39, 'GC-354-VF', 'Mercedes-Benz', 'Auto', NULL, 'Classe C', 87000),
(40, 'VH-428-YH', 'Chevrolet', 'Auto', NULL, 'Corvette', 16000),
(41, 'ND-629-NH', 'Chevrolet', 'Auto', NULL, 'Corvette', 79000),
(42, 'FG-619-ST', 'Chevrolet', 'Auto', NULL, 'Corvette', 37000),
(43, 'GT-672-SX', 'Ford', 'Auto', NULL, 'Focus RS', 46000),
(44, 'SF-328-NC', 'Ford', 'Auto', NULL, 'Focus RS', 129000),
(45, 'TG-721-JN', 'Ford', 'Auto', NULL, 'Focus RS', 77000),
(49, 'GH-657-QD', 'Toyota', 'Auto', NULL, 'Rav4', 76000),
(50, 'QJ-833-KN', 'Toyota', 'Auto', NULL, 'Rav4', 139000),
(51, 'GY-736-HB', 'Toyota', 'Auto', NULL, 'Rav4', 78000),
(52, 'VT-735-LL', 'Toyota', 'Auto', NULL, 'Prius', 176000),
(53, 'VD-732-GA', 'Toyota', 'Auto', NULL, 'Prius', 19000),
(54, 'AG-663-SQ', 'Toyota', 'Auto', NULL, 'Prius', 128000),
(55, 'WS-621-SA', 'Nissan', 'Auto', NULL, 'Micra', 66000),
(56, 'WN-672-GG', 'Nissan', 'Auto', NULL, 'Micra', 119000),
(57, 'SS-836-PK', 'Nissan', 'Auto', NULL, 'Micra', 7000),
(58, 'PE-936-JN', 'Nissan', 'Auto', NULL, 'GT-R', 16000),
(60, 'QO-832-HY', 'Nissan', 'Auto', NULL, 'GT-R', 75000),
(63, 'GF-629-BH', 'Porsche', 'Auto', NULL, 'Cayenne', 8000),
(64, 'TG-735-DF', 'Land Rover', 'Auto', NULL, 'Range-Rover', 66000),
(66, 'VD-651-HV', 'Land Rover', 'Auto', NULL, 'Range-Rover', 78000),
(67, 'GS-721-KU', 'Honda', 'Moto', 600, NULL, 12000),
(68, 'UD-736-VA', 'Honda', 'Moto', 600, NULL, 22000),
(69, 'AG-736-BV', 'Honda', 'Moto', 600, NULL, 1000),
(70, 'CO-835-OQ', 'Honda', 'Moto', 1000, NULL, 2000),
(71, 'BY-732-CC', 'Honda', 'Moto', 11000, NULL, 22000),
(72, 'BT-991-KQ', 'Honda', 'Moto', 1000, NULL, 15000),
(73, 'QJ-834-FF', 'Honda', 'Moto', 1300, NULL, 62000),
(74, 'SS-965-PL', 'Honda', 'Moto', 1300, NULL, 42000),
(75, 'HH-733-YY', 'Honda', 'Moto', 1300, NULL, 10000),
(76, 'JU-937-JH', 'Triumph', 'Moto', 675, NULL, 15000),
(77, 'FW-243-NY', 'Triumph', 'Moto', 675, NULL, 44000),
(79, 'CF-935-KH', 'Ducati', 'Moto', 646, NULL, 19000),
(80, 'UJ-357-FB', 'Ducati', 'Moto', 646, NULL, 28000),
(81, 'BR-741-RC', 'Ducati', 'Moto', 646, NULL, 31000),
(82, 'RJ-921-SI', 'Ducati', 'Moto', 848, NULL, 17000),
(83, 'FI-835-VV', 'Ducati', 'Moto', 848, NULL, 68000),
(84, 'WO-621-JU', 'Ducati', 'Moto', 848, NULL, 41000),
(85, 'VR-760-MN', 'Ducati', 'Moto', 1199, NULL, 29000),
(87, 'IH-991-TT', 'Ducati', 'Moto', 1199, NULL, 13000),
(88, 'TZ-238-VR', 'Kawazaki', 'Moto', 750, NULL, 29000),
(89, 'ZY-873-YZ', 'Kawazaki', 'Moto', 750, NULL, 38000),
(90, 'BT-936-IO', 'Kawazaki', 'Moto', 750, NULL, 21000),
(91, 'HH-211-OP', 'Kawazaki', 'Moto', 1000, NULL, 3000),
(92, 'PO-783-UY', 'Kawazaki', 'Moto', 1000, NULL, 58000),
(99, 'GF-936-LK', 'Peugeot', 'Auto', NULL, '308', 125000),
(106, 'UJ-904-JN', 'BMW', 'Auto', NULL, '320d', 76000),
(108, 'BD-896-JU', 'Renault', 'Auto', NULL, 'Koleos', 45000),
(125, 'BT-987-LM', 'Porsche', 'Auto', NULL, 'Panamera', 9000),
(126, 'DR-654-BN', 'Porsche', 'Auto', NULL, 'Panamera', 56000),
(128, 'VB-134-XW', 'Porsche', 'Auto', NULL, 'Panamera', 35000),
(135, 'HY-953-DR', 'Renault', 'Auto', NULL, 'Clio', 90000),
(136, 'NA-781-AM', 'Ducati', 'Moto', 1199, NULL, 58000),
(137, 'DE-562-HY', 'BMW', 'Auto', NULL, 'M5', 9000),
(138, 'TD-539-NH', 'Porsche', 'Auto', NULL, 'Cayenne', 45000),
(139, 'BT-908-IO', 'Mercedes-Benz', 'Auto', NULL, 'SLS-AMG', 70000);

-- --------------------------------------------------------

--
-- Table structure for table `Transactions`
--

CREATE TABLE `Transactions` (
  `ID` int(11) NOT NULL,
  `Date_debut` date NOT NULL,
  `Date_fin` date NOT NULL,
  `Statut` tinyint(1) NOT NULL,
  `Immatriculation` varchar(10) NOT NULL,
  `Emprunteur_nom` varchar(10) NOT NULL,
  `Emprunteur_prenom` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Transactions`
--

INSERT INTO `Transactions` (`ID`, `Date_debut`, `Date_fin`, `Statut`, `Immatriculation`, `Emprunteur_nom`, `Emprunteur_prenom`) VALUES
(7, '2016-05-10', '2016-05-30', 0, 'AZ-672-JH', 'Petit', 'Mehdi'),
(8, '2016-05-10', '2016-06-20', 0, 'DH-739-BV', 'St-Pierre', 'Georges'),
(9, '2016-05-12', '2016-06-03', 0, 'TY-900-PM', 'Duval', 'Franklin'),
(10, '2016-05-10', '2016-05-12', 0, 'DG-782-HB', 'Holmes', 'Sherlock'),
(11, '2016-05-10', '2016-05-12', 0, 'IO-123-UI', 'Soares', 'Edouard'),
(12, '2016-05-10', '2016-05-20', 0, 'HY-953-DR', 'Soares', 'Edouard'),
(13, '2016-05-15', '2016-06-10', 0, 'NA-781-AM', 'Garnier', 'Florian'),
(14, '2016-05-01', '2016-05-08', 0, 'DE-562-HY', 'Soares', 'Edouard'),
(15, '2016-05-01', '2016-05-07', 0, 'TD-539-NH', 'Benelli', 'Mario'),
(16, '2016-01-23', '2016-05-04', 0, 'BT-908-IO', 'Lacroix', 'Mathilde');

-- --------------------------------------------------------

--
-- Table structure for table `Vehicules`
--

CREATE TABLE `Vehicules` (
  `ID` int(11) NOT NULL,
  `Marque` varchar(20) NOT NULL,
  `Type` varchar(10) NOT NULL,
  `Cylindree` int(11) DEFAULT NULL,
  `Modele` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Vehicules`
--

INSERT INTO `Vehicules` (`ID`, `Marque`, `Type`, `Cylindree`, `Modele`) VALUES
(1, 'Peugeot', 'Auto', NULL, '206'),
(2, 'Peugeot', 'Auto', NULL, '308'),
(3, 'Peugeot', 'Auto', NULL, '508'),
(4, 'Peugeot', 'Auto', NULL, '807'),
(5, 'Renault', 'Auto', NULL, 'Clio'),
(6, 'Renault', 'Auto', NULL, 'Twingo'),
(7, 'Renault', 'Auto', NULL, 'Koleos'),
(8, 'Renault', 'Auto', NULL, 'Laguna'),
(9, 'BMW', 'Auto', NULL, '535i'),
(10, 'BMW', 'Auto', NULL, '320d'),
(11, 'BMW', 'Auto', NULL, 'M5'),
(12, 'Mercedes-Benz', 'Auto', NULL, 'SLS-AMG'),
(13, 'Mercedes-Benz', 'Auto', NULL, 'Classe C'),
(14, 'Chevrolet', 'Auto', NULL, 'Corvette'),
(15, 'Ford', 'Auto', NULL, 'Focus RS'),
(16, 'Porsche', 'Auto', NULL, 'Panamera'),
(17, 'Toyota', 'Auto', NULL, 'Rav4'),
(18, 'Toyota', 'Auto', NULL, 'Prius'),
(19, 'Nissan', 'Auto', NULL, 'Micra'),
(20, 'Nissan', 'Auto', NULL, 'GT-R'),
(21, 'Porsche', 'Auto', NULL, 'Cayenne'),
(22, 'Land Rover', 'Auto', NULL, 'Range-Rover'),
(23, 'Honda', 'Moto', 600, NULL),
(24, 'Honda', 'Moto', 1000, NULL),
(25, 'Honda', 'Moto', 1300, NULL),
(26, 'Triumph', 'Moto', 675, NULL),
(27, 'Ducati', 'Moto', 646, NULL),
(28, 'Ducati', 'Moto', 848, NULL),
(29, 'Ducati', 'Moto', 1199, NULL),
(30, 'Kawazaki', 'Moto', 750, NULL),
(31, 'Kawazaki', 'Moto', 1000, NULL),
(32, 'Yamaha', 'Moto', 1000, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Emprunteur`
--
ALTER TABLE `Emprunteur`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Emprunteur_Adresse_uindex` (`Adresse`);

--
-- Indexes for table `Exemplaires`
--
ALTER TABLE `Exemplaires`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Immatriculation` (`Immatriculation`);

--
-- Indexes for table `Transactions`
--
ALTER TABLE `Transactions`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Vehicules`
--
ALTER TABLE `Vehicules`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Emprunteur`
--
ALTER TABLE `Emprunteur`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;
--
-- AUTO_INCREMENT for table `Exemplaires`
--
ALTER TABLE `Exemplaires`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=140;
--
-- AUTO_INCREMENT for table `Transactions`
--
ALTER TABLE `Transactions`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `Vehicules`
--
ALTER TABLE `Vehicules`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
