/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.0.18-nt : Database - bjuidata
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bjuidata` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bjuidata`;

/*Table structure for table `mainmenu` */

DROP TABLE IF EXISTS `mainmenu`;

CREATE TABLE `mainmenu` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `target` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `pid` int(11) NOT NULL,
  `zid` int(11) NOT NULL,
  `pname` varchar(255) NOT NULL,
  `zname` varchar(255) NOT NULL,
  KEY `zid` (`zid`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mainmenu` */

insert  into `mainmenu`(`id`,`name`,`target`,`url`,`pid`,`zid`,`pname`,`zname`) values 
('q1','按钮','navtab','js/B-JUI.1.31/html/form/button.html',1,1,'表单相关','用户管理'),
('w1','文本框','navtab','js/B-JUI.1.31/html/form/input.html',1,1,'表单相关','用户管理'),
('s1','下拉选择框','navtab','js/B-JUI.1.31/html/form/select.html',1,1,'表单相关','用户管理'),
('s2','表单示例','navtab','js/B-JUI.1.31/html/form/form.html',2,1,'综合应用','用户管理'),
('d3','Navtab','navtab','js/B-JUI.1.31/html/base/navtab.html',1,2,'基础组件','权限管理'),
('f4','Dialog弹窗','navtab','js/B-JUI.1.31/html/base/dialog.html',1,2,'基础组件','权限管理'),
('g5','alertmsg消息窗口','navtab','js/B-JUI.1.31/html/base/alertmsg.html',1,2,'基础组件','权限管理'),
('h6','体检信息','navtab','js/B-JUI.1.31/html/datagrid/datagrid.html',3,1,'用户信息','用户管理');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
