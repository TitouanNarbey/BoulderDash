-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 03 juin 2019 à 16:55
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jpublankproject`
--

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

CREATE TABLE `map` (
  `ID` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `content` text NOT NULL,
  `diamond` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `map`
--

INSERT INTO `map` (`ID`, `width`, `height`, `content`, `diamond`) VALUES
(1, 56, 40, 'BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPP   PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPP _ PPPPPPPPPPPPPPPPRPPPPPPPPPBBBBBBBBBBBBBBBBPPPPPB\r\nBPPPP   PPPPPPPPPPPPPPPPPPPPPPPPPPBRRRRRRRRRRRRRRBPPP PB\r\nBPPPP D PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPDPPPPPPPPP PB\r\nBPPPP B PPPPPBPPPPPPPPPPPPPPPPPPPPBRRRRRRRRRRRRRRBPPP PB\r\nBPPPP P PPPPPPPPPPPPPPPPPPPPPPPPPPBBBBBBBBBBBBBBBBPPPPPB\r\nBPPPP P PPPPPPPPPPPPPPPPPPPPPRPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPP   PPPPRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPB BPPPRRRPPPPPRPPPPPPPPPPPPBPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPBPPPRRRRRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPP   PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPRPPPPPB\r\nBPPPPPPPPPP D PPPPPPPPPPPPPPPPPPPPPPPPPPPPPRPPPPPPPPPPPB\r\nBPPPPPPPPPP P PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPRPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPBPPPPPPPPPPPPRBBBBBRPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPRB   BRPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP D PPPPPPPPPB\r\nBPPPPPPPRPPPPPPPPPPBPPPPPPPPPPPPPPPPPPPPPBB P BBPPPPPPPB\r\nBPPPPRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPBBBBBPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPRPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPBPPPPRPPPPPPPPB\r\nBPPPPPPPPPPRRPRRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPRBPBRPPPPPPPRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPB   BPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPB D BPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPRPPPPPB P BPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP   PPPPB\r\nBPPPPPPPPPPBBBBBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP E PPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP   PPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPRPPPPPPPPPPPPPPPPPPPPPB\r\nBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB', 5),
(2, 50, 50, 'BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPP_PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPRRRRPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPRRDPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPDRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPRRRRRPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPDPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPRRRRPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPDDPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPRRRRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPRDDPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPRRRRRRRPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPDDPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPRRRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPRDPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPRRRRPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPDDRPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP E PPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB', 12),
(3, 50, 40, 'BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPRRRPPPPPPPPPPPPPPPPB\r\nBPPPPPPP_PPPPPPPPPPPPPPPPPPPPPRDPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPRDRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPRPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPRRRRRPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPDRRPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPBBBBBBBBBBPPPPPPPB\r\nBPPPPPPPPPRRRRPPPPPPPPPPPPPPPPPPB RRRRRR BPPPPPPPB\r\nBPPPPPPPPPRDDRPPPPPPPPPPPPPPPPPPP PPDDPP BPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPBBBBBBBBBBPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPBBBBBBBBBBPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPB  RRRRR BPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPB  PDDPP PPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPBBBBBBBBBBPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPRRRRPPPPPPPPPPPPPPPPPPPPPPPPPPRRRPPPPPPPPPB\r\nBPPPPPPBDDRPPPPPPPPPPPPPPPPPPPPPPPPPPRDPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP E PPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPB\r\nBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB', 12),
(4, 20, 20, 'BBBBBBBBBBBBBBBBBBBB\r\nBPP_PPPPPPPPPPRRRRPB\r\nBPPPPPPPPPPPPPRDDRPB\r\nBPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPB\r\nBPPP    PPPPPPPPPPPB\r\nBPPP  T PPPPPPPPPPPB\r\nBPPP    PPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPPPRRRRPPPPPB\r\nBPPPPPPPPPPDPRPPPPPB\r\nBPPPPPPPPPRRRRPPPPPB\r\nBPPPPPPPPPPPPPPPPPPB\r\nBPPPPPPPP    PPPPPPB\r\nBPPPPPPPP  C PPPPPPB\r\nBPPPPPPPP    PPPPPPB\r\nBPPP    PPPPPPPPPPPB\r\nBPPP  O PPPPPPPPPPPB\r\nBPPPPPPPPPPPPPPPEPPB\r\nBBBBBBBBBBBBBBBBBBBB', 7),
(5, 19, 20, 'BBBBBBBBBBBBBBBBBBB\r\nBPP_PPPBRRRRRBPPPPB\r\nBPPPPPPBRDRDRBPPPPB\r\nBPPPPPPPPPPPPPPPPPB\r\nBBP C P   P   P T B\r\nBPPPPPPPPPPPPPPPPPB\r\nBBBBBBBBBBBBBBBPPPB\r\nBPRPRRRRRPRPPPPPPPB\r\nBPPPPBDBDBPPPPPPPPB\r\nBPPPPPBPBPPPPPPPPPB\r\nBP PPPPPPP PPPPPPPB\r\nBP PPPPPPPOPPPPPPPB\r\nBP PPPPPPP PPPPPPPB\r\nBPPPPPPPPPPPPPPPPPB\r\nBBBBBBRPPPPPPPPPPPB\r\nBDPPPPRRPPPPPPPPPPB\r\nBDPPPPRRRPPPPPPPPPB\r\nBBBBBBBPPPPPPPPPPPB\r\nBPPPPPPPPPPPPPEPPPB\r\nBBBBBBBBBBBBBBBBBBB', 15);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `map`
--
ALTER TABLE `map`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `map`
--
ALTER TABLE `map`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
