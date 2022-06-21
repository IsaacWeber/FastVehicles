-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: fast_vehicles
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `carro`
--

DROP TABLE IF EXISTS `carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carro` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idcliente` bigint DEFAULT NULL,
  `idlocadora` bigint DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `marca` varchar(100) DEFAULT NULL,
  `modelo` varchar(100) DEFAULT NULL,
  `cor` varchar(100) DEFAULT NULL,
  `combustivel` varchar(100) DEFAULT NULL,
  `ano` int DEFAULT NULL,
  `quilometragem` bigint DEFAULT NULL,
  `placa` varchar(100) DEFAULT NULL,
  `caucao` float DEFAULT NULL,
  `valor_diario` float DEFAULT NULL,
  `motor` varchar(100) DEFAULT NULL,
  `cavalos` int DEFAULT NULL,
  `portas` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idcliente` (`idcliente`),
  KEY `idlocadora` (`idlocadora`),
  CONSTRAINT `carro_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `carro_ibfk_2` FOREIGN KEY (`idlocadora`) REFERENCES `locadora` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro`
--

LOCK TABLES `carro` WRITE;
/*!40000 ALTER TABLE `carro` DISABLE KEYS */;
/*!40000 ALTER TABLE `carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartao`
--

DROP TABLE IF EXISTS `cartao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartao` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `numero` bigint DEFAULT NULL,
  `idcliente` bigint DEFAULT NULL,
  `nome_titular` varchar(200) DEFAULT NULL,
  `banco` varchar(200) DEFAULT NULL,
  `validade` varchar(20) DEFAULT NULL,
  `cvc` int DEFAULT NULL,
  `funcao` varchar(200) DEFAULT NULL,
  `bandeira` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idcliente` (`idcliente`),
  CONSTRAINT `cartao_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartao`
--

LOCK TABLES `cartao` WRITE;
/*!40000 ALTER TABLE `cartao` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `endereco` varchar(300) DEFAULT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `cnh` varchar(20) DEFAULT NULL,
  `senha` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_locadora`
--

DROP TABLE IF EXISTS `cliente_locadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_locadora` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idcliente` bigint DEFAULT NULL,
  `idlocadora` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idcliente` (`idcliente`),
  KEY `idlocadora` (`idlocadora`),
  CONSTRAINT `cliente_locadora_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `cliente_locadora_ibfk_2` FOREIGN KEY (`idlocadora`) REFERENCES `locadora` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_locadora`
--

LOCK TABLES `cliente_locadora` WRITE;
/*!40000 ALTER TABLE `cliente_locadora` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente_locadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacao_carro`
--

DROP TABLE IF EXISTS `locacao_carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locacao_carro` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idlocadora` bigint DEFAULT NULL,
  `idcliente` bigint DEFAULT NULL,
  `idcartao` bigint DEFAULT NULL,
  `idcarro` bigint DEFAULT NULL,
  `data_locacao` date DEFAULT NULL,
  `data_entrega` date DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `forma_pagamento` varchar(100) DEFAULT NULL,
  `multa` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idcliente` (`idcliente`),
  KEY `idlocadora` (`idlocadora`),
  KEY `idcarro` (`idcarro`),
  KEY `idcartao` (`idcartao`),
  CONSTRAINT `locacao_carro_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `locacao_carro_ibfk_2` FOREIGN KEY (`idlocadora`) REFERENCES `locadora` (`id`),
  CONSTRAINT `locacao_carro_ibfk_3` FOREIGN KEY (`idcarro`) REFERENCES `carro` (`id`),
  CONSTRAINT `locacao_carro_ibfk_4` FOREIGN KEY (`idcartao`) REFERENCES `cartao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao_carro`
--

LOCK TABLES `locacao_carro` WRITE;
/*!40000 ALTER TABLE `locacao_carro` DISABLE KEYS */;
/*!40000 ALTER TABLE `locacao_carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacao_moto`
--

DROP TABLE IF EXISTS `locacao_moto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locacao_moto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idlocadora` bigint DEFAULT NULL,
  `idcliente` bigint DEFAULT NULL,
  `idcartao` bigint DEFAULT NULL,
  `idmoto` bigint DEFAULT NULL,
  `data_locacao` date DEFAULT NULL,
  `data_entrega` date DEFAULT NULL,
  `valor_total` float DEFAULT NULL,
  `forma_pagamento` varchar(100) DEFAULT NULL,
  `multa` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idcliente` (`idcliente`),
  KEY `idlocadora` (`idlocadora`),
  KEY `idmoto` (`idmoto`),
  KEY `idcartao` (`idcartao`),
  CONSTRAINT `locacao_moto_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `locacao_moto_ibfk_2` FOREIGN KEY (`idlocadora`) REFERENCES `locadora` (`id`),
  CONSTRAINT `locacao_moto_ibfk_3` FOREIGN KEY (`idmoto`) REFERENCES `moto` (`id`),
  CONSTRAINT `locacao_moto_ibfk_4` FOREIGN KEY (`idcartao`) REFERENCES `cartao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao_moto`
--

LOCK TABLES `locacao_moto` WRITE;
/*!40000 ALTER TABLE `locacao_moto` DISABLE KEYS */;
/*!40000 ALTER TABLE `locacao_moto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locadora`
--

DROP TABLE IF EXISTS `locadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locadora` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `endereco` varchar(300) DEFAULT NULL,
  `cnpj` varchar(20) DEFAULT NULL,
  `senha` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locadora`
--

LOCK TABLES `locadora` WRITE;
/*!40000 ALTER TABLE `locadora` DISABLE KEYS */;
/*!40000 ALTER TABLE `locadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moto`
--

DROP TABLE IF EXISTS `moto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `idcliente` bigint DEFAULT NULL,
  `idlocadora` bigint DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `marca` varchar(100) DEFAULT NULL,
  `modelo` varchar(100) DEFAULT NULL,
  `cor` varchar(100) DEFAULT NULL,
  `combustivel` varchar(100) DEFAULT NULL,
  `ano` int DEFAULT NULL,
  `quilometragem` float DEFAULT NULL,
  `placa` varchar(100) DEFAULT NULL,
  `caucao` float DEFAULT NULL,
  `valor_diario` float DEFAULT NULL,
  `motor` varchar(100) DEFAULT NULL,
  `cilindradas` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idcliente` (`idcliente`),
  KEY `idlocadora` (`idlocadora`),
  CONSTRAINT `moto_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `moto_ibfk_2` FOREIGN KEY (`idlocadora`) REFERENCES `locadora` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moto`
--

LOCK TABLES `moto` WRITE;
/*!40000 ALTER TABLE `moto` DISABLE KEYS */;
/*!40000 ALTER TABLE `moto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-21 20:33:22
