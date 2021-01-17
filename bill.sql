/*
SQLyog Trial v13.1.5  (64 bit)
MySQL - 10.1.38-MariaDB : Database - drip_bill
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`drip_bill` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `drip_bill`;

/*Table structure for table `bill` */

DROP TABLE IF EXISTS `bill`;

CREATE TABLE `bill` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `Amount` float DEFAULT NULL,
  `b_active` int(11) DEFAULT NULL,
  `b_number` int(11) DEFAULT NULL,
  `cgst` float DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `grossamt` float DEFAULT NULL,
  `gstAmount` float DEFAULT NULL,
  `gstPer` int(11) DEFAULT NULL,
  `gstType` int(11) DEFAULT NULL,
  `gstamt1` float DEFAULT NULL,
  `igst` int(11) DEFAULT NULL,
  `netamt` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `sgst` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  `customer_c_id` int(11) DEFAULT NULL,
  `product_p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`b_id`),
  KEY `FK6gk1u23rf3gxmgcolfajxnxxj` (`customer_c_id`),
  KEY `FKt96jolevq9nk5d46eiecsd4xv` (`product_p_id`),
  CONSTRAINT `FK6gk1u23rf3gxmgcolfajxnxxj` FOREIGN KEY (`customer_c_id`) REFERENCES `new_customer` (`c_id`),
  CONSTRAINT `FKt96jolevq9nk5d46eiecsd4xv` FOREIGN KEY (`product_p_id`) REFERENCES `product` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bill` */

/*Table structure for table `custreport` */

DROP TABLE IF EXISTS `custreport`;

CREATE TABLE `custreport` (
  `cr_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_number` int(11) DEFAULT NULL,
  `c_add` varchar(255) DEFAULT NULL,
  `c_gst` varchar(255) DEFAULT NULL,
  `c_name` varchar(255) DEFAULT NULL,
  `cgst` float DEFAULT NULL,
  `cr_active` int(11) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `grossamt` float DEFAULT NULL,
  `gstamt1` float DEFAULT NULL,
  `igst` int(11) DEFAULT NULL,
  `netamt` float DEFAULT NULL,
  `sgst` float DEFAULT NULL,
  `customer_c_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cr_id`),
  KEY `FKbgglnulunb6h18ghpen5qpjir` (`customer_c_id`),
  CONSTRAINT `FKbgglnulunb6h18ghpen5qpjir` FOREIGN KEY (`customer_c_id`) REFERENCES `new_customer` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `custreport` */

/*Table structure for table `erp_enquiry_request` */

DROP TABLE IF EXISTS `erp_enquiry_request`;

