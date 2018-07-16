CREATE DATABASE  IF NOT EXISTS `eagle` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `eagle`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eagle
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.25-MariaDB

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `ClientID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `ClientName` varchar(45) NOT NULL,
  `Address` longtext,
  `City` varchar(100) DEFAULT NULL,
  `Status` varchar(45) DEFAULT 'Active',
  PRIMARY KEY (`ClientID`)
) ENGINE=InnoDB AUTO_INCREMENT=10000022 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (10000016,'Ministop','EGI, Taft Ave, Pasay','Pasay','Active'),(10000017,'711','The Manila Residences T2, Taft Ave. Malate Manila','Pasay','Active'),(10000018,'Ministop','Vito Cruz, near Roxas Boulevard','Pasay','Active'),(10000019,'711','One Archers Taft Ave. Manila','Pasay','Active'),(10000020,'Lawson','BGC High Street','Taguig','Active'),(10000021,'Padu','7162','Caloocan','Active');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ing_audit`
--

DROP TABLE IF EXISTS `ing_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ing_audit` (
  `audit_id` int(11) NOT NULL AUTO_INCREMENT,
  `ID` bigint(20) unsigned NOT NULL,
  `auditNameIng` varchar(45) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `audit_timelog` date NOT NULL,
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ing_audit`
--

LOCK TABLES `ing_audit` WRITE;
/*!40000 ALTER TABLE `ing_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `ing_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientlists`
--

DROP TABLE IF EXISTS `ingredientlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredientlists` (
  `Amount` decimal(20,2) unsigned NOT NULL,
  `UnitOfMeasurement` varchar(45) NOT NULL,
  `ProductCode` int(20) unsigned NOT NULL,
  `IngredientCode` int(20) unsigned NOT NULL,
  `IngredientName` varchar(45) DEFAULT NULL,
  KEY `fk_ingredientlists_ingredients1_idx` (`IngredientCode`),
  KEY `fk_ingredientlists_products1_idx` (`ProductCode`),
  CONSTRAINT `fk_ingredientlists_ingredients1` FOREIGN KEY (`IngredientCode`) REFERENCES `ingredients` (`IngredientCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ingredientlists_products1` FOREIGN KEY (`ProductCode`) REFERENCES `products` (`ProductCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientlists`
--

LOCK TABLES `ingredientlists` WRITE;
/*!40000 ALTER TABLE `ingredientlists` DISABLE KEYS */;
INSERT INTO `ingredientlists` VALUES (5.00,'Dozen',119,112,NULL),(10.00,'Kg',120,116,NULL);
/*!40000 ALTER TABLE `ingredientlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredients` (
  `IngredientCode` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `IngredientName` varchar(45) NOT NULL,
  `Stock` decimal(20,2) unsigned NOT NULL,
  `Threshold` int(20) NOT NULL,
  `tillThreshold` int(20) DEFAULT NULL,
  `Ceiling` int(20) NOT NULL,
  `tilCeiling` int(20) DEFAULT NULL,
  `UnitOfMeasurement` varchar(45) NOT NULL,
  `Status` varchar(8) DEFAULT 'Active',
  PRIMARY KEY (`IngredientCode`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (111,'Flour',500.00,100,NULL,1000,NULL,'Kg','Active'),(112,'Eggs',325.00,100,NULL,1000,NULL,'Dozen','Active'),(113,'Chocolate',175.00,100,NULL,500,NULL,'Kg','Active'),(114,'Rice',550.00,100,NULL,1000,NULL,'Kg','Active'),(115,'Cheese',275.00,100,NULL,500,NULL,'Kg','Active'),(116,'Ham',275.00,100,NULL,500,NULL,'Kg','Active'),(117,'Noodles',450.00,100,NULL,1000,NULL,'Kg','Active'),(121,'Sugar',600.00,100,NULL,1000,NULL,'Kg','Active');
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacture`
--

DROP TABLE IF EXISTS `manufacture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manufacture` (
  `ProductCode` int(20) unsigned NOT NULL,
  `AmountManufactured` int(20) unsigned NOT NULL,
  `DateManufactured` date NOT NULL,
  KEY `fk_Manufacture_Products1` (`ProductCode`),
  CONSTRAINT `fk_Manufacture_Products1` FOREIGN KEY (`ProductCode`) REFERENCES `products` (`ProductCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacture`
--

LOCK TABLES `manufacture` WRITE;
/*!40000 ALTER TABLE `manufacture` DISABLE KEYS */;
/*!40000 ALTER TABLE `manufacture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetails` (
  `PurchaseOrderNo` int(20) unsigned NOT NULL,
  `ProductCode` int(20) unsigned NOT NULL,
  `UnitPrice` decimal(10,2) NOT NULL,
  `QuantityOrdered` int(20) NOT NULL,
  KEY `fk_OrderDetails_Orders1_idx` (`PurchaseOrderNo`),
  KEY `fk_OrderDetails_Products1_idx` (`ProductCode`),
  CONSTRAINT `fk_OrderDetails_Orders1` FOREIGN KEY (`PurchaseOrderNo`) REFERENCES `orders` (`PurchaseOrderNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderDetails_Products1` FOREIGN KEY (`ProductCode`) REFERENCES `products` (`ProductCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT INTO `orderdetails` VALUES (1,119,25.00,1),(1,119,25.00,1),(11,119,25.00,10),(11,120,20.00,20),(45687,119,25.00,2),(12345,119,25.00,65),(165,119,25.00,66),(91567,119,25.00,10);
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `PurchaseOrderNo` int(20) unsigned NOT NULL,
  `ClientID` int(20) unsigned NOT NULL,
  `StaffID` int(20) unsigned NOT NULL,
  `DeliveryReceiptNo` int(20) unsigned DEFAULT NULL,
  `OrderDate` date DEFAULT NULL,
  `DeliveryDate` date DEFAULT NULL,
  `StatusID` int(11) NOT NULL,
  `StatusDetails` varchar(45) DEFAULT NULL,
  `Comments` longtext,
  PRIMARY KEY (`PurchaseOrderNo`,`ClientID`,`StaffID`),
  KEY `fk_Orders_Client1_idx` (`ClientID`),
  KEY `fk_Orders_Staff1_idx` (`StaffID`),
  CONSTRAINT `fk_Orders_Client1` FOREIGN KEY (`ClientID`) REFERENCES `client` (`ClientID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orders_Staff1` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,10000016,101,NULL,'2018-08-07','2018-08-08',2,'Processing',NULL),(2,10000016,101,NULL,'2018-08-08','2018-08-09',2,'Processing',NULL),(3,10000016,101,NULL,'2018-08-09','2018-08-10',2,'Processing',NULL),(4,10000016,101,NULL,'2018-09-08','2018-09-09',2,'Processing',NULL),(5,10000016,101,NULL,'2018-09-08','2018-09-09',2,'Processing',NULL),(6,10000016,101,NULL,'2018-08-08','2018-08-09',2,'Processing',NULL),(7,10000016,101,NULL,'2018-09-08','2018-09-09',2,'Processing',NULL),(8,10000016,101,NULL,'2019-08-08','2018-08-09',2,'Processing',NULL),(9,10000016,101,NULL,'2018-08-08','2018-08-09',2,'Processing',NULL),(10,10000016,101,NULL,'2018-09-08','2018-09-09',2,'Processing',NULL),(11,10000016,101,NULL,'2018-08-08','2018-08-09',2,'Processing',NULL),(15,10000016,101,NULL,'2018-09-08','2018-09-09',2,'Processing',NULL),(165,10000018,101,NULL,'2018-08-09','2018-08-10',2,'Processing',NULL),(888,10000018,101,NULL,'2018-08-08','2018-08-08',2,'Processing',NULL),(4848,10000016,101,NULL,'2018-08-08','2018-08-09',2,'Processing',NULL),(5454,10000016,101,NULL,'2018-08-08','2018-08-09',2,'Processing',NULL),(12345,10000018,101,NULL,'2018-09-08','2018-09-09',2,'Processing',NULL),(45687,10000017,101,NULL,'2018-09-08','2018-09-08',2,'Processing',NULL),(56564,10000016,101,NULL,'2018-08-08','2018-08-08',2,'Processing',NULL),(91567,10000018,101,NULL,'2018-08-08','2018-08-08',2,'Processing',NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prod_audit`
--

DROP TABLE IF EXISTS `prod_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prod_audit` (
  `audit_id` int(11) NOT NULL AUTO_INCREMENT,
  `ID` bigint(20) unsigned NOT NULL,
  `auditNameProd` varchar(45) DEFAULT NULL,
  `Quantity` int(20) DEFAULT NULL,
  `audit_timelog` date NOT NULL,
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prod_audit`
--

LOCK TABLES `prod_audit` WRITE;
/*!40000 ALTER TABLE `prod_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `prod_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `ProductCode` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(45) NOT NULL,
  `ProductPrice` decimal(10,2) unsigned NOT NULL,
  `AvailableStock` int(20) unsigned NOT NULL DEFAULT '0',
  `Threshold` int(20) unsigned NOT NULL,
  `tillThreshold` int(20) unsigned DEFAULT NULL,
  `Ceiling` int(20) unsigned NOT NULL,
  `tillCeiling` varchar(45) DEFAULT NULL,
  `Status` varchar(8) DEFAULT 'Active',
  PRIMARY KEY (`ProductCode`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (119,'Chicken Empanada',25.00,515,100,NULL,1000,NULL,'Active'),(120,'Ham and Cheese kariman',20.00,400,100,NULL,1000,NULL,'Active');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rawmaterials`
--

DROP TABLE IF EXISTS `rawmaterials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rawmaterials` (
  `RawMaterialCode` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `IngredientCode` int(20) unsigned NOT NULL,
  `IngredientBrand` varchar(45) DEFAULT 'null',
  `PackagingAmount` decimal(20,2) unsigned NOT NULL,
  `Packaging` varchar(45) NOT NULL,
  `Amount` decimal(20,2) unsigned NOT NULL,
  `UnitOfMeasurement` varchar(45) NOT NULL,
  `Status` varchar(8) DEFAULT 'ACTIVE',
  PRIMARY KEY (`RawMaterialCode`),
  KEY `fk_RawMaterials_Ingredients1` (`IngredientCode`)
) ENGINE=InnoDB AUTO_INCREMENT=514 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rawmaterials`
--

LOCK TABLES `rawmaterials` WRITE;
/*!40000 ALTER TABLE `rawmaterials` DISABLE KEYS */;
INSERT INTO `rawmaterials` VALUES (508,0,'Robin Hood',10.00,'Pack',500.00,'Kg','ACTIVE'),(509,0,'Gold medal',20.00,'Pack',250.00,'Kg','ACTIVE'),(510,0,'SM Bonus',12.00,'Tray',1.00,'Kg','ACTIVE'),(511,0,'Sm Hypermarket',2.00,'Tray',12.00,'Dozen','ACTIVE'),(512,0,'Dairy Queen',20.00,'Box',100.00,'Grams','ACTIVE'),(513,0,'Kit Kat',30.00,'Box',100.00,'Grams','ACTIVE');
/*!40000 ALTER TABLE `rawmaterials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rejectedstocks`
--

DROP TABLE IF EXISTS `rejectedstocks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rejectedstocks` (
  `ProductCode` int(20) unsigned NOT NULL,
  `NoOfRejectedStocks` int(20) unsigned NOT NULL,
  `DateRejected` date DEFAULT NULL,
  `ReasonRejected` longtext NOT NULL,
  PRIMARY KEY (`ProductCode`),
  CONSTRAINT `fk_RejectedStocks_Products1` FOREIGN KEY (`ProductCode`) REFERENCES `products` (`ProductCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rejectedstocks`
--

LOCK TABLES `rejectedstocks` WRITE;
/*!40000 ALTER TABLE `rejectedstocks` DISABLE KEYS */;
/*!40000 ALTER TABLE `rejectedstocks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rw_audit`
--

DROP TABLE IF EXISTS `rw_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rw_audit` (
  `audit_id` int(11) NOT NULL AUTO_INCREMENT,
  `ID` bigint(20) unsigned NOT NULL,
  `auditname` varchar(45) DEFAULT NULL,
  `RW_Quantity` int(20) DEFAULT NULL,
  `audit_timelog` date DEFAULT NULL,
  PRIMARY KEY (`audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rw_audit`
--

LOCK TABLES `rw_audit` WRITE;
/*!40000 ALTER TABLE `rw_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `rw_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `StaffID` int(20) unsigned NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `Position` varchar(45) NOT NULL,
  `Address` longtext,
  PRIMARY KEY (`StaffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (101,'Soriano','Rovi Elijah','Manager','Taft Ave Manila');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplierlists`
--

DROP TABLE IF EXISTS `supplierlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplierlists` (
  `SupplierID` int(20) unsigned NOT NULL,
  `RawMaterialCode` int(20) unsigned NOT NULL,
  KEY `fk_SupplierLists_Suppliers1_idx` (`SupplierID`),
  KEY `fk_SupplierLists_Suppliers2_idx` (`RawMaterialCode`),
  CONSTRAINT `fk_SupplierLists_Suppliers1` FOREIGN KEY (`SupplierID`) REFERENCES `suppliers` (`SupplierID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_SupplierLists_Suppliers2` FOREIGN KEY (`RawMaterialCode`) REFERENCES `rawmaterials` (`RawMaterialCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplierlists`
--

LOCK TABLES `supplierlists` WRITE;
/*!40000 ALTER TABLE `supplierlists` DISABLE KEYS */;
/*!40000 ALTER TABLE `supplierlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `suppliers` (
  `SupplierID` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `SupplierName` varchar(45) NOT NULL,
  `Address` longtext,
  `City` varchar(45) DEFAULT NULL,
  `Contact` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SupplierID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'Sup1','Address 1','Makati','092228693687'),(2,'Supplier 2','Address 2','Pasay','09228693685'),(3,'Supplier 3','Add 3','City 3','09090'),(4,'Supplier 4','Address 4','City 4','45468');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplyorderdetails`
--

DROP TABLE IF EXISTS `supplyorderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplyorderdetails` (
  `SupplyOrderNum` int(20) NOT NULL AUTO_INCREMENT,
  `RawMaterialCode` int(20) unsigned NOT NULL,
  `QuantityOrdered` decimal(20,2) NOT NULL,
  `UnitOfMeasurement` varchar(45) NOT NULL,
  PRIMARY KEY (`SupplyOrderNum`),
  KEY `fk_SupplyOrderDetails_SupplyOrders1_idx` (`SupplyOrderNum`),
  KEY `fk_SupplyOrderDetails_RawMaterials1_idx` (`RawMaterialCode`),
  CONSTRAINT `fk_SupplyOrderDetails_RawMaterials1` FOREIGN KEY (`RawMaterialCode`) REFERENCES `rawmaterials` (`RawMaterialCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1055 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplyorderdetails`
--

LOCK TABLES `supplyorderdetails` WRITE;
/*!40000 ALTER TABLE `supplyorderdetails` DISABLE KEYS */;
INSERT INTO `supplyorderdetails` VALUES (1054,511,10.00,'Dozen');
/*!40000 ALTER TABLE `supplyorderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplyorders`
--

DROP TABLE IF EXISTS `supplyorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplyorders` (
  `SupplyOrderNum` int(20) NOT NULL AUTO_INCREMENT,
  `SupplierID` int(20) unsigned NOT NULL,
  `DeliveryReceiptNo` int(20) DEFAULT NULL,
  `OrderDate` datetime DEFAULT NULL,
  `DeliveryDate` date DEFAULT NULL,
  `StatusID` int(11) NOT NULL,
  `StatusDetails` varchar(45) NOT NULL,
  `Comments` longtext,
  PRIMARY KEY (`SupplyOrderNum`,`SupplierID`),
  KEY `fk_SupplyOrders_Suppliers1_idx` (`SupplierID`),
  CONSTRAINT `fk_SupplyOrders_Suppliers1` FOREIGN KEY (`SupplierID`) REFERENCES `suppliers` (`SupplierID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplyorders`
--

LOCK TABLES `supplyorders` WRITE;
/*!40000 ALTER TABLE `supplyorders` DISABLE KEYS */;
INSERT INTO `supplyorders` VALUES (1,1,0,'2018-08-09 00:00:00','2018-08-10',2,'Processing','');
/*!40000 ALTER TABLE `supplyorders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UserID` int(20) unsigned NOT NULL,
  `StaffID` int(20) unsigned NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Userhash` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UserID`,`StaffID`),
  UNIQUE KEY `Userhash_UNIQUE` (`Userhash`),
  KEY `fk_Users_Staff1_idx` (`StaffID`),
  CONSTRAINT `fk_Users_Staff1` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,101,'RSoriano','Rovi','c0442e4fba5c481eb7ce2b6fbe57b51e');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-16  9:02:43