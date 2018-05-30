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
INSERT INTO `dictionary` (`abbreviation`, `explanation`, `notes`, `status`) VALUES
  ('AF', 'Automotive & Finance', null, 'confirmed'),
  ('AG', 'Assignment Group', null, 'confirmed'),
  ('AGA', 'Automotive & Global Accounts', null, 'confirmed'),
  ('AO', 'Application Operation', null, 'confirmed'),
  ('API', 'Application Programming Interface', null, 'confirmed'),
  ('ASIC', 'Automation Strategy And Inovation Centre', 'Software development team', 'confirmed'),
  ('BR', 'Best Regards', null, 'confirmed'),
  ('BT', 'Business Trip', null, 'confirmed'),
  ('CEO', 'Chief Executive Officer', null, 'confirmed'),
  ('CFO', 'Chief Financial Officer', null, 'confirmed'),
  ('CHM', 'Change Management', null, 'confirmed'),
  ('CIO', 'Chief Information Officer', null, 'confirmed'),
  ('CMO', 'Current Mode of Operation', null, 'confirmed'),
  ('COO', 'Chief Opertion Office', null, 'confirmed'),
  ('CSA', 'Cloud Server Automation', null, 'confirmed'),
  ('CSI', 'Continual Service Improvement', null, 'confirmed'),
  ('DC', 'Datacenter', null, 'confirmed'),
  ('DCNO', 'Datacenter Network Operations', null, 'confirmed'),
  ('DCNS', 'Datacenter Network Services', null, 'confirmed'),
  ('DOM', 'Delivery Order Management', null, 'confirmed'),
  ('DSM', 'Delivery Solution Manager', null, 'confirmed'),
  ('DTAG', 'Deutche Telekom Aktiengesellschaft', null, 'confirmed'),
  ('EMEA', 'Europe Middle East Asia', null, 'confirmed'),
  ('FFM', 'Frankfurt', null, 'confirmed'),
  ('FMO', 'Future Mode of Operation', null, 'confirmed'),
  ('GAP', 'Global Access Point', null, 'confirmed'),
  ('GDPR', 'General Data Privacy Regulation', null, 'confirmed'),
  ('GDU', 'Global Delivery Unit', null, 'confirmed'),
  ('GRA', 'Global Remote Access', null, 'confirmed'),
  ('HO', 'Home Office', null, 'confirmed'),
  ('HoT', 'Head of Team', null, 'confirmed'),
  ('HOU', 'Houston', null, 'confirmed'),
  ('HW', 'Hardware', null, 'confirmed'),
  ('ICB', 'Infrastructure Capacity & Build', null, 'confirmed'),
  ('IIT', 'Internal IT', null, 'confirmed'),
  ('IM', 'Incident Management', null, 'confirmed'),
  ('IMH', 'International Magenta Hackathon', null, 'confirmed'),
  ('LAR', 'Local Admin Rights', null, 'confirmed'),
  ('MCS', 'Market & Corporate Solutions', null, 'confirmed'),
  ('MD', 'Managing Director', null, 'confirmed'),
  ('MoD', 'Manager on Duty', null, 'confirmed'),
  ('MUC', 'Munich', null, 'confirmed'),
  ('MW', 'Maintenance Window', null, 'confirmed'),
  ('OoO', 'Out of Office', null, 'confirmed'),
  ('OPEN', 'Operational Engineering', null, 'confirmed'),
  ('OPM', 'Operation Manager', null, 'confirmed'),
  ('OS', 'Operating System', null, 'confirmed'),
  ('OSS', 'Operation System Support', null, 'confirmed'),
  ('PRM', 'Problem Management', null, 'confirmed'),
  ('PSA', 'Privacy & Security Assesment', null, 'confirmed'),
  ('PSS', 'Production System Support', null, 'confirmed'),
  ('RTFM', 'Read the fucking manual', null, 'confirmed'),
  ('ScOPM', 'Service-chain Operation Manager', null, 'confirmed'),
  ('SDD', 'Software Developmnet & Design', null, 'confirmed'),
  ('SDM', 'Service Delivery Manager', null, 'confirmed'),
  ('SW', 'Software', null, 'confirmed'),
  ('TBEPM', 'Techbase Extension Project Management', null, 'confirmed'),
  ('TL', 'Team Leader', null, 'confirmed'),
  ('TSI', 'T-Systems International', null, 'confirmed'),
  ('TSM', 'Technical Solution Manager', null, 'confirmed'),
  ('TSSK', 'T-Sysytems Slovakia', null, 'confirmed'),
  ('TSSKKE', 'T-Systems Slovakia Kosice', null, 'confirmed'),
  ('VPO', 'Virtual Platform Operation', null, 'confirmed'),
  ('VSO', 'Virtual Server Operation', null, 'confirmed'),
  ('VtD', 'Visit to Doctor', null, 'confirmed'),
  ('VtDwFM', 'Visit to Doctor with Family Member', null, 'confirmed'),
  ('YaM', 'You and Me', null, 'confirmed');
UNLOCK TABLES;
