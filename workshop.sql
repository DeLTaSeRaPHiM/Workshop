CREATE DATABASE  IF NOT EXISTS `workshop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `workshop`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: workshop
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) NOT NULL,
  `product_price` int NOT NULL,
  `amount_on_monday` int NOT NULL,
  `amount_on_tuesday` int NOT NULL,
  `amount_on_wednesday` int NOT NULL,
  `amount_on_thursday` int NOT NULL,
  `amount_on_friday` int NOT NULL,
  `amount_on_saturday` int NOT NULL,
  `amount_on_sunday` int NOT NULL,
  `worker_id` int DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'ДВС',27000,80,45,56,74,54,80,30,1),(2,'Шестерёнка',1500,512,248,354,547,612,451,214,5),(3,'Коленчатый вал',5000,153,324,124,423,214,15,124,3),(4,'Электродвигатель',48000,34,43,23,40,36,52,10,4),(5,'Станок ЧПУ',127000,240,250,125,354,245,213,621,4),(6,'Гаусс-винтовка',800,62,42,54,354,786,543,42,3),(7,'Статуэтка \"Гидра\"',47500,12,45,213,45,213,546,213,5),(8,'Зарядное устройство',1500,1312,5321,4532,2315,4562,2313,5432,2);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `access_key` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Delta','Zero','1'),(2,'admin','admin','1'),(3,'Guest','Guest','3'),(4,'John Doe','qwerty1','2');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_1`
--

DROP TABLE IF EXISTS `view_1`;
/*!50001 DROP VIEW IF EXISTS `view_1`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_1` AS SELECT 
 1 AS `CONCAT(worker_surname, worker_name, worker_patronymic)`,
 1 AS `product_name`,
 1 AS `product_price`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_2`
--

DROP TABLE IF EXISTS `view_2`;
/*!50001 DROP VIEW IF EXISTS `view_2`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `view_2` AS SELECT 
 1 AS `workshop_name`,
 1 AS `product_id`,
 1 AS `product_name`,
 1 AS `product_price`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `workers`
--

DROP TABLE IF EXISTS `workers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workers` (
  `worker_id` int NOT NULL AUTO_INCREMENT,
  `worker_surname` varchar(45) NOT NULL,
  `worker_name` varchar(45) NOT NULL,
  `worker_patronymic` varchar(45) NOT NULL,
  `workshop_name` enum('Цех №1','Цех №2','Цех №3','Цех №4','Цех №5','Цех №6') NOT NULL,
  PRIMARY KEY (`worker_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workers`
--

LOCK TABLES `workers` WRITE;
/*!40000 ALTER TABLE `workers` DISABLE KEYS */;
INSERT INTO `workers` VALUES (1,'Павлов','Алексей','Васильевич','Цех №2'),(2,'Николаев','Даниил','Алексеевич','Цех №4'),(3,'Морозов','Данила','Артёмович','Цех №4'),(4,'Аняев','Павел','Сергеевич','Цех №1'),(5,'Гришин','Захар','Валерьевич','Цех №2');
/*!40000 ALTER TABLE `workers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'workshop'
--

--
-- Final view structure for view `view_1`
--

/*!50001 DROP VIEW IF EXISTS `view_1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_1` AS select concat(`workers`.`worker_surname`,`workers`.`worker_name`,`workers`.`worker_patronymic`) AS `CONCAT(worker_surname, worker_name, worker_patronymic)`,`products`.`product_name` AS `product_name`,`products`.`product_price` AS `product_price` from (`workers` join `products`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_2`
--

/*!50001 DROP VIEW IF EXISTS `view_2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_2` AS select `workers`.`workshop_name` AS `workshop_name`,`products`.`product_id` AS `product_id`,`products`.`product_name` AS `product_name`,`products`.`product_price` AS `product_price` from (`workers` join `products`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-15 23:01:57
