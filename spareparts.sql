/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 8.0.33 : Database - spareparts
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spareparts` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `spareparts`;

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `modul_id` bigint NOT NULL,
  `username` varchar(30) NOT NULL,
  `operation` enum('Created','Updated','Deleted') NOT NULL,
  `date_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `history` */

insert  into `history`(`id`,`modul_id`,`username`,`operation`,`date_time`) values 
(1,1,'svaskovic','Created','2023-02-18'),
(2,2,'mpantelic','Created','2023-02-17'),
(3,3,'svaskovic','Created','2023-02-15'),
(4,4,'ijovicic','Created','2023-03-18'),
(5,5,'vmilosavljevic','Created','2023-04-19'),
(6,6,'svaskovic','Created','2023-05-18'),
(10,3,'bdjokic','Updated','2023-06-12'),
(19,5,'vmilosavljevic','Deleted','2023-06-20'),
(22,15,'vmilosavljevic','Created','2023-06-21'),
(23,12,'vmilosavljevic','Deleted','2023-06-21'),
(24,13,'vmilosavljevic','Deleted','2023-06-21'),
(25,14,'vmilosavljevic','Deleted','2023-06-21'),
(26,15,'vmilosavljevic','Deleted','2023-06-21'),
(27,16,'vmilosavljevic','Created','2023-06-23'),
(28,16,'vmilosavljevic','Updated','2023-06-23'),
(29,16,'mpantelic','Deleted','2023-06-23'),
(30,17,'vmilosavljevic','Created','2023-06-23');

/*Table structure for table `locations` */

DROP TABLE IF EXISTS `locations`;

CREATE TABLE `locations` (
  `site_code` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `lat` varchar(20) NOT NULL,
  `lon` varchar(20) NOT NULL,
  PRIMARY KEY (`site_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `locations` */

insert  into `locations`(`site_code`,`name`,`type`,`address`,`lat`,`lon`) values 
('BA1012','Mirijevo/Zabari','GF-Green Field','ulica Rasanacki put bb,mesto Mirijevo,opstina Zabari','44 26 25.3','21 16 42.2'),
('BG','BG warehouse','HQ','Ul. Omladinskih Brigada 21','44 48 34.35','20 24 20.03'),
('Bg0704','Mirijevo Matice Srpske','Roof top','Matice Srpske 59, Beograd','44 47 19.6','20 31 30.7'),
('KG3062','Uzice Centar','RT - Roof Top','Decanska bb, Uzice, Hotel Zlatibor','43 51 20.56','19 50 22.19'),
('NI4057','Vrezina VPN','RT - Roof Top','ul. Knjazevacka 158 - Nis','43 19 47.62','21 56 18'),
('NS1454','SM Stari Banovci centar','Roof top','Nikole Zeljuga 25a, 22305 Stari Banovci','44 58 52.93','20 16 32.99'),
('NS1458','Taras','ET - Existing Tower','Ive Lole Ribara 43, Taraš','45 28 02.78','20 11 56.10'),
('NS1465','NS Kisac centar','ET - Existing Tower','opstina Kisac,','45 21 22.77','19 43 32.15');

/*Table structure for table `modules` */

DROP TABLE IF EXISTS `modules`;

CREATE TABLE `modules` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `s/n` varchar(20) DEFAULT NULL,
  `p/n` varchar(30) NOT NULL,
  `mm` int NOT NULL,
  `type` enum('Radio','Transport','Power','Asset') NOT NULL,
  `location` varchar(20) NOT NULL,
  `status` enum('Operative','Faulty','Test') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `location_idx` (`location`),
  CONSTRAINT `location` FOREIGN KEY (`location`) REFERENCES `locations` (`site_code`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `modules` */

insert  into `modules`(`id`,`name`,`s/n`,`p/n`,`mm`,`type`,`location`,`status`) values 
(1,'FRGP','bs34523246','m21333577',501202,'Radio','BA1012','Operative'),
(2,'SUMA','sdgdsg','sdgdsg',501121,'Radio','KG3062','Operative'),
(3,'Rectifier48','bs324153532','m23133523',569969,'Power','BG','Faulty'),
(4,'MMU','bs2333525235','roj2081308a',587777,'Transport','KG3062','Test'),
(5,'NPU','bs87239458','roj20813081b',533678,'Transport','BA1012','Operative'),
(6,'Jumper 5M straight-angle',NULL,'5M s-a',532222,'Asset','NI4057','Operative'),
(17,'FRGF','bs4512039','db303246',506666,'Radio','BG','Operative');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `full_name` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `privileges` enum('read','read_write','admin') DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `users` */

insert  into `users`(`full_name`,`username`,`email`,`password`,`privileges`) values 
('Branivoj Djokic','bdjokic','b.djokic@a1.rs','P@ssw0rd5','read_write'),
('Ivan Jovicic','ijovicic','i.jovicic@a1.rs','P@ssw0rd3','read_write'),
('Milenko Pantelic','mpantelic','m.pantelic@a1.rs','P@ssw0rd1','admin'),
('Sveta Vaskovic','svaskovic','b.djokic@a1.rs','P@ssw0rd4','read_write'),
('Veljko Milosavljevic','vmilosavljevic','v.milosavljevic@a1.rs','P@ssw0rd2','admin'),
('Vlada Radulovic','vradulovic','v.radulovic@a1.rs','P@ssw0rd6','read');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
