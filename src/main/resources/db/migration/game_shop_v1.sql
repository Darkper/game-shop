CREATE DATABASE  IF NOT EXISTS `game_shop_v1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `game_shop_v1`;
-- MySQL dump 10.13  Distrib 8.0.21, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: game_shop_v1
-- ------------------------------------------------------
-- Server version	8.0.21-0ubuntu0.20.04.4

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `document` varchar(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`document`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES ('012','jaxsotoo@outlook.com','Soto','Johny Al','6458684'),('012345','jaxsotoo@outlook.com','Soto','Johny','56464'),('1040049586','jaxsotoo@outlook.com','Soto Ocampo','Johny Alexander','3003323432');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directors`
--

DROP TABLE IF EXISTS `directors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directors` (
  `id` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directors`
--

LOCK TABLES `directors` WRITE;
/*!40000 ALTER TABLE `directors` DISABLE KEYS */;
INSERT INTO `directors` VALUES ('6862c521-ccd4-4548-bbe2-69700bcb8983','Director 3'),('a318647f-5648-4cbf-8cfd-ff00873826d3','Director'),('c20cede8-bcdc-4eca-a713-578082d7545d','Director 2');
/*!40000 ALTER TABLE `directors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_protagonists`
--

DROP TABLE IF EXISTS `game_protagonists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game_protagonists` (
  `game_id` varchar(255) NOT NULL,
  `protagonist_id` varchar(255) NOT NULL,
  PRIMARY KEY (`game_id`,`protagonist_id`),
  KEY `FKsggrqi2h4bo37850fas9cy0lf` (`protagonist_id`),
  CONSTRAINT `FKsggrqi2h4bo37850fas9cy0lf` FOREIGN KEY (`protagonist_id`) REFERENCES `protagonists` (`id`),
  CONSTRAINT `FKswl0bwugbf7cisxxa266xwopa` FOREIGN KEY (`game_id`) REFERENCES `games` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_protagonists`
--

LOCK TABLES `game_protagonists` WRITE;
/*!40000 ALTER TABLE `game_protagonists` DISABLE KEYS */;
INSERT INTO `game_protagonists` VALUES ('adfc73a2-d574-4a41-921d-26a619b32b82','58da9762-cd28-4edb-bf28-07170ad0ee1f'),('b322695a-4408-4ad9-a0bf-2d2838d507b1','58da9762-cd28-4edb-bf28-07170ad0ee1f'),('adfc73a2-d574-4a41-921d-26a619b32b82','6ff074d7-c2c4-4a55-b507-99998d8f9383'),('b322695a-4408-4ad9-a0bf-2d2838d507b1','6ff074d7-c2c4-4a55-b507-99998d8f9383'),('adfc73a2-d574-4a41-921d-26a619b32b82','8a654944-ad32-4132-b11e-58afc0f44898'),('d95cddac-c125-4f94-8acb-088dcb00e288','8a654944-ad32-4132-b11e-58afc0f44898'),('d95cddac-c125-4f94-8acb-088dcb00e288','b0827c28-9cfb-406c-b16a-e24725068ac3'),('08e591c2-197e-4996-9e25-b4a299588d99','c384f8d4-6eee-4be3-a7e6-0b405cb0664c'),('5584ce2b-20b1-494a-ace6-590dc0490f0b','c384f8d4-6eee-4be3-a7e6-0b405cb0664c'),('a4edae5e-c285-45f7-b91b-ac805021003c','c384f8d4-6eee-4be3-a7e6-0b405cb0664c'),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','c384f8d4-6eee-4be3-a7e6-0b405cb0664c'),('eb48070b-e87b-4b14-bbd1-ff76adffe0e0','c384f8d4-6eee-4be3-a7e6-0b405cb0664c');
/*!40000 ALTER TABLE `game_protagonists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `id` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` decimal(19,2) NOT NULL,
  `release_date` datetime NOT NULL,
  `director_id` varchar(255) NOT NULL,
  `producer_id` varchar(255) NOT NULL,
  `technology_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs26t83a4ewktj6d6nrlg6kec9` (`director_id`),
  KEY `FKrl1dyv2vn279blfkvtpids87x` (`producer_id`),
  KEY `FKr1akuub6snl1n69r9q5w28tit` (`technology_id`),
  CONSTRAINT `FKr1akuub6snl1n69r9q5w28tit` FOREIGN KEY (`technology_id`) REFERENCES `technologies` (`id`),
  CONSTRAINT `FKrl1dyv2vn279blfkvtpids87x` FOREIGN KEY (`producer_id`) REFERENCES `producers` (`id`),
  CONSTRAINT `FKs26t83a4ewktj6d6nrlg6kec9` FOREIGN KEY (`director_id`) REFERENCES `directors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES ('08e591c2-197e-4996-9e25-b4a299588d99','Super Mario Bros',4650.00,'2000-05-04 19:00:00','a318647f-5648-4cbf-8cfd-ff00873826d3','a318647f-5648-4cbf-8cfd-ff00873826d3','a318647f-5648-4cbf-8cfd-ff00873826d3'),('5584ce2b-20b1-494a-ace6-590dc0490f0b','Crash',4650.00,'2000-05-04 19:00:00','a318647f-5648-4cbf-8cfd-ff00873826d3','a318647f-5648-4cbf-8cfd-ff00873826d3','a318647f-5648-4cbf-8cfd-ff00873826d3'),('a4edae5e-c285-45f7-b91b-ac805021003c','Gears Pop',4650.00,'2000-05-04 19:00:00','a318647f-5648-4cbf-8cfd-ff00873826d3','a318647f-5648-4cbf-8cfd-ff00873826d3','a318647f-5648-4cbf-8cfd-ff00873826d3'),('adfc73a2-d574-4a41-921d-26a619b32b82','Halo',345234.00,'2020-09-10 00:00:00','6862c521-ccd4-4548-bbe2-69700bcb8983','80b87f85-db02-4f90-b276-9d8a75667a25','9abb755f-bf16-451d-82d5-a8246e47064a'),('b322695a-4408-4ad9-a0bf-2d2838d507b1','sdfsdf',54456.00,'2020-09-01 00:00:00','a318647f-5648-4cbf-8cfd-ff00873826d3','58da9762-cd28-4edb-bf28-07170ad0ee1f','1cbd1d7e-3431-4e69-9e08-e8438a2f0550'),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','Gears',500.00,'2000-05-04 19:00:00','a318647f-5648-4cbf-8cfd-ff00873826d3','a318647f-5648-4cbf-8cfd-ff00873826d3','a318647f-5648-4cbf-8cfd-ff00873826d3'),('d95cddac-c125-4f94-8acb-088dcb00e288','Super Mario',4545.00,'2020-09-03 00:00:00','6862c521-ccd4-4548-bbe2-69700bcb8983','80b87f85-db02-4f90-b276-9d8a75667a25','9abb755f-bf16-451d-82d5-a8246e47064a'),('eb48070b-e87b-4b14-bbd1-ff76adffe0e0','Gears',500.00,'2000-05-04 19:00:00','a318647f-5648-4cbf-8cfd-ff00873826d3','a318647f-5648-4cbf-8cfd-ff00873826d3','a318647f-5648-4cbf-8cfd-ff00873826d3');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producers`
--

DROP TABLE IF EXISTS `producers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producers` (
  `id` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producers`
--

LOCK TABLES `producers` WRITE;
/*!40000 ALTER TABLE `producers` DISABLE KEYS */;
INSERT INTO `producers` VALUES ('58da9762-cd28-4edb-bf28-07170ad0ee1f','Producer'),('6ff074d7-c2c4-4a55-b507-99998d8f9383','Producer 11'),('80b87f85-db02-4f90-b276-9d8a75667a25','Producer 2'),('a318647f-5648-4cbf-8cfd-ff00873826d3','Producer'),('b6e03646-9c91-41c8-9377-fb646c229eda','Producer 8'),('c8d1bd7f-b197-41a5-97d8-04662bad392f','Producer 10'),('d49c1195-7e5e-466f-845e-93d6a0fe145d','Producer 1');
/*!40000 ALTER TABLE `producers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `protagonists`
--

DROP TABLE IF EXISTS `protagonists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `protagonists` (
  `id` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `protagonists`
--

LOCK TABLES `protagonists` WRITE;
/*!40000 ALTER TABLE `protagonists` DISABLE KEYS */;
INSERT INTO `protagonists` VALUES ('58da9762-cd28-4edb-bf28-07170ad0ee1f','Protagonist 2'),('6ff074d7-c2c4-4a55-b507-99998d8f9383','Protagonist'),('8a654944-ad32-4132-b11e-58afc0f44898','Protagonist 1'),('b0827c28-9cfb-406c-b16a-e24725068ac3','New Protagonist'),('b6e03646-9c91-41c8-9377-fb646c229eda','Protagonist 12'),('c34c593b-efe5-4ab4-b401-56fe7cf39759','Protagonist 44'),('c384f8d4-6eee-4be3-a7e6-0b405cb0664c','Protagonist 3'),('c8d1bd7f-b197-41a5-97d8-04662bad392f','Protagonist');
/*!40000 ALTER TABLE `protagonists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_game`
--

DROP TABLE IF EXISTS `rent_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent_game` (
  `game_id` varchar(255) NOT NULL,
  `rent_id` varchar(255) NOT NULL,
  `days_of_rent` int NOT NULL,
  `price` decimal(19,2) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`game_id`,`rent_id`),
  KEY `FKxqof1segm3oe68krk7crir0q` (`rent_id`),
  CONSTRAINT `FK9cbre81bsvw7cih9lrjj8wxoh` FOREIGN KEY (`game_id`) REFERENCES `games` (`id`),
  CONSTRAINT `FKxqof1segm3oe68krk7crir0q` FOREIGN KEY (`rent_id`) REFERENCES `rents` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_game`
--

LOCK TABLES `rent_game` WRITE;
/*!40000 ALTER TABLE `rent_game` DISABLE KEYS */;
INSERT INTO `rent_game` VALUES ('08e591c2-197e-4996-9e25-b4a299588d99','22cd9214-e925-47f9-bbee-bda0b5186bb4',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','295ca1da-59b4-4057-8988-0cd6edba1d5a',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','395b9a8e-1919-414e-9186-befe42155b7e',1,1.00,2),('08e591c2-197e-4996-9e25-b4a299588d99','43a276be-002d-4772-bc52-01021a6f850f',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','447de5e9-e9f6-47ed-8394-8464fd2147d6',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','449dce4b-bbfc-44e6-969e-548b1eddeba2',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','45dceeaf-65dc-4adb-b49a-faca5ce1ce44',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','4f1ccecc-3043-41dd-8e4e-8408bc7cd0f9',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','5633c9e7-6c45-4ed6-8c24-d10c8eba4f80',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','57b89c04-8149-4d6d-9ad2-070ae20e53c6',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','5ac4e3d1-7ec5-4b71-bef5-a20d5dfdf238',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','68e8e429-34f8-4c94-9781-6f7057e1968b',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','7166207c-86bb-4ed5-9d5c-4bd5c7c6c973',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','8049ecc5-4cf6-4fce-a1b8-ccacc8717f9e',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','9d8748ca-68d4-4920-991a-a798bfed6538',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','a0974fe1-f2c9-44a4-871b-2a08e4e0ffba',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','a2157c80-340a-4f63-a9ba-36c9e6018ee8',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','affaadf1-5790-44df-8bb1-48a06e6ab1c6',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','b278c0b4-cda8-43bc-aac2-904c100af6fd',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','bb893c8f-2a54-4817-a6a8-7f27cbc6b72d',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','cbbcfc3f-4d25-4c8f-b4b0-4c3ca1c0bc1a',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','cd6809cd-4d8d-4e4b-b061-d03842d9b324',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','cdeeaf00-0da2-4e4e-8436-dcdd5aa2eb49',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','dff44e81-e496-402d-b604-a06842e891ce',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','e14b1809-6d8b-41d0-9290-3008d2e98536',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','e164f395-abda-4971-98aa-4de684cddf0e',1,1.00,1),('08e591c2-197e-4996-9e25-b4a299588d99','e30f0bd2-5aa7-4dfe-bce1-60287bc6f1b5',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','22cd9214-e925-47f9-bbee-bda0b5186bb4',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','295ca1da-59b4-4057-8988-0cd6edba1d5a',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','395b9a8e-1919-414e-9186-befe42155b7e',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','43a276be-002d-4772-bc52-01021a6f850f',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','447de5e9-e9f6-47ed-8394-8464fd2147d6',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','449dce4b-bbfc-44e6-969e-548b1eddeba2',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','45dceeaf-65dc-4adb-b49a-faca5ce1ce44',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','4f1ccecc-3043-41dd-8e4e-8408bc7cd0f9',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','5633c9e7-6c45-4ed6-8c24-d10c8eba4f80',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','57b89c04-8149-4d6d-9ad2-070ae20e53c6',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','5ac4e3d1-7ec5-4b71-bef5-a20d5dfdf238',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','68e8e429-34f8-4c94-9781-6f7057e1968b',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','7166207c-86bb-4ed5-9d5c-4bd5c7c6c973',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','8049ecc5-4cf6-4fce-a1b8-ccacc8717f9e',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','9d8748ca-68d4-4920-991a-a798bfed6538',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','a0974fe1-f2c9-44a4-871b-2a08e4e0ffba',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','a2157c80-340a-4f63-a9ba-36c9e6018ee8',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','affaadf1-5790-44df-8bb1-48a06e6ab1c6',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','b278c0b4-cda8-43bc-aac2-904c100af6fd',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','bb893c8f-2a54-4817-a6a8-7f27cbc6b72d',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','cbbcfc3f-4d25-4c8f-b4b0-4c3ca1c0bc1a',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','cd6809cd-4d8d-4e4b-b061-d03842d9b324',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','cdeeaf00-0da2-4e4e-8436-dcdd5aa2eb49',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','dff44e81-e496-402d-b604-a06842e891ce',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','e14b1809-6d8b-41d0-9290-3008d2e98536',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','e164f395-abda-4971-98aa-4de684cddf0e',1,1.00,1),('b8e87f1d-13b6-494b-a1f0-7de24886d1cf','e30f0bd2-5aa7-4dfe-bce1-60287bc6f1b5',1,1.00,1);
/*!40000 ALTER TABLE `rent_game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rents`
--

DROP TABLE IF EXISTS `rents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rents` (
  `id` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `client_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjavoy3jpv2yvl9dqkm5vv0b5o` (`client_id`),
  CONSTRAINT `FKjavoy3jpv2yvl9dqkm5vv0b5o` FOREIGN KEY (`client_id`) REFERENCES `clients` (`document`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rents`
--

LOCK TABLES `rents` WRITE;
/*!40000 ALTER TABLE `rents` DISABLE KEYS */;
INSERT INTO `rents` VALUES ('22cd9214-e925-47f9-bbee-bda0b5186bb4','2020-09-14','1040049586'),('295ca1da-59b4-4057-8988-0cd6edba1d5a','2020-09-16','1040049586'),('395b9a8e-1919-414e-9186-befe42155b7e','2020-09-12','1040049586'),('43a276be-002d-4772-bc52-01021a6f850f','2020-09-14','1040049586'),('447de5e9-e9f6-47ed-8394-8464fd2147d6','2020-09-18','1040049586'),('449dce4b-bbfc-44e6-969e-548b1eddeba2','2020-09-12','012345'),('45dceeaf-65dc-4adb-b49a-faca5ce1ce44','2020-09-18','1040049586'),('4f1ccecc-3043-41dd-8e4e-8408bc7cd0f9','2020-09-12','1040049586'),('5633c9e7-6c45-4ed6-8c24-d10c8eba4f80','2020-09-13','1040049586'),('57b89c04-8149-4d6d-9ad2-070ae20e53c6','2020-09-12','1040049586'),('5ac4e3d1-7ec5-4b71-bef5-a20d5dfdf238','2020-09-15','1040049586'),('68e8e429-34f8-4c94-9781-6f7057e1968b','2020-09-16','1040049586'),('7166207c-86bb-4ed5-9d5c-4bd5c7c6c973','2020-09-13','1040049586'),('8049ecc5-4cf6-4fce-a1b8-ccacc8717f9e','2020-09-11','1040049586'),('9d8748ca-68d4-4920-991a-a798bfed6538','2020-09-12','1040049586'),('a0974fe1-f2c9-44a4-871b-2a08e4e0ffba','2000-05-04','012'),('a2157c80-340a-4f63-a9ba-36c9e6018ee8','2020-09-11','1040049586'),('affaadf1-5790-44df-8bb1-48a06e6ab1c6','2000-05-04','1040049586'),('b278c0b4-cda8-43bc-aac2-904c100af6fd','2020-09-12','1040049586'),('bb893c8f-2a54-4817-a6a8-7f27cbc6b72d','2020-09-13','1040049586'),('cbbcfc3f-4d25-4c8f-b4b0-4c3ca1c0bc1a','2000-05-04','012'),('cd6809cd-4d8d-4e4b-b061-d03842d9b324','2000-05-02','1040049586'),('cdeeaf00-0da2-4e4e-8436-dcdd5aa2eb49','2020-09-15','1040049586'),('dff44e81-e496-402d-b604-a06842e891ce','2020-09-15','1040049586'),('e14b1809-6d8b-41d0-9290-3008d2e98536','2000-05-04','012'),('e164f395-abda-4971-98aa-4de684cddf0e','2020-09-11','1040049586'),('e30f0bd2-5aa7-4dfe-bce1-60287bc6f1b5','2020-09-17','1040049586');
/*!40000 ALTER TABLE `rents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technologies`
--

DROP TABLE IF EXISTS `technologies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technologies` (
  `id` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technologies`
--

LOCK TABLES `technologies` WRITE;
/*!40000 ALTER TABLE `technologies` DISABLE KEYS */;
INSERT INTO `technologies` VALUES ('1cbd1d7e-3431-4e69-9e08-e8438a2f0550','Paly Station'),('9abb755f-bf16-451d-82d5-a8246e47064a','Pc'),('a318647f-5648-4cbf-8cfd-ff00873826d3','Xbox');
/*!40000 ALTER TABLE `technologies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-12 16:50:34
