-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: garage-db
-- ------------------------------------------------------
-- Server version	5.5.5-10.10.2-MariaDB-1:10.10.2+maria~ubu2204

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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Ford'),(2,'Volkswagen'),(3,'Audi'),(4,'Mercedes-Benz'),(5,'Fiat'),(6,'Citroen'),(7,'Opel'),(8,'Alfa Romeo'),(9,'BMW'),(10,'Hyundai'),(11,'Nissan'),(12,'Peugeot'),(13,'Renault'),(14,'Smart'),(15,'Suzuki'),(17,'Toyota'),(18,'Aston Martin'),(19,'Bentley'),(20,'Bugatti'),(21,'Chevrolet'),(22,'Dacia'),(24,'Daihatsu'),(25,'Dodge'),(26,'Ferrari'),(27,'Honda'),(28,'Infiniti'),(29,'Jaguar'),(30,'Jeep'),(31,'Kia'),(32,'Lamborghini'),(33,'Lancia'),(34,'Land Rover'),(35,'Lexus'),(36,'Lotus'),(37,'Maserati'),(38,'Mazda'),(39,'McLaren'),(40,'Mini'),(41,'Mitsubishi'),(42,'Porsche'),(43,'Seat'),(44,'Rolls Royce'),(45,'Skoda'),(46,'Subaru'),(47,'Tesla'),(48,'Volvo');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `id` bigint(20) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `engine_size` varchar(255) DEFAULT NULL,
  `fuel_type` smallint(6) DEFAULT NULL,
  `horse_power` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `num_chairs` int(11) DEFAULT NULL,
  `num_doors` int(11) DEFAULT NULL,
  `number_plate` varchar(255) DEFAULT NULL,
  `transmission` smallint(6) DEFAULT NULL,
  `year_of_make` varchar(255) DEFAULT NULL,
  `brand_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj1mws2ruu9q6k2sa4pwlxthxn` (`brand_id`),
  KEY `FKs96qrqcjk9qh7x5724oy1cm90` (`category_id`),
  CONSTRAINT `FKj1mws2ruu9q6k2sa4pwlxthxn` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  CONSTRAINT `FKs96qrqcjk9qh7x5724oy1cm90` FOREIGN KEY (`category_id`) REFERENCES `car_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'White','1600',1,'120','Fiesta',5,3,'ZXM3931',1,'2010',1,1),(152,'Dark Grey','2300',1,'280','Focus',5,5,'AXB1968',1,'2022',1,1);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_category`
--

DROP TABLE IF EXISTS `car_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_category` (
  `id` bigint(20) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_category`
--

LOCK TABLES `car_category` WRITE;
/*!40000 ALTER TABLE `car_category` DISABLE KEYS */;
INSERT INTO `car_category` VALUES (1,'Hatchback'),(2,'SUV'),(3,'Van'),(4,'Pickup'),(5,'Roadster'),(6,'Coupe-Sport'),(7,'Sedan');
/*!40000 ALTER TABLE `car_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_seq`
--

DROP TABLE IF EXISTS `car_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car_seq` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_seq`
--

LOCK TABLES `car_seq` WRITE;
/*!40000 ALTER TABLE `car_seq` DISABLE KEYS */;
INSERT INTO `car_seq` VALUES (50001,1,9223372036854775806,1,50,1000,0,0);
/*!40000 ALTER TABLE `car_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'garage-db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-23 15:45:00
