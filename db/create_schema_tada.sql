CREATE DATABASE  IF NOT EXISTS `tada`
USE `tada`;

DROP TABLE IF EXISTS `dictionary`;

CREATE TABLE `dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `abbreviation` varchar(200) NOT NULL,
  `explanation` text NOT NULL,
  `notes` text,
  `status` varchar(45) NOT NULL,
  `inserted` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hitcount` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
)


