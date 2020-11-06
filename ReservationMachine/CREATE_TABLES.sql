-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: reservationmachine
-- ------------------------------------------------------
-- Server version	5.7.31-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `IDA` varchar(15) NOT NULL,
  `MDPA` char(32) DEFAULT NULL,
  `EMAILA` char(32) DEFAULT NULL,
  `NOMA` char(32) DEFAULT NULL,
  `PRENOMA` char(32) DEFAULT NULL,
  PRIMARY KEY (`IDA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('1001','1001','A','AMBLARD','Frederic'),('1002','1002',NULL,'CUSSAT-BLANC','Slyvain');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appartenirg`
--

DROP TABLE IF EXISTS `appartenirg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appartenirg` (
  `IDE` varchar(15) NOT NULL,
  `IDG` int(11) NOT NULL,
  PRIMARY KEY (`IDE`,`IDG`),
  KEY `I_FK_APPARTENIRG_ETUDIANT` (`IDE`),
  KEY `I_FK_APPARTENIRG_GROUPE` (`IDG`),
  CONSTRAINT `FK_APPARTENIRG_ETUDIANT` FOREIGN KEY (`IDE`) REFERENCES `etudiant` (`IDE`),
  CONSTRAINT `FK_APPARTENIRG_GROUPE` FOREIGN KEY (`IDG`) REFERENCES `groupe` (`IDG`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appartenirg`
--

LOCK TABLES `appartenirg` WRITE;
/*!40000 ALTER TABLE `appartenirg` DISABLE KEYS */;
INSERT INTO `appartenirg` VALUES ('21809059',1),('21809060',1),('21809051',2),('21809061',2),('21900649',2);
/*!40000 ALTER TABLE `appartenirg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concerner`
--

DROP TABLE IF EXISTS `concerner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concerner` (
  `IDR` int(11) NOT NULL,
  `IDE` varchar(15) NOT NULL,
  `IDM` int(11) NOT NULL,
  PRIMARY KEY (`IDR`,`IDE`,`IDM`),
  KEY `I_FK_CONCERNER_RECLAMATION` (`IDR`),
  KEY `I_FK_CONCERNER_ETUDIANT` (`IDE`),
  KEY `I_FK_CONCERNER_MACHINE` (`IDM`),
  CONSTRAINT `FK_CONCERNER_ETUDIANT` FOREIGN KEY (`IDE`) REFERENCES `etudiant` (`IDE`),
  CONSTRAINT `FK_CONCERNER_MACHINE` FOREIGN KEY (`IDM`) REFERENCES `machine` (`IDM`),
  CONSTRAINT `FK_CONCERNER_RECLAMATION` FOREIGN KEY (`IDR`) REFERENCES `reclamation` (`IDR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concerner`
--

LOCK TABLES `concerner` WRITE;
/*!40000 ALTER TABLE `concerner` DISABLE KEYS */;
INSERT INTO `concerner` VALUES (1,'21809051',1),(2,'21809051',2),(3,'21809060',1),(4,'21809051',1);
/*!40000 ALTER TABLE `concerner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etudiant` (
  `IDE` varchar(15) NOT NULL,
  `MDPE` char(32) DEFAULT NULL,
  `EMAILE` char(32) DEFAULT NULL,
  `NOME` char(32) DEFAULT NULL,
  `PRENOME` char(32) DEFAULT NULL,
  `ETATE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etudiant`
--

LOCK TABLES `etudiant` WRITE;
/*!40000 ALTER TABLE `etudiant` DISABLE KEYS */;
INSERT INTO `etudiant` VALUES ('21600547','21600547','Jeanne','etu@mail.fr','DUPONT','attente'),('21809051','21809051','zsy@gmail.com','ZHOU','Siyuan','valide'),('21809059','21809059','rrh@gmail.com','REN','Ruohan','valide'),('21809060','21809060','rdy@gmail.com','REN','Deyi','valide'),('21809061','21809061','zxt@gmail.com','ZHANG','Xingtian','attente'),('21900649','21900649','axel.toa@ut-capitole.fr','TOA','Axel','valide');
/*!40000 ALTER TABLE `etudiant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formation`
--

DROP TABLE IF EXISTS `formation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formation` (
  `IDF` int(11) NOT NULL,
  `NOMF` char(32) DEFAULT NULL,
  PRIMARY KEY (`IDF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formation`
--

LOCK TABLES `formation` WRITE;
/*!40000 ALTER TABLE `formation` DISABLE KEYS */;
INSERT INTO `formation` VALUES (1,'M2-IPM'),(2,'M2-ISIAD');
/*!40000 ALTER TABLE `formation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupe` (
  `IDG` int(11) NOT NULL,
  `IDF` int(11) NOT NULL,
  `NOMG` char(32) DEFAULT NULL,
  PRIMARY KEY (`IDG`),
  KEY `I_FK_GROUPE_FORMATION` (`IDF`),
  CONSTRAINT `FK_GROUPE_FORMATION` FOREIGN KEY (`IDF`) REFERENCES `formation` (`IDF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupe`
--

LOCK TABLES `groupe` WRITE;
/*!40000 ALTER TABLE `groupe` DISABLE KEYS */;
INSERT INTO `groupe` VALUES (1,1,'TP1'),(2,1,'TP2');
/*!40000 ALTER TABLE `groupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `machine`
--

DROP TABLE IF EXISTS `machine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `machine` (
  `IDM` int(11) NOT NULL,
  `IDS` int(11) DEFAULT NULL,
  `NOMM` char(32) DEFAULT NULL,
  `ETATM` char(32) DEFAULT NULL,
  PRIMARY KEY (`IDM`),
  KEY `I_FK_MACHINE_SALLE` (`IDS`),
  CONSTRAINT `FK_MACHINE_SALLE` FOREIGN KEY (`IDS`) REFERENCES `salle` (`IDS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `machine`
--

LOCK TABLES `machine` WRITE;
/*!40000 ALTER TABLE `machine` DISABLE KEYS */;
INSERT INTO `machine` VALUES (1,1,'A13058','DISPONIBLE'),(2,1,'A13059','INDISPONIBLE'),(3,2,'A14056','HORS_SERVICE'),(4,3,'A15023','INDISPONIBLE'),(5,4,'A11078','DISPONIBLE'),(6,1,'A15022','DISPONIBLE'),(7,1,'A13060','DISPONIBLE'),(8,2,'A13061','DISPONIBLE'),(9,2,'A15024','DISPONIBLE'),(10,2,'A12033','DISPONIBLE'),(11,3,'A12034','DISPONIBLE'),(12,3,'A12035','DISPONIBLE'),(13,3,'A12036','DISPONIBLE'),(14,4,'A15026','DISPONIBLE'),(15,4,'A13022','DISPONIBLE'),(16,4,'A17069','DISPONIBLE'),(17,4,'A17070','DISPONIBLE'),(18,NULL,'A10236','INDISPONIBLE'),(19,NULL,'A12345','INDISPONIBLE');
/*!40000 ALTER TABLE `machine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reclamation` (
  `IDR` int(11) NOT NULL,
  `TYPER` char(32) DEFAULT NULL,
  `DESCRIPTIONR` char(255) DEFAULT NULL,
  `ETATR` char(20) DEFAULT NULL,
  PRIMARY KEY (`IDR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reclamation`
--

LOCK TABLES `reclamation` WRITE;
/*!40000 ALTER TABLE `reclamation` DISABLE KEYS */;
INSERT INTO `reclamation` VALUES (1,'En_panne','Je ne peux pas me connecter','EN_COURS'),(2,'En_panne','Mysql marche pas dans cette machine','TRAITEE'),(3,'Deja_reserve','c\'est l\'heure de ma reservation,mais il y a une autre etudiant','TRAITEE'),(4,'En_panne','La machine est en panne !','EN_COURS');
/*!40000 ALTER TABLE `reclamation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserverm`
--

DROP TABLE IF EXISTS `reserverm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserverm` (
  `IDE` varchar(15) NOT NULL,
  `IDM` int(11) NOT NULL,
  `HEUREDEBUTM` time NOT NULL,
  `DATEM` date NOT NULL,
  `HEUREFINM` time DEFAULT NULL,
  PRIMARY KEY (`IDE`,`IDM`,`HEUREDEBUTM`,`DATEM`),
  KEY `I_FK_RESERVERM_ETUDIANT` (`IDE`),
  KEY `I_FK_RESERVERM_MACHINE` (`IDM`),
  CONSTRAINT `FK_RESERVERM_ETUDIANT` FOREIGN KEY (`IDE`) REFERENCES `etudiant` (`IDE`),
  CONSTRAINT `FK_RESERVERM_MACHINE` FOREIGN KEY (`IDM`) REFERENCES `machine` (`IDM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserverm`
--

LOCK TABLES `reserverm` WRITE;
/*!40000 ALTER TABLE `reserverm` DISABLE KEYS */;
INSERT INTO `reserverm` VALUES ('21809051',1,'09:30:00','2020-11-03','12:00:00'),('21809051',15,'13:05:00','2020-11-06','18:05:00'),('21809059',9,'08:15:00','2020-11-04','10:30:00'),('21809059',11,'08:15:00','2020-11-02','10:30:00'),('21809060',1,'12:00:00','2020-11-03','16:00:00'),('21809060',3,'17:00:00','2020-11-03','17:30:00'),('21900649',4,'08:30:00','2020-10-29','10:45:00'),('21900649',5,'08:30:00','2020-10-26','10:45:00'),('21900649',10,'08:30:00','2020-10-28','10:45:00');
/*!40000 ALTER TABLE `reserverm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservers`
--

DROP TABLE IF EXISTS `reservers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservers` (
  `HEUREDEBUTS` time NOT NULL,
  `DATES` date NOT NULL,
  `IDResp` varchar(15) NOT NULL,
  `IDS` int(11) NOT NULL,
  `HEUREFINS` time DEFAULT NULL,
  `NOMTP` char(32) DEFAULT NULL,
  `IDG` int(11) NOT NULL,
  PRIMARY KEY (`HEUREDEBUTS`,`DATES`,`IDResp`,`IDS`,`IDG`),
  KEY `I_FK_RESERVERS_CALENDS` (`HEUREDEBUTS`,`DATES`),
  KEY `I_FK_RESERVERS_RESPTP` (`IDResp`),
  KEY `I_FK_RESERVERS_SALLE` (`IDS`),
  KEY `I_FK_RESERVERS_GROUPE` (`IDG`),
  CONSTRAINT `FK_RESERVERS_GROUPE` FOREIGN KEY (`IDG`) REFERENCES `groupe` (`IDG`),
  CONSTRAINT `FK_RESERVERS_RESPTP` FOREIGN KEY (`IDResp`) REFERENCES `resptp` (`IDResp`),
  CONSTRAINT `FK_RESERVERS_SALLE` FOREIGN KEY (`IDS`) REFERENCES `salle` (`IDS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservers`
--

LOCK TABLES `reservers` WRITE;
/*!40000 ALTER TABLE `reservers` DISABLE KEYS */;
INSERT INTO `reservers` VALUES ('08:00:00','2020-11-06','1',4,'09:30:00','Programmation',1),('14:00:00','2020-10-23','2',3,'18:00:00','Programmation',2);
/*!40000 ALTER TABLE `reservers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resptp`
--

DROP TABLE IF EXISTS `resptp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resptp` (
  `IDResp` varchar(15) NOT NULL,
  `MDPR` char(32) DEFAULT NULL,
  `EMAILR` char(32) DEFAULT NULL,
  `NOMR` char(32) DEFAULT NULL,
  `PRENOMR` char(32) DEFAULT NULL,
  PRIMARY KEY (`IDResp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resptp`
--

LOCK TABLES `resptp` WRITE;
/*!40000 ALTER TABLE `resptp` DISABLE KEYS */;
INSERT INTO `resptp` VALUES ('1','111','ravat@gmail.com','RAVAT','Franck'),('2','222','valles@gmail.com','VALLES','Natalie');
/*!40000 ALTER TABLE `resptp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salle` (
  `IDS` int(11) NOT NULL,
  `NOMS` char(32) DEFAULT NULL,
  PRIMARY KEY (`IDS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salle`
--

LOCK TABLES `salle` WRITE;
/*!40000 ALTER TABLE `salle` DISABLE KEYS */;
INSERT INTO `salle` VALUES (1,'ME405'),(2,'ME407'),(3,'ME410'),(4,'ME401');
/*!40000 ALTER TABLE `salle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traiter`
--

DROP TABLE IF EXISTS `traiter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `traiter` (
  `IDA` varchar(15) NOT NULL,
  `IDR` int(11) NOT NULL,
  PRIMARY KEY (`IDA`,`IDR`),
  KEY `I_FK_TRAITER_ADMIN` (`IDA`),
  KEY `I_FK_TRAITER_RECLAMATION` (`IDR`),
  CONSTRAINT `FK_TRAITER_ADMIN` FOREIGN KEY (`IDA`) REFERENCES `admin` (`IDA`),
  CONSTRAINT `FK_TRAITER_RECLAMATION` FOREIGN KEY (`IDR`) REFERENCES `reclamation` (`IDR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traiter`
--

LOCK TABLES `traiter` WRITE;
/*!40000 ALTER TABLE `traiter` DISABLE KEYS */;
INSERT INTO `traiter` VALUES ('1001',1),('1001',2),('1001',3);
/*!40000 ALTER TABLE `traiter` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-06 13:30:01
