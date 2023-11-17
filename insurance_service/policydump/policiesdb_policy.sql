-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: policiesdb
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `policy`
--

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `policy` (
  `policy_id` bigint NOT NULL,
  `coverage` bigint DEFAULT NULL,
  `policy_company` varchar(255) DEFAULT NULL,
  `policy_name` varchar(255) DEFAULT NULL,
  `policy_price` double DEFAULT NULL,
  `tenure` int DEFAULT NULL,
  `benefit_id` bigint DEFAULT NULL,
  `policy_type_id` bigint DEFAULT NULL,
  PRIMARY KEY (`policy_id`),
  KEY `FK3hxn073boknycksuyltib5n2m` (`benefit_id`),
  KEY `FKo1xjitah0i8u19u5380o7382w` (`policy_type_id`),
  CONSTRAINT `FK3hxn073boknycksuyltib5n2m` FOREIGN KEY (`benefit_id`) REFERENCES `benefit` (`benefit_id`),
  CONSTRAINT `FKo1xjitah0i8u19u5380o7382w` FOREIGN KEY (`policy_type_id`) REFERENCES `policy_type` (`policy_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policy`
--

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;
INSERT INTO `policy` VALUES (1,50000,'Insurance Corp A','Policy 1',100,1,101,1),(2,75000,'Insurance Corp B','Policy 2',150,2,102,2),(3,100000,'Insurance Corp C','Policy 3',200,3,103,3),(4,60000,'Insurance Corp A','Policy 4',120,4,104,2),(5,40000,'Insurance Corp D','Policy 5',80,5,105,1),(6,120000,'Insurance Corp B','Policy 6',250,1,106,5),(7,110000,'Insurance Corp C','Policy 7',220,2,107,4),(8,85000,'Insurance Corp D','Policy 8',170,3,108,3),(9,75000,'Insurance Corp A','Policy 9',150,4,109,2),(10,45000,'Insurance Corp B','Policy 10',90,5,110,1),(11,50000,'Insurance Corp A','Policy 1',100,1,101,1),(12,75000,'Insurance Corp B','Policy 2',150,2,102,2),(13,100000,'Insurance Corp C','Policy 3',200,3,103,3),(14,60000,'Insurance Corp A','Policy 4',120,4,104,2),(15,40000,'Insurance Corp D','Policy 5',80,5,105,1),(16,120000,'Insurance Corp B','Policy 6',250,1,106,5),(17,110000,'Insurance Corp C','Policy 7',220,2,107,4),(18,85000,'Insurance Corp D','Policy 8',170,3,108,3),(19,75000,'Insurance Corp A','Policy 9',150,4,109,2),(20,45000,'Insurance Corp B','Policy 10',90,5,110,1);
/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-04 23:48:37
