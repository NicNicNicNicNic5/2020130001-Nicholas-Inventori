-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: inventory
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipment` (
  `Equipment_ID` char(10) NOT NULL,
  `Inventory_ID` char(10) DEFAULT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Strength` int DEFAULT NULL,
  `Intelligence` int DEFAULT NULL,
  `Vitality` int DEFAULT NULL,
  `Agility` int DEFAULT NULL,
  `Dexterity` int DEFAULT NULL,
  `Lucky` int DEFAULT NULL,
  `Enhancement` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Equipment_ID`),
  KEY `Inventory_ID_FK` (`Inventory_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES ('ARACH00001','INVEN90001','ARACHNID\'S_BOW',50,50,0,100,100,0,'S'),('BOREA00001','INVEN50001','BOREAS\'S_BOWGUN',100,50,0,100,50,0,'S'),('DRAGO00001','INVEN70001','DRAGON\'S_GREATSWORD',200,0,0,50,50,0,'S'),('GOPHE00001','INVEN40001','GOPHERGA\'S_KNUCKLE',100,0,100,50,50,0,'S'),('IFRIT00001','INVEN10001','IFRIT\'S_SWORD',100,50,0,100,50,0,'S'),('KRAKE00001','INVEN80001','KRAKEN\'S_SPEAR',100,100,0,100,0,0,'S'),('LEVIA00001','INVEN30001','LEVIATHAN\'S_SPEAR',100,100,0,100,0,0,'S'),('LUCIF00001','INVEN20001','LUCIFER\'S_STAFF',0,100,0,0,100,100,'S'),('LUNAR00001','INVEN60001','LUNARIA\'S_STAFF',0,100,0,0,50,150,'S'),('TEMPE00001','INVEN00001','TEMPEST\'S_SWORD',100,100,0,0,0,100,'S');
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `Inventory_ID` char(10) NOT NULL,
  `Equipment_ID` char(10) DEFAULT NULL,
  `Possession` int DEFAULT NULL,
  `Place` int DEFAULT NULL,
  PRIMARY KEY (`Inventory_ID`),
  KEY `Equipment_ID_FK` (`Equipment_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES ('INVEN00001','TEMPE00001',1,10),('INVEN10001','IFRIT00001',1,1),('INVEN20001','LUCIF00001',1,2),('INVEN30001','LEVIA00001',1,3),('INVEN40001','GOPHE00001',1,4),('INVEN50001','BOREA00001',1,5),('INVEN60001','LUNAR00001',1,6),('INVEN70001','DRAGO00001',1,7),('INVEN80001','KRAKE00001',1,8),('INVEN90001','ARACH00001',1,9);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_equipment`
--

DROP TABLE IF EXISTS `player_equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player_equipment` (
  `Player_Equip_ID` char(10) NOT NULL,
  `Inventory_ID` char(10) DEFAULT NULL,
  `Main_Weapon` varchar(30) DEFAULT NULL,
  `Sub_Weapon` varchar(30) DEFAULT NULL,
  `Armor` varchar(30) DEFAULT NULL,
  `Glove` varchar(30) DEFAULT NULL,
  `Shoe` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Player_Equip_ID`),
  KEY `Inventory_ID_PE_FK` (`Inventory_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_equipment`
--

LOCK TABLES `player_equipment` WRITE;
/*!40000 ALTER TABLE `player_equipment` DISABLE KEYS */;
INSERT INTO `player_equipment` VALUES ('EQUIP10000','INVEN10000','TEMPEST\'S_SWORD','TEMPEST\'S_KNIFE','TEMPEST\'S_VEST','TEMPEST\'S_RING','TEMPEST\'S_ANGKLET'),('EQUIP10001','INVEN10001','IFRIT\'S_SWORD','IFRIT\'S_BUCKLER','IFRIT\'S_ARMOR','IFRIT\'S_VAMBRACE','IFRIT\'S_GREAVES'),('EQUIP10002','INVEN10002','LUCIFER\'S_STAFF','LUCIFER\'S_ORB','LUCIFER\'S_VEST','LUCIFER\'S_RING','LUCIFER\'S_ANGKLET'),('EQUIP10003','INVEN10003','LEVIATHAN\'S_SPEAR','LEVIATHAN\'S_KNIFE','LEVIATHAN\'S_VEST','LEVIATHAN\'S_VAMBRACE','LEVIATHAN\'S_GREAVES'),('EQUIP10004','INVEN10004','GOPHERGA\'S_KNUCKLE','GOPHERGA\'S_SHIELD','GOPHERGA\'S_ARMOR','GOPHERGA\'S_GLOVE','GOPHERGA\'S_SHOES'),('EQUIP10005','INVEN10005','BOREAS\'S_BOWGUN','BOREAS\'S_ARROW','BOREAS\'S_VEST','BOREAS\'S_VAMBRACE','BOREAS\'S_GREAVES'),('EQUIP10006','INVEN10006','LUNARIA\'S_STAFF','LUNARIA\'S_ORB','LUNARIA\'S_VEST','LUNARIA\'S_VAMBRACE','LUNARIA\'S_GREAVES'),('EQUIP10007','INVEN10007','DRAGON\'S_GREATSWORD','DRAGON\'S_KNIFE','DRAGON\'S_MAIL','DRAGON\'S_GLOVE','DRAGON\'S_SHOES'),('EQUIP10008','INVEN10008','KRAKEN\'S_SPEAR','KRAKEN\'S_KNIFE','KRAKEN\'S_VEST','KRAKEN\'S_VAMBRACE','KRAKEN\'S_GREAVES'),('EQUIP10009','INVEN10009','ARACHNID\'S_BOW','ARACHNID\'S_ARROW','ARACHNID\'S_VEST','ARACHNID\'S_RING','ARACHNID\'S_ANGKLET'),('tes','tes','a','a','a','a','a');
/*!40000 ALTER TABLE `player_equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player_status`
--

DROP TABLE IF EXISTS `player_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player_status` (
  `Player_ID` char(10) NOT NULL,
  `Player_Equip_ID` char(10) DEFAULT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Strength` int DEFAULT NULL,
  `Intelligence` int DEFAULT NULL,
  `Vitality` int DEFAULT NULL,
  `Agility` int DEFAULT NULL,
  `Dexterity` int DEFAULT NULL,
  `Lucky` int DEFAULT NULL,
  PRIMARY KEY (`Player_ID`),
  KEY `Player_Equip_ID_FK` (`Player_Equip_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player_status`
--

LOCK TABLES `player_status` WRITE;
/*!40000 ALTER TABLE `player_status` DISABLE KEYS */;
INSERT INTO `player_status` VALUES ('LIKMI10000','EQUIP10000','PUCCI',0,300,100,100,100,0),('LIKMI10001','EQUIP10001','JONATHAN',100,100,100,100,100,100),('LIKMI10002','EQUIP10002','JOSEPH',100,200,100,200,0,0),('LIKMI10003','EQUIP10003','JOTARO',150,150,50,100,150,0),('LIKMI10004','EQUIP10004','JOSUKE',100,50,200,100,100,50),('LIKMI10005','EQUIP10005','GIORNO',100,100,50,150,150,50),('LIKMI10006','EQUIP10006','JOLYNE',100,200,50,50,150,50),('LIKMI10007','EQUIP10007','DIO',200,200,200,0,0,0),('LIKMI10008','EQUIP10008','KIRA',300,50,50,50,50,100),('LIKMI10009','EQUIP10009','DIAVOLO',150,150,300,0,0,0);
/*!40000 ALTER TABLE `player_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-10 17:41:27
