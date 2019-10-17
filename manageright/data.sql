-- MySQL dump 10.13  Distrib 8.0.17, for Linux (x86_64)
--
-- Host: localhost    Database: manageRight
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `AllowedHolidays`
--

DROP TABLE IF EXISTS `AllowedHolidays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AllowedHolidays` (
  `Company_ID` int(11) NOT NULL,
  `Holiday_ID` int(11) NOT NULL,
  PRIMARY KEY (`Company_ID`,`Holiday_ID`),
  KEY `Holiday_ID` (`Holiday_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AllowedHolidays`
--

LOCK TABLES `AllowedHolidays` WRITE;
/*!40000 ALTER TABLE `AllowedHolidays` DISABLE KEYS */;
INSERT INTO `AllowedHolidays` VALUES (1,1),(2,1),(2,2);
/*!40000 ALTER TABLE `AllowedHolidays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AllowedLeaves`
--

DROP TABLE IF EXISTS `AllowedLeaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AllowedLeaves` (
  `MaxAllowed` int(11) NOT NULL,
  `Company_ID` int(11) NOT NULL,
  `Leave_ID` int(11) NOT NULL,
  `Eligibility_ID` int(11) NOT NULL,
  PRIMARY KEY (`Company_ID`,`Leave_ID`),
  KEY `Leave_ID` (`Leave_ID`),
  KEY `Eligibility_ID` (`Eligibility_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AllowedLeaves`
--

LOCK TABLES `AllowedLeaves` WRITE;
/*!40000 ALTER TABLE `AllowedLeaves` DISABLE KEYS */;
/*!40000 ALTER TABLE `AllowedLeaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ApplicableAt`
--

DROP TABLE IF EXISTS `ApplicableAt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ApplicableAt` (
  `Holiday_ID` int(11) NOT NULL,
  `Region_ID` int(11) NOT NULL,
  PRIMARY KEY (`Holiday_ID`,`Region_ID`),
  KEY `Region_ID` (`Region_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ApplicableAt`
--

LOCK TABLES `ApplicableAt` WRITE;
/*!40000 ALTER TABLE `ApplicableAt` DISABLE KEYS */;
INSERT INTO `ApplicableAt` VALUES (1,1),(1,3),(2,5);
/*!40000 ALTER TABLE `ApplicableAt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Benefits`
--

DROP TABLE IF EXISTS `Benefits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Benefits` (
  `Type` varchar(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Benefit_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Benefit_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Benefits`
--

LOCK TABLES `Benefits` WRITE;
/*!40000 ALTER TABLE `Benefits` DISABLE KEYS */;
INSERT INTO `Benefits` VALUES ('Percent','Yearly Bonus',1),('Absolute','Laundry',2),('','',3);
/*!40000 ALTER TABLE `Benefits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BenefitsProvided`
--

DROP TABLE IF EXISTS `BenefitsProvided`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BenefitsProvided` (
  `Company_ID` int(11) NOT NULL,
  `Benefit_ID` int(11) NOT NULL,
  PRIMARY KEY (`Company_ID`,`Benefit_ID`),
  KEY `Benefit_ID` (`Benefit_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BenefitsProvided`
--

LOCK TABLES `BenefitsProvided` WRITE;
/*!40000 ALTER TABLE `BenefitsProvided` DISABLE KEYS */;
/*!40000 ALTER TABLE `BenefitsProvided` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CalendarHoliday`
--

DROP TABLE IF EXISTS `CalendarHoliday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CalendarHoliday` (
  `Holiday_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(15) NOT NULL,
  `EndDate` date NOT NULL,
  `StartDate` date NOT NULL,
  PRIMARY KEY (`Holiday_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CalendarHoliday`
--

LOCK TABLES `CalendarHoliday` WRITE;
/*!40000 ALTER TABLE `CalendarHoliday` DISABLE KEYS */;
INSERT INTO `CalendarHoliday` VALUES (1,'Christmas','2019-12-25','2019-12-25'),(2,'Dussehra','2019-10-09','2019-10-06');
/*!40000 ALTER TABLE `CalendarHoliday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Compensations`
--

DROP TABLE IF EXISTS `Compensations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Compensations` (
  `Amount` int(11) NOT NULL,
  `Benefit_ID` int(11) NOT NULL,
  `Employee_ID` int(11) NOT NULL,
  PRIMARY KEY (`Benefit_ID`,`Employee_ID`),
  KEY `Employee_ID` (`Employee_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Compensations`
--

LOCK TABLES `Compensations` WRITE;
/*!40000 ALTER TABLE `Compensations` DISABLE KEYS */;
/*!40000 ALTER TABLE `Compensations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DepartmentsAvailable`
--

DROP TABLE IF EXISTS `DepartmentsAvailable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DepartmentsAvailable` (
  `Departments` varchar(20) NOT NULL,
  `Company_ID` int(11) NOT NULL,
  PRIMARY KEY (`Departments`,`Company_ID`),
  KEY `Company_ID` (`Company_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DepartmentsAvailable`
--

LOCK TABLES `DepartmentsAvailable` WRITE;
/*!40000 ALTER TABLE `DepartmentsAvailable` DISABLE KEYS */;
INSERT INTO `DepartmentsAvailable` VALUES ('Information',1);
/*!40000 ALTER TABLE `DepartmentsAvailable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Eligibility`
--

DROP TABLE IF EXISTS `Eligibility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Eligibility` (
  `Name` varchar(30) NOT NULL,
  `Eligibility_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(30) NOT NULL,
  `Constraints` varchar(30) NOT NULL,
  PRIMARY KEY (`Eligibility_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Eligibility`
--

LOCK TABLES `Eligibility` WRITE;
/*!40000 ALTER TABLE `Eligibility` DISABLE KEYS */;
INSERT INTO `Eligibility` VALUES ('Maternity',1,'Gender','Female'),('Seniority',2,'BaseSalary','ABOVE 100000'),('Company Perks',3,'WorkerType','FULLTIME');
/*!40000 ALTER TABLE `Eligibility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EmergencyColleagues`
--

DROP TABLE IF EXISTS `EmergencyColleagues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EmergencyColleagues` (
  `Employee` int(11) NOT NULL,
  `Colleague` int(11) NOT NULL,
  PRIMARY KEY (`Employee`,`Colleague`),
  KEY `Colleague` (`Colleague`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EmergencyColleagues`
--

LOCK TABLES `EmergencyColleagues` WRITE;
/*!40000 ALTER TABLE `EmergencyColleagues` DISABLE KEYS */;
/*!40000 ALTER TABLE `EmergencyColleagues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EmergencyContacts`
--

DROP TABLE IF EXISTS `EmergencyContacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EmergencyContacts` (
  `Dependant` char(1) NOT NULL,
  `Employee_ID` int(11) NOT NULL,
  `PR_ID` int(11) NOT NULL,
  PRIMARY KEY (`Employee_ID`,`PR_ID`),
  KEY `PR_ID` (`PR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EmergencyContacts`
--

LOCK TABLES `EmergencyContacts` WRITE;
/*!40000 ALTER TABLE `EmergencyContacts` DISABLE KEYS */;
/*!40000 ALTER TABLE `EmergencyContacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employee` (
  `BaseSalary` int(11) NOT NULL,
  `Origin` varchar(20) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Nationality` varchar(30) NOT NULL,
  `DOB` date NOT NULL,
  `Gender` varchar(15) NOT NULL,
  `MaritalStatus` char(1) NOT NULL,
  `HomeAddress` varchar(256) NOT NULL,
  `WorkEmail` varchar(50) NOT NULL,
  `WorkMobile` varchar(15) NOT NULL,
  `MailingAddress` varchar(256) NOT NULL,
  `Employee_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EduLevel` varchar(40) NOT NULL,
  `TaxIdentification` varchar(20) NOT NULL,
  `WorksFor` int(11) DEFAULT NULL,
  `ManagedBy` int(11) DEFAULT NULL,
  `Shift` int(11) DEFAULT NULL,
  PRIMARY KEY (`Employee_ID`),
  KEY `Shift` (`Shift`),
  KEY `WorksFor` (`WorksFor`),
  KEY `ManagedBy` (`ManagedBy`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (100000,'India','Radha','Krishna','India','2019-10-17','Male','U','D-32/3, RRCAT Colony','krishna2020r@gmail.com','7892551741','D-32/3, RRCAT Colony',2,'Engineering','1',1,NULL,1),(100000,'India','Sayam','Choudhary','India','1999-07-04','Male','U','Hiran Magri Udaipur','sayam@gmail.com','3333333333','Hiran Magri Udaipur',3,'Engineering','10',1,2,1),(10000,'India','Anuraj','Singh','India','1999-03-24','Male','M','Saugar','anuraj@gmail.com','111111111','Saugar',4,'Engineering','100',NULL,NULL,NULL);
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employment`
--

DROP TABLE IF EXISTS `Employment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Employment` (
  `WorkerType` varchar(10) NOT NULL,
  `JobTitle` varchar(20) NOT NULL,
  `Employment_ID` int(11) NOT NULL AUTO_INCREMENT,
  `HireDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `StartDate` date NOT NULL,
  `Employee_ID` int(11) DEFAULT NULL,
  `Department` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Employment_ID`),
  KEY `Employee_ID` (`Employee_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employment`
--

LOCK TABLES `Employment` WRITE;
/*!40000 ALTER TABLE `Employment` DISABLE KEYS */;
INSERT INTO `Employment` VALUES ('FULLTIME','Developer',4,'2019-10-01','2019-10-17','2019-10-10',2,NULL),('FULLTIME','Developer',5,'2019-10-17','2019-10-25','2019-10-17',2,'Information'),('FULLTIME','Developer',6,'2019-10-16','2019-10-31','2019-10-16',3,'Information');
/*!40000 ALTER TABLE `Employment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Leaves`
--

DROP TABLE IF EXISTS `Leaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Leaves` (
  `Name` varchar(30) NOT NULL,
  `MaxDuration` int(11) NOT NULL,
  `MinDuration` int(11) NOT NULL,
  `Leave_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Leave_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Leaves`
--

LOCK TABLES `Leaves` WRITE;
/*!40000 ALTER TABLE `Leaves` DISABLE KEYS */;
INSERT INTO `Leaves` VALUES ('Casual',4,1,2);
/*!40000 ALTER TABLE `Leaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LeavesLeft`
--

DROP TABLE IF EXISTS `LeavesLeft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LeavesLeft` (
  `Remaining` int(11) NOT NULL,
  `Leave_ID` int(11) NOT NULL,
  `Employee_ID` int(11) NOT NULL,
  PRIMARY KEY (`Leave_ID`,`Employee_ID`),
  KEY `Employee_ID` (`Employee_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LeavesLeft`
--

LOCK TABLES `LeavesLeft` WRITE;
/*!40000 ALTER TABLE `LeavesLeft` DISABLE KEYS */;
/*!40000 ALTER TABLE `LeavesLeft` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Office`
--

DROP TABLE IF EXISTS `Office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Office` (
  `Mailing_Address` varchar(256) NOT NULL,
  `Office_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Company` int(11) NOT NULL,
  `LocatedAt` int(11) NOT NULL,
  PRIMARY KEY (`Office_ID`),
  KEY `Company` (`Company`),
  KEY `LocatedAt` (`LocatedAt`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Office`
--

LOCK TABLES `Office` WRITE;
/*!40000 ALTER TABLE `Office` DISABLE KEYS */;
INSERT INTO `Office` VALUES ('Whitefield Area',1,1,6),('Railway Station Road',2,3,2);
/*!40000 ALTER TABLE `Office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PersonalRelations`
--

DROP TABLE IF EXISTS `PersonalRelations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PersonalRelations` (
  `Name` varchar(60) NOT NULL,
  `PR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Mobile` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `MailingAddress` varchar(256) NOT NULL,
  PRIMARY KEY (`PR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PersonalRelations`
--

LOCK TABLES `PersonalRelations` WRITE;
/*!40000 ALTER TABLE `PersonalRelations` DISABLE KEYS */;
INSERT INTO `PersonalRelations` VALUES ('P Lavanya',1,'7777777777','lavanya@gmail.com','Sarjapur, Bangalore'),('Ravi Choudhary',2,'8888888888','ravi@gmail.com','Lake Palace, Udaipur'),('Vijaya Lakshmi',3,'9999999999','vijaya@gmail.com','RRCAT Colony, Indore');
/*!40000 ALTER TABLE `PersonalRelations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Region`
--

DROP TABLE IF EXISTS `Region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Region` (
  `Name` varchar(30) NOT NULL,
  `Region_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LocatedIn` int(11) DEFAULT NULL,
  PRIMARY KEY (`Region_ID`),
  KEY `LocatedIn` (`LocatedIn`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Region`
--

LOCK TABLES `Region` WRITE;
/*!40000 ALTER TABLE `Region` DISABLE KEYS */;
INSERT INTO `Region` VALUES ('Russia',1,NULL),('Moscow',2,1),('Las Vegas',3,NULL),('Sri Lanka',4,NULL),('India',5,NULL),('Karnataka',6,5),('Madhya Pradesh',7,5),('Indore',8,7),('Bhopal',9,7),('Kanpur',10,5),('Kanp',11,NULL);
/*!40000 ALTER TABLE `Region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Role` (
  `RoleID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  PRIMARY KEY (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Shifts`
--

DROP TABLE IF EXISTS `Shifts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Shifts` (
  `Timings` char(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Shift_ID` int(11) NOT NULL AUTO_INCREMENT,
  `HoursPerWeek` int(11) NOT NULL,
  PRIMARY KEY (`Shift_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Shifts`
--

LOCK TABLES `Shifts` WRITE;
/*!40000 ALTER TABLE `Shifts` DISABLE KEYS */;
INSERT INTO `Shifts` VALUES ('1030to1830','12345',1,40),('0900to1700','12345',2,40),('1030to1830','1234',3,32);
/*!40000 ALTER TABLE `Shifts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Shifts_DaysofWork`
--

DROP TABLE IF EXISTS `Shifts_DaysofWork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Shifts_DaysofWork` (
  `DaysofWork` int(11) NOT NULL,
  `Shift_ID` int(11) NOT NULL,
  PRIMARY KEY (`DaysofWork`,`Shift_ID`),
  KEY `Shift_ID` (`Shift_ID`),
  CONSTRAINT `Shifts_DaysofWork_ibfk_1` FOREIGN KEY (`Shift_ID`) REFERENCES `Shifts` (`Shift_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Shifts_DaysofWork`
--

LOCK TABLES `Shifts_DaysofWork` WRITE;
/*!40000 ALTER TABLE `Shifts_DaysofWork` DISABLE KEYS */;
/*!40000 ALTER TABLE `Shifts_DaysofWork` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SubCompany`
--

DROP TABLE IF EXISTS `SubCompany`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SubCompany` (
  `CompanyName` varchar(30) NOT NULL,
  `Company_ID` int(11) NOT NULL AUTO_INCREMENT,
  `HeadOffice` int(11) DEFAULT NULL,
  PRIMARY KEY (`Company_ID`),
  KEY `HeadOffice` (`HeadOffice`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SubCompany`
--

LOCK TABLES `SubCompany` WRITE;
/*!40000 ALTER TABLE `SubCompany` DISABLE KEYS */;
INSERT INTO `SubCompany` VALUES ('Xerox India',1,0),('Xerox Technologies',2,0),('Xerox International',3,0);
/*!40000 ALTER TABLE `SubCompany` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `UserID` int(11) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-17 15:49:19
