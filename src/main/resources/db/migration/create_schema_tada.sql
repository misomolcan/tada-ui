CREATE DATABASE  IF NOT EXISTS `tada` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tada`;

--
-- Table structure for table `dictionary`
--

DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `abbreviation` varchar(200) NOT NULL,
  `explanation` text,
  `notes` text,
  `status` varchar(200) NOT NULL,
  `inserted` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hitcount` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dictionary`
--

LOCK TABLES `dictionary` WRITE;
INSERT INTO `dictionary` VALUES (1,'ASIC','Automation Strategy And Inovation Centre','Software development team.','proposed','2018-05-30 12:08:58',0),(2,'GDU','Global Delivery Unit','','proposed','2018-05-30 12:09:28',1),(3,'FMO','Future Mode of Operation','cc','suggested','2018-05-30 12:15:01',0);
UNLOCK TABLES;