CREATE TABLE `erp_enquiry_request` (
  `enq_id` int(11) NOT NULL AUTO_INCREMENT,
  `enq_company_name` varchar(100) DEFAULT NULL,
  `enq_contact_id` int(11) DEFAULT NULL,
  `enq_date` date DEFAULT NULL,
  `enq_description` varchar(255) DEFAULT NULL,
  `enq_email` varchar(100) DEFAULT NULL,
  `enq_name` varchar(100) NOT NULL,
  `enq_post_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`enq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `erp_enquiry_request` */

/*Table structure for table `erp_hr_requirement` */

DROP TABLE IF EXISTS `erp_hr_requirement`;

CREATE TABLE `erp_hr_requirement` (
  `hr_req_id` int(11) NOT NULL AUTO_INCREMENT,
  `hr_active` int(11) DEFAULT NULL,
  `hr_created_date` varchar(255) DEFAULT NULL,
  `hr_department` varchar(30) DEFAULT NULL,
  `hr_shifts` varchar(30) DEFAULT NULL,
  `labour_required` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`hr_req_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `erp_hr_requirement` */

/*Table structure for table `new_customer` */

DROP TABLE IF EXISTS `new_customer`;

CREATE TABLE `new_customer` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(30) DEFAULT NULL,
  `c_active` varchar(30) DEFAULT NULL,
  `c_name` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `contact_no` varchar(30) DEFAULT NULL,
  `email_id` varchar(30) DEFAULT NULL,
  `gst_no` varchar(30) DEFAULT NULL,
  `note_of_add` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `new_customer` */

insert  into `new_customer`(`c_id`,`address`,`c_active`,`c_name`,`city`,`contact_no`,`email_id`,`gst_no`,`note_of_add`) values 
(1,'pune','1','megha',NULL,'9933389707','megha@gmail.com','657567',NULL);

/*Table structure for table `new_vendor` */

DROP TABLE IF EXISTS `new_vendor`;

CREATE TABLE `new_vendor` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(30) DEFAULT NULL,
  `cgst` float DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `conatct_no` varchar(30) DEFAULT NULL,
  `email_id` varchar(30) DEFAULT NULL,
  `gst_no` varchar(30) DEFAULT NULL,
  `igst` float DEFAULT NULL,
  `sgst` float DEFAULT NULL,
  `v_active` int(11) DEFAULT NULL,
  `v_name` varchar(30) DEFAULT NULL,
  `website` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `new_vendor` */

insert  into `new_vendor`(`v_id`,`address`,`cgst`,`city`,`conatct_no`,`email_id`,`gst_no`,`igst`,`sgst`,`v_active`,`v_name`,`website`) values 
(1,'Pune',9,'Pune','9960703944','rahul@gmail.com','54645',0,9,1,'Rahul','dfs');

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `person` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `min_quantity` int(11) DEFAULT NULL,
  `p_active` varchar(5) DEFAULT NULL,
  `p_brand` varchar(30) DEFAULT NULL,
  `p_code` varchar(30) DEFAULT NULL,
  `p_name` varchar(30) DEFAULT NULL,
  `packages` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `size` varchar(30) DEFAULT NULL,
  `uom` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`p_id`,`min_quantity`,`p_active`,`p_brand`,`p_code`,`p_name`,`packages`,`quantity`,`rate`,`size`,`uom`) values 
(1,NULL,'1','Amul','8989','Milk',90,NULL,89,NULL,'lit');

/*Table structure for table `product1` */

DROP TABLE IF EXISTS `product1`;

CREATE TABLE `product1` (
  `p1_id` int(11) NOT NULL AUTO_INCREMENT,
  `p1_brand` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`p1_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product1` */

/*Table structure for table `product_details` */

DROP TABLE IF EXISTS `product_details`;

CREATE TABLE `product_details` (
  `pd_id` int(11) NOT NULL AUTO_INCREMENT,
  `box` int(11) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `p_HSN` varchar(255) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  `packages` int(11) DEFAULT NULL,
  `pd_active` varchar(5) DEFAULT NULL,
  `pro_name` varchar(255) DEFAULT NULL,
  `pro_uom` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `customer_c_id` int(11) DEFAULT NULL,
  `product_p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pd_id`),
  KEY `FK5an103cti3e0rwsb9ksk1fevg` (`customer_c_id`),
  KEY `FKa3rumcciqibyvuoybadc552gp` (`product_p_id`),
  CONSTRAINT `FK5an103cti3e0rwsb9ksk1fevg` FOREIGN KEY (`customer_c_id`) REFERENCES `new_customer` (`c_id`),
  CONSTRAINT `FKa3rumcciqibyvuoybadc552gp` FOREIGN KEY (`product_p_id`) REFERENCES `product` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `product_details` */

insert  into `product_details`(`pd_id`,`box`,`c_id`,`p_HSN`,`p_id`,`packages`,`pd_active`,`pro_name`,`pro_uom`,`quantity`,`rate`,`size`,`customer_c_id`,`product_p_id`) values 
(1,NULL,NULL,'8989',NULL,NULL,'1','Milk','lit',NULL,56,NULL,1,1);

/*Table structure for table `product_report` */

DROP TABLE IF EXISTS `product_report`;

CREATE TABLE `product_report` (
  `pr_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `pr_active` varchar(30) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `product_p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pr_id`),
  KEY `FK4akdue3ckpolic37lq2tejxjr` (`product_p_id`),
  CONSTRAINT `FK4akdue3ckpolic37lq2tejxjr` FOREIGN KEY (`product_p_id`) REFERENCES `product` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `product_report` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
