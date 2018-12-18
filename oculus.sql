-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `project`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `project` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `project`;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `ID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL DEFAULT 'unknown',
  `Number_Of_Pages` int(11) NOT NULL DEFAULT '1',
  `Release_Year` year(4) NOT NULL DEFAULT '2018',
  `Author` varchar(45) NOT NULL DEFAULT 'unknown',
  `Issue_number` int(11) NOT NULL DEFAULT '1',
  `Is_Favourite` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NONCLUSTERED` (`Name`,`Author`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Mustafa Kemal',498,2018,'Yılmaz Özdil',1,0),(2,'Beraber Yürüttük Biz bu Yıllarda',331,2015,'Yılmaz Özdil',3,0),(3,'Türkiye-Avrupa Birliği ilişkileri',768,2006,'',21,0),(4,'İsim ',475,2014,'Yılmaz Özdil',1,0),(5,'Kırmızı ve Siyah',681,2013,'Stendhal',13,0),(6,'Uyurgezer',333,2009,'Jonathan Barnes',1,0),(7,'Ana',408,2011,'Gorki',7,0),(8,'Türkiyenin Dış politika Gündemi',291,2001,'',1,0),(9,'Stratejik Derinlik',563,2001,'Ahmet Davutoğlu',1,0),(10,'İncir Kuşları',159,2012,'Sinan Akyüz',26,0),(11,'Gölgeler',101,2018,'Zülfü Livaneli',1,0),(12,'Tanrının Tarihi',608,2017,'Karen Armstrong',2,0),(13,'Büyük Tasarım',161,2012,'Stephan Hawking',7,0),(14,'Engereğin Gözü',147,2011,'Zülfü Livaneli',26,0),(15,'Galat-ı Meşhur',471,2016,'Soner Yalçın',1,0),(16,'Sevmek Dokunmaktır',295,1985,'Desmond Morris',2,0),(17,'Köşkteki Esrar',288,2008,'Agatha Christie',6,0);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musics`
--

DROP TABLE IF EXISTS `musics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `musics` (
  `ID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL DEFAULT 'unknown',
  `Author` varchar(45) NOT NULL DEFAULT 'unknown',
  `Composer` varchar(45) NOT NULL DEFAULT 'unknown',
  `Singer` varchar(45) NOT NULL DEFAULT 'unknown',
  `Duration` double NOT NULL DEFAULT '0',
  `Is_favourite` int(11) DEFAULT '0',
  `Genre` varchar(45) NOT NULL DEFAULT 'unknown',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NONCLUSTERED` (`Name`,`Singer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Team 4 project';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musics`
--

LOCK TABLES `musics` WRITE;
/*!40000 ALTER TABLE `musics` DISABLE KEYS */;
INSERT INTO `musics` VALUES (1,'Istiklal MarÅŸÄ±','Mehmet Akif Ersoy','Osman Zeki ÃœngÃ¶r','Halk',1.25,0,'unknown'),(2,'Shoot to Thrill','P. J. Tracy','Angus Young','AC/DC',5.17,0,'Rock'),(3,'Back in Black','Brian Johnson','Malcolm Young','AC/DC',4.14,0,'Rock'),(4,'Highway To Hell','Bon Scott','Angus Young','AC/DC',3.28,0,'Rock'),(5,'Hail To The King','Mike Elizondo','Matt Shadows','Avanged Sevenfold',5.05,0,'Rock'),(6,'Seize The Day','Synyster Gates','Matt Shadows','Avanged Sevenfold',5.32,0,'Rock'),(7,'Flames','Sia','David Guetta','David Guetta , Sia',3.15,0,'Pop'),(8,'Attention','Kesha','Macklemore','Macklemore',4,0,'Pop');
/*!40000 ALTER TABLE `musics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'project'
--

--
-- Dumping routines for database 'project'
--

--
-- Current Database: `oculus`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `oculus` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `oculus`;

--
-- Dumping events for database 'oculus'
--

--
-- Dumping routines for database 'oculus'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/ oculus 4 
-- Dump completed on 2018-11-06 17:35:48
