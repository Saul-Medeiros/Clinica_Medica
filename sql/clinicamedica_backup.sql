-- MariaDB dump 10.19  Distrib 10.4.25-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: clinica_medica
-- ------------------------------------------------------
-- Server version	10.4.25-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `clinica_medica`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `clinica_medica` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `clinica_medica`;

--
-- Table structure for table `atendente`
--

DROP TABLE IF EXISTS `atendente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atendente` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `formacao` varchar(100) NOT NULL,
  `endereco_id` int(11) NOT NULL,
  PRIMARY KEY (`matricula`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  KEY `fk_atendente_endereco_idx` (`endereco_id`),
  CONSTRAINT `fk_atendente_endereco` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendente`
--

LOCK TABLES `atendente` WRITE;
/*!40000 ALTER TABLE `atendente` DISABLE KEYS */;
INSERT INTO `atendente` (`matricula`, `nome`, `formacao`, `endereco_id`) VALUES (111,'João','Ensino médio',1),(222,'Larissa','Ensino Médio',2),(333,'Mateus','Ensino Médio',3),(444,'Carlos','Superior em Administração',4),(555,'Ronaldo','Superior em Gestão de RH',5);
/*!40000 ALTER TABLE `atendente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `numero` int(11) NOT NULL,
  `data` date NOT NULL,
  `horario` time NOT NULL,
  `paciente_cpf` varchar(20) NOT NULL,
  `medico_crm` varchar(11) NOT NULL,
  `atendente_matricula` int(11) NOT NULL,
  PRIMARY KEY (`numero`,`paciente_cpf`,`medico_crm`,`atendente_matricula`),
  UNIQUE KEY `numero_UNIQUE` (`numero`),
  KEY `fk_consulta_paciente1_idx` (`paciente_cpf`),
  KEY `fk_consulta_medico1_idx` (`medico_crm`),
  KEY `fk_consulta_atendente1_idx` (`atendente_matricula`),
  CONSTRAINT `fk_consulta_atendente1` FOREIGN KEY (`atendente_matricula`) REFERENCES `atendente` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_consulta_medico1` FOREIGN KEY (`medico_crm`) REFERENCES `medico` (`crm`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_consulta_paciente1` FOREIGN KEY (`paciente_cpf`) REFERENCES `paciente` (`cpf`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
INSERT INTO `consulta` (`numero`, `data`, `horario`, `paciente_cpf`, `medico_crm`, `atendente_matricula`) VALUES (1,'2023-06-26','15:00:00','11111111111','55555555',111),(2,'2023-03-01','16:00:00','22222222222','11111111',222),(3,'2022-02-07','12:00:00','33333333333','22222222',333),(4,'2012-05-17','13:00:00','44444444444','33333333',444),(5,'2017-08-16','09:00:00','55555555555','44444444',555);
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consultorio`
--

DROP TABLE IF EXISTS `consultorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consultorio` (
  `numero` int(11) NOT NULL,
  `endereco_id` int(11) NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `fk_consultorio_endereco1_idx` (`endereco_id`),
  CONSTRAINT `fk_consultorio_endereco1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultorio`
--

LOCK TABLES `consultorio` WRITE;
/*!40000 ALTER TABLE `consultorio` DISABLE KEYS */;
INSERT INTO `consultorio` (`numero`, `endereco_id`) VALUES (30,1),(20,2),(35,3),(25,4),(40,5);
/*!40000 ALTER TABLE `consultorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id` int(11) NOT NULL,
  `rua` varchar(100) NOT NULL,
  `cep` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` (`id`, `rua`, `cep`) VALUES (1,'Santa Maria',255),(2,'Riacho Fundo 2',898),(3,'Gama Oeste',2051),(4,'Taguatinga Sul',872),(5,'Ceilandia',333);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (
  `crm` varchar(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `especialidade` varchar(100) NOT NULL,
  `consultorio_numero` int(11) NOT NULL,
  `endereco_id` int(11) NOT NULL,
  PRIMARY KEY (`crm`),
  UNIQUE KEY `crm_UNIQUE` (`crm`),
  KEY `fk_medico_endereco1_idx` (`endereco_id`),
  KEY `fk_medico_consultorio1_idx` (`consultorio_numero`),
  CONSTRAINT `fk_medico_consultorio1` FOREIGN KEY (`consultorio_numero`) REFERENCES `consultorio` (`numero`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_medico_endereco1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` (`crm`, `nome`, `especialidade`, `consultorio_numero`, `endereco_id`) VALUES ('11111111','Miguel','Nutricionista',20,1),('22222222','Pedro','Cardiologista',30,2),('33333333','Hugo','Dentista',35,4),('44444444','Victória','Fisioterapeuta',40,5),('55555555','Glauder','Endocrinologista',25,3);
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `cpf` varchar(20) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `endereco_id` int(11) NOT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  KEY `fk_paciente_endereco1_idx` (`endereco_id`),
  CONSTRAINT `fk_paciente_endereco1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` (`cpf`, `nome`, `telefone`, `endereco_id`) VALUES ('11111111111','Saul','61940028922',2),('22222222222','Marcos','61992929292',1),('33333333333','Yago','61993939393',3),('44444444444','Priscila','61994949494',4),('55555555555','Yasmin','61995959595',5);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-21 18:46:42
