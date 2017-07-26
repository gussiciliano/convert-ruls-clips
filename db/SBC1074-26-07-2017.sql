CREATE DATABASE  IF NOT EXISTS `SBC1074` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `SBC1074`;
-- MySQL dump 10.13  Distrib 5.5.55, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: SBC1074
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
  `nombre` varchar(100) DEFAULT NULL,
  `proceso_idproceso` int(11) NOT NULL,
  `grupo_actividad_idgrupo_actividad` int(11) NOT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idactividad`),
  KEY `fk_actividad_proceso1_idx` (`proceso_idproceso`),
  KEY `fk_actividad_grupo_actividad1_idx` (`grupo_actividad_idgrupo_actividad`),
  CONSTRAINT `fk_actividad_grupo_actividad1` FOREIGN KEY (`grupo_actividad_idgrupo_actividad`) REFERENCES `grupo_actividad` (`idgrupo_actividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_actividad_proceso1` FOREIGN KEY (`proceso_idproceso`) REFERENCES `proceso` (`idproceso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (1,'Realizar estimaciones',1,1,'estimar'),(2,'Asignar recursos',1,1,'asignar-recursos'),(3,'Definir metricas',1,1,'def-metricas'),(4,'Planificar evaluaciones',1,2,'planif-eval'),(5,'Planificar al gestion de la configuracion',1,2,'planif-config'),(6,'Planificar la transicion del sistema',1,2,'planif-trans'),(7,'Planificar la instalacion',1,2,'planif-inst'),(8,'Planificar la documentación',1,2,'planif-doc'),(9,'Planaificar la Formación',1,2,'planif-form'),(10,'Planificar la gestion del proyecto',1,2,'planif-gest'),(11,'Planificar la integracion',1,2,'planif-integ'),(12,'Gestionar riesgos',1,3,'gestion-riesgo'),(13,'Gestionar el proyecto',1,3,'gestion-proyecto'),(14,'Identificar requerimientos de mejor del pcvs',1,3,'mejora-pcvs'),(15,'Archivar registros',1,3,'archivar-reg'),(16,'Recolectar y analizar metricas',1,3,'recol-metricas'),(17,'Identificar ideas o necesidades',2,4,'identificar-ideas'),(18,'Formular soluciones potenciales',2,4,'formular-solucion'),(19,'Realizar estudios de factibilidad',2,4,'estudio-factibilidad'),(20,'Refinar y finalizar la idea o requerimiento',2,4,'refinar-idea'),(21,'Analizar funciones',2,5,'analizar-funciones'),(22,'Desarrollar la arquitectura del sistema',2,5,'desarrollar-arquitectura'),(23,'Descomponer los requerimientos del sistema',2,5,'descom-req-sistema'),(24,'Identificar requerimientos del software impor',2,6,'ident-req-swi'),(25,'Evaluar origenes del software importado',2,6,'eval-orig-swi'),(26,'Definir el metodo de importacion de software',2,6,'def-metodo-swi'),(27,'Importar software',2,6,'importar-sw'),(28,'Definir y desarrollar requisitos del software',3,7,'definir-requisitos-SW'),(29,'Definir requisitos de interfaz',3,7,'definir-requisitos-IF'),(30,'Priorizar e integrar requisitos de software',3,7,'integrar-requisitos-SW'),(31,'Realizar un diseño arquitectonico',3,8,'disenio-arq'),(32,'Diseñar la base de datos',3,8,'diseniar-BD'),(33,'Diseñar interfaces',3,8,'diseniar-IF'),(34,'Realizar diseño detallado',3,8,'disenio-detallado'),(35,'Crear codigo objeto',3,9,'crear-objeto'),(36,'Crear documentacion de operación',3,9,'crear-doc-operacion'),(37,'Realizar integracion',3,9,'realizar-integracion'),(38,'Distribuir software',4,10,'distribuir-sw'),(39,'Instalar software',4,10,'instalar-sw'),(40,'Aceptar el software en el ambiente operaciona',4,10,'aceptar-sw'),(41,'Operar el sistema',4,11,'operar'),(42,'Mantener el histórico de solicitudes de soporte',4,11,'historico-soporte'),(43,'Proveer asistencia tecnica y consultoria',4,11,'prov-asist-consult'),(44,'Identificar requisitos de mejora del software',4,12,'indentif-req-mejora'),(45,'Implementar metodo de reporte de problemas',4,12,'impl-reporte-prob'),(46,'Reaplicar el ciclo de vida del software',4,12,'reaplicar-cv'),(47,'Notificar al usuario',4,13,'notificar'),(48,'Realizar operaciones paralelas',4,13,'op-paralelas'),(49,'Retirar el sistema',4,13,'retirar'),(50,'Realizar revisiones',5,14,'ejec-revisiones'),(51,'Crear matriz de trazabilidad',5,14,'crear-matriz'),(52,'Realizar auditoria',5,14,'realizar-auditoria'),(53,'Desarrollar procedimientos de prueba',5,14,'procedim-prueba'),(54,'Crear datos de prueba',5,14,'crear-datos-prueba'),(55,'Ejecutar pruebas',5,14,'ejecutar-pruebas'),(56,'Reportar resultados de evaluacion',5,14,'report-resultados'),(57,'Desarrollar identificacion de configuracion',5,15,'indentif-config'),(58,'Realizar gestion de configuracion',5,15,'realiz-gestion'),(59,'Realizar información de estado de configuración',5,15,'estado-config'),(60,'Implementar documentacion',5,16,'implem-doc'),(61,'Producir y distribuir documentacion',5,16,'dist-doc'),(62,'Desarrollar materiales de formacion',5,17,'desarr-mat-formacion'),(63,'Validar el programa de formacion',5,17,'validar-formacion'),(64,'Implementar el programa de formacion',5,17,'implem-formacion');
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_entrada_de`
--

DROP TABLE IF EXISTS `es_entrada_de`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `es_entrada_de` (
  `idproducto` int(11) NOT NULL,
  `idactividad` int(11) NOT NULL,
  PRIMARY KEY (`idproducto`,`idactividad`),
  KEY `fk_producto_has_actividad_actividad1_idx` (`idactividad`),
  KEY `fk_producto_has_actividad_producto_idx` (`idproducto`),
  CONSTRAINT `fk_producto_has_actividad_actividad1` FOREIGN KEY (`idactividad`) REFERENCES `actividad` (`idactividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_has_actividad_producto` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `es_entrada_de`
--

LOCK TABLES `es_entrada_de` WRITE;
/*!40000 ALTER TABLE `es_entrada_de` DISABLE KEYS */;
INSERT INTO `es_entrada_de` VALUES (27,1),(31,1),(1,2),(27,2),(31,2),(42,2),(5,3),(14,3),(42,3),(3,4),(4,4),(14,4),(16,4),(17,4),(33,4),(39,4),(42,4),(46,4),(14,5),(33,5),(23,6),(26,6),(33,6),(7,7),(14,7),(33,7),(40,7),(50,7),(14,8),(33,8),(14,9),(33,9),(42,9),(102,9),(104,9),(1,10),(2,10),(17,10),(18,10),(23,10),(26,10),(27,10),(33,10),(5,11),(14,11),(33,11),(42,11),(46,11),(1,12),(2,12),(5,12),(7,12),(12,12),(14,12),(15,12),(16,12),(18,12),(22,12),(27,12),(33,12),(41,12),(42,12),(46,12),(90,12),(1,13),(2,13),(5,13),(6,13),(7,13),(9,13),(10,13),(11,13),(12,13),(13,13),(14,13),(15,13),(16,13),(17,13),(22,13),(34,13),(55,13),(64,13),(90,13),(96,13),(18,14),(22,14),(64,14),(75,14),(90,14),(3,16),(4,16),(5,16),(66,16),(67,16),(68,16),(70,16),(71,16),(90,16),(105,17),(106,17),(107,17),(108,17),(109,17),(23,18),(23,19),(24,19),(25,19),(8,20),(23,20),(24,20),(25,20),(26,20),(26,21),(27,21),(14,22),(27,22),(28,22),(28,23),(29,23),(14,24),(42,24),(33,25),(34,26),(35,26),(34,27),(36,27),(14,28),(17,28),(31,28),(32,28),(14,29),(28,29),(31,29),(32,29),(39,29),(17,30),(32,30),(39,30),(14,31),(29,31),(33,31),(42,31),(14,32),(33,32),(42,32),(33,33),(42,33),(14,34),(33,34),(38,34),(42,34),(43,34),(44,34),(45,34),(14,35),(46,35),(10,36),(42,36),(46,36),(14,37),(16,37),(37,37),(47,37),(48,37),(49,37),(85,37),(88,37),(9,38),(14,38),(50,38),(88,38),(52,39),(53,39),(54,39),(57,40),(58,40),(90,40),(15,41),(54,41),(58,41),(15,42),(61,42),(15,43),(5,44),(11,44),(14,44),(22,44),(75,44),(90,44),(12,45),(19,45),(20,45),(64,45),(90,45),(94,45),(12,46),(14,46),(66,46),(67,46),(68,46),(13,47),(13,48),(58,48),(13,49),(5,50),(14,50),(33,50),(38,50),(63,50),(70,50),(82,50),(83,50),(42,51),(5,52),(14,52),(5,53),(42,53),(46,53),(5,54),(33,54),(42,54),(46,54),(47,54),(49,54),(70,54),(84,54),(5,55),(37,55),(48,55),(51,55),(84,55),(85,55),(86,55),(14,56),(19,56),(70,56),(76,56),(77,56),(78,56),(79,56),(80,56),(83,56),(87,56),(6,57),(14,57),(82,57),(6,58),(81,58),(92,58),(6,59),(92,59),(93,59),(10,60),(14,60),(38,60),(10,61),(96,61),(11,62),(14,62),(38,62),(46,62),(11,63),(98,63),(99,63),(100,63),(11,64),(102,64),(103,64);
/*!40000 ALTER TABLE `es_entrada_de` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `es_salida_de`
--

DROP TABLE IF EXISTS `es_salida_de`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `es_salida_de` (
  `idproducto` int(11) NOT NULL,
  `idactividad` int(11) NOT NULL,
  PRIMARY KEY (`idproducto`,`idactividad`),
  KEY `fk_producto_has_actividad_actividad2_idx` (`idactividad`),
  KEY `fk_producto_has_actividad_producto1_idx` (`idproducto`),
  CONSTRAINT `fk_producto_has_actividad_actividad2` FOREIGN KEY (`idactividad`) REFERENCES `actividad` (`idactividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_has_actividad_producto1` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `codigo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idfase`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase`
