CREATE DATABASE  IF NOT EXISTS `SBC1074` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `SBC1074`;
-- MySQL dump 10.13  Distrib 5.5.55, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: SBC1074
-- ------------------------------------------------------
-- Server version	5.5.55-0ubuntu0.14.04.1

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
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividad` (
  `idactividad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `proceso_idproceso` int(11) NOT NULL,
  `grupo_actividad_idgrupo_actividad` int(11) NOT NULL,
  PRIMARY KEY (`idactividad`),
  KEY `fk_actividad_proceso1_idx` (`proceso_idproceso`),
  KEY `fk_actividad_grupo_actividad1_idx` (`grupo_actividad_idgrupo_actividad`),
  CONSTRAINT `fk_actividad_proceso1` FOREIGN KEY (`proceso_idproceso`) REFERENCES `proceso` (`idproceso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_actividad_grupo_actividad1` FOREIGN KEY (`grupo_actividad_idgrupo_actividad`) REFERENCES `grupo_actividad` (`idgrupo_actividad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (1,'Realizar estimaciones',1,1),(2,'Asignar recursos',1,1),(3,'Definir metricas',1,1),(4,'Plan de evaluaciones',1,2),(5,'Plan de gestion de la configuracion',1,2),(6,'Plan de transicion del sistema',1,2),(7,'Plan de instalacion',1,2),(8,'Documentar',1,2),(9,'Formar',1,2),(10,'Plan de gestion del proyecto',1,2),(11,'Plan de integracion',1,2),(12,'Gestionar riesgos',1,3),(13,'Gestionar el proyecto',1,3),(14,'Identificar requerimientos de mejor del pcvs',1,3),(15,'Mantener registros',1,3),(16,'Recolectar y analizar metricas',1,3),(17,'Identificar ideas o requerimientos',2,4),(18,'Formular enfoques potenciales',2,4),(19,'Realizar estudios de factibilidad',2,4),(20,'Refinar y finalizar la idea o requerimiento',2,4),(21,'Analizar funciones',2,5),(22,'Desarrollar la arquitectura del sistema',2,5),(23,'Descomponer los requerimientos del sistema',2,5),(24,'Identificar requerimientos del software impor',2,6),(25,'Evaluar origenes del software importado',2,6),(26,'Definir el metodo del software importado',2,6),(27,'Importar software',2,6),(28,'Definir y desarrollar requerimientos del soft',3,7),(29,'Definir requerimientos de interfaz',3,7),(30,'Priorizar e integrar requerimientos de softwa',3,7),(31,'Realizar un diseño arquitectonico',3,8),(32,'Diseñar la base de datos',3,8),(33,'Diseñar interfaces',3,8),(34,'Realizar diseño detallado',3,8),(35,'Crear codigo ejecutable',3,9),(36,'Crear documentacion operativa',3,9),(37,'Realizar integracion',3,9),(38,'Distribuir software',4,10),(39,'Instalar software',4,10),(40,'Aceptar el software en el ambiente operaciona',4,10),(41,'Operar el sistema',4,11),(42,'Mantener un log de solicitudes de soporte',4,11),(43,'Proveer asistencia tecnica y consultoria',4,11),(44,'Identificar requerimientos de mejora del soft',4,12),(45,'Implementar metodo de reporte de problemas',4,12),(46,'Reaplicar el ciclo de vida del software',4,12),(47,'Notificar al usuario',4,13),(48,'Realizar operaciones paralelas',4,13),(49,'Retirar el sistema',4,13),(50,'Realizar revisiones',5,14),(51,'Crear matriz de trazabilidad',5,14),(52,'Realizar auditoria',5,14),(53,'Desarrollar procedimientos de testing',5,14),(54,'Crear datos de test',5,14),(55,'Ejecutar tests',5,14),(56,'Reportar resultados de evaluacion',5,14),(57,'Desarrollar identificacion de configuracion',5,15),(58,'Realizar control de configuracion',5,15),(59,'Realizar estado de cuenta',5,15),(60,'Implementar documentacion',5,16),(61,'Producir y distribuir documentacion',5,16),(62,'Desarrollar materiales de formacion',5,17),(63,'Validar el programa de formacion',5,17),(64,'Implementar el programa de formacion',5,17);
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_entrada_de`
--

DROP TABLE IF EXISTS `es_entrada_de`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `es_entrada_de` (
  `producto_idproducto` int(11) NOT NULL,
  `actividad_idactividad` int(11) NOT NULL,
  PRIMARY KEY (`producto_idproducto`,`actividad_idactividad`),
  KEY `fk_producto_has_actividad_actividad1_idx` (`actividad_idactividad`),
  KEY `fk_producto_has_actividad_producto_idx` (`producto_idproducto`),
  CONSTRAINT `fk_producto_has_actividad_producto` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_has_actividad_actividad1` FOREIGN KEY (`actividad_idactividad`) REFERENCES `actividad` (`idactividad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_entrada_de`
--

LOCK TABLES `es_entrada_de` WRITE;
/*!40000 ALTER TABLE `es_entrada_de` DISABLE KEYS */;
INSERT INTO `es_entrada_de` VALUES (27,1),(31,1),(1,2),(27,2),(31,2),(42,2),(5,3),(14,3),(42,3),(3,4),(4,4),(14,4),(16,4),(17,4),(33,4),(39,4),(42,4),(46,4),(14,5),(33,5),(23,6),(26,6),(33,6),(7,7),(14,7),(33,7),(40,7),(50,7),(14,8),(33,8),(14,9),(33,9),(42,9),(102,9),(104,9),(1,10),(2,10),(17,10),(18,10),(23,10),(26,10),(27,10),(33,10),(5,11),(14,11),(33,11),(42,11),(46,11),(1,12),(2,12),(5,12),(7,12),(12,12),(14,12),(15,12),(16,12),(18,12),(22,12),(27,12),(33,12),(41,12),(42,12),(46,12),(90,12),(1,13),(2,13),(5,13),(6,13),(7,13),(9,13),(10,13),(11,13),(12,13),(13,13),(14,13),(15,13),(16,13),(17,13),(22,13),(34,13),(55,13),(64,13),(90,13),(96,13),(18,14),(22,14),(64,14),(75,14),(90,14),(3,16),(4,16),(5,16),(66,16),(67,16),(68,16),(70,16),(71,16),(90,16),(67,17),(69,17),(23,18),(23,19),(24,19),(25,19),(8,20),(23,20),(24,20),(25,20),(26,20),(26,21),(27,21),(14,22),(27,22),(28,22),(28,23),(29,23),(14,24),(42,24),(33,25),(34,26),(35,26),(34,27),(36,27),(14,28),(17,28),(31,28),(32,28),(14,29),(28,29),(31,29),(32,29),(39,29),(17,30),(32,30),(39,30),(14,31),(29,31),(33,31),(42,31),(14,32),(33,32),(42,32),(33,33),(42,33),(14,34),(33,34),(38,34),(42,34),(43,34),(44,34),(45,34),(14,35),(46,35),(10,36),(42,36),(46,36),(14,37),(16,37),(37,37),(47,37),(48,37),(49,37),(85,37),(88,37),(9,38),(14,38),(50,38),(88,38),(52,39),(53,39),(54,39),(57,40),(58,40),(90,40),(15,41),(54,41),(58,41),(15,42),(61,42),(15,43),(5,44),(11,44),(14,44),(22,44),(75,44),(90,44),(12,45),(19,45),(20,45),(64,45),(90,45),(94,45),(12,46),(14,46),(66,46),(67,46),(68,46),(13,47),(13,48),(58,48),(13,49),(5,50),(14,50),(33,50),(38,50),(63,50),(70,50),(82,50),(83,50),(42,51),(5,52),(14,52),(5,53),(42,53),(46,53),(5,54),(33,54),(42,54),(46,54),(47,54),(49,54),(70,54),(84,54),(5,55),(37,55),(48,55),(51,55),(84,55),(85,55),(86,55),(14,56),(19,56),(70,56),(76,56),(77,56),(78,56),(79,56),(80,56),(83,56),(87,56),(6,57),(14,57),(82,57),(6,58),(81,58),(92,58),(6,59),(92,59),(93,59),(10,60),(14,60),(38,60),(10,61),(96,61),(11,62),(14,62),(38,62),(46,62),(11,63),(98,63),(99,63),(100,63),(11,64),(102,64),(103,64);
/*!40000 ALTER TABLE `es_entrada_de` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_salida_de`
--

DROP TABLE IF EXISTS `es_salida_de`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `es_salida_de` (
  `producto_idproducto` int(11) NOT NULL,
  `actividad_idactividad` int(11) NOT NULL,
  PRIMARY KEY (`producto_idproducto`,`actividad_idactividad`),
  KEY `fk_producto_has_actividad_actividad2_idx` (`actividad_idactividad`),
  KEY `fk_producto_has_actividad_producto1_idx` (`producto_idproducto`),
  CONSTRAINT `fk_producto_has_actividad_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_has_actividad_actividad2` FOREIGN KEY (`actividad_idactividad`) REFERENCES `actividad` (`idactividad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_salida_de`
--

LOCK TABLES `es_salida_de` WRITE;
/*!40000 ALTER TABLE `es_salida_de` DISABLE KEYS */;
INSERT INTO `es_salida_de` VALUES (1,1),(2,2),(3,3),(4,3),(5,4),(6,5),(7,6),(8,6),(9,7),(10,8),(11,9),(12,10),(13,10),(14,10),(15,10),(16,11),(17,12),(18,13),(19,13),(20,14),(21,15),(22,16),(23,17),(24,18),(25,18),(26,19),(27,20),(28,21),(29,22),(30,23),(31,23),(32,23),(33,24),(34,25),(35,25),(36,26),(37,27),(38,27),(39,28),(40,28),(41,29),(42,30),(43,31),(44,32),(45,33),(46,34),(47,35),(48,35),(49,35),(50,36),(51,37),(52,38),(53,38),(54,38),(55,39),(56,39),(57,40),(58,40),(59,41),(60,41),(61,42),(62,43),(63,43),(64,44),(65,45),(66,45),(67,45),(68,45),(69,46),(70,46),(71,46),(72,47),(73,48),(74,49),(75,49),(76,50),(77,50),(78,50),(79,50),(80,50),(81,50),(82,51),(83,52),(84,53),(85,54),(86,54),(87,55),(88,55),(89,55),(90,56),(91,56),(92,57),(93,58),(94,58),(94,59),(95,59),(96,60),(97,61),(98,62),(99,62),(100,62),(101,63),(102,63),(103,63),(104,64);
/*!40000 ALTER TABLE `es_salida_de` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fase`
--

DROP TABLE IF EXISTS `fase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fase` (
  `idfase` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idfase`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase`
--

LOCK TABLES `fase` WRITE;
/*!40000 ALTER TABLE `fase` DISABLE KEYS */;
/*!40000 ALTER TABLE `fase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fase_has_actividad`
--

DROP TABLE IF EXISTS `fase_has_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fase_has_actividad` (
  `fase_idfase` int(11) NOT NULL,
  `actividad_idactividad` int(11) NOT NULL,
  `fase_inicial` tinyint(1) DEFAULT NULL,
  `fase_final` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`fase_idfase`,`actividad_idactividad`),
  KEY `fk_fase_has_actividad_actividad1_idx` (`actividad_idactividad`),
  KEY `fk_fase_has_actividad_fase1_idx` (`fase_idfase`),
  CONSTRAINT `fk_fase_has_actividad_fase1` FOREIGN KEY (`fase_idfase`) REFERENCES `fase` (`idfase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fase_has_actividad_actividad1` FOREIGN KEY (`actividad_idactividad`) REFERENCES `actividad` (`idactividad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase_has_actividad`
--

LOCK TABLES `fase_has_actividad` WRITE;
/*!40000 ALTER TABLE `fase_has_actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `fase_has_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo_actividad`
--

DROP TABLE IF EXISTS `grupo_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo_actividad` (
  `idgrupo_actividad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `proceso_idproceso` int(11) NOT NULL,
  PRIMARY KEY (`idgrupo_actividad`),
  KEY `fk_grupo_actividad_proceso1_idx` (`proceso_idproceso`),
  CONSTRAINT `fk_grupo_actividad_proceso1` FOREIGN KEY (`proceso_idproceso`) REFERENCES `proceso` (`idproceso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo_actividad`
--

LOCK TABLES `grupo_actividad` WRITE;
/*!40000 ALTER TABLE `grupo_actividad` DISABLE KEYS */;
INSERT INTO `grupo_actividad` VALUES (1,'Iniciacion del proyecto',1),(2,'Planeamiento del proyecto',1),(3,'Monitoreo y control del proyecto',1),(4,'Exploracion de conceptos',2),(5,'Asignacion del sistema',2),(6,'Importacion de Software',2),(7,'Requerimientos',3),(8,'Diseño',3),(9,'Implementacion',3),(10,'Instalacion',4),(11,'Operacion y Soporte',4),(12,'Mantenimiento',4),(13,'Retiro',4),(14,'Evaluacion',5),(15,'Gestion de la configuracion del Software',5),(16,'Desarrollo de la documentacion',5),(17,'Formacion',5);
/*!40000 ALTER TABLE `grupo_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proceso`
--

DROP TABLE IF EXISTS `proceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proceso` (
  `idproceso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idproceso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proceso`
--

LOCK TABLES `proceso` WRITE;
/*!40000 ALTER TABLE `proceso` DISABLE KEYS */;
INSERT INTO `proceso` VALUES (1,'Procesos de gestion del proyecto'),(2,'Procesos de predesarrollo'),(3,'Procesos de desarrollo'),(4,'Procesos de postdesarrollo'),(5,'Procesos integrales');
/*!40000 ALTER TABLE `proceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Estimaciones'),(2,'Asignacion de recursos'),(3,'Métricas definidas'),(4,'Metodos de analisis y recoleccion'),(5,'Plan de evaluación'),(6,'Plan de gestion de la configuración'),(7,'Plan de transición'),(8,'Evaluación del impacto de la transición'),(9,'Plan de instalación del Software'),(10,'Plan de documentación'),(11,'Plan de formación'),(12,'Plan de Informe y resolución de problemas'),(13,'Plan de retiro'),(14,'Plan de gestión del proyecto'),(15,'Plan de soporte'),(16,'Plan de Integración'),(17,'Informe de riesgos'),(18,'Informe de gestión del proyecto'),(19,'Anomalias'),(20,'Requerimientos de mejoras del entorno'),(21,'Registros históricos'),(22,'Informe de análisis de información'),(23,'Evaluación primaria de necesidades'),(24,'Restricciones y beneficios'),(25,'Soluciones potenciales'),(26,'Recomendaciones'),(27,'Necesidades'),(28,'Descripción funcional del sistema'),(29,'Arquitectura del sistema'),(30,'Requisitos funcionales del hardware'),(31,'Requisitos funcionales del software'),(32,'Requisitos de la interfaz del sistema'),(33,'Requisitos de software externo'),(34,'Origenes seleccionados del software externo'),(35,'Métodos candidatos de importacion de software'),(36,'Método de importación de SW seleccionado'),(37,'Software importado'),(38,'Documentación del software importado'),(39,'Requisitos preliminares de software'),(40,'Requisitos de instalacion'),(41,'Requisitos de la interfaz de software'),(42,'Requisitos de software'),(43,'Diseño arquitectonico del software'),(44,'Diseño de base de datos'),(45,'Diseño de Interfaces'),(46,'Diseño detallado de software'),(47,'Código fuente'),(48,'Código Ejecutable'),(49,'Base de datos'),(50,'Documentación de operación'),(51,'Software integrado'),(52,'Plan de instalación por paquete'),(53,'Software empaquetado'),(54,'Documentación de operación empaquetada'),(55,'Informe de instalación'),(56,'Software instalado'),(57,'Aceptación del cliente'),(58,'Sistema software instalado'),(59,'Histórico de operación'),(60,'Anomalías de operación'),(61,'Respuestas de soporte'),(62,'Anomalías de mantenimiento'),(63,'Histórico de peticiones de soporte'),(64,'Recomendaciones de Mejora del software'),(65,'Anomalías no consideradas'),(66,'Histórico de reportes'),(67,'Información de problemas de mejora'),(68,'Información de corrección de problemas'),(69,'Recomendaciones de mantenimiento'),(70,'Información de problemas resueltos'),(71,'Histórico de reportes actualizado'),(72,'Notificación oficial'),(73,'Histórico de operaciones paralelas'),(74,'Histórico de archivo de información'),(75,'Información de revisión post operación'),(76,'Revisión de resultados en proceso'),(77,'Información de Revisión post-implementacion'),(78,'Recomendaciones de mejora de proceso'),(79,'Información de estado de la gestión'),(80,'Información de analisis de trazabilidad'),(81,'Información de cambios en la asignación del s'),(82,'Matriz de trazabilidad'),(83,'Información de resultados de auditoría'),(84,'Procedimientos de prueba'),(85,'Stubs y drivers para pruebas'),(86,'Datos de prueba'),(87,'Información sumaria de pruebas'),(88,'Software probado'),(89,'Anomalías Software probado'),(90,'Informe de evaluación'),(91,'Anomalias de evaluación'),(92,'Identificación de la configuración'),(93,'Cambio de estado'),(94,'Item controlado'),(95,'Información de reporte de estado'),(96,'Documentación'),(97,'Documentación Publicada'),(98,'Manual de entrenamiento'),(99,'Material de entrenamiento'),(100,'Presentaciones preparadas'),(101,'Feedback durante el entrenamiento'),(102,'Manual de entrenamiento actualizado'),(103,'Material de entrenamiento actualizado'),(104,'Personal entrenado');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-06 10:46:19