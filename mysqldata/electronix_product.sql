CREATE DATABASE  IF NOT EXISTS `electronix` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `electronix`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: electronix
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `prodid` int NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `created_timestamp` datetime(6) DEFAULT NULL,
  `pcat` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `price` int NOT NULL,
  `sellerId` int DEFAULT NULL,
  PRIMARY KEY (`prodid`),
  KEY `FK1vpet817bib8p40k93lei6uw7` (`sellerId`),
  CONSTRAINT `FK1vpet817bib8p40k93lei6uw7` FOREIGN KEY (`sellerId`) REFERENCES `sellers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Panasonic',NULL,'AC','42395faa70c24126a2bbf585adc85785.jpg','Panasonic A2GC(2 ton)',18500,3),(2,'JBL',NULL,'Audio','fd39cc9530a843919924fe36e45f47b3.jpg','JBL Bluetooth(Over the head earphones)',1790,3),(3,'Boat',NULL,'Audio','30619e6c0d0f4fb08406342b16b122aa.jpg','Boat Bluetooth(Over the head earphones)',2000,3),(4,'Sony',NULL,'Televisions','373e8e9ace374389b4123477d989fd47.jpg','Sony Android TV(4K HDR)',29400,3),(5,'LG',NULL,'Refrigerators','18f42a7c8f9e4b41bb130a6f918d3f11.jpg','LG Fridge(20L capacity, 4 Star Rating)',18000,3),(6,'Nikon',NULL,'Cameras','e463e1929e474c86bad543132b1f944c.jpg','Nikon Camera (3.4mm Lense)',45000,3),(7,'LG',NULL,'Washing Machines','0ccda9064de14db7b0c225f81402ec02.jpg','LG Washing Machine (Front Load, 10Liter Capacity)',18500,3),(8,'Nokia',NULL,'Mobile Phones','020c9c45d11c499cab0bf1c73d56b9cf.jpg','Nokia 1100',8000,1),(9,'Apple',NULL,'Mobile Phones','34857fdb47ac496eb9f4317fad9faef1.jpg','IPhone 13',55000,1),(10,'Samsung',NULL,'Mobile Phones','1c01d0c57e654b8d88c3dba07a5cfe16.jpg','Samsang S21 (5G,128Gb storage,16Gb RAM)',49000,1),(11,'JBL',NULL,'Audio','8305fab381bc41e5a9c2694d9fd9745e.jpg','JBL sound Bar',999,4),(12,'Sony',NULL,'Audio','a3780211524449cb8a890854bd6902cf.webp','Sony Home Theater',11000,4),(13,'Boat',NULL,'Audio','260140c8faf84b4fa7b4323479ad7b93.jpg','Boat In-Ear Headphones',899,4);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-27 10:03:06