--

LOCK TABLES `fase` WRITE;
/*!40000 ALTER TABLE `fase` DISABLE KEYS */;
INSERT INTO `fase` VALUES (1,'Preparación','preparacion'),(2,'Requisitos y análisis','req-analisis'),(3,'Diseño','disenio'),(4,'Codificación','codificacion'),(5,'Integración','integracion'),(6,'Implementación','implementacion'),(7,'Operación y mantenimiento','operacion'),(8,'Retiro','retiro');
/*!40000 ALTER TABLE `fase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fase_has_actividad`
--

DROP TABLE IF EXISTS `fase_has_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fase_has_actividad` (
  `fase_idfase` int(11) DEFAULT NULL,
  `actividad_idactividad` int(11) DEFAULT NULL,
  `fase_inicial` tinyint(1) DEFAULT NULL,
  `fase_final` tinyint(1) DEFAULT NULL,
  `id_fase_has_actividad` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_fase_has_actividad`),
  KEY `fk_fase_has_actividad_actividad1_idx` (`actividad_idactividad`),
  KEY `fk_fase_has_actividad_fase1_idx` (`fase_idfase`),
  CONSTRAINT `fk_fase_has_actividad_actividad1` FOREIGN KEY (`actividad_idactividad`) REFERENCES `actividad` (`idactividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fase_has_actividad_fase1` FOREIGN KEY (`fase_idfase`) REFERENCES `fase` (`idfase`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=955 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase_has_actividad`
--

LOCK TABLES `fase_has_actividad` WRITE;
/*!40000 ALTER TABLE `fase_has_actividad` DISABLE KEYS */;
INSERT INTO `fase_has_actividad` VALUES (2,1,1,1,842),(2,2,1,0,843),(3,2,0,0,844),(4,2,0,0,845),(5,2,0,0,846),(6,2,0,0,847),(7,2,0,0,848),(8,2,0,1,849),(2,3,1,0,850),(3,3,0,1,851),(2,4,1,1,852),(2,5,1,1,853),(6,7,1,1,854),(2,8,1,1,855),(2,9,1,1,856),(2,10,1,1,857),(2,11,1,0,858),(6,11,0,1,859),(2,12,1,0,860),(3,12,0,0,861),(4,12,0,0,862),(5,12,0,0,863),(6,12,0,1,864),(2,13,1,0,865),(3,13,0,0,866),(4,13,0,0,867),(5,13,0,0,868),(6,13,0,0,869),(7,13,0,0,870),(8,13,0,1,871),(7,14,1,0,872),(8,14,0,1,873),(1,15,1,0,874),(2,15,0,0,875),(3,15,0,0,876),(4,15,0,0,877),(5,15,0,0,878),(6,15,0,0,879),(7,15,0,0,880),(8,15,0,1,881),(2,16,1,0,882),(3,16,0,0,883),(4,16,0,0,884),(5,16,0,0,885),(6,16,0,0,886),(7,16,0,0,887),(8,16,0,1,888),(1,17,1,1,889),(1,18,1,0,890),(2,18,0,1,891),(1,19,1,0,892),(2,19,0,1,893),(2,20,1,1,894),(2,21,1,0,895),(3,21,0,1,896),(2,22,1,1,897),(2,23,1,1,898),(2,28,1,1,899),(2,29,1,1,900),(2,30,1,1,901),(2,31,1,0,902),(3,31,0,1,903),(3,32,1,1,904),(3,33,1,1,905),(3,34,1,1,906),(4,35,1,1,907),(3,36,1,0,908),(4,36,0,0,909),(5,36,0,1,910),(5,37,1,1,911),(6,38,1,1,912),(6,39,1,1,913),(6,40,1,1,914),(7,41,1,1,915),(7,42,1,1,916),(7,43,1,1,917),(7,44,1,1,918),(3,45,1,1,919),(7,47,1,0,920),(8,47,0,1,921),(8,49,1,1,922),(2,50,1,0,923),(3,50,0,0,924),(4,50,0,0,925),(5,50,0,1,926),(2,51,1,0,927),(3,51,0,0,928),(4,51,0,0,929),(5,51,0,1,930),(2,52,1,0,931),(3,52,0,0,932),(4,52,0,1,933),(4,53,1,1,934),(4,54,1,1,935),(4,55,1,0,936),(5,55,0,0,937),(6,55,0,1,938),(1,57,1,1,939),(2,58,1,0,940),(3,58,0,0,941),(4,58,0,0,942),(5,58,0,0,943),(6,58,0,0,944),(7,58,0,1,945),(3,60,1,0,946),(4,60,0,0,947),(5,60,0,1,948),(5,61,1,0,949),(6,61,0,1,950),(5,62,1,1,951),(6,63,1,1,952),(6,64,1,0,953),(7,64,0,1,954);
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
  `codigo` varchar(45) DEFAULT NULL,
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
INSERT INTO `grupo_actividad` VALUES (1,'Proceso de Iniciacion del proyecto',1,'actividad-inic'),(2,'Proceso de Planeamiento del proyecto',1,'actividad-plan'),(3,'Proceso de Seguimiento y control del proyecto',1,'actividad-syc'),(4,'Proceso de Exploracion de conceptos',2,'actividad-exp'),(5,'Proceso de Asignacion del sistema',2,'actividad-asig'),(6,'Proceso de Importacion de Software',2,'actividad-imp'),(7,'Proceso de Requerimientos',3,'actividad-req'),(8,'Proceso de Diseño',3,'actividad-dis'),(9,'Proceso de Implementacion',3,'actividad-impl'),(10,'Proceso de Instalacion',4,'actividad-inst'),(11,'Proceso de Operacion y Soporte',4,'actividad-oys'),(12,'Proceso de Mantenimiento',4,'actividad-mant'),(13,'Proceso de Retiro',4,'actividad-ret'),(14,'Proceso de Verificación y validación',5,'actividad-vyv'),(15,'Proceso de Gestion de la configuracion del So',5,'actividad-conf'),(16,'Proceso de Desarrollo de la documentacion',5,'actividad-doc'),(17,'Proceso de Formacion',5,'actividad-form');
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
  `codigo` varchar(45) DEFAULT NULL,
  `interno` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Estimaciones','estimac',1),(2,'Asignacion de recursos','asig-recursos',1),(3,'Métricas definidas','metricas-def',1),(4,'Metodos de analisis y recoleccion','met-analisis',1),(5,'Plan de evaluación','plan-evaluac',1),(6,'Plan de gestion de la configuración','plan-config',1),(7,'Plan de transición','plan-transic',1),(8,'Evaluación del impacto de la transición','eval-transicion',1),(9,'Plan de instalación del Software','plan-inst',1),(10,'Plan de documentación','plan-doc',1),(11,'Plan de formación','plan-formac',1),(12,'Plan de Informe y resolución de problemas','plan-problemas',1),(13,'Plan de retiro','plan-retiro',1),(14,'Plan de gestión del proyecto','plan-gestion',1),(15,'Plan de soporte','plan-soporte',1),(16,'Plan de Integración','plan-integrac',1),(17,'Informe de riesgos','inf-riesgos',1),(18,'Informe de gestión del proyecto','inf-gestion',1),(19,'Anomalias','anomalias',1),(20,'Requerimientos de mejoras del entorno','req-mejora',1),(21,'Registros históricos','reg-historicos',1),(22,'Informe de análisis de información','inf-analisis-info',1),(23,'Evaluación primaria de necesidades','eval-prim-necesidades',1),(24,'Restricciones y beneficios','restric-benef',1),(25,'Soluciones potenciales','soluc-potenc',1),(26,'Recomendaciones','recomendaciones',1),(27,'Necesidades','necesidades',1),(28,'Descripción funcional del sistema','desc-func-sistema',1),(29,'Arquitectura del sistema','arq-sistema',1),(30,'Requisitos funcionales del hardware','req-func-hw',1),(31,'Requisitos funcionales del software','req-func-sw',1),(32,'Requisitos de la interfaz del sistema','req-if',1),(33,'Requisitos de software externo','req-sw-ext',1),(34,'Origenes seleccionados del software externo','orig-sw-ext',1),(35,'Métodos candidatos de importacion de software','met-cand-import-sw',1),(36,'Método de importación de SW seleccionado','met-sel-import-sw',1),(37,'Software importado','sw-import',1),(38,'Documentación del software importado','doc-sw-iport',1),(39,'Requisitos preliminares de software','req-prelim-sw',1),(40,'Requisitos de instalacion','req-inst',1),(41,'Requisitos de la interfaz de software','req-if-sw',1),(42,'Requisitos de software','req-sw',1),(43,'Diseño arquitectonico del software','dis-arq-sw',1),(44,'Diseño de base de datos','dis-bd',1),(45,'Diseño de Interfaces','dis-if',1),(46,'Diseño detallado de software','dis-det-sw',1),(47,'Código fuente','cod-fte',1),(48,'Código Ejecutable','cod-ejec',1),(49,'Base de datos','bd',1),(50,'Documentación de operación','doc-operac',1),(51,'Software integrado','sw-integrado',1),(52,'Plan de instalación por paquete','plan-inst-paq',1),(53,'Software empaquetado','sw-empaq',1),(54,'Documentación de operación empaquetada','doc-op-empaq',1),(55,'Informe de instalación','inf-inst',1),(56,'Software instalado','sw-inst',1),(57,'Aceptación del cliente','acep-cliente',1),(58,'Sistema software instalado','sist-sw-integ',1),(59,'Histórico de operación','hist-operac',1),(60,'Anomalías de operación','anom-operac',1),(61,'Respuestas de soporte','resp-soporte',1),(62,'Anomalías de mantenimiento','anom-mant',1),(63,'Histórico de peticiones de soporte','host-soporte',1),(64,'Recomendaciones de Mejora del software','rec-mej-sw',1),(65,'Anomalías no consideradas','anom-no-consid',1),(66,'Histórico de reportes','hist-reportes',1),(67,'Información de problemas de mejora','inf-prob-mejora',1),(68,'Información de corrección de problemas','inf-corr-problema',1),(69,'Recomendaciones de mantenimiento','recom-mant',1),(70,'Información de problemas resueltos','inf-prob-resuel',1),(71,'Histórico de reportes actualizado','hist-report-act',1),(72,'Notificación oficial','notif-oficial',1),(73,'Histórico de operaciones paralelas','hist-oper-paral',1),(74,'Histórico de archivo de información','hist-arch-info',1),(75,'Información de revisión post operación','inf-revis-post-op',1),(76,'Revisión de resultados en proceso','rev-result-proc',1),(77,'Información de Revisión post-implementacion','inf-rev-post-imp',1),(78,'Recomendaciones de mejora de proceso','rec-mej-proceso',1),(79,'Información de estado de la gestión','info-est-gestion',1),(80,'Información de analisis de trazabilidad','info-analisis-traz',1),(81,'Información de cambios en la asignación del s','info-cambios-asig',1),(82,'Matriz de trazabilidad','matriz-traz',1),(83,'Información de resultados de auditoría','inf-result-audit',1),(84,'Procedimientos de prueba','proc-prueba',1),(85,'Stubs y drivers para pruebas','stub-driver',1),(86,'Datos de prueba','datos-prueba',1),(87,'Información sumaria de pruebas','info-sum-pruebas',1),(88,'Software probado','sw-probado',1),(89,'Anomalías Software probado','anomal-sw-probado',1),(90,'Informe de evaluación','inf-eval',1),(91,'Anomalias de evaluación','anom-eval',1),(92,'Identificación de la configuración','iden-conf',1),(93,'Cambio de estado','camb-estado',1),(94,'Item controlado','item-controlado',1),(95,'Información de reporte de estado','info-rep-estado',1),(96,'Documentación','docum',1),(97,'Documentación Publicada','docum-publ',1),(98,'Manual de entrenamiento','manual-entrenam',1),(99,'Material de entrenamiento','mat-entrenam',1),(100,'Presentaciones preparadas','pres-prepar',1),(101,'Feedback durante el entrenamiento','feedback-entrenam',1),(102,'Manual de entrenamiento actualizado','manual-entrenam-act',1),(103,'Material de entrenamiento actualizado','mat-entrenam-act',1),(104,'Personal entrenado','personal-entrenado',1),(105,'Requerimientos de software cambiantes','req-sw-camb',0),(106,'Solicitudes del Cliente','sol-cliente',0),(107,'Ideas propias de la organización','ideas-propias',0),(108,'Informacion de mercadeo','info-mercadeo',0),(109,'Solicitudes de usuario','sol-usuario',0),(110,'Recursos de desarrollo y presupuesto','rec-desarrollo',0),(111,'Información de disponibilidad de mercado','info-mercado',0),(112,'Información de recursos','info-recursos',0);
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

-- Dump completed on 2017-07-26 19:47:34
