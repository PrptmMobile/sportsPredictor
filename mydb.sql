-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Current Database: `mydb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mydb`;

--
-- Table structure for table `competitions`
--

DROP TABLE IF EXISTS `competitions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competitions` (
  `competetionId` int(11) NOT NULL AUTO_INCREMENT,
  `leagueId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `pts` int(11) DEFAULT NULL,
  `scores` int(11) DEFAULT NULL,
  PRIMARY KEY (`competetionId`),
  KEY `leagueId_idx` (`leagueId`),
  KEY `userId_idx` (`userId`),
  CONSTRAINT `leagueId_comp` FOREIGN KEY (`leagueId`) REFERENCES `leagues` (`leagueId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userId_comp` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competitions`
--

LOCK TABLES `competitions` WRITE;
/*!40000 ALTER TABLE `competitions` DISABLE KEYS */;
/*!40000 ALTER TABLE `competitions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countries` (
  `countryId` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`countryId`),
  UNIQUE KEY `countryUniqueIndex` (`country`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (5,'England'),(9,'Finland'),(7,'International'),(3,'None'),(1,'Russia'),(2,'Sweden'),(13,'Ukraine'),(4,'USA');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leagues`
--

DROP TABLE IF EXISTS `leagues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leagues` (
  `leagueId` int(11) NOT NULL AUTO_INCREMENT,
  `league` varchar(45) NOT NULL,
  `countryId` int(11) NOT NULL,
  `sportId` int(11) NOT NULL,
  PRIMARY KEY (`leagueId`),
  UNIQUE KEY `leagueUniqueIndex` (`league`),
  KEY `countryId_idx` (`countryId`),
  KEY `sportId_idx` (`sportId`),
  CONSTRAINT `countryId` FOREIGN KEY (`countryId`) REFERENCES `countries` (`countryId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sportId` FOREIGN KEY (`sportId`) REFERENCES `sports` (`sportId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leagues`
--

LOCK TABLES `leagues` WRITE;
/*!40000 ALTER TABLE `leagues` DISABLE KEYS */;
INSERT INTO `leagues` VALUES (1,'RFPL 2016/2017',1,1),(4,'HaparandaTornio Bandy Cup 2016',7,2),(5,'Friendly',7,1),(6,'Test for England',5,1),(7,'Test for Russia',1,1),(8,'bakakjasdfhds',5,1);
/*!40000 ALTER TABLE `leagues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matches` (
  `matchId` int(11) NOT NULL AUTO_INCREMENT,
  `homeId` int(11) NOT NULL,
  `awayId` int(11) NOT NULL,
  `homeGls` int(11) DEFAULT NULL,
  `awayGls` int(11) DEFAULT NULL,
  `leagueId` int(11) NOT NULL,
  `dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`matchId`),
  KEY `homeId_idx` (`homeId`),
  KEY `leagueId_idx` (`leagueId`),
  KEY `teamId_away_idx` (`awayId`),
  CONSTRAINT `leagueId_match` FOREIGN KEY (`leagueId`) REFERENCES `leagues` (`leagueId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamId_away` FOREIGN KEY (`awayId`) REFERENCES `teams` (`teamId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamId_home` FOREIGN KEY (`homeId`) REFERENCES `teams` (`teamId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
INSERT INTO `matches` VALUES (1,1,2,3,1,1,'2016-09-30 10:46:04'),(2,1,2,8,0,1,'2016-09-30 23:57:16'),(3,1,2,3,1,1,'2016-09-30 22:20:01'),(4,1,2,3,1,1,'2016-09-30 22:20:35'),(6,3,1,0,6,1,'2016-10-01 00:02:19'),(7,9,2,NULL,NULL,1,'2016-10-21 20:00:00');
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predicts`
--

DROP TABLE IF EXISTS `predicts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `predicts` (
  `predictId` int(11) NOT NULL AUTO_INCREMENT,
  `matchId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `homePr` int(11) NOT NULL,
  `awayPr` int(11) NOT NULL,
  `points` int(11) DEFAULT NULL,
  PRIMARY KEY (`predictId`),
  KEY `matchId_idx` (`matchId`),
  KEY `userId_idx` (`userId`),
  CONSTRAINT `matchId_pr` FOREIGN KEY (`matchId`) REFERENCES `matches` (`matchId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userId_pr` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predicts`
--

LOCK TABLES `predicts` WRITE;
/*!40000 ALTER TABLE `predicts` DISABLE KEYS */;
/*!40000 ALTER TABLE `predicts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sports`
--

DROP TABLE IF EXISTS `sports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sports` (
  `sportId` int(11) NOT NULL AUTO_INCREMENT,
  `sport` varchar(45) NOT NULL,
  PRIMARY KEY (`sportId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sports`
--

LOCK TABLES `sports` WRITE;
/*!40000 ALTER TABLE `sports` DISABLE KEYS */;
INSERT INTO `sports` VALUES (1,'Football'),(2,'Bandy'),(3,'None'),(4,'Ice Hockey');
/*!40000 ALTER TABLE `sports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teampart`
--

DROP TABLE IF EXISTS `teampart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teampart` (
  `teampartId` int(11) NOT NULL AUTO_INCREMENT,
  `leagueId` int(11) NOT NULL,
  `teamId` int(11) NOT NULL,
  `pld` int(11) DEFAULT NULL,
  `gs` int(11) DEFAULT '0',
  `gc` int(11) DEFAULT '0',
  `pts` varchar(45) DEFAULT '0',
  PRIMARY KEY (`teampartId`),
  KEY `leagueId_idx` (`leagueId`),
  KEY `teamId_idx` (`teamId`),
  CONSTRAINT `leagueId_tp` FOREIGN KEY (`leagueId`) REFERENCES `leagues` (`leagueId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamId_tp` FOREIGN KEY (`teamId`) REFERENCES `teams` (`teamId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teampart`
--

LOCK TABLES `teampart` WRITE;
/*!40000 ALTER TABLE `teampart` DISABLE KEYS */;
INSERT INTO `teampart` VALUES (1,1,1,NULL,0,0,'0'),(3,1,2,NULL,0,0,'0'),(4,1,3,NULL,0,0,'0'),(5,1,9,0,0,0,'0');
/*!40000 ALTER TABLE `teampart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teams` (
  `teamId` int(11) NOT NULL AUTO_INCREMENT,
  `team` varchar(64) NOT NULL,
  `sportId` int(11) NOT NULL,
  `countryId` int(11) NOT NULL,
  PRIMARY KEY (`teamId`),
  UNIQUE KEY `teamUniqueIndex` (`team`),
  KEY `countryId_idx` (`countryId`),
  KEY `sportId_idx` (`sportId`),
  CONSTRAINT `countryId_team` FOREIGN KEY (`countryId`) REFERENCES `countries` (`countryId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sportId_team` FOREIGN KEY (`sportId`) REFERENCES `sports` (`sportId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'CSKA Moscow',1,1),(2,'Spartak Moscow',1,9),(3,'Arsenal Tula',1,1),(4,'Murman Murmansk',2,1),(5,'None',3,3),(7,'HT Bandy',2,2),(8,'Stroitel Murmansk',2,1),(9,'Tom Tomsk',1,1);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `teamId` int(11) DEFAULT NULL,
  `countryId` int(11) DEFAULT NULL,
  `admin` varchar(45) DEFAULT NULL,
  `email` varchar(128) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userUniqueIndex` (`username`),
  KEY `teamId_idx` (`teamId`),
  KEY `countryId_idx` (`countryId`),
  CONSTRAINT `countryId_user` FOREIGN KEY (`countryId`) REFERENCES `countries` (`countryId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teamId` FOREIGN KEY (`teamId`) REFERENCES `teams` (`teamId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','12345',1,1,NULL,''),(4,'admin11','password',1,1,NULL,''),(5,'111','222',2,2,NULL,''),(6,'artem','111',1,1,NULL,''),(7,'cskafan','444',1,1,NULL,''),(8,'cskafan888','888',1,1,NULL,''),(9,'murmanfan','333',1,1,NULL,''),(15,'arsfan','111',1,3,NULL,''),(16,'amf','123',1,3,NULL,'amf@gloogle.com'),(17,'administrator','123',4,1,'1','murmanfan@gmail.com'),(18,'fcrvt','123',1,1,'0','fcrvt@yandex.ru'),(19,'bna','123',1,3,'0','jkhdfv@shjdfjh.ru');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-01 17:34:41
