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
-- Table structure for table `benefit`
--

DROP TABLE IF EXISTS `benefit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benefit` (
  `benefit_id` bigint NOT NULL,
  `benefit_value` text,
  PRIMARY KEY (`benefit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benefit`
--

LOCK TABLES `benefit` WRITE;
/*!40000 ALTER TABLE `benefit` DISABLE KEYS */;
INSERT INTO `benefit` VALUES (101,'[\"Emergency Room Visits\", \"Ambulance Services\", \"Urgent Care\"]'),(102,'[\"Surgical Procedures\", \"Anesthesia\", \"Operating Room\"]'),(103,'[\"Diagnostic Tests\", \"X-Rays\", \"Lab Work\"]'),(104,'[\"Home Health Care\", \"Nursing Services\", \"Medical Equipment Rental\"]'),(105,'[\"Outpatient Services\", \"Specialist Consultations\", \"Physical Exams\"]'),(106,'[\"Wellness Checkups\", \"Immunizations\", \"Preventive Care\"]'),(107,'[\"Prescription Drug Coverage\", \"Generic Drugs\", \"Brand-Name Drugs\"]'),(108,'[\"Rehabilitation Therapy\", \"Occupational Therapy\", \"Speech Therapy\"]'),(109,'[\"Vision Exams\", \"Eye Surgery\", \"Laser Vision Correction\"]'),(110,'[\"Hearing Aids\", \"Audiology Services\", \"Hearing Tests\"]'),(111,'[\"Emergency Room Visits\", \"Ambulance Services\", \"Urgent Care\"]'),(112,'[\"Surgical Procedures\", \"Anesthesia\", \"Operating Room\"]'),(113,'[\"Diagnostic Tests\", \"X-Rays\", \"Lab Work\"]'),(114,'[\"Home Health Care\", \"Nursing Services\", \"Medical Equipment Rental\"]'),(115,'[\"Outpatient Services\", \"Specialist Consultations\", \"Physical Exams\"]'),(116,'[\"Wellness Checkups\", \"Immunizations\", \"Preventive Care\"]'),(117,'[\"Prescription Drug Coverage\", \"Generic Drugs\", \"Brand-Name Drugs\"]'),(118,'[\"Rehabilitation Therapy\", \"Occupational Therapy\", \"Speech Therapy\"]'),(119,'[\"Vision Exams\", \"Eye Surgery\", \"Laser Vision Correction\"]'),(120,'[\"Hearing Aids\", \"Audiology Services\", \"Hearing Tests\"]');
/*!40000 ALTER TABLE `benefit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-04 23:48:38
